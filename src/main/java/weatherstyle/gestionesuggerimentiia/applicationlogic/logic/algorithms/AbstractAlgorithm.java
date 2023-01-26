package weatherstyle.gestionesuggerimentiia.applicationlogic.logic.algorithms;

import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.CapoAbbigliamento;

public class AbstractAlgorithm<T extends CapoAbbigliamento> {

    private ImplementorAlgorithm<T> impl;

    public ImplementorAlgorithm<T> getImplementorAlgorithm(){
        // impl = new RegressionTreeAlgorithm<>();
        impl = new GeneticAlgorithm<>();
        return impl;
    }
}
