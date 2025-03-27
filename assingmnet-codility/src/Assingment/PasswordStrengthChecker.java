package Assingment;

import java.util.Scanner;

public class PasswordStrengthChecker {
    
    
    public static String checkPasswordStrength(String password) {
        boolean hasLowercase = false;
        boolean hasUppercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        if (password.length() < 8) {
            return "Weak: Password must be at least 8 characters long.";
        }

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }

        if (hasLowercase && hasUppercase && hasDigit && hasSpecialChar) {
            return "Strong: Your password is secure.";
        } else if ((hasLowercase && hasUppercase && hasDigit) || 
                   (hasLowercase && hasUppercase && hasSpecialChar)) {
            return "Moderate: Add more variety to your password.";
        } else {
            return "Weak: Include uppercase, lowercase, numbers, and special characters.";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a password to check its strength:");
        String password = scanner.nextLine();

        String result = checkPasswordStrength(password);
        System.out.println(result);

        scanner.close();
    }
}
