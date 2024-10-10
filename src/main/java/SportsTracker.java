import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SportsTracker {

    // Log of activities with the date and duration
    HashMap<String, HashMap<LocalDate, Integer>> activities = new HashMap<>();

    public void logActivity(String activity, int duration) {
        // Log the activity and duration with the current date
        LocalDate today = LocalDate.now();
        activities.putIfAbsent(activity, new HashMap<>());
        activities.get(activity).put(today, duration);
    }

    public void viewActivities() {
        // View all logged activities
        for (Map.Entry<String, HashMap<LocalDate, Integer>> entry : activities.entrySet()) {
            String activity = entry.getKey();
            for (Map.Entry<LocalDate, Integer> dateEntry : entry.getValue().entrySet()) {
                System.out.println("Activity: " + activity + ", Date: " + dateEntry.getKey() + ", Duration: " + dateEntry.getValue() + " minutes");
            }
        }
    }

    public int calculateTotalTime() {
        // Calculate total time spent on sports for the week
        int totalTime = 0;
        LocalDate oneWeekAgo = LocalDate.now().minusWeeks(1);

        for (HashMap<LocalDate, Integer> dateMap : activities.values()) {
            for (Map.Entry<LocalDate, Integer> entry : dateMap.entrySet()) {
                if (!entry.getKey().isBefore(oneWeekAgo)) {
                    totalTime += entry.getValue();
                }
            }
        }

        return totalTime;
    }

    public static void main(String[] args) {
        // Create an instance of SportsTracker
        SportsTracker sportsTracker = new SportsTracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Log Activity");
            System.out.println("2. View Activities");
            System.out.println("3. Calculate Total Time");
            System.out.println("4. Exit");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter the activity:");
                    String activity = scanner.next();
                    System.out.println("Enter the duration:");
                    int duration = scanner.nextInt();
                    sportsTracker.logActivity(activity, duration);
                    break;
                case 2:
                    sportsTracker.viewActivities();
                    break;
                case 3:
                    System.out.println("Total time spent on sports: " + sportsTracker.calculateTotalTime() + " minutes");
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}