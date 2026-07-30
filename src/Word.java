import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Word {
    String newWord;
    String category;

    public Word() throws URISyntaxException, IOException, InterruptedException {
        URI url = new URI("https://random-words-api.kushcreates.com/api?language=pt-br&words=1");

        HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build();
        HttpRequest request = HttpRequest.newBuilder().uri(url).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

//        System.out.println(response.body());

        String[] body = response.body().split(",");
        this.newWord = body[0].substring(body[0].indexOf("word")+7,body[0].length()-1);
        this.category = body[2].substring(body[2].indexOf("category")+11,body[2].length()-1);
    }
}
