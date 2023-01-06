import pandas as pd

df_meteo = pd.read_csv('../csv_dataset_meteo/meteo_dataset.csv')

df_shoes = pd.read_csv('../newCsv_all_clothes/shoes-dataset.csv')

df_meteo.sample(frac=1.0)

df = pd.concat([df_meteo, df_shoes], axis=1)

df.dropna(inplace=True)
df.drop_duplicates(inplace=True)

print(df.info())

df.reset_index(inplace=True, drop=True)

df.to_csv('../newCsv_all_clothes/shoes_meteo_dataset.csv', index=False)
#TODO Aggiungere commenti


