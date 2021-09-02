package pl.glownia.pamela;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Printer {
    NumberFormat dollar = NumberFormat.getCurrencyInstance(Locale.US);

    void printMenu() {
        StringBuilder menu = new StringBuilder();
        menu.append("Choose your action:\n");
        menu.append("1) Add income\n");
        menu.append("2) Add purchase\n");
        menu.append("3) Show list of purchases\n");
        menu.append("4) Balance\n");
        menu.append("0) Exit");
        System.out.println(menu);

    }

    void printPurchaseCategory(boolean showListMethod) {
        StringBuilder purchaseCategory = new StringBuilder();
        purchaseCategory.append("Choose the type of purchase:\n");
        purchaseCategory.append("1) Food\n");
        purchaseCategory.append("2) Clothes\n");
        purchaseCategory.append("3) Entertainment\n");
        purchaseCategory.append("4) Other\n");
        if (showListMethod) {
            purchaseCategory.append("5) All\n");
            purchaseCategory.append("6) Back");
        } else {
            purchaseCategory.append("5) Back");
        }
        System.out.println(purchaseCategory);
    }

    void printAListOfPurchases(ArrayList<String> listOfPurchases, double totalPrice) {
        if (listOfPurchases.size() == 0) {
            System.out.println("The purchase list is empty");
        } else {
            for (String purchase : listOfPurchases) {
                System.out.println(purchase);
            }
            printTotalPrice(totalPrice);
        }
    }

    void printBalance(double balance) {
        System.out.println("Balance: " + dollar.format(balance));
    }

    void printTotalPrice(double price) {
        System.out.println("Total: " + dollar.format(price));
    }
}
