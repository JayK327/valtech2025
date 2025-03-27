package Assignment;

import java.util.Scanner;

public class PasswordStrength {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a password to check its strength: ");
        String password = scanner.nextLine();  
        scanner.close();


        System.out.println("Your Entered Password: " + password);
        int strength = ratePasswordStrength(password);
        System.out.println("Password Strength Rating: " + strength);
    }

    public static int ratePasswordStrength(String password) {
        if (password == null || password.length() < 8) {
            return 2;
        }

        int rating = 0;

        if (password.length() < 8) {
            rating += 2;
        } else if (password.length() >= 8 && password.length() <= 11) {
            rating += 4;
        } else if (password.length() >= 12 && password.length() <= 15) {
            rating += 7;
        } else {
            rating += 10;
        }

        
        boolean hasUpperCase = false;
        boolean	hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }

        if (!(hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar)) {
            rating -= 2;  
        } else {
            rating += 2;  
        }

        
        if (containsCommonSequence(password)) {
            rating -= 2;  
        }

        return Math.max(1, Math.min(rating, 10));  
    }

    private static boolean containsCommonSequence(String password) {
        String[] commonSequences = {
            "123","12345","0000", "password", "qwerty", "abc"
        };

        for (String sequence : commonSequences) {
            if (password.toLowerCase().contains(sequence)) {
                return true;
            }
        }
        return false;
    }
}
