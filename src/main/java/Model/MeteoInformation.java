package Model;

public class MeteoInformation {
    private double temperaturaPercepita;
    private String meteo;

    public MeteoInformation() {
    }

    public MeteoInformation(double temperaturaPercepita, String meteo) {
        this.temperaturaPercepita = temperaturaPercepita;
        this.meteo = meteo;
    }

    public double getTemperaturaPercepita() {
        return temperaturaPercepita;
    }

    public void setTemperaturaPercepita(double temperaturaPercepita) {
        this.temperaturaPercepita = temperaturaPercepita;
    }

    public String getMeteo() {
        return meteo;
    }

    public void setMeteo(String meteo) {
        this.meteo = meteo;
    }
}
