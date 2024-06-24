import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class principal {
    public static void main(String[] args)throws IOException, InterruptedException {

        String url_str = "https://v6.exchangerate-api.com/v6/0a568581bf8fa195f19e26c7/latest/USD";

        // Making Request
        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

    // Convert to JSON
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

    // Accessing object
        String req_result = jsonobj.get("result").getAsString();


        System.out.println(req_result);


    }
}
