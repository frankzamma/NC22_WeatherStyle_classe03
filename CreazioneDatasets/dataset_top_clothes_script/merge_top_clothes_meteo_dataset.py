import pandas as pd

meteodf = pd.read_csv("../csv_dataset_meteo/dataset_meteo.csv")
meteodf1 = pd.read_csv("../csv_dataset_meteo/meteo_dataset.csv")
capidf = pd.read_csv("../newCsv_all_clothes/top_dataset.csv")

capidf.sample(frac=1.0)

meteodf = pd.concat([meteodf, meteodf1])
meteodf.sample(frac=1.0)

meteodf.reset_index(inplace=True, drop=True)

dataframe = pd.concat([capidf, meteodf], axis=1)

dataframe.dropna(inplace=True)

dataframe.drop_duplicates()

print(dataframe.info())

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

dataframe.to_csv("../newCsv_all_clothes/dataset_capi_meteo_no_y.csv", index=False)