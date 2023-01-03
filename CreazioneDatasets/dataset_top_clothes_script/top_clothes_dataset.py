import pandas as pd

# in questo script costruiremo un dataset esclusivamente pensato per le maglie, ossia quelle indicate come "Top"

# numero massimo di righe da mostrare a schermo per stampare il dataframe
pd.options.display.max_rows = 15000

# dataset preso da github in cui sono state tolte alcune colonne preliminarmente mediante excel ed etichettate in italiano
# link github: https://github.com/justjess678/clothes-scraper.git
# colonne considerate:
# Type          --> Tipo (Top, Bottom, Dress)
# Material      --> Materiale
# Color         --> Colore
# Sleeve Lenght --> Manica
# Season        --> Stagione
dataframe = pd.read_csv("./csv_top_bottom/top_bottom_git.csv")

# stampiamo informazioni sul dataframe
# print(dataframe.info())

# stampiamo il numero di valori presenti nel dataframe per il tipo
# print(dataframe["Tipo"].value_counts())

# elimina le righe bottom --> pantaloni
for x in dataframe.index:
    if dataframe.loc[x, "Tipo"] == "Bottom":
        dataframe.drop(x, inplace=True)

# elimina le righe dress --> vestiti da donna
for x in dataframe.index:
    if dataframe.loc[x, "Tipo"] == "Dress":
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
capi_mancanti_df = pd.read_csv("./csv_top_bottom/top_missing.csv")
dataframe = pd.concat([dataframe, capi_mancanti_df])

# resetta gli indici del dataframe
dataframe.reset_index(inplace=True, drop=True)

# eliminiamo la colonna Tipo non più utile
dataframe.drop('Tipo', axis=1, inplace=True)

# cambiamo il nome dei materiali per averli tutti in italiano
for x in dataframe.index:
    if str(dataframe.loc[x, "Materiale"]).__contains__("Cotton"):
        dataframe.loc[x, "Materiale"] = "cotone"
    if str(dataframe.loc[x, "Materiale"]) == "Polyester":
        dataframe.loc[x, "Materiale"] = "poliestere"
    if str(dataframe.loc[x, "Materiale"]) == "Viscose":
        dataframe.loc[x, "Materiale"] = "seta"
    if str(dataframe.loc[x, "Materiale"]) == "Satin":
        dataframe.loc[x, "Materiale"] = "raso"
    if str(dataframe.loc[x, "Materiale"]) == "Linen":
        dataframe.loc[x, "Materiale"] = "lino"
    if str(dataframe.loc[x, "Materiale"]) == "Velvet":
        dataframe.loc[x, "Materiale"] = "velluto"
    if str(dataframe.loc[x, "Materiale"]) == "Crochet":
        dataframe.loc[x, "Materiale"] = "tweed"

# eliminiamo tutte le righe con materiali che non sono stati considerati per il nostro problema
for x in dataframe.index:
    if (str(dataframe.loc[x, "Materiale"]) != "cotone") and (str(dataframe.loc[x, "Materiale"]) != "poliestere") \
            and (str(dataframe.loc[x, "Materiale"]) != "seta") and (str(dataframe.loc[x, "Materiale"]) != "lino") \
            and (str(dataframe.loc[x, "Materiale"]) != "tweed") and (str(dataframe.loc[x, "Materiale"]) != "raso")\
            and (str(dataframe.loc[x, "Materiale"]) != "velluto") and (str(dataframe.loc[x, "Materiale"]) != "lana")\
            and (str(dataframe.loc[x, "Materiale"])):
        dataframe.drop(x, inplace=True)

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
i = 0
for x in dataframe.index:
    if dataframe.loc[x, "Stagione"] == "Summer":
        dataframe.loc[x, "Stagione"] = "estate"
    if dataframe.loc[x, "Stagione"] == "Spring":
        dataframe.loc[x, "Stagione"] = "primavera"
    if dataframe.loc[x, "Stagione"] == "Fall":
        dataframe.loc[x, "Stagione"] = "autunno"
    if dataframe.loc[x, "Stagione"] == "Winter":
        dataframe.loc[x, "Stagione"] = "inverno"
    if dataframe.loc[x, "Stagione"] == "['Spring', 'Summer']":
        dataframe.loc[x, "Stagione"] = "primavera_estate"
    if dataframe.loc[x, "Stagione"] == "['Fall', 'Winter']":
        dataframe.loc[x, "Stagione"] = "autunno_inverno"
    if dataframe.loc[x, "Stagione"] == "['Spring', 'Fall']":
        if i % 2 == 0:
            dataframe.loc[x, "Stagione"] = "autunno"
        else:
            dataframe.loc[x, "Stagione"] = "primavera"
            i += 1
    if dataframe.loc[x, "Stagione"] == "All":
        dataframe.loc[x, "Stagione"] = "all"
    if dataframe.loc[x, "Stagione"] == "['Spring', 'Summer', 'Fall']":
        dataframe.drop(x, inplace=True)


