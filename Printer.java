package pl.glownia.pamela;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Printer {

    void printMenu(){
        StringBuilder menu = new StringBuilder();
        menu.append("Choose your action:\n");
        menu.append("1) Add income\n");
        menu.append("2) Add purchase\n");
        menu.append("3) Show list of purchases\n");
        menu.append("4) Balance\n");
        menu.append("0) Exit");
        System.out.println(menu.toString());

    }
    void printAListOfPurchases(ArrayList<String> listOfPurchases) {
        for(String purchase: listOfPurchases){
            System.out.println(purchase);
        }
    }

    void printTotalPrice(double price) {
        NumberFormat dollar = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("Total: " + dollar.format(price));
    }
}
