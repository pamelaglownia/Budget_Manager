package pl.glownia.pamela;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static pl.glownia.pamela.SortingOption.*;
import static pl.glownia.pamela.PurchaseType.*;

class Sorter {
    Printer printer = new Printer();
    Input input = new Input();

    void sort(List<Purchase> foodList, List<Purchase> clothesList, List<Purchase> entertainmentList, List<Purchase> otherList, List<Purchase> listOfAllPurchases) {
        int userDecision;
        do {
            printer.printSortingOptions();
            userDecision = input.takeUserDecision(1, 4);
            if (userDecision == ALL_PURCHASES.getNumber()) {
                System.out.println(ALL.getName());
                sortAllPurchases(listOfAllPurchases);
                System.out.println();
            } else if (userDecision == TYPE.getNumber()) {
                sortByType(foodList, clothesList, entertainmentList, otherList);
                System.out.println();
            } else if (userDecision == CERTAIN_TYPE.getNumber()) {
                sortOneCategory(foodList, clothesList, entertainmentList, otherList);
                System.out.println();
            }
        } while (userDecision != 4);
    }

    private void sortAllPurchases(List<Purchase> listOfPurchases) {
        if (listOfPurchases.isEmpty()) {
            printer.printInformationEmptyList();
        }
        listOfPurchases.sort(Comparator.comparing(Purchase::getProductPrice).reversed());
        printer.printAListOfPurchases(listOfPurchases);
    }

    private void sortByType(List<Purchase> foodList, List<Purchase> clothesList, List<Purchase> entertainmentList, List<Purchase> otherList) {
        Calculator calculator = new Calculator();
        double foodPrice = calculator.calculatePrice(foodList);
        double clothesPrice = calculator.calculatePrice(clothesList);
        double entertainmentPrice = calculator.calculatePrice(entertainmentList);
        double otherPrice = calculator.calculatePrice(otherList);
        double totalPrice = foodPrice + clothesPrice + entertainmentPrice + otherPrice;
        double[] priceArray = {foodPrice, clothesPrice, entertainmentPrice, otherPrice};
        Arrays.asList(priceArray).sort(Collections.reverseOrder());
        System.out.println("Types:");
        if (totalPrice > 0) {
            printer.printSortedPricesByCategories(priceArray, foodPrice, clothesPrice, entertainmentPrice, otherPrice);
        } else {
            printer.printEmptyCategories();
        }
        printer.printTotalPrice(totalPrice);
    }

    private void sortOneCategory(List<Purchase> foodList, List<Purchase> clothesList, List<Purchase> entertainmentList, List<Purchase> otherList) {
        printer.printPurchaseCategoryToSort();
        int userDecision = input.takeUserDecision(1, 4);
        if (userDecision == FOOD.getNumber()) {
            System.out.println(FOOD.getName() + ":");
            sortAllPurchases(foodList);
        } else if (userDecision == CLOTHES.getNumber()) {
            System.out.println(CLOTHES.getName() + ":");
            sortAllPurchases(clothesList);
        } else if (userDecision == ENTERTAINMENT.getNumber()) {
            System.out.println(ENTERTAINMENT.getName() + ":");
            sortAllPurchases(entertainmentList);
        } else if (userDecision == OTHER.getNumber()) {
            System.out.println(OTHER.getName() + ":");
            sortAllPurchases(otherList);
        }
    }
}