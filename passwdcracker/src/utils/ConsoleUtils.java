package utils;

/**
 * Utilitaire simple pour afficher du texte coloré dans le terminal
 */

public class ConsoleUtils {
    
    // Constructeur privé
    private ConsoleUtils() {
        throw new UnsupportedOperationException("Utility class");
    }
    
    // Codes ANSI
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String CYAN = "\u001B[36m";
    
    // Méthodes principales
    public static void success(String message) {
        System.out.println(GREEN + message + RESET);
    }
    
    public static void error(String message) {
        System.out.println(RED + message + RESET);
    }
    
    public static void warning(String message) {
        System.out.println(YELLOW + message + RESET);
    }
    
    public static void info(String message) {
        System.out.println(BLUE + message + RESET);
    }
    
    public static void print(String message, String color) {
        System.out.println(color + message + RESET);
    }
    
    
}