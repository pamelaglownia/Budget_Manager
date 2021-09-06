package pl.glownia.pamela;

import java.util.ArrayList;
import java.util.List;

import static pl.glownia.pamela.MenuOption.*;

public class Menu {
    Printer printer = new Printer();
    Input input = new Input();
    Calculator calculator = new Calculator();
    private final List<Purchase> foodList = new ArrayList<>();
    private final List<Purchase> clothesList = new ArrayList<>();
    private final List<Purchase> entertainmentList = new ArrayList<>();
    private final List<Purchase> otherList = new ArrayList<>();

    void chooseOption() {
        int userDecision;
        double income = 0, totalPrice = 0;
        do {
            printer.printMenu();
            userDecision = input.takeUserDecision();
            System.out.println();
            if (userDecision == ADD_INCOME.getNumber()) {
                income += calculator.addIncome();
            } else if (userDecision == ADD_PURCHASE.getNumber()) {
                totalPrice = calculator.addPurchaseRelatedToCategory(foodList, clothesList, entertainmentList, otherList, totalPrice);
            } else if (userDecision == SHOW_LIST_OF_PURCHASES.getNumber()) {
                printer.printAListOfPurchases(foodList);
                printer.printAListOfPurchases(clothesList);
                printer.printAListOfPurchases(entertainmentList);
                printer.printAListOfPurchases(otherList);
            } else if (userDecision == BALANCE.getNumber()) {
                double balance = calculator.calculateBalance(income, totalPrice);
                printer.printBalance(balance);
            }
            System.out.println();
        } while (userDecision != 0);
        System.out.println("Bye!");
    }
}