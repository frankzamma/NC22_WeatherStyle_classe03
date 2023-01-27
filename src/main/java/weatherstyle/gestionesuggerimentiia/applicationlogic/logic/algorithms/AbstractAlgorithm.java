package weatherstyle.gestionesuggerimentiia.applicationlogic.logic.algorithms;

import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.CapoAbbigliamento;

import java.io.File;

/**
 * @author Raffaele Aurucci
 * classe che fa da ponte alle classi che implementano gli algoritmi di intelligenza artificiale,
 * mediante questa è possibile ottenere le istanze delle due implementazioni realizzate.
 * @param <T> tipo della categoria di capo d'abbigliamento, al momento è possibile lavorare solo su Maglie, Pantaloni e
 * Scarpe.
 */
public class AbstractAlgorithm<T extends CapoAbbigliamento> {

    /**
     * interfaccia comune alle due implementazioni
     */
    private ImplementorAlgorithm<T> impl;

    /**
     * tipo che rappresenta il tipo parametrico con cui è stata istanziata la classe, necessaria per comprendere
     * la path relativa al csv per addestrare i modelli
     */
    private int typeOfClass;

    /**
     * stringa che rappresenta la path di dove si trova deployata l'applicazione sul server, necessaria per costruire
     * la path relativa ai file csv
     */
    private String realPath;

    public static final int MAGLIA = 0;
    public static final int PANTALONI = 1;
    public static final int SCARPE = 2;

    /**
     * costruttore vuoto, pensato per l'implementazione basata su algoritmo genetico
     */
    public AbstractAlgorithm() {
    }

    /**
     * costruttore pensato per l'implementazione basata su machine learning
     * @param typeOfClass tipo della classe
     * @param realPath stringa passata dalla servlet
     */
    public AbstractAlgorithm(int typeOfClass, String realPath) {
        if (typeOfClass != 0 && typeOfClass != 1 && typeOfClass != 2) {
            throw new IllegalArgumentException("Tipo di classe deve essere Maglia, Pantaloni o Scarpe");
        }
        this.typeOfClass = typeOfClass;
        this.realPath = realPath;
    }

    /**
     * @return un modello di machine learning addestrato sul tipo della classe istanziata
     */
    public ImplementorAlgorithm<T> getImplementorML() {
        String pathDataset = "";

        if (typeOfClass == MAGLIA) {
            pathDataset += this.realPath + File.separator + "WEB-INF" + File.separator + "resources"
                    + File.separator + "csv" + File.separator + "top_meteo_dataset_labeled.csv";
        }

        if (typeOfClass == PANTALONI) {
            pathDataset += this.realPath + File.separator + "WEB-INF" + File.separator + "resources"
                    + File.separator + "csv" + File.separator + "bottom_meteo_dataset_labeled.csv";
        }

        if (typeOfClass == SCARPE) {
            pathDataset += this.realPath + File.separator + "WEB-INF" + File.separator + "resources"
                    + File.separator + "csv" + File.separator + "shoes_meteo_dataset_labeled.csv";
        }

        impl = new RegressionTreeAlgorithm<>(pathDataset);
        return impl;
    }

    /**
     * @return un algoritmo genetico che lavora sul tipo della classe istanziata
     */
    public ImplementorAlgorithm<T> getImplementorGA() {
        impl = new GeneticAlgorithm<>();
        return impl;
    }
}
