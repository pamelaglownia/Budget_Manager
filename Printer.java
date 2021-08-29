package pl.glownia.pamela;

import java.text.NumberFormat;
import java.util.Locale;

public class Printer {

    void printAListOfPurchases(String list) {
        System.out.println(list);
    }

    void printTotalPrice(double price) {
        NumberFormat dollar = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("Total: " + dollar.format(price));
    }
}
