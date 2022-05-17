package view;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public final class InputValidator {
    private static Scanner scanner = new Scanner(System.in);

    public static int getInt(String message) {
        scanner = new Scanner(System.in);
        System.out.println(message);
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("Incorrect input! Please type a number:");
        }
        int result = scanner.nextInt();
        scanner.nextLine();
        return result;
    }

    public static String getPhone(String message) {
        scanner = new Scanner(System.in);
        System.out.println(message);
        while (!scanner.hasNext("\\d{9}")) {
            scanner.nextLine();
            System.out.println("Incorrect input! Please type a 9 digits without spaces:");
        }

        return scanner.nextLine();
    }

    public static BigDecimal getBigDecimal(String message) {
        scanner = new Scanner(System.in);
        System.out.println(message);
        while (!scanner.hasNextBigDecimal()) {
            scanner.nextLine();
            System.out.println("Incorrect input! Please type a decimal number:");
        }

        BigDecimal result = scanner.nextBigDecimal();
        scanner.nextLine();
        return result;

    }

    public static String getString(String message) {
        scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

    public static LocalDate getLocalDate(String message) {
        scanner = new Scanner(System.in);
        System.out.println(message);
        while (!scanner.hasNext("20([2468][048]|[13579][26])-02-29"  // rok przestępny
                + "|(20\\d{2})-02-(0[1-9]|1\\d|2[0-8])"                     // luty
                + "|(20\\d{2})-(0[13578]|10|12)-(0[1-9]|[12]\\d|3[01])"     // 31
                + "|(20\\d{2})-(0[469]|11)-(0[1-9]|[12]\\d|30)")) {         // 30
            System.out.println("Incorrect input! Please enter a date in yyyy-mm-dd format");
            scanner.nextLine();
        }
        LocalDate result = LocalDate.parse(scanner.nextLine());

        return LocalDate.parse(scanner.nextLine());

    }

    public static boolean getBoolean(String message) {
        scanner = new Scanner(System.in);
        System.out.println(message);
        while (!scanner.hasNext("[YNyn]")) {
            System.out.println("Incorrect input! Please enter Y or N");
            scanner.nextLine();
        }
        if (scanner.hasNext("[Yy]")){
            scanner.nextLine();
            return true;
        } else return false;
    }
}