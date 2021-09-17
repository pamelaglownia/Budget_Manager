package pl.glownia.pamela;

import java.util.*;

import static java.util.Comparator.comparing;
import static pl.glownia.pamela.SortingOption.*;
import static pl.glownia.pamela.PurchaseType.*;

class Sorter {
    Printer printer = new Printer();
    Input input = new Input();

    void sort(List<Purchase> listOfPurchases) {
        int userDecision;
        do {
            printer.printSortingOptions();
            userDecision = input.takeUserDecision(1, 4);
            if (userDecision == ALL_PURCHASES.getNumber()) {
                sortAllPurchases(listOfPurchases);
                System.out.println();
            } else if (userDecision == TYPE.getNumber()) {
                sortByType(listOfPurchases);
                System.out.println();
            } else if (userDecision == CERTAIN_TYPE.getNumber()) {
                printer.printPurchaseCategoryToSort();
                int chosenCategory = input.takeUserDecision(1, 4);
                sortOneCategory(listOfPurchases, chosenCategory);
                System.out.println();
            }
        } while (userDecision != 4);
    }

    private void sortAllPurchases(List<Purchase> listOfPurchases) {
        if (listOfPurchases.isEmpty()) {
            printer.printInformationEmptyList();
        }
        System.out.println(ALL.getName());
        listOfPurchases.stream()
                .sorted(comparing(Purchase::getProductPrice).reversed())
                .forEach(System.out::println);
    }

    private void sortByType(List<Purchase> listOfPurchases) {
        Map<String, Double> typePriceMap = new HashMap<>();
        for (PurchaseType purchaseType : PurchaseType.values()) {
            if (purchaseType.getNumber() != 5) {
                final int finalNumber = purchaseType.getNumber();
                double sum = listOfPurchases.stream()
                        .filter(purchase -> purchase.getPurchaseType().getNumber() == finalNumber)
                        .mapToDouble(Purchase::getProductPrice)
                        .sum();
                typePriceMap.put(purchaseType.getName(), sum);
            }
        }
        typePriceMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(element -> System.out.println(element.getKey() + " $" + String.format(Locale.US, "%.2f", element.getValue())));
    }

    private void sortOneCategory(List<Purchase> listOfPurchases, int userDecision) {
        if (listOfPurchases.isEmpty()) {
            printer.printInformationEmptyList();
        } else {
            printer.printCategory(userDecision);
            listOfPurchases.stream()
                    .filter(purchase -> purchase.getPurchaseType().getNumber() == userDecision)
                    .sorted(comparing(Purchase::getProductPrice).reversed())
                    .forEach(System.out::println);
        }
    }
}