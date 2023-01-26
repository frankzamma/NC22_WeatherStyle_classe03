package weatherstyle.gestionecitta.applicationlogic.logic.beans;

public class Citta {

    private Integer id;
    private String nome;
    private String lat;
    private String lon;

    public Citta() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "Citta{" + "id=" + id + ", nome='" + nome + '\'' + ", lat='" + lat + '\'' + ", lon='" + lon + '\'' + '}';
    }
}
