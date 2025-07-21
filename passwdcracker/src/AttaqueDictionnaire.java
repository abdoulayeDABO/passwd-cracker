
import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import utils.ConsoleUtils;

public class AttaqueDictionnaire extends Attaque {
    @Override
    public void initier(CibleAuthentification cible, String login) {
        System.out.println("Démarrage de l'attaque par dictionnaire...");
        Charset charset = Charset.forName("US-ASCII");
        String file = "./data/password.txt";
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(file), charset)) {
            String password;
            while ((password = reader.readLine()) != null) {
                boolean success = cible.testerMotDePasse(login, password);
                System.out.println("Tentative avec mot de passe: " + password + " -> " + (success ? "SUCCES" : "ECHEC"));
                if (success) {
                    System.out.print("Mot de passe trouve: ");
                    ConsoleUtils.success(password);
                    break;
                }
            }
        } catch (Exception e) {
            System.err.format("Erreur dictionnaire: %s%n", e);
        }
    }
}
