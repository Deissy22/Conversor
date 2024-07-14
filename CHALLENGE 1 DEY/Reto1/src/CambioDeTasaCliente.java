import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;


public class CambioDeTasaCliente {

    private static final String API_KEY = "a653c14dc98c59fcef1bc799";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    private HttpClient httpClient;

    public CambioDeTasaCliente() {
        this.httpClient = HttpClient.newHttpClient();
    }

    public double getTasaDeCambio(String deMoneda, String aMoneda) throws IOException, InterruptedException {
        String url = BASE_URL + API_KEY + "/pair/" + deMoneda + "/" + aMoneda;

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
        Gson gson = new Gson();
        JsonElement element = JsonParser.parseString(response.body());
        JsonObject jsonObject = element.getAsJsonObject();
        double respuestaJson = jsonObject.get("conversion_rate").getAsDouble();
        if (response.statusCode() == 200) {
            return respuestaJson;
        } else {
            System.out.println("Error al obtener tasa de cambio");
            return respuestaJson;
        }
    }

    public double conversionDinero(double tasa, double cantidad){
        return tasa*cantidad;
    }

}
