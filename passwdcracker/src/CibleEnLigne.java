import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import utils.HttpUtils;

public class CibleEnLigne implements CibleAuthentification {
    private static final String URI = "http://localhost/app/login.php";

    @Override
    public boolean testerMotDePasse(String login, String motDePasse) {
        try {
            HttpClient client = HttpUtils.createHttpClient();
            HttpRequest request = HttpUtils.createPostRequest(URI, login, motDePasse);
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.statusCode() == 200;
        } catch (Exception e) {
            System.err.println("Erreur lors du test sur la cible en ligne : " + e.getMessage());
            return false;
        }
    }
} 