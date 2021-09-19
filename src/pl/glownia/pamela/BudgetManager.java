package pl.glownia.pamela;

import java.util.ArrayList;
import java.util.List;

import static pl.glownia.pamela.MenuOption.*;

class BudgetManager {
    private final Printer printer = new Printer();
    private final Input input = new Input();
    private final ListManager listManager = new ListManager();

    void run() {
        List<Purchase> listOfPurchases = new ArrayList<>();
        int userDecision;
        double income = 0, totalPrice = 0, balance = 0;
        do {
            printer.printMenu();
            userDecision = input.takeUserDecision(0, 7);
            System.out.println();
            if (userDecision == ADD_INCOME.getNumber()) {
                income += listManager.addIncome();
                balance = listManager.calculateBalance(income, totalPrice);
            } else if (userDecision == ADD_PURCHASE.getNumber()) {
                listManager.addPurchaseRelatedToCategory(listOfPurchases);
                totalPrice = listManager.calculatePrice(listOfPurchases);
                balance -= totalPrice;
            } else if (userDecision == SHOW_LIST_OF_PURCHASES.getNumber()) {
                listManager.showListOfPurchases(listOfPurchases);
            } else if (userDecision == BALANCE.getNumber()) {
                printer.printBalance(balance);
            } else if (userDecision == SAVE.getNumber()) {
                FileManager fileManager = new FileManager();
                fileManager.savePurchasesInTheFile(listOfPurchases, balance);
            } else if (userDecision == LOAD.getNumber()) {
                FileManager fileManager = new FileManager();
                fileManager.loadListOfPurchasesFromFile(listOfPurchases);
                balance = fileManager.loadBalanceFromAFile();
            } else if (userDecision == ANALYZE.getNumber()) {
                Sorter sorter = new Sorter();
                sorter.sort(listOfPurchases);
            }
            System.out.println();
        } while (userDecision != EXIT.getNumber());
        System.out.println("Bye!");
    }
}