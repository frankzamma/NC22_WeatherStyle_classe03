package weatherstyle.gestionecitta.storage.service;

import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class InfoCittaImpl implements InfoCittaService {

    @Override
    public List<Citta> getCittaByName(final String name) {
        String[] nameSplit = name.split(" ");
        String splitting = nameSplit[0];

        if (nameSplit.length >= 2) {
            for (int i = 1; i <= nameSplit.length - 1; i++) {
                splitting += "%20";
                splitting += nameSplit[i];
            }
        }

        List<Citta> cittaList = new ArrayList<>();
        Gson gson = new Gson();
        HttpRequest httpRequest = null;

        try {
            httpRequest = HttpRequest.newBuilder()
                    .uri(new URI("https://nominatim.openstreetmap.org/?city=" + splitting + "&format=json"))
                    .build();
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Elaborazione richiesta API Citta fallita");
        }

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> response = null;
        try {
            response = httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new IllegalArgumentException("Invio richiesta API Citta fallita");
        }

        JsonArray jsonArray = gson.fromJson(response.body(),JsonArray.class);

        for (JsonElement element: jsonArray) {
            JsonObject jsonObject = element.getAsJsonObject();
            jsonObject.remove("place_id");
            jsonObject.remove("licence");
            jsonObject.remove("osm_type");
            jsonObject.remove("osm_id");
            jsonObject.remove("boundingbox");
            jsonObject.remove("class");
            jsonObject.remove("type");
            jsonObject.remove("importance");
            jsonObject.remove("icon");

            Citta citta = new Citta();

            String cityName = jsonObject.get("display_name").getAsString();
            String cityLon = jsonObject.get("lon").getAsString();
            String cityLat = jsonObject.get("lat").getAsString();

            citta.setNome(cityName);
            citta.setLon(cityLon);
            citta.setLat(cityLat);

            cittaList.add(citta);
        }
        return cittaList;
    }
}
