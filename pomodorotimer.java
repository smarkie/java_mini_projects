import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class PomodoroTimer {
    private static final int POMODORO_DURATION = 25; // Pomodoro duration in minutes
    private static final int BREAK_DURATION = 5; // Break duration in minutes
    private static final int LONG_BREAK_DURATION = 15; // Long break duration in minutes
    private static int pomodoroCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Pomodoro Timer!");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Start Pomodoro Timer");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    startPomodoro();
                    break;
                case 2:
                    System.out.println("Exiting Pomodoro Timer. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void startPomodoro() {
        pomodoroCount++;
        System.out.println("\nPomodoro " + pomodoroCount + " started. Work for " + POMODORO_DURATION + " minutes.");

        Timer pomodoroTimer = new Timer();
        pomodoroTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Pomodoro " + pomodoroCount + " completed!");

                if (pomodoroCount % 4 == 0) {
                    System.out.println("Congratulations! You've completed four Pomodoros. Take a longer break for "
                            + LONG_BREAK_DURATION + " minutes.");
                    pomodoroCount = 0;
                    scheduleBreak(LONG_BREAK_DURATION);
                } else {
                    System.out.println("Take a short break for " + BREAK_DURATION + " minutes.");
                    scheduleBreak(BREAK_DURATION);
                }
            }
        }, POMODORO_DURATION * 60 * 1000); // Schedule the timer for the Pomodoro duration

    }

    private static void scheduleBreak(int duration) {
        Timer breakTimer = new Timer();
        breakTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                startPomodoro(); // Start the next Pomodoro after the break
            }
        }, duration * 60 * 1000); // Schedule the timer for the break duration
    }
}
