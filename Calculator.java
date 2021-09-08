package pl.glownia.pamela;

import java.util.List;

import static pl.glownia.pamela.PurchaseType.*;

public class Calculator {
    private final Input input = new Input();
    private final Printer printer = new Printer();

    Purchase addPurchaseToTheList() {
        String productName = input.enterPurchaseName();
        double productPrice = input.enterPrice();
        System.out.println("Purchase was added.");
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

    double addPurchaseRelatedToCategory(List<Purchase> foodList, List<Purchase> clothesList, List<Purchase> entertainmentList, List<Purchase> otherList, List<Purchase> listOfAllPurchases, double totalPrice) {
        int userDecision;
        do {
            printer.printPurchaseCategory(false);
            userDecision = input.takeUserDecision(1, 5);
            if (userDecision == FOOD.getNumber()) {
                System.out.println(FOOD.getName());
                foodList.add(addPurchaseToTheList());
                listOfAllPurchases.add(foodList.get((foodList.size() - 1)));
                totalPrice += calculatePrice(foodList);
            } else if (userDecision == CLOTHES.getNumber()) {
                System.out.println(CLOTHES.getName());
                clothesList.add(addPurchaseToTheList());
                listOfAllPurchases.add(clothesList.get((clothesList.size() - 1)));
                totalPrice += calculatePrice(clothesList);
            } else if (userDecision == ENTERTAINMENT.getNumber()) {
                System.out.println(ENTERTAINMENT.getName());
                entertainmentList.add(addPurchaseToTheList());
                listOfAllPurchases.add(entertainmentList.get((entertainmentList.size() - 1)));
                totalPrice += calculatePrice(entertainmentList);
            } else if (userDecision == OTHER.getNumber()) {
                System.out.println(OTHER.getName());
                otherList.add(addPurchaseToTheList());
                listOfAllPurchases.add(otherList.get((otherList.size() - 1)));
                totalPrice += calculatePrice(otherList);
            }
            System.out.println();
        } while (userDecision != 5);
        return totalPrice;
    }

    void showListOfPurchases(List<Purchase> foodList, List<Purchase> clothesList, List<Purchase> entertainmentList, List<Purchase> otherList, List<Purchase> listOfAllPurchases, double totalPrice) {
        int userDecision;
        double partPrice;
        do {
            printer.printPurchaseCategory(true);
            userDecision = input.takeUserDecision(1, 6);
            System.out.println();
            if (userDecision == FOOD.getNumber()) {
                if (foodList.isEmpty()) {
                    printer.printInformationEmptyList();
                } else {
                    System.out.println(FOOD.getName() + ":");
                    printer.printAListOfPurchases(foodList);
                    partPrice = calculatePrice(foodList);
                    printer.printTotalPrice(partPrice);
                }
            } else if (userDecision == CLOTHES.getNumber()) {
                if (clothesList.isEmpty()) {
                    printer.printInformationEmptyList();
                } else {
                    System.out.println(CLOTHES.getName() + ":");
                    printer.printAListOfPurchases(clothesList);
                    partPrice = calculatePrice(clothesList);
                    printer.printTotalPrice(partPrice);
                }
            } else if (userDecision == ENTERTAINMENT.getNumber()) {
                if (entertainmentList.isEmpty()) {
                    printer.printInformationEmptyList();
                } else {
                    System.out.println(ENTERTAINMENT.getName() + ":");
                    printer.printAListOfPurchases(entertainmentList);
                    partPrice = calculatePrice(entertainmentList);
                    printer.printTotalPrice(partPrice);
                }
            } else if (userDecision == OTHER.getNumber()) {
                if (otherList.isEmpty()) {
                    printer.printInformationEmptyList();
                } else {
                    System.out.println(OTHER.getName() + ":");
                    printer.printAListOfPurchases(otherList);
                    partPrice = calculatePrice(otherList);
                    printer.printTotalPrice(partPrice);
                }
            } else if (userDecision == ALL.getNumber()) {
                if (listOfAllPurchases.isEmpty()) {
                    printer.printInformationEmptyList();
                } else {
                    System.out.println(ALL.getName() + ":");
                    printer.printAListOfPurchases(listOfAllPurchases);
                    printer.printTotalPrice(totalPrice);
                }
            }
            System.out.println();
        } while (userDecision != 6);
    }
}