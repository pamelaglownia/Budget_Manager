package pl.glownia.pamela;

import java.util.ArrayList;
import java.util.List;

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
            switch (userDecision) {
                case 1:
                    income += calculator.addIncome();
                    break;
                case 2:
                    totalPrice = calculator.addPurchaseRelatedToCategory(foodList, clothesList, entertainmentList, otherList, totalPrice);
                    break;
                case 3:
                    printer.printAListOfPurchases(foodList);
                    printer.printAListOfPurchases(clothesList);
                    printer.printAListOfPurchases(entertainmentList);
                    printer.printAListOfPurchases(otherList);
                    printer.printTotalPrice(totalPrice);
                    break;
                case 4:
                    double balance = calculator.calculateBalance(income, totalPrice);
                    printer.printBalance(balance);
                    break;
            }
            System.out.println();
        } while (userDecision != 0);
        System.out.println("Bye!");
    }
}