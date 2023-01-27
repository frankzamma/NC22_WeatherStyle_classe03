package weatherstyle.gestionemeteo.applicationlogic.logic.beans;

public class MeteoDailyMin {
    private Integer id;
    private String meteo;
    private double temperaturaPercepitaMedia;
    private String stagionePrevisione;

    public MeteoDailyMin() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMeteoStringMin() {
        return meteo;
    }

    public void setMeteo(String meteo) {
        this.meteo = meteo;
    }

    public String getMeteo() {
        return meteo;
    }

    public double getTemperaturaPercepitaMedia() {
        return temperaturaPercepitaMedia;
    }

    public void setTemperaturaPercepitaMedia(double temperaturaPercepitaMedia) {
        this.temperaturaPercepitaMedia = temperaturaPercepitaMedia;
    }

    public String getStagionePrevisione() {
        return stagionePrevisione;
    }

    public void setStagionePrevisione(String stagionePrevisione) {
        this.stagionePrevisione = stagionePrevisione;
    }
}
