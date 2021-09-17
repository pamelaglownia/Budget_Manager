package pl.glownia.pamela;

import java.util.List;

class ListManager {
    private final Input input = new Input();
    private final Printer printer = new Printer();

    Purchase addPurchaseToTheList(int userDecision) {
        Purchase purchase = new Purchase();
        for (PurchaseType type : PurchaseType.values()) {
            if (type.getNumber() == userDecision) {
                purchase.setPurchaseType(type);
            }
        }
        purchase.setProductName(input.enterPurchaseName());
        purchase.setProductPrice(input.enterPrice());
        System.out.println("Purchase was added.");
        return purchase;
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
                for (PurchaseType type : PurchaseType.values()) {
                    if (type.getNumber() == userDecision) {
                        System.out.println(type.getName() + ":");
                    }
                }
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