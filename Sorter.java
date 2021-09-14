package pl.glownia.pamela;

import java.util.List;

import static pl.glownia.pamela.SortingOption.*;
import static pl.glownia.pamela.PurchaseType.*;

public class Sorter {
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

    void sortAllPurchases(List<Purchase> listOfPurchases) {
        if (listOfPurchases.isEmpty()) {
            printer.printInformationEmptyList();
        }
        for (int i = 0; i < listOfPurchases.size(); i++) {
            for (int j = 0; j < listOfPurchases.size() - i - 1; j++) {
                if (listOfPurchases.get(j).getProductPrice() < listOfPurchases.get(j + 1).getProductPrice()) {
                    Purchase temp = listOfPurchases.get(j);
                    listOfPurchases.set(j, listOfPurchases.get(j + 1));
                    listOfPurchases.set(j + 1, temp);
                }
            }
        }
        printer.printAListOfPurchases(listOfPurchases);
    }

    void sortByType(List<Purchase> foodList, List<Purchase> clothesList, List<Purchase> entertainmentList, List<Purchase> otherList) {
        Calculator calculator = new Calculator();
        double foodPrice = calculator.calculatePrice(foodList);
        double clothesPrice = calculator.calculatePrice(clothesList);
        double entertainmentPrice = calculator.calculatePrice(entertainmentList);
        double otherPrice = calculator.calculatePrice(otherList);
        double totalPrice = foodPrice + clothesPrice + entertainmentPrice + otherPrice;
        double[] priceArray = {foodPrice, clothesPrice, entertainmentPrice, otherPrice};
        for (int i = 0; i < priceArray.length; i++) {
            for (int j = 0; j < priceArray.length - i - 1; j++) {
                if (priceArray[j] < priceArray[j + 1]) {
                    double temp = priceArray[j];
                    priceArray[j] = priceArray[j + 1];
                    priceArray[j + 1] = temp;
                }
            }
        }
        System.out.println("Types:");
        printer.printSortedPricesByCategories(priceArray, foodPrice, clothesPrice, entertainmentPrice, otherPrice);
        printer.printTotalPrice(totalPrice);
    }

    void sortOneCategory(List<Purchase> foodList, List<Purchase> clothesList, List<Purchase> entertainmentList, List<Purchase> otherList) {
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