package pl.glownia.pamela;

import java.text.NumberFormat;
import java.util.Locale;

public class Printer {
    private Calculator calculator = new Calculator();
    private Input input = new Input();

    void run() {
        String list = input.takeAListOfPurchases();
        printAListOfPurchases(list);
        printTotalPrice(list);
    }

    void printAListOfPurchases(String list) {
        System.out.println(list);
    }

    void printTotalPrice(String list) {
        double price = calculator.calculatePurchases(list);
        NumberFormat dollar = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("Total: " + dollar.format(price));
    }
}
