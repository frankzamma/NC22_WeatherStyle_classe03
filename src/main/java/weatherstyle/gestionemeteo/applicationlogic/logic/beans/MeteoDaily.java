package weatherstyle.gestionemeteo.applicationlogic.logic.beans;

public class MeteoDaily {

    private int id;
    private String meteo;
    private double temperatura;
    private String stagionePrevisione;

    public MeteoDaily() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMeteo() {
        return meteo;
    }

    public void setMeteo(String meteo) {
        this.meteo = meteo;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public String getStagionePrevisione() {
        return stagionePrevisione;
    }

    public void setStagionePrevisione(String stagionePrevisione) {
        this.stagionePrevisione = stagionePrevisione;
    }


}
