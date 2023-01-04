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
    }

    # da fare per altri range


]


# questa funzione identifica il range corretto in base alla temperatura percepita
def calculate_ranges(temp_perc):
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


# questa funzione assegna un punteggio al materiale rispetto alla temperatura percepita
def evaluate_materiale(materiale, temp_perc):
    pass


# questa funzione assegna un punteggio alla stagione del capo rispetto alla temperatura percepita
def evaluate_stagione(stagione_capo, stagione_prev):
    pass


# questa funzione assegna un punteggio al colore del capo rispetto al meteo e alla temperatura percepita
def evaluate_colore(meteo, colore, temp_perc):
    pass


# questa funzione assegna un punteggio alla manica del capo rispetto alla temperatura percepita
def evaluate_manica(manica, temp_perc):
    i = calculate_ranges(temp_perc)
    return ranges[i][manica]


