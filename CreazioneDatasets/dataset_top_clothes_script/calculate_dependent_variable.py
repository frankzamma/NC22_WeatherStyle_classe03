import pandas as pd

# per prima cosa, si importa il dataset contenente i capi d'abbigliamento e il meteo
dataframe = pd.read_csv("../newCsv_all_clothes/top_meteo_dataset_no_y.csv")

print(dataframe.info())

lista = []


# definiamo una funzione che somma dei valori che costituirà il valore della variabile dipendente
# in particolare, somma la valutazione del materiale, della stagione, del colore e della manica
def sum_values():
    for x in dataframe.index:
        punteggio = 0
        punteggio += evaluate_materiale(dataframe.loc[x, "Materiale"], dataframe.loc[x, "TemperaturaPercepita"])
        punteggio += evaluate_stagione(dataframe.loc[x, "Stagione"], dataframe.loc[x, "StagionePrevisione"])
        punteggio += evaluate_colore(dataframe.loc[x, "Meteo"], dataframe.loc[x, "Colore"],
                                     dataframe.loc[x, "TemperaturaPercepita"])
        punteggio += evaluate_manica(dataframe.loc[x, "Manica"], dataframe.loc[x, "TemperaturaPercepita"])
        lista.append(punteggio)


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
    }
]

stagionalita = [
    {  # stagione inverno
        'inverno': 10,
        'autunno': 7,
        'primavera': 4,
        'estate': 0,
        'primavera_estate': 0,
        'autunno_inverno': 8,
        'all': 5
    },
    {  # stagione primavera
        'primavera': 10,
        'estate': 7,
        'autunno': 5,
        'inverno': 3,
        'primavera_estate': 8,
        'autunno_inverno': 4,
        'all': 5
    },
    {  # stagione estate
        'estate': 10,
        'autunno': 4,
        'inverno': 0,
        'primavera': 7,
        'primavera_estate': 8,
        'autunno_inverno': 2,
        'all': 5
    },
    {  # stagione autunno
        'autunno': 10,
        'inverno': 7,
        'primavera': 5,
        'estate': 3,
        'primavera_estate': 4,
        'autunno_inverno': 8,
        'all': 5
    }
]


# questa funzione identifica il range corretto in base alla temperatura percepita
def calculate_ranges_temperatura(temp_perc):
    if temp_perc >= 30:
        return 0
    if 25 <= temp_perc < 30:
        return 1
    if 20 <= temp_perc < 25:
        return 2
    if 15 <= temp_perc < 20:
        return 3
    if 10 <= temp_perc < 15:
        return 4
    if 5 <= temp_perc < 10:
        return 5
    if temp_perc < 5:
        return 6


def calculate_ranges_stagione(stagione):
    if stagione == "inverno":
        return 0
    if stagione == "primavera":
        return 1
    if stagione == "estate":
        return 2
    if stagione == "autunno":
        return 3


# questa funzione assegna un punteggio al materiale rispetto alla temperatura percepita
def evaluate_materiale(materiale, temp_perc):
    i = calculate_ranges_temperatura(temp_perc)
    return ranges[i][materiale]


# questa funzione assegna un punteggio al capo d'abbigliamento in base alla sua stagionalitù
def evaluate_stagione(stagione_capo, stagione_prev):
    i = calculate_ranges_stagione(stagione_prev)
    return stagionalita[i][stagione_capo]


# questa funzione assegna un punteggio al colore del capo rispetto al meteo e alla temperatura percepita
def evaluate_colore(meteo, colore, temp_perc):
    i = calculate_ranges_temperatura(temp_perc)
    if colore == "chiaro" and meteo == "soleggiato" and i <= 2:
        return 10
    elif colore == "scuro" and meteo == "soleggiato" and i <= 2:
        return 0
    else:
        return 5


# questa funzione assegna un punteggio alla manica del capo rispetto alla temperatura percepita
def evaluate_manica(manica, temp_perc):
    i = calculate_ranges_temperatura(temp_perc)
    return ranges[i][manica]


# richiama la funzione per sommare i valori ottenuti
sum_values()

# si aggiunge la colonna Punteggio al dataframe, inizializzandola con la lista
dataframe["Punteggio"] = lista

# stampa il dataframe ottenuto
print(dataframe.to_string())

# si esporta il dataframe in formato CSV
dataframe.to_csv("../newCsv_all_clothes/top_meteo_dataset.csv", index=False)

# si eliminano dal dataframe le colonne "time" e "mese", in quanto ininfluenti per la predizione
dataframe.pop('time')
dataframe.pop('Mese')

# si esporta nuovamente il dataframe in formato CSV
dataframe.to_csv("../newCsv_all_clothes/top_meteo_dataset_selection.csv", index=False)
