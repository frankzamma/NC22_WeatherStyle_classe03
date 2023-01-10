from CreazioneDatasets import utils


# funzione per assegnare un punteggio a ciascun capo d'abbigliamento
def compute_dv(dataframe, bottom):
    dataframe.loc[:, 'Punteggio'] = 0

    for x in dataframe.index:
        punteggio = 0
        punteggio += evaluate_materiale(dataframe.loc[x, "Materiale"], dataframe.loc[x, "TemperaturaPercepita"])
        punteggio += evaluate_stagione(dataframe.loc[x, "Stagione"], dataframe.loc[x, "StagionePrevisione"])
        punteggio += utils.evaluate_colore(dataframe.loc[x, "Meteo"], dataframe.loc[x, "Colore"],
                                           dataframe.loc[x, "TemperaturaPercepita"])
        if bottom:
            punteggio += evaluate_lunghezza(dataframe.loc[x, "Lunghezza"], dataframe.loc[x, "TemperaturaPercepita"])
        else:
            punteggio += evaluate_manica(dataframe.loc[x, "Manica"], dataframe.loc[x, "TemperaturaPercepita"])
        dataframe.loc[x, 'Punteggio'] = punteggio
    return dataframe

# si costruisce un dizionario in cui si assegna un punteggio per ogni materiale di cui è
# costituito un capo d'abbigliamento, in base alla temperatura


ranges = [
    {  # temperatura > 30°
        'cotone': 9,
        'poliestere': 4,
        'cashmere': 1,
        'lino': 10,
        'seta': 9,
        'tweed': 2,
        'velluto': 3,
        'lana': 0,
        'raso': 8,
        'lunga': 0,
        'corta': 10,
        'media': 3,
    },
    {  # 25° <= temperatura < 30°
        'cotone': 10,
        'poliestere': 5,
        'cashmere': 1,
        'lino': 9,
        'seta': 8,
        'tweed': 2,
        'velluto': 3,
        'lana': 0,
        'raso': 7,
        'lunga': 2,
        'corta': 8,
        'media': 6
    },
    {  # 20° <= temperatura < 25°
        'cotone': 10,
        'poliestere': 7,
        'cashmere': 2,
        'lino': 8,
        'seta': 9,
        'tweed': 2,
        'velluto': 4,
        'lana': 1,
        'raso': 6,
        'lunga': 5,
        'corta': 5,
        'media': 10
    },
    {  # 15° <= temperatura < 20°
        'cotone': 10,
        'poliestere': 8,
        'cashmere': 5,
        'lino': 6,
        'seta': 7,
        'tweed': 6,
        'velluto': 5,
        'lana': 4,
        'raso': 4,
        'lunga': 8,
        'corta': 2,
        'media': 4
    },
    {  # 10 <= temperatura < 15°
        'cotone': 9,
        'poliestere': 8,
        'cashmere': 7,
        'lino': 5,
        'seta': 6,
        'tweed': 6,
        'velluto': 6,
        'lana': 7,
        'raso': 3,
        'lunga': 9,
        'corta': 1,
        'media': 3
    },
    {  # 5 <= temperatura < 10°
        'cotone': 8,
        'poliestere': 8,
        'cashmere': 8,
        'lino': 2,
        'seta': 4,
        'tweed': 7,
        'velluto': 8,
        'lana': 9,
        'raso': 2,
        'lunga': 10,
        'corta': 0,
        'media': 0
    },
    {  # temperatura < 5°
        'cotone': 8,
        'poliestere': 8,
        'cashmere': 10,
        'lino': 0,
        'seta': 3,
        'tweed': 8,
        'velluto': 9,
        'lana': 10,
        'raso': 1,
        'lunga': 10,
        'corta': 0,
        'media': 0
    }
]


stagionalita = [
    {  # stagione inverno
        'inverno': 6,
        'autunno': 4,
        'primavera': 2,
        'estate': 0,
        'primavera_estate': 1,
        'autunno_inverno': 5,
        'all': 3
    },
    {  # stagione primavera
        'primavera': 6,
        'estate': 4,
        'autunno': 2,
        'inverno': 0,
        'primavera_estate': 5,
        'autunno_inverno': 1,
        'all': 3
    },
    {  # stagione estate
        'estate': 6,
        'autunno': 2,
        'inverno': 0,
        'primavera': 4,
        'primavera_estate': 5,
        'autunno_inverno': 1,
        'all': 3
    },
    {  # stagione autunno
        'autunno': 6,
        'inverno': 4,
        'primavera': 2,
        'estate': 0,
        'primavera_estate': 1,
        'autunno_inverno': 5,
        'all': 3
    }
]


# questa funzione assegna un punteggio al materiale rispetto alla temperatura percepita
def evaluate_materiale(materiale, temp_perc):
    i = utils.calculate_ranges_temperatura(temp_perc)
    return ranges[i][materiale]


# questa funzione assegna un punteggio al capo d'abbigliamento in base alla sua stagionalità
def evaluate_stagione(stagione_capo, stagione_prev):
    i = utils.calculate_ranges_stagione(stagione_prev)
    return stagionalita[i][stagione_capo]


# questa funzione assegna un punteggio alla manica del capo rispetto alla temperatura percepita
def evaluate_manica(manica, temp_perc):
    i = utils.calculate_ranges_temperatura(temp_perc)
    return ranges[i][manica]


# questa funzione assegna un punteggio alla manica del capo rispetto alla temperatura percepita
def evaluate_lunghezza(lunghezza, temp_perc):
    i = utils.calculate_ranges_temperatura(temp_perc)
    return ranges[i][lunghezza]

