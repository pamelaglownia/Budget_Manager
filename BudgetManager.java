package pl.glownia.pamela;

import java.util.ArrayList;
import java.util.List;

import static pl.glownia.pamela.MenuOption.*;

class BudgetManager {
    Printer printer = new Printer();
    Input input = new Input();
    Calculator calculator = new Calculator();
    FileManager fileManager = new FileManager();
    private final List<Purchase> foodList = new ArrayList<>();
    private final List<Purchase> clothesList = new ArrayList<>();
    private final List<Purchase> entertainmentList = new ArrayList<>();
    private final List<Purchase> otherList = new ArrayList<>();
    private final List<Purchase> listOfAllPurchases = new ArrayList<>();

    void run() {
        int userDecision;
        double income = 0, totalPrice = 0, balance = 0;
        do {
            printer.printMenu();
            userDecision = input.takeUserDecision(EXIT.getNumber(), LOAD.getNumber());
            System.out.println();
            if (userDecision == ADD_INCOME.getNumber()) {
                income += calculator.addIncome();
                balance = calculator.calculateBalance(income, totalPrice);
            } else if (userDecision == ADD_PURCHASE.getNumber()) {
                calculator.addPurchaseRelatedToCategory(foodList, clothesList, entertainmentList, otherList, listOfAllPurchases);
                totalPrice = calculator.calculatePrice(listOfAllPurchases);
                balance = calculator.calculateBalance(income, totalPrice);
            } else if (userDecision == SHOW_LIST_OF_PURCHASES.getNumber()) {
                calculator.showListOfPurchases(foodList, clothesList, entertainmentList, otherList, listOfAllPurchases, totalPrice);
            } else if (userDecision == BALANCE.getNumber()) {
                printer.printBalance(balance);
            } else if (userDecision == SAVE.getNumber()) {
                fileManager.savePurchasesInTheFile(foodList, clothesList, entertainmentList, otherList, balance);
            } else if (userDecision == LOAD.getNumber()) {
                fileManager.loadListOfPurchasesFromFile(foodList, clothesList, entertainmentList, otherList, listOfAllPurchases);
                totalPrice = calculator.calculatePrice(listOfAllPurchases);
                balance = fileManager.loadBalanceFromAFile();
            }
            System.out.println();
        } while (userDecision != EXIT.getNumber());
        System.out.println("Bye!");
    }
}