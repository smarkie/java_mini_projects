import java.util.Scanner;

public class ExpenseTracker {
    private double balance;

    // Constructor to initialize balance to 0
    public ExpenseTracker() {
        balance = 0;
    }

    // Method to add an expense
    public void addExpense(double amount) {
        balance -= amount;
        System.out.println("Expense of $" + amount + " added successfully.");
    }

    // Method to add income
    public void addIncome(double amount) {
        balance += amount;
        System.out.println("Income of $" + amount + " added successfully.");
    }

    // Method to calculate and display total balance
    public void displayBalance() {
        System.out.println("Total Balance: $" + balance);
    }

    public static void main(String[] args) {
        ExpenseTracker expenseTracker = new ExpenseTracker(); // Create an instance of ExpenseTracker
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for user input

        // Main loop to display menu and process user commands
        while (true) {
            // Display menu options
            System.out.println("\n===== Expense Tracker Menu =====");
            System.out.println("1. Add Expense");
            System.out.println("2. Add Income");
            System.out.println("3. Display Total Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt(); // Read user choice
            scanner.nextLine(); // Consume newline character
            
            switch (choice) {
                case 1: // Add Expense
                    System.out.print("Enter expense amount: $");
                    double expenseAmount = scanner.nextDouble();
                    expenseTracker.addExpense(expenseAmount);
                    break;
                case 2: // Add Income
                    System.out.print("Enter income amount: $");
                    double incomeAmount = scanner.nextDouble();
                    expenseTracker.addIncome(incomeAmount);
                    break;
                case 3: // Display Total Balance
                    expenseTracker.displayBalance();
                    break;
                case 4: // Exit
                    System.out.println("Exiting Expense Tracker. Goodbye!");
                    scanner.close(); // Close the Scanner object
                    System.exit(0); // Terminate the program
                    break;
                default: // Invalid choice
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
