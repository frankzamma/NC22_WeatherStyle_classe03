import pandas as pd

# in questo script si fondono i dataset meteo e capi, visto che le osservazioni per i capi sono superiori rispetto
# al dataset meteo, abbiamo pensato di fondere più volte il dataset meteo con quello dei capi, così da avere un
# gran numero di osservazioni diversificate
meteodf = pd.read_csv("../csv_dataset_meteo/dataset_meteo.csv")
meteodf1 = pd.read_csv("../csv_dataset_meteo/meteo_dataset.csv")
capidf = pd.read_csv("../newCsv_all_clothes/top_dataset.csv")

# mischia in maniera casuale le righe dal dataframe capi
capidf.sample(frac=1.0)

# concatena i due dataframe del meteo e mischia le righe in maniera casuale
meteodf = pd.concat([meteodf, meteodf1])
meteodf.sample(frac=1.0)

# reimposta gli indici nel dataframe meteodf
meteodf.reset_index(inplace=True, drop=True)

# concatena il dataframe capi con il dataframe meteo
dataframe = pd.concat([capidf, meteodf], axis=1)

# elimina le righe con valori nulli nelle diverse celle
dataframe.dropna(inplace=True)

# elimina eventuali duplicati
dataframe.drop_duplicates()

# stampa informazioni sul dataframe finale
print(dataframe.info())

# stampa il numero di valori per ogni colonna del dataframe
print("\n")
print(dataframe["Materiale"].value_counts())
print("\n")
print(dataframe["Colore"].value_counts())
print("\n")
print(dataframe["Manica"].value_counts())
print("\n")
print(dataframe["Stagione"].value_counts())
print("\n")
print(dataframe["Meteo"].value_counts())
print("\n")
print(dataframe["TemperaturaPercepita"].value_counts())
print("\n")
print(dataframe["StagionePrevisione"].value_counts())

# esportiamo il dataframe in formato csv nella cartella indicata
dataframe.to_csv("../newCsv_all_clothes/dataset_capi_meteo_no_y.csv", index=False)