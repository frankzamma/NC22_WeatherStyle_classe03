package weatherstyle.gestionemeteo.applicationlogic.logic.beans;

import java.util.List;

public class MeteoHours {
    private List<MeteoHour> meteoInfo;

    public MeteoHours() {
    }

    public MeteoHours(List<MeteoHour> meteoInfo) {
        this.meteoInfo = meteoInfo;
    }

    public List<MeteoHour> getMeteoInfo() {
        return meteoInfo;
    }

    public void setMeteoInfo(List<MeteoHour> meteoInfo) {
        this.meteoInfo = meteoInfo;
    }

    public boolean add(MeteoHour meteoHour) {
        return meteoInfo.add(meteoHour);
    }

    public MeteoHour get(int index) {
        return meteoInfo.get(index);
    }

    public void add(int index, MeteoHour element) {
        meteoInfo.add(index, element);
    }
}
