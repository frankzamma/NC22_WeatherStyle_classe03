import pandas as pd
from CreazioneDatasets import utils_depend_variable as udv

dataframe = pd.read_csv("../newCsv_all_clothes/bottom_meteo_dataset_no_y.csv")


# richiama la funzione per sommare i valori ottenuti
dataframe = udv.compute_dv(dataframe, bottom=True)


# si esporta il dataframe in formato CSV
dataframe.to_csv("../newCsv_all_clothes/bottom_meteo_dataset.csv", index=False)

# si eliminano dal dataframe le colonne "time" e "mese", in quanto ininfluenti per la predizione
dataframe.pop('time')
dataframe.pop('Mese')

# si esporta nuovamente il dataframe in formato CSV
dataframe.to_csv("../newCsv_all_clothes/bottom_meteo_dataset_labeled.csv", index=False)
dataframe.to_csv('../../src/main/webapp/WEB-INF/resources/csv/bottom_meteo_dataset_labeled.csv', index=False)
