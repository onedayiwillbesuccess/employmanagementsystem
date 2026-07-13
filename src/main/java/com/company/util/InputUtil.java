package com.company.util;

import java.util.Scanner;

public class InputUtil {

    private static final Scanner scanner = new Scanner(System.in);

    private InputUtil() {
    }

    public static int readInt(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException ex) {

                System.out.println("Invalid number. Try again.");

            }

        }

    }

    public static double readDouble(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Double.parseDouble(scanner.nextLine());

            } catch (NumberFormatException ex) {

                System.out.println("Invalid decimal value.");

            }

        }

    }

    public static String readString(String message) {

        System.out.print(message);

        return scanner.nextLine().trim();

    }

}
