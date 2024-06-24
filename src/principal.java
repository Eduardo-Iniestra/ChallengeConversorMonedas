import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class principal {
    public static void main(String[] args)throws IOException, InterruptedException {

        String direccion = "https://v6.exchangerate-api.com/v6/0a568581bf8fa195f19e26c7/latest/USD";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion)).build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        System.out.println(json);



    }
}
