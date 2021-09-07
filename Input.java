package pl.glownia.pamela;

import java.util.Locale;
import java.util.Scanner;

public class Input {
    private final Scanner scan = new Scanner(System.in).useLocale(Locale.US);

    int takeUserDecision(int start, int end) {
        int decision;
        while (!(scan.hasNextInt())) {
            System.out.println("Incorrect value. Enter again:");
            scan.next();
        }
        decision = scan.nextInt();
        scan.nextLine();
        while (!(decision >= start && decision <= end)) {
            System.out.println("Choose one option from " + start + " to " + end + ":");
            decision = takeUserDecision(start, end);
        }
        return decision;
    }

    double enterNumber() {
        double userInputNumber;
        while (!(scan.hasNextDouble())) {
            System.out.println("Incorrect value. Enter again:");
            scan.next();
        }
        userInputNumber = scan.nextDouble();
        scan.nextLine();
        return userInputNumber;
    }

    String enterPurchaseName() {
        System.out.println("Enter purchase name:");
        String productName = scan.nextLine();
        while (productName.equals("")) {
            System.out.println("Purchase can not be empty. Enter purchase name:");
            productName = scan.nextLine();
        }
        return productName;
    }

    double enterPrice() {
        System.out.println("Enter its price:");
        return enterNumber();
    }
}