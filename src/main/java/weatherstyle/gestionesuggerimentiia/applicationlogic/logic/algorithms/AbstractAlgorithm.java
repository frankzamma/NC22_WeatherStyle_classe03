package weatherstyle.gestionesuggerimentiia.applicationlogic.logic.algorithms;

import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.CapoAbbigliamento;

import java.io.File;

public class AbstractAlgorithm<T extends CapoAbbigliamento> {

    private ImplementorAlgorithm<T> impl;
    private int typeOfClass;
    private String realPath;

    public static final int MAGLIA = 0;
    public static final int PANTALONI = 1;
    public static final int SCARPE = 2;

    public AbstractAlgorithm(){
    }

    public AbstractAlgorithm(int typeOfClass, String realPath){
        if (typeOfClass != 0 && typeOfClass != 1 && typeOfClass != 2)
            throw new IllegalArgumentException("Tipo di classe deve essere Maglia, Pantaloni o Scarpe");
        this.typeOfClass = typeOfClass;
        this.realPath = realPath;
    }

    public ImplementorAlgorithm<T> getImplementorML(){
        String pathDataset = "";

        if (typeOfClass == MAGLIA)
            pathDataset += this.realPath + File.separator + "WEB-INF" + File.separator + "resources"
                    + File.separator + "csv" + File.separator + "top_meteo_dataset_labeled.csv";

        if (typeOfClass == PANTALONI)
            pathDataset += this.realPath + File.separator + "WEB-INF" + File.separator + "resources"
                    + File.separator + "csv" + File.separator + "bottom_meteo_dataset_labeled.csv";

        if (typeOfClass == SCARPE)
            pathDataset += this.realPath + File.separator + "WEB-INF" + File.separator + "resources"
                    + File.separator + "csv" + File.separator + "shoes_meteo_dataset_labeled.csv";

        impl = new RegressionTreeAlgorithm<>(pathDataset);
        return impl;
    }

    public ImplementorAlgorithm<T> getImplementorGA(){
        impl = new GeneticAlgorithm<>();
        return impl;
    }
}
