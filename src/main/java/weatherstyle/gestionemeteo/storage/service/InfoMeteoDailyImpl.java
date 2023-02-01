package weatherstyle.gestionemeteo.storage.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDaily;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Francesco Giuseppe Zammarrelli
 * La classe Info meteo dailyi.
 */
public class InfoMeteoDailyImpl implements InfoMeteoDailyService {

    @Override
    public MeteoDaily getInfoMeteoDailyByDay(LocalDate day,Citta citta) {
        if (citta != null && citta.getLat() != null && citta.getLon() != null) {
            if (day != null) {
                try {
                    URI uri = URI.create("https://api.open-meteo.com/v1/"
                            + "forecast?latitude=" + citta.getLat() + "&longitude=" + citta.getLon()
                            + "&daily=weathercode,temperature_2m_max,temperature_2m_min"
                            + "&timezone=Europe%2FLondon"
                            + "&start_date=" + day.format(DateTimeFormatter.ISO_LOCAL_DATE)
                            + "&end_date=" + day.format(DateTimeFormatter.ISO_LOCAL_DATE));

                    HttpRequest request =  HttpRequest.newBuilder()
                            .uri(uri).build();

                    HttpClient client  = HttpClient.newHttpClient();
                    HttpResponse<String> response =  client.send(request,HttpResponse.BodyHandlers.ofString());


                    Gson parser =  new Gson();

                    JsonObject meteoJson =  parser.fromJson(response.body(),JsonObject.class);

                    int weatherCode =  meteoJson.get("daily").getAsJsonObject().get("weathercode").getAsInt();
                    double temperaturaPercepitaMassima =  meteoJson.get("daily").getAsJsonObject().get("temperature_2m_max").getAsDouble();
                    double temperaturaPercepitaMinima =  meteoJson.get("daily").getAsJsonObject().get("temperature_2m_min").getAsDouble();
                    MeteoDaily meteoDaily =  new MeteoDaily();
                    meteoDaily.setTime(day);
                    meteoDaily.setWeatherCode(weatherCode);
                    meteoDaily.setTemperaturaPercepitaMinima(temperaturaPercepitaMinima);
                    meteoDaily.setTemperaturaPercepitaMassima(temperaturaPercepitaMassima);

                    return meteoDaily;

                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("Errore nella formulazione della richiesta");
                } catch (IOException e) {
                    throw new IllegalArgumentException("Problema nell'invio della richiesta");
                } catch (InterruptedException e) {
                    throw new IllegalArgumentException("Problema di rete");
                }
            } else {
                throw new IllegalArgumentException("Parametro day non ammissibile");
            }
        } else {
            throw new IllegalArgumentException("Parametro citta non consistente");
        }
    }

    @Override
    public List<MeteoDaily> getInfoMeteoDailyByRangeOfDays(LocalDate init, LocalDate end, Citta citta) {
        if (citta != null && citta.getLat() != null && citta.getLon() != null) {
            if ((init != null || end != null) && init.isBefore(end)) {
                try {
                    URI uri = URI.create("https://api.open-meteo.com/v1/"
                            + "forecast?latitude=" + citta.getLat() + "&longitude=" + citta.getLon()
                            + "&daily=weathercode,temperature_2m_max,temperature_2m_min"
                            + "&timezone=Europe%2FLondon"
                            + "&start_date=" + init.format(DateTimeFormatter.ISO_LOCAL_DATE)
                            + "&end_date=" + end.format(DateTimeFormatter.ISO_LOCAL_DATE));

                    HttpRequest request =  HttpRequest.newBuilder()
                            .uri(uri).build();

                    HttpClient client  = HttpClient.newHttpClient();
                    HttpResponse<String> response =  client.send(request,HttpResponse.BodyHandlers.ofString());


                    Gson parser =  new Gson();

                    JsonObject meteoJsonAll =  parser.fromJson(response.body(),JsonObject.class);
                    JsonObject meteoJson =  meteoJsonAll.getAsJsonObject("daily");
                    JsonArray times =  meteoJson.getAsJsonArray("time");

                    JsonArray weatherCodes =  meteoJson.get("weathercode").getAsJsonArray();
                    JsonArray temperaturaPercepitaMassimas =  meteoJson.get("temperature_2m_max").getAsJsonArray();
                    JsonArray temperaturaPercepitaMinimas =  meteoJson.get("temperature_2m_min").getAsJsonArray();
                    List<MeteoDaily> list =  new ArrayList<>();
                    for (int i = 0; i < times.size(); i++) {
                        MeteoDaily meteoDaily =  new MeteoDaily();

                        int weatherCode =  weatherCodes.get(i).getAsInt();
                        double temperaturaPercepitaMassima =  temperaturaPercepitaMassimas.get(i).getAsDouble();
                        double temperaturaPercepitaMinima =  temperaturaPercepitaMinimas.get(i).getAsDouble();
                        String date =  times.get(i).getAsString();
                        String[] dateSplit =  date.split("-");

                        int year = Integer.parseInt(dateSplit[0]);
                        int month =  Integer.parseInt(dateSplit[1]);
                        int day =  Integer.parseInt(dateSplit[2]);
                        meteoDaily.setWeatherCode(weatherCode);
                        meteoDaily.setTime(LocalDate.of(year,month,day));
                        meteoDaily.setTemperaturaPercepitaMassima(temperaturaPercepitaMassima);
                        meteoDaily.setTemperaturaPercepitaMinima(temperaturaPercepitaMinima);

                        list.add(meteoDaily);
                    }

                    return list;

                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("Errore nella formulazione della richiesta");
                } catch (IOException e) {
                    throw new IllegalArgumentException("Problema nell'invio della richiesta");
                } catch (InterruptedException e) {
                    throw new IllegalArgumentException("Problema di rete");
                }
            } else {
                throw new IllegalArgumentException("Init e End non corrette");

            }
        } else {
            throw new IllegalArgumentException("Citta non corretta");
        }
    }
}
