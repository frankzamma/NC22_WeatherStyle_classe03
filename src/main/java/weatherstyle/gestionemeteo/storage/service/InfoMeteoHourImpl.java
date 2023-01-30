package weatherstyle.gestionemeteo.storage.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoHour;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoHours;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class InfoMeteoHourImpl implements InfoMeteoHourService {

    @Override
    public MeteoHours getInfoMeteoHourByDay(LocalDate day, Citta citta) {
        if(citta != null && citta.getLat() != null && citta.getLon() != null){
            if(day != null) {
                try{
                    URI uri = URI.create("https://api.open-meteo.com/v1/forecast?latitude="+citta.getLat() +
                            "&longitude="+citta.getLon()+"&hourly=temperature_2m," +
                            "relativehumidity_2m,precipitation," +
                            "weathercode,visibility,windspeed_10m" +
                            "&start_date="+   day.format(DateTimeFormatter.ISO_LOCAL_DATE) +
                            "&end_date="+   day.format(DateTimeFormatter.ISO_LOCAL_DATE));


                    HttpRequest request =  HttpRequest.newBuilder()
                            .uri(uri).build();

                    HttpClient client  = HttpClient.newHttpClient();
                    HttpResponse<String> response =  client.send(request, HttpResponse.BodyHandlers.ofString());


                    Gson parser =  new Gson();

                    JsonObject meteoJsonAll =  parser.fromJson(response.body(), JsonObject.class);
                    JsonObject meteoJson =  meteoJsonAll.getAsJsonObject("hourly");
                    JsonArray times=  meteoJson.getAsJsonArray("time");
                    JsonArray weatherCodes =  meteoJson.get("weathercode").getAsJsonArray();
                    JsonArray temperaturas =  meteoJson.getAsJsonArray("temperature_2m");
                    JsonArray umiditaRelativas =  meteoJson.getAsJsonArray("relativehumidity_2m");
                    JsonArray precipitazionis = meteoJson.getAsJsonArray("precipitation");

                    JsonArray visibilities = meteoJson.getAsJsonArray("visibility");
                    JsonArray windSpeeds = meteoJson.getAsJsonArray("windspeed_10m");

                    List<MeteoHour> list =  new ArrayList<>();
                    for(int i = 0; i < times.size(); i++){
                        MeteoHour meteoHour =  new MeteoHour();

                        int weatherCode =  weatherCodes.get(i).getAsInt();
                        double temperatura =  temperaturas.get(i).getAsDouble();
                        double umiditaRelativa =  umiditaRelativas.get(i).getAsDouble();
                        double precipitazioni =  precipitazionis.get(i).getAsDouble();

                        int visibilita =  visibilities.get(i).getAsInt();
                        double windSpeed =  windSpeeds.get(i).getAsDouble();
                        String date =  times.get(i).getAsString();

                        meteoHour.setWeatherCode(weatherCode);
                        meteoHour.setTime(LocalTime.parse(date, DateTimeFormatter.ISO_DATE_TIME));
                        meteoHour.setDate(LocalDate.parse(date, DateTimeFormatter.ISO_DATE_TIME));
                        meteoHour.setTemperatura(temperatura);
                        meteoHour.setUmiditaRelativa(umiditaRelativa);
                        meteoHour.setPrecipitazioni(precipitazioni);
                        meteoHour.setWindSpeed(windSpeed);
                        meteoHour.setVisibilitaMetri(visibilita);

                        list.add(meteoHour);
                    }

                    MeteoHours meteoHours =  new MeteoHours(list);

                    return meteoHours;

                }catch (IllegalArgumentException e){
                    throw new IllegalArgumentException("Errore nella formulazione della richiesta");
                } catch (IOException e) {
                    throw new IllegalArgumentException("Problema nell'invio della richiesta");
                } catch (InterruptedException e) {
                    throw new IllegalArgumentException("Problema di rete");
                }
            }else{
                throw new IllegalArgumentException("Giorno non corretto");

            }
        }else{
            throw new IllegalArgumentException("Citta non corretta");
        }
    }


    @Override
    public List<MeteoHours> getInfoMeteoHourByRangeOfDays(LocalDate init, LocalDate end, Citta citta) {
        if(init != null && end != null && init.isBefore(end)){
            if(citta != null){
                List<LocalDate> localDates = new ArrayList<>();

                localDates.add(init);

                while(!localDates.get(localDates.size() - 1).equals(end)){
                    LocalDate tmp =  localDates.get(localDates.size() - 1).plusDays(1);
                    localDates.add(tmp);
                }

                List<MeteoHours> listMeteo =  new ArrayList<>();

                for (LocalDate date : localDates){
                    MeteoHours meteoHours =  this.getInfoMeteoHourByDay(date, citta);
                    listMeteo.add(meteoHours);
                }

                return listMeteo;

            }else {
                throw new IllegalArgumentException("Citta non può essere null");
            }
        }else{
            throw new IllegalArgumentException("Init e End non corrette");
        }
    }
}
