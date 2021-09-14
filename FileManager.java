package pl.glownia.pamela;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

class FileManager {
    private final File file;

    FileManager() {
        this.file = new File("./src/pl/glownia/pamela/purchases.txt");
    }

    void savePurchasesInTheFile(List<Purchase> foodList, List<Purchase> clothesList, List<Purchase> entertainmentList, List<Purchase> otherList, double balance) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(String.format(Locale.US, "Balance:$%.2f \n", balance));
            writePurchaseToFile(fileWriter, foodList, PurchaseType.FOOD.getName());
            writePurchaseToFile(fileWriter, clothesList, PurchaseType.CLOTHES.getName());
            writePurchaseToFile(fileWriter, entertainmentList, PurchaseType.ENTERTAINMENT.getName());
            writePurchaseToFile(fileWriter, otherList, PurchaseType.OTHER.getName());
            System.out.println("Purchases were saved!");
        } catch (IOException e) {
            System.out.printf("An exception occurs %s", e.getMessage());
        }
    }

    private void writePurchaseToFile(FileWriter fileWriter, List<Purchase> purchaseList, String category) throws IOException {
        if (!purchaseList.isEmpty()) {
            for (Purchase element : purchaseList) {
                fileWriter.write(category + ":" + element.toString() + "\n");
            }
        }
    }

    void loadListOfPurchasesFromFile(List<Purchase> foodList, List<Purchase> clothesList, List<Purchase> entertainmentList, List<Purchase> otherList, List<Purchase> listOfAllPurchases) {
        clearAllLists(foodList, clothesList, entertainmentList, otherList, listOfAllPurchases);
        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String purchaseName = line.substring(line.indexOf(":") + 1, line.lastIndexOf("$")).trim();
                double purchasePrice = Double.parseDouble(line.substring(line.lastIndexOf("$") + 1));
                if (line.contains("Food")) {
                    foodList.add(new Purchase(purchaseName, purchasePrice));
                }
                if (line.contains("Clothes")) {
                    clothesList.add(new Purchase(purchaseName, purchasePrice));
                }
                if (line.contains("Entertainment")) {
                    entertainmentList.add(new Purchase(purchaseName, purchasePrice));

                }
                if (line.contains("Other")) {
                    otherList.add(new Purchase(purchaseName, purchasePrice));
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

    double loadBalanceFromAFile() {
        double balance = 0;
        try (Scanner scan = new Scanner(file)) {
            String line = scan.nextLine();
            if (line.contains("Balance")) {
                balance = Double.parseDouble(line.substring(line.lastIndexOf("$") + 1));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File doesn't exist.");
        }
        return balance;
    }

    private void clearAllLists(List<Purchase> foodList, List<Purchase> clothesList, List<Purchase> entertainmentList, List<Purchase> otherList, List<Purchase> listOfAllPurchases) {
        foodList.clear();
        clothesList.clear();
        entertainmentList.clear();
        otherList.clear();
        listOfAllPurchases.clear();
    }
}