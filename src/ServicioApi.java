import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ServicioApi {
    public double obtenerTasa(String base, String cambio) {
        String direccion = "https://v6.exchangerate-api.com/v6/3b0ad7e80fee5826ee87e0ef/pair/" + base + "/" + cambio;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(direccion)).build();
        try{
            HttpResponse<String> respuesta = client.send(request,HttpResponse.BodyHandlers.ofString());
            String json = respuesta.body();
            Gson gson = new Gson();
            TasaDeConversion tasa = gson.fromJson(json, TasaDeConversion.class);
            return tasa.conversion_rate();
        } catch (IOException | InterruptedException e){
            System.out.println("Ocurrió un error");
            return 0;
        }
    }
}
