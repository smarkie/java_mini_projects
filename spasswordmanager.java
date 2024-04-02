import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PasswordManager {
    private Map<String, String> passwords;

    public PasswordManager() {
        passwords = new HashMap<>();
    }

    // Method to add or update a password
    public void addOrUpdatePassword(String username, String password) {
        passwords.put(username, password);
        System.out.println("Password for " + username + " added/updated successfully.");
    }

    // Method to retrieve a password
    public String getPassword(String username) {
        return passwords.get(username);
    }

    // Method to remove a password
    public void removePassword(String username) {
        if (passwords.containsKey(username)) {
            passwords.remove(username);
            System.out.println("Password for " + username + " removed successfully.");
        } else {
            System.out.println("Password for " + username + " not found.");
        }
    }

    public static void main(String[] args) {
        PasswordManager passwordManager = new PasswordManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Password Manager Menu =====");
            System.out.println("1. Add/Update Password");
            System.out.println("2. Retrieve Password");
            System.out.println("3. Remove Password");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    passwordManager.addOrUpdatePassword(username, password);
                    break;
                case 2:
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    String retrievedPassword = passwordManager.getPassword(username);
                    if (retrievedPassword != null) {
                        System.out.println("Password for " + username + ": " + retrievedPassword);
                    } else {
                        System.out.println("Password for " + username + " not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter username to remove password: ");
                    username = scanner.nextLine();
                    passwordManager.removePassword(username);
                    break;
                case 4:
                    System.out.println("Exiting Password Manager. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
