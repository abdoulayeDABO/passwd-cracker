import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CibleLocale implements CibleAuthentification {
    @Override
    public boolean testerMotDePasse(String login, String motDePasse) {
        try {
            String[] command = {"java", "-cp", "./cibles", "Login", login, motDePasse};
            Process process = new ProcessBuilder(command).start();
            BufferedReader resultat = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String output = resultat.readLine();
            int exitCode = process.waitFor();
            return exitCode == 0;
        } catch (Exception e) {
            System.err.println("Erreur lors du test sur la cible locale : " + e.getMessage());
            return false;
        }
    }
} 