package utils;

public class PasswordUtils {

    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()_+-=[]{}|;:,.<>?";
    private static final String ALL_CHARACTERS = LOWERCASE + UPPERCASE + DIGITS + SPECIAL_CHARS;


    public static String generateCharacters( boolean includeLowercase, 
                                      boolean includeUppercase, 
                                      boolean includeDigits, 
                                      boolean includeSpecialChars) {
        StringBuilder characters = new StringBuilder();

        if (includeLowercase) {
            characters.append(LOWERCASE);
        }
        if (includeUppercase) {
            characters.append(UPPERCASE);
        }
        if (includeDigits) {
            characters.append(DIGITS);
        }
        if (includeSpecialChars) {
            characters.append(SPECIAL_CHARS);
        }

        return characters.toString();
    }

    public static String[] generatePasswordCombinations(String characters, int length) {
        if (length <= 0 || characters == null || characters.isEmpty()) {
            throw new IllegalArgumentException("Invalid input for password generation.");
        }
        
        int totalCombinations = (int) Math.pow(characters.length(), length);
        String[] combinations = new String[totalCombinations];

        for (int i = 0; i < totalCombinations; i++) {
            StringBuilder password = new StringBuilder();
            int temp = i;
            for (int j = 0; j < length; j++) {
                password.append(characters.charAt(temp % characters.length()));
                temp /= characters.length();
            }
            combinations[i] = password.reverse().toString();
        }

        return combinations;
        
    }
}
