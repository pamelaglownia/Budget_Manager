package pl.glownia.pamela;

import java.util.ArrayList;

public class Calculator {
    private final Printer printer = new Printer();
    private final Input input = new Input();


    ArrayList<String> addPurchaseToTheList(ArrayList<String> listOfPurchases) {
        String purchase = input.enterPurchase();
        listOfPurchases.add(purchase);
        System.out.println("Purchase was added.");
        return listOfPurchases;
    }

    double addIncome() {
        System.out.println("Enter income:");
        double income = input.enterNumber();
        System.out.println("Income added.");
        return income;
    }

    double calculateTotalPrice(ArrayList<String> listOfPurchases) {
        double totalPrice = 0;
        for (String purchase : listOfPurchases) {
            String[] array = purchase.split("\\$");
            totalPrice += Double.parseDouble(array[array.length - 1]);
        }
        printer.printTotalPrice(totalPrice);
        return totalPrice;
    }
}