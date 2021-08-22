package pl.glownia.pamela;

public class Printer {
    private Input input = new Input();

    void run() {
        String list = input.takeAListOfPurchases();
        printAListOfPurchases(list);
    }

    void printAListOfPurchases(String list) {
        System.out.println("List of your purchases:");
        System.out.println(list);
    }
}
