package com.company.util;

public class ConsolePrinter {

    private ConsolePrinter() {
    }

    public static void printHeader(String title) {

        System.out.println();
        System.out.println("==========================================");
        System.out.println(title);
        System.out.println("==========================================");

    }

    public static void success(String message) {

        System.out.println("[SUCCESS] " + message);

    }

    public static void error(String message) {

        System.out.println("[ERROR] " + message);

    }

    public static void info(String message) {

        System.out.println("[INFO] " + message);

    }

}
