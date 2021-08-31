package pl.glownia.pamela;

import java.util.ArrayList;
import java.util.Scanner;

public class Input {
    private final Scanner scan = new Scanner(System.in);

    ArrayList<String> addPurchaseToTheList() {
        System.out.println("Provide list of products with prices. \nWhen you finish, mark end-of-file (Ctrl+D on Linux and Mac or Ctrl+Z on Windows): ");
        ArrayList<String> listOfPurchases = new ArrayList<>();
        while (scan.hasNextLine()) {
            String userInput = scan.nextLine();
            listOfPurchases.add(userInput);
        }
        return listOfPurchases;
    }

    int takeUserDecision() {
        int decision = scan.nextInt();
        while (!(decision >= 0 && decision <= 4)) {
            System.out.println("Choose one option from 0 to 4:");
            decision = scan.nextInt();
        }
        return decision;
    }

    double enterIncome() {
        System.out.println("Enter income:");
        double income;
        while (!(scan.hasNextDouble())) {
            System.out.println("Income should be number. Enter income:");
            scan.next();
        }
        income = scan.nextDouble();
        System.out.println("Income added.");
        return income;
    }
}