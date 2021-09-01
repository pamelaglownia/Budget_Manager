package pl.glownia.pamela;

import java.util.ArrayList;

public class Menu {
    Printer printer = new Printer();
    Input input = new Input();
    Calculator calculator = new Calculator();

    void chooseOption() {
        ArrayList<String> listOfPurchases = new ArrayList<>();
        int userDecision;
        double income = 0;
        do {
            printer.printMenu();
            userDecision = input.takeUserDecision();
            switch (userDecision) {
                case 1:
                    income += calculator.addIncome();
                    break;
                case 2:
                    calculator.addPurchaseToTheList(listOfPurchases);
                    break;
                case 3:
                    System.out.println("Showing list of purchases\n***");
                    break;
                case 4:
                    System.out.println("Showing balance\n***");
                    break;
            }
        } while (userDecision != 0);
        System.out.println("Bye!");
    }
}
