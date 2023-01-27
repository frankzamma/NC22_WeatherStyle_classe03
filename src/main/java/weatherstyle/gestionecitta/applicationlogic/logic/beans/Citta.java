package weatherstyle.gestionecitta.applicationlogic.logic.beans;

/**
 * @author Raffaele Aurucci
 * citta che l'utente salva tra i preferiti oppure di cui ha ricevuto un suggerimento
 */
public class Citta {

    /**
     * id citta
     */
    private Integer id;

    /**
     * nome citta
     */
    private String nome;

    /**
     * latitudine
     */
    private String lat;

    /**
     * longitudine
     */
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
