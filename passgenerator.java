import java.security.SecureRandom;
import java.util.Scanner;

public class EfficientPasswordGenerator {
    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+";
    
    // Method to generate a highly secure random password of specified length
    public static String generateSecurePassword(int length) {
        StringBuilder password = new StringBuilder();
        SecureRandom random = new SecureRandom();
        
        // Include at least one character from each category
        password.append(UPPER_CASE.charAt(random.nextInt(UPPER_CASE.length())));
        password.append(LOWER_CASE.charAt(random.nextInt(LOWER_CASE.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));
        
        // Include remaining characters randomly
        for (int i = 4; i < length; i++) {
            String allChars = UPPER_CASE + LOWER_CASE + DIGITS + SPECIAL_CHARACTERS;
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }
        
        return password.toString();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Password Generator Menu =====");
            System.out.println("1. Generate Password");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter password length: ");
                    int passwordLength = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    String generatedPassword = generateSecurePassword(passwordLength);
                    System.out.println("Generated Password: " + generatedPassword);
                    break;
                case 2:
                    System.out.println("Exiting Password Generator. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
