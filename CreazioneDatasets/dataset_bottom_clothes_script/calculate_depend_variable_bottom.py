import pandas as pd
from CreazioneDatasets import utils

dataframe = pd.read_csv("../newCsv_all_clothes/bottom_meteo_dataset_no_y.csv")

lista=[]

#funzione per assegnare un punteggio a ciascun capo d'abbigliamento
def sum_values():
    for x in dataframe.index:
        punteggio = 0
        punteggio += evaluate_materiale(dataframe.loc[x, "Materiale"], dataframe.loc[x, "TemperaturaPercepita"])
        punteggio += evaluate_stagione(dataframe.loc[x, "Stagione"], dataframe.loc[x, "StagionePrevisione"])
        punteggio += utils.evaluate_colore(dataframe.loc[x, "Meteo"], dataframe.loc[x, "Colore"],
                                     dataframe.loc[x, "TemperaturaPercepita"])
        punteggio += evaluate_lunghezza(dataframe.loc[x, "Lunghezza"], dataframe.loc[x, "TemperaturaPercepita"])
        lista.append(punteggio)

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
        'lungo': 0,
        'corto': 10,
        'medio': 3,
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
        'lungo': 2,
        'corto': 8,
        'medio': 6
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
        'lungo': 5,
        'corto': 5,
        'medio': 10
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
        'lungo': 8,
        'corto': 2,
        'medio':4
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
        'lungo': 9,
        'corto': 1,
        'medio': 3
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
        'lungo': 10,
        'corto': 0,
        'medio': 0
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
        'lungo': 10,
        'corto': 0,
        'medio': 0
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

# questa funzione assegna un punteggio al capo d'abbigliamento in base alla sua stagionalitù
def evaluate_stagione(stagione_capo, stagione_prev):
    i = utils.calculate_ranges_stagione(stagione_prev)
    return stagionalita[i][stagione_capo]

# questa funzione assegna un punteggio alla manica del capo rispetto alla temperatura percepita
def evaluate_lunghezza(lunghezza, temp_perc):
    i = utils.calculate_ranges_temperatura(temp_perc)
    return ranges[i][lunghezza]

# richiama la funzione per sommare i valori ottenuti
sum_values()

# si aggiunge la colonna Punteggio al dataframe, inizializzandola con la lista
dataframe["Punteggio"] = lista

# si esporta il dataframe in formato CSV
dataframe.to_csv("../newCsv_all_clothes/bottom_meteo_dataset.csv", index=False)

# si eliminano dal dataframe le colonne "time" e "mese", in quanto ininfluenti per la predizione
dataframe.pop('time')
dataframe.pop('Mese')

# si esporta nuovamente il dataframe in formato CSV
dataframe.to_csv("../newCsv_all_clothes/bottom_meteo_dataset_labeled.csv", index=False)

