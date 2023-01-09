import pandas as pd
import random as rd

# Alcuni dizionari usati nel codice -> lo script inzia a riga 106
dictonary = {
    'Leather': 'Cuoio',
    'Suede': 'Camoscio',
    'Rubber': 'Gomma',
    'Synthetic': 'Sintetico',
    "Full-grain leather": 'Pelle',
    'Mesh': 'Tessuto',
    'Nubuck': 'Pelle',
    'Canvas': 'Tela',
    'Nylon': 'Tessuto',
    'Patent Leather': 'Pelle',
    'Faux Leather': 'Ecopelle',
    'Lace': 'Tessuto',
    'Cotton': 'Tessuto',
    'Wool': 'Tessuto',
    'Faux Fur': 'Tessuto',
    'Microfiber': 'Tessuto',
    'Sheepskin': 'Pelle',
    'Hair Calf': 'Pelle',
    'Polyester': 'Poliestere',
    'Nappa': 'Cuoio',
    'Fleece': 'Tessuto',
    'Satin': 'Tessuto',
    'Neoprene': 'Gomma',
    'EVA': 'Gomma',
    'Shearling': 'Tessuto',
    'Velvet': 'Tessuto',
    'Felt': 'Tessuto',
    'Cork': 'Tessuto',
    'Jute': 'Tessuto',
    'Ripstop': 'Sintetico',
    'Terry': 'Sintetico',
    'Velour': 'Tessuto',
    'Polyurethane': 'Sintetico',
    'Corduroy': 'Tessuto',
    'Denim': 'Sintetico',
    'Cordura': 'Tessuto',
    'Linen': 'Tessuto',
    'Silk': 'Tessuto',
    'Deerskin': 'Pelle',
    'Hemp': 'Tessuto',
    'Vinyl': 'Sintetico',
    'Latex': 'Sintetico',
    'Crocodile': 'Pelle',
    'Crocodile ': 'Pelle',
    'Cable Knit': 'Tessuto',
    'Ostrich': 'Pelle',
    'Tweed': 'Tessuto',
    'Lambskin': 'Pelle',
    'Acrylic': 'Pelle',
    'Snakeskin': 'Pelle',
    'Exotic': 'Pelle',
    'Raffia': 'Pelle',
    'Distressed Leather': 'Cuoio',
    'Horse Hair': 'Tessuto',
    'Cashmere': 'Tessuto',
    'Faux Suede': 'Tessuto',
    'Jacquard': 'Tessuto',
    'Chiffon': 'Tessuto',
    'Crochet': 'Tessuto'
}

antiscivolo = {
    'EVA': True,
    'Padded': False,
    'Leather': False,
    'Moisture Wicking': True,
    'Memory Foam': True,
    'Removable': False,
    'Latex Lined': True,
    'Textile': False,
    'Gel': False,
    'Orthotic Friendly': True,
    'Polyurethane': False,
    'Synthetic Leather': False,
    'Hypoallergenic': False,
    'Poron': False,
}

traduttore_categorie = {
    'Sneakers and Athletic Shoes': 'Scarpa da ginnastica',
    'Ankle': 'Stivaletto alla caviglia',
    'Mid-Calf': 'Stivaletto alla caviglia',
    'Heels': 'Scarpe con tacchi',
    'Loafers': 'Scarpa classica',
    'Oxfords': 'Scarpa classica',
    'Clogs and Mules': 'Scarpe aperte',
    'Knee High': 'Stivaletto alla caviglia',
    'Boat Shoes': 'Anfibi',
    'Heel': 'Scarpe aperte',
    'Over the Knee': 'Stivali',
    'Athletic': 'Scarpa da ginnastica',
    'Boot': 'Stivali',
    'Slipper Heels': 'Scarpe aperte',
    'Prewalker Boots': 'Stivali'
}

impermeabilita_dict = {
    'Cuoio': 'y',
    'Tessuto': 'n',
    'Pelle': 'y',
    'Tela': 'n',
    'Camoscio': 'n',
    'Ecopelle': 'y',
    'Sintetico': 'n',
    'Gomma': 'y',
    'Poliestere': 'n',

}


