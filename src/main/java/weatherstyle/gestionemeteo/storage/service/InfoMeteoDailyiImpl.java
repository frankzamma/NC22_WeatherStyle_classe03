package weatherstyle.gestionemeteo.storage.service;

import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDaily;

import java.time.LocalDate;
import java.util.List;

public class InfoMeteoDailyiImpl implements InfoMeteoDailyService {

    @Override
    public MeteoDaily getInfoMeteoDailyByDay(LocalDate day, Citta citta) {
        return null;
    }

    @Override
    public List<MeteoDaily> getInfoMeteoDailyByIntervallDay(LocalDate init, LocalDate end, Citta citta) {
        return null;
    }
}
