
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
import utils.ConsoleUtils;

public class AttaqueBruteForce extends Attaque {
    @Override
    public void initier(CibleAuthentification cible, String login) {
        try {
            String characters = PasswordUtils.generateCharacters(true, false, false, false);
            String[] passwordList = PasswordUtils.generatePasswordCombinations(characters, 5);

            for (String password : passwordList) {
                boolean success = cible.testerMotDePasse(login, password);
                System.out.println("Tentative avec mot de passe: " + password + " -> " + (success ? "SUCCES" : "ECHEC"));
                if (success) {
                    System.out.print("Mot de passe trouve: ");
                    ConsoleUtils.success(password);
                    break;
                }
            }
        } catch (Exception e) {
            System.err.format("Erreur brute force: %s%n", e);
        }
    }
}
