"""
 #   Column                Non-Null Count  Dtype
---  ------                --------------  -----
 0   time                  5026 non-null   object
 1   Meteo                 5026 non-null   object
 2   TemperaturaPercepita  5026 non-null   float64
 3   StagionePrevisione    5026 non-null   object
 4   Mese                  5026 non-null   object
 5   Tipo                  5026 non-null   object
 6   Scivoloso             5026 non-null   bool
 7   Impermeabile          5026 non-null   bool
 8   Colore                5026 non-null   object
 9   Stagione              5026 non-null   object
 """
import pandas as pd
import utils

ranges = [
    {  # temperatura > 30°
        'inverno': 0,
        'autunno': 1,
        'primavera': 2,
        'estate': 5,
        'primavera_estate': 4,
        'autunno_inverno': 1,
        'all': 3
    },
    {  # 25° <= temperatura < 30°
        'inverno': 0,
        'autunno': 1,
        'primavera': 3,
        'estate': 5,
        'primavera_estate': 4,
        'autunno_inverno': 1,
        'all': 3
    },
    {  # 20° <= temperatura < 25°
        'inverno': 1,
        'autunno': 2,
        'primavera': 5,
        'estate': 4,
        'primavera_estate': 4,
        'autunno_inverno': 1,
        'all': 3
    },
    {  # 15° <= temperatura < 20°
        'inverno': 4,
        'autunno': 5,
        'primavera': 4,
        'estate': 3,
        'primavera_estate': 3,
        'autunno_inverno': 4,
        'all': 3
    },
    {  # 10 <= temperatura < 15°
        'inverno': 5,
        'autunno': 5,
        'primavera': 3,
        'estate': 1,
        'primavera_estate': 2,
        'autunno_inverno': 4,
        'all': 3
    },
    {  # 5 <= temperatura < 10°
        'inverno': 5,
        'autunno': 4,
        'primavera': 1,
        'estate': 0,
        'primavera_estate': 0,
        'autunno_inverno': 4,
        'all': 3
    },
    {  # temperatura < 5°
        'inverno': 5,
        'autunno': 3,
        'primavera': 1,
        'estate': 0,
        'primavera_estate': 0,
        'autunno_inverno': 3,
        'all': 3
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


def evaluate_stagione(stagione_capo, stagione_prev):
    i = utils.calculate_ranges_stagione(stagione_prev)
    return stagionalita[i][stagione_capo]


def evaluate_temperature(stagione_capo, temperatura_percepita):
    i = utils.calculate_ranges_temperatura(temperatura_percepita)
    return ranges[i][stagione_capo]


def evaluate_pioggia(scivoloso, impermeabile):
    if scivoloso and impermeabile:
        return 5
    elif scivoloso :
        return 3
    elif impermeabile:
        return 4
    else:
        return 0


df = pd.read_csv('../newCsv_all_clothes/shoes_meteo_dataset.csv')

df.loc[:, 'Punteggio'] = 0

for x in df.index:
    p = 0
    p += evaluate_temperature(df.loc[x, "Stagione"], df.loc[x, "TemperaturaPercepita"])
    p += evaluate_stagione(df.loc[x, "Stagione"], df.loc[x, "StagionePrevisione"])
    p += utils.evaluate_colore(df.loc[x, "Meteo"], df.loc[x, "Colore"],\
                                 df.loc[x, "TemperaturaPercepita"])
    if df.loc[x, 'Meteo'] == 'pioggia' or df.loc[x, 'Meteo'] == 'neve':
        p += evaluate_pioggia(df.loc[x, 'Scivoloso'], df.loc[x, 'Scivoloso'])

    df.loc[x, 'Punteggio']  = p
print(df.info())

df.to_csv('../newCsv_all_clothes/shoes_meteo_dataset_labeled.csv', index=False)
#TODO Aggiungere commenti