# stampiamo il numero di valori presenti nel dataframe per i colori
# print(dataframe["Materiale"].value_counts())

# sostituiamo i colori con i valori --> chiaro, scuro e colorato
for x in dataframe.index:
    if dataframe.loc[x, "Colore"] == "Multicolor":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "Black":
        dataframe.loc[x, "Colore"] = "scuro"
    if dataframe.loc[x, "Colore"] == "Beige":
        dataframe.loc[x, "Colore"] = "chiaro"
    if dataframe.loc[x, "Colore"] == "Brown":
        dataframe.loc[x, "Colore"] = "scuro"
    if dataframe.loc[x, "Colore"] == "Burgundy":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "Dusty Pink":
        dataframe.loc[x, "Colore"] = "scuro"
    if dataframe.loc[x, "Colore"] == "White":
        dataframe.loc[x, "Colore"] = "chiaro"
    if dataframe.loc[x, "Colore"] == "Green":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "['Pastel', ' Baby Pink']":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "Coral Pink":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "Dusty Blue":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "Red":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "Mint Green":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "Black and White":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "Navy Blue":
        dataframe.loc[x, "Colore"] = "scuro"
    if dataframe.loc[x, "Colore"] == "['Pastel', ' Dusty Pink']":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "Lime Green":
        dataframe.loc[x, "Colore"] = "chiaro"
    if dataframe.loc[x, "Colore"] == "Baby Pink":
        dataframe.loc[x, "Colore"] = "chiaro"
    if dataframe.loc[x, "Colore"] == "Maroon":
        dataframe.loc[x, "Colore"] = "scuro"
    if dataframe.loc[x, "Colore"] == "Dark Grey":
        dataframe.loc[x, "Colore"] = "scuro"
    if dataframe.loc[x, "Colore"] == "Army Green":
        dataframe.loc[x, "Colore"] = "scuro"
    if dataframe.loc[x, "Colore"] == "Grey":
        dataframe.loc[x, "Colore"] = "scuro"
    if dataframe.loc[x, "Colore"] == "['Pastel', ' Lilac Purple']":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "Light Grey":
        dataframe.loc[x, "Colore"] = "chiaro"
    if dataframe.loc[x, "Colore"] == "Khaki":
        dataframe.loc[x, "Colore"] = "chiaro"
    if dataframe.loc[x, "Colore"] == "['Red', ' Bright']":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "Dark Green":
        dataframe.loc[x, "Colore"] = "scuro"
    if dataframe.loc[x, "Colore"] == "Orange, Pastel":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "Pink":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "Apricot":
        dataframe.loc[x, "Colore"] = "chiaro"
    if dataframe.loc[x, "Colore"] == "Yellow":
        dataframe.loc[x, "Colore"] = "chiaro"
    if dataframe.loc[x, "Colore"] == "['Orange', ' Bright']":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "['Bright', ' Lime Green']":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "['Pastel', ' Mint Green']":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "Mauve Purple":
        dataframe.loc[x, "Colore"] = "scuro"
    if dataframe.loc[x, "Colore"] == "['Pastel', ' Baby Blue']":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "['Yellow', ' Pastel']":
        dataframe.loc[x, "Colore"] = "chiaro"
    if dataframe.loc[x, "Colore"] == "Chocolate Brown":
        dataframe.loc[x, "Colore"] = "scuro"
    if dataframe.loc[x, "Colore"] == "Burnt Orange":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "Redwood":
        dataframe.loc[x, "Colore"] = "scuro"
    if dataframe.loc[x, "Colore"] == "Blue":
        dataframe.loc[x, "Colore"] = "scuro"
    if dataframe.loc[x, "Colore"] == "Watermelon Pink":
        dataframe.loc[x, "Colore"] = "chiaro"
    if dataframe.loc[x, "Colore"] == "Lilac Purple":
        dataframe.loc[x, "Colore"] = "scuro"
    if dataframe.loc[x, "Colore"] == "Pastel, Lime Green":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "Rusty Rose":
        dataframe.loc[x, "Colore"] = "chiaro"
    if dataframe.loc[x, "Colore"] == "Red and White":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "Champagne":
        dataframe.loc[x, "Colore"] = "chiaro"
    if dataframe.loc[x, "Colore"] == "Royal Blue":
        dataframe.loc[x, "Colore"] = "scuro"
    if dataframe.loc[x, "Colore"] == "Blue and White":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "Baby Blue":
        dataframe.loc[x, "Colore"] = "chiaro"
    if dataframe.loc[x, "Colore"] == "Coffee Brown":
        dataframe.loc[x, "Colore"] = "scuro"
    if dataframe.loc[x, "Colore"] == "Rust Brown":
        dataframe.loc[x, "Colore"] = "scuro"
    if dataframe.loc[x, "Colore"] == "Orange, Bright":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "Mustard Yellow":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "Mocha Brown":
        dataframe.loc[x, "Colore"] = "scuro"
    if dataframe.loc[x, "Colore"] == "Mint Blue":
        dataframe.loc[x, "Colore"] = "scuro"
    if dataframe.loc[x, "Colore"] == "Camel":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "['Neon', ' Lime Green']":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "Orange":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "['Pastel', ' Lime Green']":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "Rose Red":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "Pastel, Baby Pink":
        dataframe.loc[x, "Colore"] = "chiaro"
    if dataframe.loc[x, "Colore"] == "Cadet Blue":
        dataframe.loc[x, "Colore"] = "scuro"
    if dataframe.loc[x, "Colore"] == "Purple":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "Gold":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "['Pastel', ' Dusty Blue']":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "Olive Green":
        dataframe.loc[x, "Colore"] = "scuro"
    if dataframe.loc[x, "Colore"] == "Violet Purple":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "['Blue', ' Pastel']":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "['Pastel', ' Dusty Purple']":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "['Yellow', ' Bright']":
        dataframe.loc[x, "Colore"] = "chiaro"
    if dataframe.loc[x, "Colore"] == "['Hot Pink', ' Neon']":
        dataframe.loc[x, "Colore"] = "scuro"
    if dataframe.loc[x, "Colore"] == "['Camel', ' Pastel']":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "['Neon', ' Orange']":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "Hot Pink":
        dataframe.loc[x, "Colore"] = "scuro"
    if dataframe.loc[x, "Colore"] == "['Pink', ' Neon']":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "Bronze":
        dataframe.loc[x, "Colore"] = "scuro"
    if dataframe.loc[x, "Colore"] == "['Royal Blue', ' Bright']":
        dataframe.loc[x, "Colore"] = "scuro"
    if dataframe.loc[x, "Colore"] == "Teal Blue":
        dataframe.loc[x, "Colore"] = "scuro"
    if dataframe.loc[x, "Colore"] == "['Multicolor', ' Dusty Blue']":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "Bright, Mint Blue":
        dataframe.loc[x, "Colore"] = "scuro"
    if dataframe.loc[x, "Colore"] == "Bright, Watermelon Pink":
        dataframe.loc[x, "Colore"] = "chiaro"
    if dataframe.loc[x, "Colore"] == "['Purple', ' Pastel']":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "['Pink', ' Pastel']":
        dataframe.loc[x, "Colore"] = "chiaro"
    if dataframe.loc[x, "Colore"] == "Pastel, Coral Pink":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "Pastel, Lilac Purple":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "['Neon', ' Yellow']":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "Neon, Orange":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "['Green', ' Bright']":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "Red, Bright":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "Yellow, Bright":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "['Hot Pink', ' Bright']":
        dataframe.loc[x, "Colore"] = "chiaro"
    if dataframe.loc[x, "Colore"] == "Pink, Pastel":
        dataframe.loc[x, "Colore"] = "chiaro"
    if dataframe.loc[x, "Colore"] == "['Pastel', ' Mauve Purple']":
        dataframe.loc[x, "Colore"] = "scuro"
    if dataframe.loc[x, "Colore"] == "Coral Orange":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "Green, Neon":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "Red Violet":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "Dusty Purple":
        dataframe.loc[x, "Colore"] = "scuro"
    if dataframe.loc[x, "Colore"] == "Ginger":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "['Blue', ' Bright']":
        dataframe.loc[x, "Colore"] = "scuro"
    if dataframe.loc[x, "Colore"] == "['Pastel', ' Coral Pink']":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "['Bright', ' Watermelon Pink']":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "['Green', ' Pastel']":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "['Bright', ' Baby Blue']":
        dataframe.loc[x, "Colore"] = "chiaro"
    if dataframe.loc[x, "Colore"] == "Pastel, Mint Green":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "Silver":
        dataframe.loc[x, "Colore"] = "chiaro"
    if dataframe.loc[x, "Colore"] == "['Pink', ' Bright']":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "Pastel, Baby Blue":
        dataframe.loc[x, "Colore"] = "colorato"
    if dataframe.loc[x, "Colore"] == "['Blue', ' Bright']":
        dataframe.loc[x, "Colore"] = "scuro"
    if dataframe.loc[x, "Colore"] == "Pastel, Dusty Pink":
        dataframe.loc[x, "Colore"] = "colorato"


