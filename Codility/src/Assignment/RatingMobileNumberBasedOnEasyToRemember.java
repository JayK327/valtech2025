package Assignment;

import java.util.Scanner;

public class RatingMobileNumberBasedOnEasyToRemember {

    public static int rateMobileNumberBasedOnEasyToRemember(String mobileNumber) {
        if (mobileNumber == null || mobileNumber.length() != 10 || !mobileNumber.matches("\\d+")) {
            return 1; // Invalid number or format, rated low
        }

        int rating = 0;

        if (isAllDigitsSame(mobileNumber)) {
            return 10;  
        }
        if (isConsecutiveSequence(mobileNumber)) {
            rating += 8;
        }
        if (containsPartialSequence(mobileNumber)) {
            rating += 6;
        }
        if (containsFamiliarPatterns(mobileNumber)) {
            rating += 7;
        }
        if (hasRepeatingGroups(mobileNumber)) {
            rating += 5;
        }
        if (rating == 0) {
            rating = 3; 
        }

        return Math.max(1, Math.min(rating, 10));  // Normalize
    }

    // (1111111111)
    private static boolean isAllDigitsSame(String mobileNumber) {
        char firstDigit = mobileNumber.charAt(0);
        for (int i = 1; i < mobileNumber.length(); i++) {
            if (mobileNumber.charAt(i) != firstDigit) {
                return false;
            }
        }
        return true;
    }

    //(ascending or descending)
    private static boolean isConsecutiveSequence(String mobileNumber) {
        for (int i = 0; i < mobileNumber.length() - 1; i++) {
            if (Math.abs(mobileNumber.charAt(i) - mobileNumber.charAt(i + 1)) != 1) {
                return false;
            }
        }
        return true;
    }

    //(e.g., "1231231234")
    private static boolean containsPartialSequence(String mobileNumber) {
        for (int i = 0; i < mobileNumber.length() / 2; i++) {
            String firstPart = mobileNumber.substring(0, i + 1);
            String secondPart = mobileNumber.substring(i + 1, i + firstPart.length() + 1);
            if (firstPart.equals(secondPart)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsFamiliarPatterns(String mobileNumber) {
        String[] commonPatterns = {
            "555", "800", "888", "900", "123", "234", "777", "000", "111"
        };
        for (String pattern : commonPatterns) {
            if (mobileNumber.contains(pattern)) {
                return true;
            }
        }
        return false;
    }

    // (e.g., "1112223333")
    private static boolean hasRepeatingGroups(String mobileNumber) {
        String group1 = mobileNumber.substring(0, 3);
        String group2 = mobileNumber.substring(3, 6);
        String group3 = mobileNumber.substring(6, 10);
        return group1.equals(group2) || group1.equals(group3) || group2.equals(group3);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a mobile number to get rating based on 'easy to remember' : ");
        String mobileNumber = scanner.nextLine();  
        scanner.close();

        System.out.println("Mobile Number: " + mobileNumber);
        int rating = rateMobileNumberBasedOnEasyToRemember(mobileNumber);
        System.out.println("Mobile Number Easy to Remember Rating: " + rating);
    }
}
