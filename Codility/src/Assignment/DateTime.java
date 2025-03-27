package Assignment;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateTime {

    public static String computeTimeDifference(LocalDateTime startTime, LocalDateTime endTime) {
        if (endTime.isBefore(startTime)) {
            return "End time >> start time.";
        }
        Duration duration = Duration.between(startTime, endTime);

        long days = duration.toDays();
        long hours = duration.toHours() % 24;
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;

        return String.format("%d day(s), %d hour(s), %d minute(s), %d second(s)", days, hours, minutes, seconds);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try {
            // Start time input 
            System.out.println("Enter start time in given format (yyyy-MM-dd HH:mm:ss):");
            String startTimeInput = scanner.nextLine();
            LocalDateTime startTime = LocalDateTime.parse(startTimeInput, formatter);

            // End time input 
            System.out.println("Enter end time (yyyy-MM-dd HH:mm:ss):");
            String endTimeInput = scanner.nextLine();
            LocalDateTime endTime = LocalDateTime.parse(endTimeInput, formatter);

            String result = computeTimeDifference(startTime, endTime);
            System.out.println("Time Difference: " + result);
        } catch (Exception e) {
            System.out.println("Invalid format.");
        }

        scanner.close();
    }
}
