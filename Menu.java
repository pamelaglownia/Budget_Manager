package pl.glownia.pamela;

import java.util.ArrayList;

public class Menu {
    Printer printer = new Printer();
    Input input = new Input();
    Calculator calculator = new Calculator();
    private final ArrayList<String> listOfPurchases = new ArrayList<>();
    private final ArrayList<String> foodList = new ArrayList<>();
    private final ArrayList<String> clothesList = new ArrayList<>();
    private final ArrayList<String> entertainmentList = new ArrayList<>();
    private final ArrayList<String> otherList = new ArrayList<>();

    void chooseOption() {


        int userDecision;
        double income = 0, totalPrice = 0;
        do {
            printer.printMenu();
            userDecision = input.takeUserDecision();
            System.out.println();
            switch (userDecision) {
                case 1:
                    income += calculator.addIncome();
                    break;
                case 2:
                    addPurchaseRelatedToCategory(false);
                    break;
                case 3:
                    totalPrice = calculator.calculateTotalPrice(listOfPurchases);
                    printer.printAListOfPurchases(listOfPurchases, totalPrice);
                    break;
                case 4:
                    calculator.calculateBalance(income, totalPrice);
                    break;
            }
            System.out.println();
        } while (userDecision != 0);
        System.out.println("Bye!");
    }

    void addPurchaseRelatedToCategory(boolean showListMethod) {
        int userDecision;
        do {
            printer.printPurchaseCategory(showListMethod);
            userDecision = input.chooseTheCategoryOfPurchase();
            switch (userDecision) {
                case 1:
                    System.out.println("Food:");
                    calculator.addPurchaseToTheList(foodList);
                    break;
                case 2:
                    System.out.println("Clothes:");
                    calculator.addPurchaseToTheList(clothesList);
                    break;
                case 3:
                    System.out.println("Entertainment:");
                    calculator.addPurchaseToTheList(entertainmentList);
                    break;
                case 4:
                    System.out.println("Other:");
                    calculator.addPurchaseToTheList(otherList);
                    break;
                case 5:
                    if (showListMethod) {
                        System.out.println("All:");
                        listOfPurchases.addAll(foodList);
                        listOfPurchases.addAll(clothesList);
                        listOfPurchases.addAll(entertainmentList);
                        listOfPurchases.addAll(otherList);
                    }
                    break;
            }
        } while ((userDecision != 6 && showListMethod) || (userDecision != 5 && !showListMethod));
    }
}
