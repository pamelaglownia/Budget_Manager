package pl.glownia.pamela;

import java.util.Locale;
import java.util.Scanner;

public class Input {
    private final Scanner scan = new Scanner(System.in).useLocale(Locale.US);

    int takeUserDecision() {
        int decision = scan.nextInt();
        while (!(decision >= 0 && decision <= 4)) {
            System.out.println("Choose one option from 0 to 4:");
            decision = scan.nextInt();
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

    int chooseTheCategoryOfPurchase() {
        int categoryNumber = scan.nextInt();
        while (!(categoryNumber >= 1 && categoryNumber <= 6)) {
            System.out.println("Choose one option from 1 to 6:");
            categoryNumber = scan.nextInt();
        }
        scan.nextLine();
        return categoryNumber;
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