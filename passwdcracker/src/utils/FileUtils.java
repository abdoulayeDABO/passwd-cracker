package utils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class FileUtils {
    // Utility methods for file operations
    public static String readFile(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier " + filePath + ": " + e.getMessage());
            return "";
        }
    }
}