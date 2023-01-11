import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt

df = pd.read_csv("../csv_all_clothes/dataset_github_completo.csv")

# fa il conteggio delle tipologie di capo d'abbigliamento
sns.countplot(data=df, x="Type")
plt.show()

for x in df.index:
    if df.loc[x, "Type"] == "Dress":
        df.drop(x, inplace=True)

sns.countplot(data=df, y="Type", hue="Material")
plt.show()

sns.countplot(data=df, y="Type", hue="Season")
plt.show()

sns.countplot(data=df, y="Type", hue="Color")
plt.show()

for x in df.index:
    if df.loc[x, "Type"] == "Bottom":
        df.drop(x, inplace=True)

sns.countplot(data=df, x="Type", hue="Sleeve Length")
plt.show()