package pl.glownia.pamela;

import java.util.ArrayList;

public class Calculator {
    private final Input input = new Input();
    private final Printer printer = new Printer();

    double calculateTotalPrice(ArrayList<String> listOfPurchases) {
        double totalPrice = 0;
        for (String purchase : listOfPurchases) {
            String[] array = purchase.split("\\$");
            totalPrice += Double.parseDouble(array[array.length - 1]);
        }
        printer.printTotalPrice(totalPrice);
        return totalPrice;
    }

    void run() {
        ArrayList<String> listOfPurchases = input.takeAListOfPurchases();
        printer.printAListOfPurchases(listOfPurchases);
        double totalPrice = calculateTotalPrice(listOfPurchases);
    }
}