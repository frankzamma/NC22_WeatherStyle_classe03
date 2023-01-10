import pandas as pd
import random as rd
from CreazioneDatasets import utilis_creation as uc

pd.options.display.max_rows = 15000

# colonne considerate:
# Type          --> Tipo (Top, Bottom, Dress)
# Material      --> Materiale
# Color         --> Colore
# Season        --> Stagione

dataframe = pd.read_csv("../csv_all_clothes/top_bottom_git.csv")

# elimina le righe top -> maglie
for x in dataframe.index:
    if dataframe.loc[x, "Tipo"] == "Top":
        dataframe.drop(x, inplace=True)

# elimina le righe dress
for x in dataframe.index:
    if dataframe.loc[x, "Tipo"] == "Dress":
        dataframe.drop(x, inplace=True)

# materiali considerati per il nostro problema
# 1     Cotton          --> cotone
# 2     Polyester       --> poliestere
# 3     Viscose         --> seta
# 4     Satin           --> raso
# 5     Velvet          --> velluto
# 6     Cotton Blends   --> cotone
# 7     Crochet         --> tweed
# 8     Linen           --> lino

dataframe.rename(columns={'Manica': 'Lunghezza'}, inplace=True)

# verifica che la colonna sia stata rinominata correttamente
# for column in dataframe:
# for column in dataframe:
#  print(column)

# caricare CSV con dati generati da Excel
capi_mancanti_df = pd.read_csv("../csv_all_clothes/bottom_missing.csv")
dataframe = pd.concat([dataframe, capi_mancanti_df])

# resetta gli indici del dataframe
dataframe.reset_index(inplace=True, drop=True)

# eliminiamo la colonna Tipo non più utile
dataframe.drop('Tipo', axis=1, inplace=True)

# cambiamo il nome dei materiali per averli tutti in italiano
# ed eliminiamo tutte le righe con materiali che non sono stati considerati per il nostro problema
dataframe = uc.translate_and_clean_material(dataframe)

# contiamo le occorrenze per ciascuna stagione
# print(dataframe["Stagione"].value_counts())

# cambiamo i valori delle stagioni in italiano
dataframe = uc.translate_season(dataframe)

# contiamo le occorrenze dopo aver ordinato il dataset
# print(dataframe["Stagione"].value_counts())

# imputazione dell'attributo lunghezza del pantalone
dataframe.loc[:, 'Lunghezza'] = 'lunga'
dataframe.dropna(inplace=True)

dictonary = {
    'autunno': ['lunga'],
    'inverno': ['lunga'],
    'primavera': ['lunga', 'media'],
    'estate': ['lunga', 'media', 'corta'],
    'primavera_estate': ['lunga', 'media', 'corta'],
    'autunno_inverno': ['lunga'],
    'all': ['lunga']
}

for i in dataframe.index:
    array = dictonary[dataframe.loc[i, 'Stagione']]
    number = rd.randint(0, len(array) - 1)
    dataframe.loc[i, 'Lunghezza'] = array[number]

dataframe.dropna(inplace=True)

# sostituiamo i colori con i valori --> chiaro, scuro e colorato
dataframe = uc.imputation_colore(dataframe)

print(dataframe["Colore"].value_counts())
print(dataframe.info())

# esportiamo il dataframe in formato csv
dataframe.to_csv("../newCsv_all_clothes/bottom_dataset.csv", index=False)
