package pl.glownia.pamela;

import java.util.List;

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
            switch (userDecision) {
                case 1:
                    System.out.println("Food:");
                    foodList.add(addPurchaseToTheList());
                    totalPrice += calculatePrice(foodList);
                    break;
                case 2:
                    System.out.println("Clothes:");
                    clothesList.add(addPurchaseToTheList());
                    totalPrice += calculatePrice(clothesList);
                    break;
                case 3:
                    System.out.println("Entertainment:");
                    entertainmentList.add(addPurchaseToTheList());
                    totalPrice += calculatePrice(entertainmentList);
                    break;
                case 4:
                    System.out.println("Other:");
                    otherList.add(addPurchaseToTheList());
                    totalPrice += calculatePrice(otherList);
                    break;
            }
        } while (userDecision != 5);
        return totalPrice;
    }
}