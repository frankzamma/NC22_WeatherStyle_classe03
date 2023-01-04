import pandas as pd

dataframe = pd.read_csv("../csv_dataset_meteo/dataset_meteo.csv")

dataframe["time"] = pd.to_datetime(dataframe["time"])

season = {1: "inverno", 2: "inverno", 3: "primavera", 4: "primavera", 5: "primavera", 6: "estate",
          7: "estate", 8: "estate", 9: "autunno", 10: "autunno", 11: "autunno", 12: "inverno"}

mese = {1: "gennaio", 2: "febbraio", 3: "marzo", 4: "aprile", 5: "maggio", 6: "giugno",
        7: "luglio", 8: "agosto", 9: "settembre", 10: "ottobre", 11: "novembre", 12: "dicembre"}

dataframe["StagionePrevisione"] = pd.DatetimeIndex(dataframe["time"]).month

dataframe["Mese"] = dataframe["StagionePrevisione"]

for x in dataframe.index:
    dataframe.loc[x, "StagionePrevisione"] = season.get(dataframe.loc[x, "StagionePrevisione"])

for x in dataframe.index:
    dataframe.loc[x, "Mese"] = mese.get(dataframe.loc[x, "Mese"])

for x in dataframe.index:
    y = str(dataframe.loc[x, "Meteo"])
    if y.__contains__("Piog") or y.__contains__("piog"):
        dataframe.loc[x, "Meteo"] = "pioggia"
    if y.__contains__("sol") or y.__contains__("Sol") or y.__contains__("chiaro") or y.__contains__("Parzial"):
        dataframe.loc[x, "Meteo"] = "soleggiato"
    if (y.__contains__("nuv") or y.__contains__("Nuv") or y.__contains__("Coperto")) and not(y.__contains__("Parzial")):
        dataframe.loc[x, "Meteo"] = "nuvoloso"
    if y.__contains__("Nebbia"):
        dataframe.loc[x, "Meteo"] = "soleggiato"
    if y.__contains__("Temporale"):
        dataframe.loc[x, "Meteo"] = "pioggia"
    if y.__contains__("Nev") or y.__contains__("nev") or y.__contains__("Grandine"):
        dataframe.loc[x, "Meteo"] = "neve"

dataframe = dataframe.sample(frac=1.0)

dataframe.to_csv("meteo_dataset.csv", index=False)
