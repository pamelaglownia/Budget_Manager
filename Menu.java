package pl.glownia.pamela;

import java.util.ArrayList;

public class Menu {
    Printer printer = new Printer();
    Input input = new Input();
    Calculator calculator = new Calculator();

    void chooseOption() {
        ArrayList<String> listOfPurchases = new ArrayList<>();
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
                    calculator.addPurchaseToTheList(listOfPurchases);
                    break;
                case 3:
                    totalPrice = calculator.calculateTotalPrice(listOfPurchases);
                    printer.printAListOfPurchases(listOfPurchases,totalPrice);
                    break;
                case 4:
                    calculator.calculateBalance(income,totalPrice);
                    break;
            }
            System.out.println();
        } while (userDecision != 0);
        System.out.println("Bye!");
    }
}
