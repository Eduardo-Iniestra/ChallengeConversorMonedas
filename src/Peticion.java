import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Peticion {
    private String monedaBase;
    private String monedaCambio;
    private int cantidad;

    public void api(String monedaBase, String monedaCambio, int cantidad){
        this.monedaBase = monedaBase;
        this.monedaCambio = monedaCambio;
        this.cantidad = cantidad;

        try{
            String url_str  = "https://v6.exchangerate-api.com/v6/0a568581bf8fa195f19e26c7/pair/" +
                    monedaBase +"/" + monedaCambio +"/" + cantidad;

            // Making Request
            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            // Convert to JSON
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();

            // Accessing object
            String req_result = jsonobj.get("conversion_result").getAsString();

            System.out.println("Resultado = " + req_result);

        }catch (IOException e){
            System.out.println("No se encontraron esos valores");
        }

    }

    public String getMonedaBase() {
        return monedaBase;
    }

    public String getMonedaCambio() {
        return monedaCambio;
    }

    public int getCantidad() {
        return cantidad;
    }

}
