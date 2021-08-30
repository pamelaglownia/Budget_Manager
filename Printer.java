package pl.glownia.pamela;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Printer {

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
