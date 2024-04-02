import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Task class represents a single task with description and completion status
class Task {
    private String description;
    private boolean isDone;

    // Constructor to initialize task with description and default completion status (false)
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    // Getter method for task description
    public String getDescription() {
        return description;
    }

    // Getter method for task completion status
    public boolean isDone() {
        return isDone;
    }

    // Method to mark task as done
    public void markAsDone() {
        isDone = true;
    }
}

// ToDoList class manages a list of tasks and provides operations to manipulate them
class ToDoList {
    private List<Task> tasks;

    // Constructor to initialize an empty list of tasks
    public ToDoList() {
        tasks = new ArrayList<>();
    }

    // Method to add a new task to the list
    public void addTask(String description) {
        tasks.add(new Task(description));
        System.out.println("Task added successfully.");
    }

    // Method to delete a task from the list based on index
    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Invalid task index.");
        }
    }

    // Method to mark a task as done based on index
    public void markTaskAsDone(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsDone();
            System.out.println("Task marked as done.");
        } else {
            System.out.println("Invalid task index.");
        }
    }

    // Method to display all tasks in the list with their status
    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                System.out.println((i + 1) + ". " + task.getDescription() + (task.isDone() ? " [Done]" : ""));
            }
        }
    }
}

public class ToDoApp {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList(); // Create a new ToDoList instance
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for user input

        // Main loop to display menu and process user commands
        while (true) {
            // Display menu options
            System.out.println("\n===== ToDo App Menu =====");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Mark Task as Done");
            System.out.println("4. Display Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt(); // Read user choice
            scanner.nextLine(); // Consume newline character
            
            switch (choice) {
                case 1: // Add Task
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    toDoList.addTask(description);
                    break;
                case 2: // Delete Task
                    System.out.print("Enter task index to delete: ");
                    int deleteIndex = scanner.nextInt() - 1;
                    toDoList.deleteTask(deleteIndex);
                    break;
                case 3: // Mark Task as Done
                    System.out.print("Enter task index to mark as done: ");
                    int doneIndex = scanner.nextInt() - 1;
                    toDoList.markTaskAsDone(doneIndex);
                    break;
                case 4: // Display Tasks
                    toDoList.displayTasks();
                    break;
                case 5: // Exit
                    System.out.println("Exiting ToDo App. Goodbye!");
                    scanner.close(); // Close the Scanner object
                    System.exit(0); // Terminate the program
                    break;
                default: // Invalid choice
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
