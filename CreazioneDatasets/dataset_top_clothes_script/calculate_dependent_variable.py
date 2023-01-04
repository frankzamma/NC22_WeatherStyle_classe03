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
    }
    # da fare per altri range
]


# questa funzione identifica il range corretto in base alla temperatura percepita
def calculate_ranges(temp_perc):
    pass


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
    pass

