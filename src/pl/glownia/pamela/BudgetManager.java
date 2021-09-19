package pl.glownia.pamela;

import java.util.ArrayList;
import java.util.List;

class BudgetManager {
    private final Printer printer = new Printer();
    private final Input input = new Input();
    private final ListManager listManager = new ListManager();

    void run() {
        FileManager fileManager = new FileManager();
        List<Purchase> listOfPurchases = new ArrayList<>();
        int userDecision;
        double income = 0, totalPrice = 0, balance = 0;
        do {
            printer.printMenu();
            userDecision = input.takeUserDecision(0, 7);
            int option = MenuOption.checkUserDecision(userDecision);
            System.out.println();
            switch (option) {
                case 1:
                    income += listManager.addIncome();
                    balance = listManager.calculateBalance(income, totalPrice);
                    break;
                case 2:
                    listManager.addPurchaseRelatedToCategory(listOfPurchases);
                    totalPrice = listManager.calculatePrice(listOfPurchases);
                    balance -= totalPrice;
                    break;
                case 3:
                    listManager.showListOfPurchases(listOfPurchases);
                    break;
                case 4:
                    printer.printBalance(balance);
                    break;
                case 5:
                    fileManager.savePurchasesInTheFile(listOfPurchases, balance);
                    break;
                case 6:
                    fileManager.loadListOfPurchasesFromFile(listOfPurchases);
                    balance = fileManager.loadBalanceFromAFile();
                    break;
                case 7:
                    Sorter sorter = new Sorter();
                    sorter.sort(listOfPurchases);
            }
            System.out.println();
        } while (userDecision != 0);
        System.out.println("Bye!");
    }
}