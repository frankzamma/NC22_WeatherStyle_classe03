package Model;

public class ScoreCapoAbbigliamentoLegacy {

    private CapoAbbigliamentoLegacy capoAbbigliamento;
    private Double punteggio;

    public ScoreCapoAbbigliamentoLegacy(CapoAbbigliamentoLegacy capoAbbigliamento, Double punteggio) {
        this.capoAbbigliamento = capoAbbigliamento;
        this.punteggio = punteggio;
    }

    public CapoAbbigliamentoLegacy getCapoAbbigliamento() {
        return capoAbbigliamento;
    }

    public void setCapoAbbigliamento(CapoAbbigliamentoLegacy capoAbbigliamento) {
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
