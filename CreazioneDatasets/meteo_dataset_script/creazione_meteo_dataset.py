import pandas as pd
import os
array =['Belluno.csv', 'Firenze.csv', 'Genova.csv', 'Napoli.csv', 'Palermo.csv', 'Parma.csv', 'Potenza.csv', 'Roma.csv',
        'Salerno.csv', 'Treviso.csv', 'Milano.csv', 'Aosta.csv', 'Cortina.csv', 'Fisciano.csv']

dictonary = {
    0: "Cielo chiaro",
    1: "Principalmente chiaro",
    2: "Parzialmente nuvoloso",
    3: "Coperto",
    45: "Nebbia",
    48: "Nebbia",
    51: "pioggerella debole",
    53: "pioggerella Moderata",
    55: "pioggerella intensa",
    56: "Congelamento leggero",
    57: "Congelamento forte",
    61: "Pioggia",
    63: "Pioggia moderata",
    65: "Pioggia molto intensa",
    66: "Grandine",
    67: "Grandine forte",
    71: "Nevicate leggere",
    73: "Nevicate moderate",
    75: "Nevicate molto intense",
    77: "Granelli di neve",
    80: "Pioggia a carattere temporalesco leggero",
    81: "Pioggia a carattere temporalesco l Medio",
    82: "Pioggia a carattere temporalesco l Violento",
    85: "Neve leggera",
    86: "Neve Intensa",
    95: "Temporale",
    96: "Temporale con grandine leggera",
    99: "Temporale Forte"
}
if not(os.path.exists('../newCsv_meteo')):
    os.mkdir('../newCsv_meteo')

for file in array:
    df = pd.read_csv('../csv_meteo/' + file)

    df.loc[:, 'TemperaturaPercepita'] = 0
    df.rename(columns={'weathercode': 'Meteo'}, inplace=True)
    for i in df.index:
        df.loc[i, 'TemperaturaPercepita'] = \
            (df.loc[i, 'apparent_temperature_max'] + df.loc[i, 'apparent_temperature_min'])/2

        df.loc[i, 'Meteo'] = dictonary[df.loc[i, 'Meteo']]

    df.pop('apparent_temperature_max')
    df.pop('apparent_temperature_min')

    name = '../newCsv_meteo/New' + file
    df.to_csv(name, index=False)

    print(df)

final = []

for i in array:
    name = '../newCsv_meteo/New' + i
    final.append(pd.read_csv(name))


final_df = pd.concat(final, ignore_index=True)


if not(os.path.exists('../dataset_meteo')):
    os.mkdir('../dataset_meteo')

final_df.to_csv('../dataset_meteo/dataset_meteo.csv', index=False)

print(final_df)

