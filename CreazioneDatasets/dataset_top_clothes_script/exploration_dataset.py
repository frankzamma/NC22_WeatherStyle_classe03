import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt

df = pd.read_csv("../newCsv_all_clothes/top_meteo_dataset_selection.csv")

# descrive il dataset in termini statistici
print(df.describe())

# istogrammi dove mostra come varia il punteggio rispetto a ogni feature
for label in ["Materiale", "Colore", "Manica", "Stagione", "Meteo", "StagionePrevisione"]:
    sns.barplot(data=df, x=label, y="Punteggio")
    plt.show()

# mostra un grafico di dispersione dei valori di temperatura rispetto al punteggio
sns.scatterplot(data=df, x="TemperaturaPercepita", y="Punteggio")
plt.show()

# mostra la forma della distribuzione delle variabili come scatterplot ma in modo più formale
sns.jointplot(data=df, x="TemperaturaPercepita", y="Punteggio")
plt.show()

# mostra grafici dove viene vista la variazione delle varie variabili numeriche
sns.pairplot(data=df)
plt.show()

# mette in relazione la variabile x e y rispetto ad una colonna specificata --> "Stagione"
sns.relplot(data=df, x="Punteggio", y="Materiale", kind="line", col="Stagione")
plt.show()


