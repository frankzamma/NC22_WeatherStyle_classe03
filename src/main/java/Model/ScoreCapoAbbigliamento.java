package Model;

public class ScoreCapoAbbigliamento {

    private CapoAbbigliamento capoAbbigliamento;
    private Double punteggio;

    public ScoreCapoAbbigliamento(CapoAbbigliamento capoAbbigliamento,Double punteggio) {
        this.capoAbbigliamento = capoAbbigliamento;
        this.punteggio = punteggio;
    }

    public CapoAbbigliamento getCapoAbbigliamento() {
        return capoAbbigliamento;
    }

    public void setCapoAbbigliamento(CapoAbbigliamento capoAbbigliamento) {
        this.capoAbbigliamento = capoAbbigliamento;
    }

    public Double getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(Double punteggio) {
        this.punteggio = punteggio;
    }

    @Override
    public String toString() {
        return "[" + capoAbbigliamento
                + ", punteggio=" + punteggio + "]"
                ;
    }
}
