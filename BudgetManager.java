package pl.glownia.pamela;

import java.util.ArrayList;
import java.util.List;

import static pl.glownia.pamela.MenuOption.*;

class BudgetManager {
    private final Printer printer = new Printer();
    private final Input input = new Input();
    private final Calculator calculator = new Calculator();
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
            userDecision = input.takeUserDecision(0, 7);
            System.out.println();
            if (userDecision == ADD_INCOME.getNumber()) {
                income += calculator.addIncome();
                balance = calculator.calculateBalance(income, totalPrice);
            } else if (userDecision == ADD_PURCHASE.getNumber()) {
                calculator.addPurchaseRelatedToCategory(foodList, clothesList, entertainmentList, otherList, listOfAllPurchases);
                totalPrice = calculator.calculatePrice(listOfAllPurchases);
                balance = calculator.calculateBalance(income, totalPrice);
            } else if (userDecision == SHOW_LIST_OF_PURCHASES.getNumber()) {
                calculator.showListOfPurchases(foodList, clothesList, entertainmentList, otherList, listOfAllPurchases);
            } else if (userDecision == BALANCE.getNumber()) {
                printer.printBalance(balance);
            } else if (userDecision == SAVE.getNumber()) {
                FileManager fileManager = new FileManager();
                fileManager.savePurchasesInTheFile(foodList, clothesList, entertainmentList, otherList, balance);
            } else if (userDecision == LOAD.getNumber()) {
                FileManager fileManager = new FileManager();
                fileManager.loadListOfPurchasesFromFile(foodList, clothesList, entertainmentList, otherList, listOfAllPurchases);
                totalPrice = calculator.calculatePrice(listOfAllPurchases);
                balance = fileManager.loadBalanceFromAFile();
            } else if (userDecision == ANALYZE.getNumber()) {
                Sorter sorter = new Sorter();
                sorter.sort(foodList, clothesList, entertainmentList, otherList, listOfAllPurchases);
            }
            System.out.println();
        } while (userDecision != EXIT.getNumber());
        System.out.println("Bye!");
    }
}