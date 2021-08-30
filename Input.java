package pl.glownia.pamela;

import java.util.ArrayList;
import java.util.Scanner;

public class Input {
    private final Scanner scan = new Scanner(System.in);

    ArrayList<String> takeAListOfPurchases() {
        System.out.println("Provide list of products with prices. \nWhen you finish, mark end-of-file (Ctrl+D on Linux and Mac or Ctrl+Z on Windows): ");
        ArrayList<String> listOfPurchases = new ArrayList<>();
        while (scan.hasNextLine()) {
            String userInput = scan.nextLine();
            listOfPurchases.add(userInput);
        }
        return listOfPurchases;
    }
}