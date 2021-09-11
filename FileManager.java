package pl.glownia.pamela;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

class FileManager {
    private final File file;

    FileManager() {
        this.file = new File("./src/pl/glownia/pamela/purchases.txt");
    }

    void savePurchasesInTheFile(List<Purchase> foodList, List<Purchase> clothesList, List<Purchase> entertainmentList, List<Purchase> otherList, double balance) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(String.format(Locale.US, "Balance: $%.2f \n", balance));
            writePurchaseToFile(fileWriter, foodList, PurchaseType.FOOD.getName());
            writePurchaseToFile(fileWriter, clothesList, PurchaseType.CLOTHES.getName());
            writePurchaseToFile(fileWriter, entertainmentList, PurchaseType.ENTERTAINMENT.getName());
            writePurchaseToFile(fileWriter, otherList, PurchaseType.OTHER.getName());
            fileWriter.close();
            System.out.println("Purchases were saved!");
        } catch (IOException e) {
            System.out.printf("An exception occurs %s", e.getMessage());
        }
    }

    void writePurchaseToFile(FileWriter fileWriter, List<Purchase> purchaseList, String category) throws IOException {
        if (!purchaseList.isEmpty()) {
            for (Purchase element : purchaseList) {
                fileWriter.write(category + ": " + element.toString() + "\n");
            }
        }
    }

    void loadListOfPurchasesFromFile(double balance) {
        List<Purchase> foodList = new ArrayList<>();
        List<Purchase> clothesList = new ArrayList<>();
        List<Purchase> entertainmentList = new ArrayList<>();
        List<Purchase> otherList = new ArrayList<>();
        List<Purchase> listOfAllPurchases = new ArrayList<>();
        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNext()) {
                String[] tempArray = scan.nextLine().split(" ");
                if (tempArray[0].contains("Balance")) {
                    balance = Double.parseDouble(tempArray[1].substring((1)));
                    listOfAllPurchases.add(new Purchase(tempArray[0], balance));
                } else if (tempArray[0].contains("Food")) {
                    foodList.add(new Purchase(tempArray[1], Double.parseDouble(tempArray[2].substring(1))));
                } else if (tempArray[0].contains("Clothes")) {
                    clothesList.add(new Purchase(tempArray[1], Double.parseDouble(tempArray[2].substring(1))));
                } else if (tempArray[0].contains("Entertainment")) {
                    entertainmentList.add(new Purchase(tempArray[1], Double.parseDouble(tempArray[2].substring(1))));
                } else if (tempArray[0].contains("Other")) {
                    otherList.add(new Purchase(tempArray[1], Double.parseDouble(tempArray[2].substring(1))));
                }
            }
            listOfAllPurchases.addAll(foodList);
            listOfAllPurchases.addAll(clothesList);
            listOfAllPurchases.addAll(entertainmentList);
            listOfAllPurchases.addAll(otherList);
            System.out.println("Purchased were loaded!");
        } catch (FileNotFoundException e) {
            System.out.println("File doesn't exist.");
        }
    }
}