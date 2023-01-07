import pandas as pd

df_meteo = pd.read_csv('../csv_dataset_meteo/meteo_dataset.csv')

df_shoes = pd.read_csv('../newCsv_all_clothes/shoes-dataset.csv')

df_meteo.sample(frac=1.0)

df = pd.concat([df_shoes, df_meteo], axis=1)

df.pop('time')
df.pop('Mese')
df.dropna(inplace=True)
df.drop_duplicates(inplace=True)

print(df.info())

df.reset_index(inplace=True, drop=True)

print(df_meteo['Meteo'].value_counts().to_string())

df.to_csv('../newCsv_all_clothes/shoes_meteo_dataset.csv', index=False)
#TODO Aggiungere commenti


