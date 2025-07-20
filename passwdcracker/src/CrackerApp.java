
public class CrackerApp {

    public static boolean verifier_argumets(String[] args) {
        if (args.length < 2 || args.length > 3) {
            System.out.println("Usage: java CrackerApp <type> <cible> <login>");
            return false;
        }

        if (!args[0].equals("dictionnary") && !args[0].equals("bruteForce")) {
            System.out.println("Type d'attaque non reconnu. Veuillez spécifier 'dictionnary' ou 'bruteForce'.");
            return false;
        }

        if (!args[1].equals("local") && !args[1].equals("remote")) {
            System.out.println("Cible non reconnue. Veuillez spécifier 'local' ou 'remote'.");
            return false;
        }

        if (args[2] == null || args[2].isEmpty()) {
            System.out.println("Le login ne peut pas être vide.");
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("============================");
        System.out.println("Password Cracker Application");
        System.out.println("============================");
        System.err.println();

        if (!verifier_argumets(args)) {
            return;
        }

        String type = args[0];
        String cible = args[1];
        String login = args[2];

        FabriqueAttaque fabrique;

        switch (type) {
            case "dictionnary":
                fabrique = new FabriqueAttaqueDictionnaire();
                break;
            case "bruteForce":
                fabrique = new FabriqueAttaqueBruteForce();
                break;
            default:
                System.out.println("Type d'attaque non reconnu. Veuillez spécifier 'dictionnary' ou 'bruteForce'.");
                return;
        }

        Attaque attaque = fabrique.creerAttaque();
        attaque.initier(cible, login);
    }

}
