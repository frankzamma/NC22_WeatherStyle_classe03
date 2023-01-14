# WeatherStyle
**Repository project:** Ingegneria del Software e Fondamenti di Intelligenza Artificiale<br>
**Name Project:** WeatherStyle<br>

**Team components:**

| Nome | Matricola |
| ---- | --------- |
| Aurucci Raffaele | 0512110832 |
| Miglino Annalaura | 0512110868 |
| Palmieri Angelo | 0512111009 |
| Zammarrelli Francesco Giuseppe | 0512110964 |

**NOTA**: Attualmente la repository contiene un driver che permette di testare i moduli di intelligenza artificiale
<hr>

## Indice
- [Introduzione](#introduzione)
- [Contenuto della repository](#contenuto-della-repository)
- [Dipendenze](#dipendenze)
- [Guida alla configurazione](#guida-alla-configurazione)
   - [Esecuzione degli script Python (in IntelliJ)](#esecuzione-degli-script-python-in-intellij)
   - [Setup Tomcat](#setup-tomcat)

## Introduzione
Il progetto **WeatherStyle** nasce dall'idea di quattro studenti pendolari dell'Università degli Studi di Salerno, per risolvere uno dei principali problemi che si trovano ogni giorno ad affrontare, ovvero scegliere l'abbigliamento più adatto a fronteggiare le condizioni climatiche (a volte estreme) previste al Campus di Fisciano.<br>
Il problema esposto non riguarda solo gli studenti, ma anche tutti coloro che devono spostarsi per lavoro verso un'altra città, quindi avere un applicativo che lo risolva, seppur parzialmente, aiuterà un significativo numero di persone.
<br>
L'**obiettivo** di WeatherStyle è quello di realizzare un agente intelligente che aiuti gli utenti a scegliere quali, tra i propri capi d'abbigliamento, siano più adatti considerando le condizioni meteorologiche.

## Contenuto della repository
* Nella cartella *src/main/java/* sono disponbili i package *Logic* e *Model*
    * **Logic.ga** contiene tutte le classi necessarie alla realizzazione degli algoritmi genetici
    * **Logic.machinelearning** contiene tutte le classi necessarie all'addestramento dei modelli di machine learning
    * **Logic.controller** contiene tutte le classi servlet necessarie per la logica di controllo dell'applicazione
    * **Model** contiene la logica di storage e i java beans
* Nella cartella *src/main/webapp/WEB-INF/* è disponibile la logica di presentazione, proseguendo in *./resources/* sono presenti i CSV necessari alle classi presenti in **Logic.machinelearning**
* Nella cartella *CreazioneDatasets/* sono disponibili tutti gli script necessari alla creazione dei datasets per addestrare i modelli di machine learning, nonchè i relativi file CSV da cui dipendono.


## Dipendenze

Il progetto è stato realizzato tramite l'IDE [IntelliJ IDEA Ultimate](https://www.jetbrains.com/idea/download), la guida del prossimo paragrafo farà riferimento ad esso per la configurazione.
Per poter eseguire completamente il progetto è necessario aver installato le seguenti dipendenze
* [Phyton3](https://www.python.org/download/releases/3.0/)
* [JDK 17](https://www.oracle.com/java/technologies/downloads/#java17)
* [Tomcat 10.0.17](https://archive.apache.org/dist/tomcat/tomcat-10/v10.0.17/bin/)

Consigliamo [Plugin IntelliJ per Phyton](https://plugins.jetbrains.com/plugin/631-python) che permette di includere tutte le funzionalità di PyCharm all'interno di IntelliJ.

## Guida alla configurazione
Per clonare la repository all'interno dell'IDE [IntelliJ IDEA Ultimate](https://www.jetbrains.com/idea/download) andare in *File* > *New* > *Project From Version Control*<br>
Nella finestra che appare inserire l'[url](https://github.com/frankzamma/NC22_WeatherStyle_classe03.git) della repository come nella seguente immagine.
![image](https://user-images.githubusercontent.com/65612000/212434444-0b0d9b92-e4c8-40ba-b081-06bbe352f995.png)
<br>
### Esecuzione degli script Python (in IntelliJ)
**1.** Aprendo uno script python (contenuti nella directory *CreateDatasets*), IntelliJ vi mostrerà il seguente messaggio.
<br>
<img width="692" alt="image" src="https://user-images.githubusercontent.com/65612000/212434840-f51f3f7f-2908-4f38-82f8-b3274770fbb6.png">
<br><br>
**2.** Cliccando su *Configure Python Interpeter* si aprirà la seguente schermata
<br>
<img width="692" alt="image" src="https://user-images.githubusercontent.com/114738583/212468674-2c825904-a3d5-4c6e-867c-159c601abd0b.png">
<br><br>
**3.** Bisognerà cliccare su **(+)** in alto a sinistra e selezionare *Python*<br>
<img width="238" alt="image" src="https://user-images.githubusercontent.com/65612000/212435464-0b9d64dd-8c8f-4fb3-bca1-b30ee777eedc.png">
<br><br>
**4.** Se non avete mai usato il [Plugin IntelliJ per Phyton](https://plugins.jetbrains.com/plugin/631-python) , vi apparirà la seguente schermata.
<br>
<img width="692" alt="image" src="https://user-images.githubusercontent.com/114738583/212468507-bd13211e-2d57-4aab-918b-fa21d9176565.png">
<br>
Se avete già usato [Plugin IntelliJ per Phyton](https://plugins.jetbrains.com/plugin/631-python) e al posto di *No-interpeter* vi apparirà un *Python SDK* già configurato potete passare al punto **8**.
<br><br>
**5.** A questo punto sarà necessario cliccare sui **(...)** e vi sarà presentata la seguente schermata:<br>
<img width="692" alt="image" src="https://user-images.githubusercontent.com/114738583/212468400-4e970ab6-ba37-471e-b8ff-d73778c705b1.png">
<br><br>
**6.** Bisognerà cliccare su **(+)** in alto a sinistra e selezionare *Add Python SDK...*<br>
<img width="238" alt="image" src="https://user-images.githubusercontent.com/114738583/212469041-f6bb794a-6dbc-43a2-b032-5122f0a8d44a.png">
<br><br>
**7.** Bisognerà quindi selezionare *Virtualenv Environment* e cliccare su **OK**<br>
<img width="692" alt="image" src="https://user-images.githubusercontent.com/114738583/212470023-76d1bc68-27d1-4f15-9502-67b02c9182e7.png">
<br><br>
**8.** Arrivati qui sarà necessario selezionare la *Python SDK* scaricata in precedenza e cliccare su **Apply** <br>
<img width="692" alt="image" src="https://user-images.githubusercontent.com/114738583/212469739-025e73af-9eff-43cc-a090-dbaf663f0ce2.png">
<br>
### Setup Tomcat
**1.** Per poter eseguire correttamente il progetto è necessario prima configurare l'**ambiente di deployment**, andando su *Add Configuration* verrà presentata la seguente schermata, quindi cliccare su **(+)** in alto a sinistra
<br>
<img width="692" alt="image" src="https://user-images.githubusercontent.com/114738583/212470483-f751dd2c-129d-4087-9465-4e662e339e68.png">
<br><br>
**2.** Bisognerà quindi selezionare *Tomcat Server* > *Local*
<br>
<img width="238" alt="image" src="https://user-images.githubusercontent.com/114738583/212470726-4de58ace-42c7-41e1-a602-3cd461b41a05.png">
<br><br>
**3.** Dunque andare nella sezione *Deployment*, cliccare su **(+)** e quindi su *Artifact...* 
<br>
<img width="692" alt="image" src="https://user-images.githubusercontent.com/114738583/212471078-f29af068-8178-4788-9d87-a23a82b18d9e.png">
<br><br>
**4.** Selezionare *WeatherStyle:war exploded* 
<br>
<img width="450" alt="image" src="https://user-images.githubusercontent.com/114738583/212471290-d89542f7-95ae-490d-9e9c-8e7645213295.png">
<br><br>
**5.** A questo punto tornare nella sezione *Server*, aggiungere la **JRE** selezionando una delle **JDK** scaricate in  precedenza e cliccare su **Apply**.
<br>
<img width="692" alt="image" src="https://user-images.githubusercontent.com/114738583/212471729-3ce7a5fa-2043-480f-8cec-db5a1660274a.png">
<br><br>






  
  
  










