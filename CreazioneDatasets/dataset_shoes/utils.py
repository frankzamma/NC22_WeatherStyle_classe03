
def calculate_ranges_temperatura(temp_perc):
    if temp_perc >= 30:
        return 0
    if 25 <= temp_perc < 30:
        return 1
    if 20 <= temp_perc < 25:
        return 2
    if 15 <= temp_perc < 20:
        return 3
    if 10 <= temp_perc < 15:
        return 4
    if 5 <= temp_perc < 10:
        return 5
    if temp_perc < 5:
        return 6


def calculate_ranges_stagione(stagione):
    if stagione == "inverno":
        return 0
    if stagione == "primavera":
        return 1
    if stagione == "estate":
        return 2
    if stagione == "autunno":
        return 3


def evaluate_colore(meteo, colore, temp_perc):
    i = calculate_ranges_temperatura(temp_perc)
    if colore == "chiaro" and meteo == "soleggiato" and i <= 2:
        return 10
    elif colore == "scuro" and meteo == "soleggiato" and i <= 2:
        return 0
    else:
        return 5

#TODO Aggiungere commenti