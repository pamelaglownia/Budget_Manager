package pl.glownia.pamela;

import java.util.List;

class ListManager {
    private final Input input = new Input();
    private final Printer printer = new Printer();

    Purchase addPurchaseToTheList(int userDecision) {
        PurchaseType type = PurchaseType.choosePurchaseType(userDecision);
        String productName = input.enterPurchaseName();
        double productPrice = input.enterPrice();
        System.out.println("Purchase was added.");
        return new Purchase(type, productName, productPrice);
    }

    double addIncome() {
        System.out.println("Enter income:");
        double income = input.enterNumber();
        System.out.println("Income added.");
        return income;
    }

    double calculatePriceForCategory(List<Purchase> listOfPurchases, int userDecision) {
        return listOfPurchases.stream()
                .filter(purchase -> purchase.getPurchaseType().getNumber() == userDecision)
                .mapToDouble(Purchase::getProductPrice)
                .sum();
    }

    double calculatePrice(List<Purchase> listOfPurchases) {
        return listOfPurchases.stream()
                .mapToDouble(Purchase::getProductPrice)
                .sum();
    }

    double calculateBalance(double income, double totalPrice) {
        return income - totalPrice;
    }

    void addPurchaseRelatedToCategory(List<Purchase> listOfPurchases) {
        int userDecision;
        do {
            printer.printPurchaseCategory(false);
            userDecision = input.takeUserDecision(1, 5);
            if (userDecision != 5) {
                listOfPurchases.add(addPurchaseToTheList(userDecision));
            }
            System.out.println();
        } while (userDecision != 5);
    }

    void showListOfPurchases(List<Purchase> listOfPurchases) {
        int userDecision;
        do {
            printer.printPurchaseCategory(true);
            userDecision = input.takeUserDecision(1, 6);
            if (listOfPurchases.isEmpty() && userDecision != 6) {
                printer.printInformationEmptyList();
            } else {
                printer.printCategory(userDecision);
                if (userDecision == 5) {
                    printer.printAListOfPurchases(listOfPurchases);
                    printer.printTotalPrice(calculatePrice(listOfPurchases));
                } else if (userDecision != 6) {
                    int finalUserDecision = userDecision;
                    listOfPurchases.stream()
                            .filter(purchase -> purchase.getPurchaseType().getNumber() == finalUserDecision)
                            .forEach(System.out::println);
                    printer.printTotalPrice(calculatePriceForCategory(listOfPurchases, finalUserDecision));
                }
            }
            System.out.println();
        } while (userDecision != 6);
    }
}