dictonary_stagione = {
    'scarpa classica': ['all', 'primavera_estate', 'autunno_inverno', 'inverno'],
    'stivaletto alla caviglia': ['inverno', 'autunno_inverno', 'autunno'],
    'anfibi': ['autunno_inverno', 'inverno', 'autunno'],
    'stivali': ['inverno', 'autunno_inverno', 'autunno'],
    'scarpa da ginnastica': ['all', 'primavera_estate', 'autunno_inverno', 'inverno', 'estate'],
    'scarpe aperte': ['primavera_estate', 'estate', 'primavera'],
    'scarpe con tacchi': ['primavera_estate', 'autunno_inverno', 'inverno', 'estate']
}

df = pd.read_csv('../csv_all_clothes/shoes-dataset.csv')
df_missing = pd.read_csv('../csv_all_clothes/shoes-missing.csv')

df.pop('CID')
df.pop('HeelHeight')
df.pop('Gender')
df.pop('ToeStyle')
df.pop('Closure')

df.drop_duplicates(inplace=True)
df.dropna(inplace=True)

df.loc[:, 'Antiscivolo'] = 'n'
df.loc[:, 'Impermeabile'] = 'n'
df.drop(df[(df.SubCategory == 'Slipper Flats')].index, inplace=True)
df.drop(df[(df.SubCategory == 'Prewalker')].index, inplace=True)
df.drop(df[(df.SubCategory == 'Firstwalker')].index, inplace=True)
df.drop(df[(df.SubCategory == 'Crib Shoes')].index, inplace=True)
df.drop(df[(df.SubCategory == 'Flat')].index, inplace=True)
df.drop(df[(df.SubCategory == 'Flats')].index, inplace=True)
'''
- Stagione
- Impermeabile
- Antiscivolo
- Stagione 
'''

df.loc[:, 'Colore'] = 'chiaro'
df.loc[:, 'Stagione'] = ''
for i in df.index:
    if df.loc[i, 'Material'].__contains__(';'):
        tmp = str(df.loc[i, 'Material']).split(';')
        df.loc[i, 'Material'] = tmp[0]
    df.loc[i, 'Material'] = dictonary[str(df.loc[i, 'Material'])]

    coin = rd.randint(0, 2)
    if coin == 0:
        df.loc[i, 'Colore'] = 'scuro'
    elif coin == 1:
        df.loc[i, 'Colore'] = 'colorato'

    '''if str(df.loc[i, 'SubCategory']) == 'Sneakers and Athletic Shoes':
        if coin == 0:
            df.loc[i, 'SubCategory'] = 'Sneakers'
        else:
            df.loc[i, 'SubCategory'] = 'Athletic Shoes'''''

    if df.loc[i, 'Insole'].__contains__(';'):
        tmp = str(df.loc[i, 'Insole']).split(';')
        df.loc[i, 'Insole'] = tmp[0]

    if antiscivolo[df.loc[i, 'Insole']]:
        df.loc[i, 'Antiscivolo'] = 'y'

    df.loc[i, 'SubCategory'] = traduttore_categorie[df.loc[i, 'SubCategory']].lower()

    if df.loc[i, 'SubCategory'] != 'Scarpe con tacchi'.lower() and df.loc[i, 'SubCategory'] != 'scarpe aperte':
        df.loc[i, 'Impermeabile'] = impermeabilita_dict[df.loc[i, 'Material']]

    stagione = dictonary_stagione[df.loc[i, 'SubCategory']]
    number = rd.randint(0, len(stagione) - 1)
    df.loc[i, 'Stagione'] = stagione[number].lower()

df.pop('Material')
df.pop('Category')
df.pop('Insole')

df.rename(columns={'SubCategory': 'Tipo'}, inplace=True)


print(df['Tipo'].value_counts().to_string())
# df.drop_duplicates(inplace=True)
print(df.info())

# print(df['SubCategory'].value_counts().to_string() + '\n\n')
# print(df['Category'].value_counts().to_string() + '\n\n')
# print(df['Material'].value_counts().to_string() + '\n\n')

final_df = pd.concat([df, df_missing])
print(df_missing.info())
print(final_df.info())

print(final_df['Tipo'].value_counts().to_string())
final_df.to_csv('../newCsv_all_clothes/shoes-dataset.csv', index=False)


#TODO Aggiungere commenti
