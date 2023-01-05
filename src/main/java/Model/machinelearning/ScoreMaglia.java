package Model.machinelearning;

import Model.Maglia;

public class ScoreMaglia {

    private Maglia maglia;
    private Double punteggio;

    public ScoreMaglia(Maglia maglia, double punteggio) {
        this.maglia = maglia;
        this.punteggio = punteggio;
    }

    public Maglia getMaglia() {
        return maglia;
    }

    public void setMaglia(Maglia maglia) {
        this.maglia = maglia;
    }

    public Double getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(Double punteggio) {
        this.punteggio = punteggio;
    }
}
