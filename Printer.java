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

    void printAListOfPurchases(ArrayList<String> listOfPurchases, double totalPrice) {
        if (listOfPurchases.size() == 0) {
            System.out.println("The purchase list is empty");
        }
        else{
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
