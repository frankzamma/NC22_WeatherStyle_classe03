import pandas as pd

meteodf = pd.read_csv("../csv_dataset_meteo/meteo_dataset.csv")
capidf = pd.read_csv("../newCsv_all_clothes/bottom_dataset.csv")

#print("Numero di righe nel dataset meteo:"+str(len(meteodf.axes[0])))
#print("Numero di righe nel dataset vestiti:"+str(len(capidf.axes[0])))

# mischia in maniera casuale le righe dal dataframe capi
capidf.sample(frac=1.0)

# mischia in maniera casuale le righe dal dataframe meteo
meteodf.sample(frac=1.0)

# concatena il dataframe capi con il dataframe meteo
dataframe = pd.concat([capidf, meteodf], axis=1)

# elimina le righe con valori nulli nelle diverse celle
dataframe.dropna(inplace=True)

# elimina eventuali duplicati
dataframe.drop_duplicates()

# stampa informazioni sul dataframe finale
#print(dataframe.info())

# esportiamo il dataframe in formato csv
dataframe.to_csv("../newCsv_all_clothes/bottom_meteo_dataset_no_y.csv", index=False)
