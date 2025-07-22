
public class CrackerApp {

    public static boolean verifier_argumets(String[] args) {
        if (args.length < 3) {
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
        String cibleType = args[1];
        String login = args[2];

        FabriqueAttaque fabriqueAttaque;
        FabriqueCible fabriqueCible;

        // Fabrique d'attaque
        switch (type) {
            case "dictionnary":
                fabriqueAttaque = new FabriqueAttaqueDictionnaire();
                break;
            case "bruteForce":
                fabriqueAttaque = new FabriqueAttaqueBruteForce();
                break;
            default:
                System.out.println("Type d'attaque non reconnu. Veuillez spécifier 'dictionnary' ou 'bruteForce'.");
                return;
        }

        // Fabrique de cible
        switch (cibleType) {
            case "local":
                fabriqueCible = new FabriqueCibleLocale();
                break;
            case "remote":
                fabriqueCible = new FabriqueCibleEnLigne();
                break;
            default:
                System.out.println("Cible non reconnue. Veuillez spécifier 'local' ou 'remote'.");
                return;
        }

        Attaque attaque = fabriqueAttaque.creerAttaque();
        CibleAuthentification cible = fabriqueCible.creerCible();
        attaque.initier(cible, login);
    }
}
