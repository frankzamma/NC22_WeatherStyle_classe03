package weatherstyle.gestionemeteo.applicationlogic.logic.beans;

public class MeteoDaily {

    private Integer id;
    private String meteo;
    private double temperaturaPercepitaMedia;
    private String stagionePrevisione;

    private int weatherCode;
    private double temperaturaPercepitaMinima;
    private double temperaturaPercepitaMassima;


    public MeteoDaily() {
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

    public int getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(int weatherCode) {
        this.weatherCode = weatherCode;
    }

    public double getTemperaturaPercepitaMinima() {
        return temperaturaPercepitaMinima;
    }

    public void setTemperaturaPercepitaMinima(double temperaturaPercepitaMinima) {
        this.temperaturaPercepitaMinima = temperaturaPercepitaMinima;
    }

    public double getTemperaturaPercepitaMassima() {
        return temperaturaPercepitaMassima;
    }

    public void setTemperaturaPercepitaMassima(double temperaturaPercepitaMassima) {
        this.temperaturaPercepitaMassima = temperaturaPercepitaMassima;
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

    @Override
    public String toString() {
        return "MeteoDaily{" +
                "id=" + id +
                ", meteo='" + meteo + '\'' +
                ", temperaturaPercepitaMedia=" + temperaturaPercepitaMedia +
                ", stagionePrevisione='" + stagionePrevisione + '\'' +
                ", weatherCode=" + weatherCode +
                ", temperaturaPercepitaMinima=" + temperaturaPercepitaMinima +
                ", temperaturaPercepitaMassima=" + temperaturaPercepitaMassima +
                '}';
    }
}
