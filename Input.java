package pl.glownia.pamela;

import java.util.Scanner;

public class Input {
    private Scanner scan = new Scanner(System.in);

    String takeAListOfPurchases() {
        System.out.println("Provide list of products with prices. \nWhen you finish, mark end-of-file (Ctrl+D on Linux and Mac or Ctrl+Z on Windows): ");
        StringBuilder listOfPurchases = new StringBuilder();
        while (scan.hasNextLine()) {
            String userInput = scan.nextLine();
            listOfPurchases.append(userInput);
            listOfPurchases.append("\n");
        }
        return listOfPurchases.toString();
    }
}