package com.company.validation;

public class ValidationUtil {

    private ValidationUtil() {
    }

    public static boolean isValidEmail(String email) {

        return email != null &&
                email.matches("^[A-Za-z0-9+_.-]+@(.+)$");

    }

    public static boolean isValidPhone(String phone) {

        return phone != null &&
                phone.matches("\\d{10}");

    }

    public static boolean isValidAge(int age) {

        return age >= 18 && age <= 60;

    }

    public static boolean isValidSalary(double salary) {

        return salary > 0;

    }

}