# stampiamo il numero di valori presenti nel dataframe per le maniche
# print(dataframe["Maniche"].value_counts())

# sostituiamo i valori delle maniche con i valori --> lunghi e corti
for x in dataframe.index:
    if dataframe.loc[x, "Manica"] == "Long Sleeve":
        dataframe.loc[x, "Manica"] = "lunga"
    if dataframe.loc[x, "Manica"] == "Short Sleeve":
        dataframe.loc[x, "Manica"] = "corta"
    if dataframe.loc[x, "Manica"] == "Sleeveless":
        dataframe.loc[x, "Manica"] = "corta"
    if dataframe.loc[x, "Manica"] == "['Short Sleeve', ' Cap Sleeve']":
        dataframe.loc[x, "Manica"] = "corta"
    if dataframe.loc[x, "Manica"] == "['Short Sleeve', ' Half Sleeve']":
        dataframe.loc[x, "Manica"] = "corta"
    if dataframe.loc[x, "Manica"] == "Three Quarter Length Sleeve":
        dataframe.loc[x, "Manica"] = "lunga"
    if dataframe.loc[x, "Manica"] == "Half Sleeve":
        dataframe.loc[x, "Manica"] = "corta"
    if dataframe.loc[x, "Manica"] == "Cap Sleeve":
        dataframe.loc[x, "Manica"] = "corta"
    if dataframe.loc[x, "Manica"] == "Extra-Long Sleeve":
        dataframe.loc[x, "Manica"] = "lunga"

# esportiamo il dataframe in formato csv
dataframe.to_csv("./newCsv_top_bottom/top_dataset.csv", index=False)

