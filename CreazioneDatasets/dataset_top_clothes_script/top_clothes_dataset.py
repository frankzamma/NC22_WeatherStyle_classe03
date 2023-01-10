import pandas as pd
from CreazioneDatasets import utilis_creation as uc

# in questo script costruiremo un dataset esclusivamente pensato per le maglie, ossia quelle indicate come "Top"

# numero massimo di righe da mostrare a schermo per stampare il dataframe
pd.options.display.max_rows = 15000

# dataset preso da github in cui sono state tolte alcune colonne preliminarmente ed etichettate in italiano
# link github: https://github.com/justjess678/clothes-scraper.git
# colonne considerate:
# Type          --> Tipo (Top, Bottom, Dress)
# Material      --> Materiale
# Color         --> Colore
# Sleeve Lenght --> Manica
# Season        --> Stagione
dataframe = pd.read_csv("../csv_all_clothes/top_bottom_git.csv")

# stampiamo informazioni sul dataframe
# print(dataframe.info())

# stampiamo il numero di valori presenti nel dataframe per il tipo
# print(dataframe["Tipo"].value_counts())

# elimina le righe bottom --> pantaloni
for x in dataframe.index:
    if str(dataframe.loc[x, "Tipo"]) == "Bottom":
        dataframe.drop(x, inplace=True)

# elimina le righe dress --> vestiti da donna
for x in dataframe.index:
    if str(dataframe.loc[x, "Tipo"]) == "Dress":
        dataframe.drop(x, inplace=True)

# stampiamo il numero di valori presenti nel dataframe per i materiali
# print(dataframe["Stagione"].value_counts())

# materiali considerati per il nostro problema
# 1     Cotton          --> cotone
# 2     Polyester       --> poliestere
# 3     Viscose         --> seta
# 4     Satin           --> raso
# 5     Velvet          --> velluto
# 6     Cotton Blends   --> cotone
# 7     Crochet         --> tweed
# 8     Linen           --> lino

# concateniamo il dataframe con un'altro dataframe di capi dato che alcuni di questi erano presenti in numero inferiore
# per il nostro problema, tali osservazioni sono state generate in maniera pseudo-casuale con google sheets
capi_mancanti_df = pd.read_csv("../csv_all_clothes/top_missing.csv")
dataframe = pd.concat([dataframe, capi_mancanti_df])

# resetta gli indici del dataframe
dataframe.reset_index(inplace=True, drop=True)

# eliminiamo la colonna Tipo non più utile
dataframe.drop('Tipo', axis=1, inplace=True)

# cambiamo il nome dei materiali per averli tutti in italiano
# ed eliminiamo tutte le righe con materiali che non sono stati considerati per il nostro problema
dataframe = uc.translate_and_clean_material(dataframe)

# rimuove le righe con celle che hanno valori mancanti, mediante delle stampe abbiamo notato che il valore mancante
# fosse principalmente la manica, quindi abbiamo trovato un modo per inserirla
# dataframe.dropna(inplace=True)

# andiamo a usare la moda per inserire i valori mancanti nelle righe con cella "Manica" vuota
x = dataframe["Manica"].mode()[0]
dataframe["Manica"].fillna(x, inplace=True)

# eliminiamo tutte le righe che presentano valori vuoti nelle celle
dataframe.dropna(inplace=True)

# stampiamo il numero di valori presenti nel dataframe per le stagioni
# print(dataframe["Stagione"].value_counts())

# cambiamo i valori delle stagioni in italiano
dataframe = uc.translate_season(dataframe)

# stampiamo il numero di valori presenti nel dataframe per i colori
# print(dataframe["Materiale"].value_counts())

# sostituiamo i colori con i valori --> chiaro, scuro e colorato
dataframe = uc.imputation_colore(dataframe)

# stampiamo il numero di valori presenti nel dataframe per le maniche
# print(dataframe["Maniche"].value_counts())

# sostituiamo i valori delle maniche con i valori --> lunghi e corti
for x in dataframe.index:
    if str(dataframe.loc[x, "Manica"]) == "Long Sleeve":
        dataframe.loc[x, "Manica"] = "lunga"
    if str(dataframe.loc[x, "Manica"]) == "Short Sleeve":
        dataframe.loc[x, "Manica"] = "corta"
    if str(dataframe.loc[x, "Manica"]) == "Sleeveless":
        dataframe.loc[x, "Manica"] = "corta"
    if str(dataframe.loc[x, "Manica"]) == "['Short Sleeve', ' Cap Sleeve']":
        dataframe.loc[x, "Manica"] = "corta"
    if str(dataframe.loc[x, "Manica"]) == "['Short Sleeve', ' Half Sleeve']":
        dataframe.loc[x, "Manica"] = "corta"
    if str(dataframe.loc[x, "Manica"]) == "Three Quarter Length Sleeve":
        dataframe.loc[x, "Manica"] = "lunga"
    if str(dataframe.loc[x, "Manica"]) == "Half Sleeve":
        dataframe.loc[x, "Manica"] = "corta"
    if str(dataframe.loc[x, "Manica"]) == "Cap Sleeve":
        dataframe.loc[x, "Manica"] = "corta"
    if str(dataframe.loc[x, "Manica"]) == "Extra-Long Sleeve":
        dataframe.loc[x, "Manica"] = "lunga"


# mischiamo i dati
dataframe.sample(frac=1.0)

# esportiamo il dataframe in formato csv
dataframe.to_csv("../newCsv_all_clothes/top_dataset.csv", index=False)


