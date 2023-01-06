import pandas as pd

df = pd.read_csv('../csv_all_clothes/shoes-dataset.csv')

df.pop('CID')
df.pop('HeelHeight')
df.pop('Gender')
df.pop('ToeStyle')
df.pop('Closure')

df.drop_duplicates(inplace=True)
df.dropna(inplace=True)

dictonary = {
    'Leather': 'Cuoio',
    'Suede': 'Camoscio',
    'Rubber': 'Gomma',
    'Synthetic': 'Sintetico',
    "Full-grain leather":  'Pelle',
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

scivoloso = {
    'EVA': False,
    'Padded': False,
    'Leather': True,
    'Moisture Wicking': False,
    'Memory Foam': False,
    'Removable': True,
    'Latex Lined': False,
    'Textile': True,
    'Gel': True,
    'Orthotic Friendly': False,
    'Polyurethane': True,
    'Synthetic Leather': True,
    'Hypoallergenic': True,
    'Poron': True,
}
df.loc[:, 'Scivoloso'] = False
#j = 0
for i in df.index:
    if df.loc[i, 'Material'].__contains__(';'):
        tmp = str(df.loc[i, 'Material']).split(';')
        df.loc[i, 'Material'] = tmp[0]
    df.loc[i, 'Material'] = dictonary[str(df.loc[i, 'Material'])]
    #print(j)
    #j+=1
    if df.loc[i, 'Insole'].__contains__(';'):
        tmp = str(df.loc[i, 'Insole']).split(';')
        df.loc[i, 'Insole'] = tmp[0]

    if scivoloso[df.loc[i, 'Insole']]:
        df.loc[i, 'Scivoloso'] = True

print(df.info())

print(df['SubCategory'].value_counts().to_string())
print(df['Category'].value_counts().to_string())

#TODO Calcolo attributo Impermeabile da Category + Material

df.to_csv('../newCsv_all_clothes/shoes-dataset.csv', index=False)
#Rubber -> gomma
