package pl.glownia.pamela;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import static pl.glownia.pamela.PurchaseType.*;
import static pl.glownia.pamela.MenuOption.*;

public class Printer {
    NumberFormat dollar = NumberFormat.getCurrencyInstance(Locale.US);

    void printMenu() {
        String menu = "Choose your action:\n" +
                "1) " + ADD_INCOME.getName() + "\n" +
                "2) " + ADD_PURCHASE.getName() + "\n" +
                "3) " + SHOW_LIST_OF_PURCHASES.getName() + "\n" +
                "4) " + BALANCE.getName() + "\n" +
                "5) " + SAVE.getName() + "\n" +
                "6) " + LOAD.getName() + "\n" +
                "0) " + EXIT.getName();
        System.out.println(menu);
    }

    void printPurchaseCategory(boolean showListMethod) {
        StringBuilder purchaseCategory = new StringBuilder();
        purchaseCategory.append("Choose the type of purchase:\n");
        purchaseCategory.append("1) ").append(FOOD.getName()).append("\n");
        purchaseCategory.append("2) ").append(CLOTHES.getName()).append("\n");
        purchaseCategory.append("3) ").append(ENTERTAINMENT.getName()).append("\n");
        purchaseCategory.append("4) ").append(OTHER.getName()).append("\n");
        if (showListMethod) {
            purchaseCategory.append("5) ").append(ALL.getName()).append("\n");
            purchaseCategory.append("6) Back");
        } else {
            purchaseCategory.append("5) Back");
        }
        System.out.println(purchaseCategory);
    }

    void printInformationEmptyList() {
        System.out.println("The purchase list is empty");
    }

    void printAListOfPurchases(List<Purchase> listOfPurchases) {
        for (Purchase purchase : listOfPurchases) {
            System.out.println(purchase.toString());
        }
    }

    void printBalance(double balance) {
        System.out.println("Balance: " + dollar.format(balance));
    }

    void printTotalPrice(double price) {
        System.out.println("Total sum: " + dollar.format(price));
    }
}