package org.uic.interpreter.console;

import java.util.Scanner;

public class Console {

    public static void write(String str) {
        System.out.print(str);
    }

    public static void writeLine(String str) {
        System.out.println(str);
    }

    public static void writeLine(String str, int num) {
        for (int i = 0; i < num; i++) {
            Console.write(str);
        }

        Console.writeLine("");
    }

    public static String readLine() {
        Scanner scanner = new Scanner(System.in);

        String stringResult = scanner.next();
        if (!stringResult.isEmpty()) {
            return stringResult;
        } else {
            return null;
        }
    }

    public static String askForStringResult(String question) {
        return Console.askForStringResult(question, null);
    }

    public static String askForStringResult(String question, String defaultValue) {
        if (defaultValue != null) {
            Console.write(String.format("%s (%s) ", question, defaultValue));
        } else {
            Console.write(String.format("%s ", question));
        }

        String stringResult = Console.readLine();
        if (stringResult == null) {
            stringResult = defaultValue;
        }

        return stringResult;
    }

    public static boolean askForBooleanResult(String question) {
        return Console.askForBooleanResult(question, false);
    }

    public static boolean askForBooleanResult(String question, boolean defaultValue) {
        if (defaultValue) {
            Console.write(String.format("%s (J/n) ", question));
        } else {
            Console.write(String.format("%s (j/N) ", question));
        }

        String stringResult = Console.readLine();
        return stringResult != null && stringResult.equalsIgnoreCase("j");
    }
}
