package pl.glownia.pamela;

import java.util.ArrayList;
import java.util.List;

import static pl.glownia.pamela.PurchaseType.*;

public class Calculator {
    private final Input input = new Input();
    private final Printer printer = new Printer();

    Purchase addPurchaseToTheList() {
        String productName = input.enterPurchaseName();
        double productPrice = input.enterPrice();
        System.out.println("Purchase was added.\n");
        return new Purchase(productName, productPrice);
    }

    double addIncome() {
        System.out.println("Enter income:");
        double income = input.enterNumber();
        System.out.println("Income added.");
        return income;
    }

    double calculatePrice(List<Purchase> listOfPurchases) {
        double price = 0;
        for (Purchase purchase : listOfPurchases) {
            price = purchase.getProductPrice();
        }
        return price;
    }

    double calculateBalance(double income, double totalPrice) {
        return income - totalPrice;
    }

    double addPurchaseRelatedToCategory(List<Purchase> foodList, List<Purchase> clothesList, List<Purchase> entertainmentList, List<Purchase> otherList, double totalPrice) {
        int userDecision;
        do {
            printer.printPurchaseCategory(false);
            userDecision = input.chooseTheCategoryOfPurchase();
            if (userDecision == FOOD.getNumber()) {
                System.out.println(FOOD.getName());
                foodList.add(addPurchaseToTheList());
                totalPrice += calculatePrice(foodList);
            } else if (userDecision == CLOTHES.getNumber()) {
                System.out.println(CLOTHES.getName());
                clothesList.add(addPurchaseToTheList());
                totalPrice += calculatePrice(clothesList);
            } else if (userDecision == ENTERTAINMENT.getNumber()) {
                System.out.println(ENTERTAINMENT.getName());
                entertainmentList.add(addPurchaseToTheList());
                totalPrice += calculatePrice(entertainmentList);
            } else if (userDecision == OTHER.getNumber()) {
                System.out.println(OTHER.getName());
                otherList.add(addPurchaseToTheList());
                totalPrice += calculatePrice(otherList);
            }
        } while (userDecision != 5);
        return totalPrice;
    }

    void showListOfPurchases(List<Purchase> foodList, List<Purchase> clothesList, List<Purchase> entertainmentList, List<Purchase> otherList, double totalPrice) {
        int userDecision;
        double partPrice;
        do {
            printer.printPurchaseCategory(true);
            userDecision = input.chooseTheCategoryOfPurchase();
            if (userDecision == FOOD.getNumber()) {
                System.out.println(FOOD.getName());
                printer.printAListOfPurchases(foodList);
                partPrice = calculatePrice(foodList);
                printer.printTotalPrice(partPrice);
            } else if (userDecision == CLOTHES.getNumber()) {
                System.out.println(CLOTHES.getName());
                printer.printAListOfPurchases(clothesList);
                partPrice = calculatePrice(clothesList);
                printer.printTotalPrice(partPrice);
            } else if (userDecision == ENTERTAINMENT.getNumber()) {
                System.out.println(ENTERTAINMENT.getName());
                printer.printAListOfPurchases(entertainmentList);
                partPrice = calculatePrice(entertainmentList);
                printer.printTotalPrice(partPrice);
            } else if (userDecision == OTHER.getNumber()) {
                System.out.println(OTHER.getName());
                printer.printAListOfPurchases(otherList);
                partPrice = calculatePrice(otherList);
                printer.printTotalPrice(partPrice);
            } else if (userDecision == ALL.getNumber()) {
                System.out.println(ALL.getName());
                List<Purchase> listOfAllPurchases = new ArrayList<>();
                listOfAllPurchases.addAll(foodList);
                listOfAllPurchases.addAll(clothesList);
                listOfAllPurchases.addAll(entertainmentList);
                listOfAllPurchases.addAll(otherList);
                printer.printAListOfPurchases(listOfAllPurchases);
                printer.printTotalPrice(totalPrice);
            }
        } while (userDecision != 6);
    }
}