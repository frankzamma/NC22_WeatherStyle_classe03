package Model;

public class MeteoInformationLegacy {
    private double temperaturaPercepita;
    private String meteo;
    private String stagionePrevisione;

    public MeteoInformationLegacy() {
    }

    public MeteoInformationLegacy(double temperaturaPercepita,String meteo,String stagionePrevisione) {
        this.temperaturaPercepita = temperaturaPercepita;
        this.meteo = meteo;
        this.stagionePrevisione = stagionePrevisione;
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

    public String getStagionePrevisione() {
        return stagionePrevisione;
    }

    public void setStagionePrevisione(String stagionePrevisione) {
        this.stagionePrevisione = stagionePrevisione;
    }
}
