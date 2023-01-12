import seaborn as sb
import pandas as pd
import matplotlib.pyplot as plt
df = pd.read_csv('../csv_all_clothes/shoes-dataset.csv')
df_new = pd.read_csv('../newCsv_all_clothes/shoes-dataset.csv')
print(df["CID"].count())
df.dropna(inplace=True)
print(df["CID"].count())
df.pop('CID')
df.drop_duplicates(inplace=True)

print(df["HeelHeight"].value_counts())

# sb.countplot(data=df, y=df['Category'])
# sb.countplot(data=df, y=df['SubCategory'])
# sb.countplot(data=df, y=df['Insole'])
sb.set(rc={"figure.figsize":(10, 6)})
sb.countplot(data=df_new, x=df_new['Tipo'])

plt.show()
