package pl.glownia.pamela;

public class Menu {
    Printer printer = new Printer();
    Input input = new Input();

    void chooseOption() {
        int userDecision;
        double income = 0;
        do {
            printer.printMenu();
            userDecision = input.takeUserDecision();
            switch (userDecision) {
                case 1:
                    income += input.enterIncome();
                    //validate if income is added
                    System.out.println(income);
                    break;
                case 2:
                    System.out.println("Adding purchase...\n***");
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
