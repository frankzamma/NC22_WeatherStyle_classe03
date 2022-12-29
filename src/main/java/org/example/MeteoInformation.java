package org.example;

public class MeteoInformation {
    private  int temperaturaPercepita;
    private String meteo;

    public MeteoInformation(int temperaturaPercepita, String meteo) {
        this.temperaturaPercepita = temperaturaPercepita;
        this.meteo = meteo;
    }

    public int getTemperaturaPercepita() {
        return temperaturaPercepita;
    }

    public void setTemperaturaPercepita(int temperaturaPercepita) {
        this.temperaturaPercepita = temperaturaPercepita;
    }

    public String getMeteo() {
        return meteo;
    }

    public void setMeteo(String meteo) {
        this.meteo = meteo;
    }

}
