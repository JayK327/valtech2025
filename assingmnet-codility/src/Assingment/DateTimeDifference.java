package Assingment;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateTimeDifference {

   
    public static String computeTimeDifference(LocalDateTime startTime, LocalDateTime endTime) {
        if (endTime.isBefore(startTime)) {
            return "End time must be after start time.";
        }

        
        Duration duration = Duration.between(startTime, endTime);

       
        long days = duration.toDays();
        long hours = duration.toHours() % 24;
        long minutes = duration.toMinutes() % 60;

        return String.format("%d day(s), %d hour(s), %d minute(s)", days, hours, minutes);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        try {
           
            System.out.println("Enter start time (yyyy-MM-dd HH:mm):");
            String startTimeInput = scanner.nextLine();
            LocalDateTime startTime = LocalDateTime.parse(startTimeInput, formatter);

            
            System.out.println("Enter end time (yyyy-MM-dd HH:mm):");
            String endTimeInput = scanner.nextLine();
            LocalDateTime endTime = LocalDateTime.parse(endTimeInput, formatter);

           
            String result = computeTimeDifference(startTime, endTime);
            System.out.println("Time Difference: " + result);
        } catch (Exception e) {
            System.out.println("Invalid input format. Please use yyyy-MM-dd HH:mm.");
        }

        scanner.close();
    }
}
