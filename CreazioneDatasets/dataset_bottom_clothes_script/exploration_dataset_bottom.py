import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt

df = pd.read_csv("../newCsv_all_clothes/bottom_meteo_dataset_labeled.csv")

# descrive il dataset in termini statistici
#print(df.describe())

# istogrammi dove mostra come varia il punteggio rispetto a ogni feature
for label in ["Materiale", "Colore", "Lunghezza", "Stagione", "Meteo", "StagionePrevisione"]:
    sns.barplot(data=df, x=label, y="Punteggio")
    plt.show()

# mostra un grafico di dispersione dei valori di temperatura rispetto al punteggio
sns.scatterplot(data=df, x="TemperaturaPercepita", y="Punteggio")
plt.show()

# mostra la forma della distribuzione della variabile temperatura allo stesso modo di scatterplot ma con
# grafici bivariati
sns.jointplot(data=df, x="TemperaturaPercepita", y="Punteggio")
plt.show()

# mette in relazione la variabile "Punteggio" e "Materiale" rispetto alla colonna "Stagione"
# il grafico mostra come sono distribuiti i punteggi di ogni materiale rispetto alla stagione
# della previsione, ovviamente i punteggi risulteranno bassi o alti a seconda della combinazione
# di variabili
sns.relplot(data=df, x="Materiale", y="Punteggio", kind="scatter", col="StagionePrevisione")
plt.show()