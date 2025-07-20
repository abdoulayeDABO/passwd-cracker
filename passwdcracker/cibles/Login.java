
public class Login {

    final static String LOGIN = "admin";
    final static String MOT_DE_PASSE = "passer";

    public static boolean authenticate(String login, String mot_de_passe) {
        return LOGIN.equals(login) && MOT_DE_PASSE.equals(mot_de_passe);
    }

    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Usage: java LocalAuthenticator <login> <mot_de_passe>");
            return;
        }

        String login = args[0];
        String mot_de_passe = args[1];

        if (authenticate(login, mot_de_passe)) {
            System.out.println("SUCCES");
            System.exit(0);
        } else {
            System.out.println("ECHEC");
            System.exit(1);
        }
    }
}
