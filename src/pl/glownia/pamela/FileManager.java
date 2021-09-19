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

    void savePurchasesInTheFile(List<Purchase> listOfPurchases, double balance) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(String.format(Locale.US, "Balance:$%.2f \n", balance));
            writePurchaseToFile(fileWriter, listOfPurchases);
            System.out.println("Purchases were saved!");
        } catch (IOException e) {
            System.out.printf("An exception occurs %s", e.getMessage());
        }
    }

    private void writePurchaseToFile(FileWriter fileWriter, List<Purchase> listOfPurchases) throws IOException {
        if (!listOfPurchases.isEmpty()) {
            for (Purchase purchase : listOfPurchases) {
                fileWriter.write(purchase.getPurchaseType().getName() + ":" + purchase + "\n");
            }
        }
    }

    void loadListOfPurchasesFromFile(List<Purchase> listOfPurchases) {
        listOfPurchases.clear();
        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                for (PurchaseType type : PurchaseType.values()) {
                    if (type.getName().equals(line.substring(0, line.indexOf(":")))) {
                        String productName = line.substring(line.indexOf(":") + 1, line.lastIndexOf("$")).trim();
                        double productPrice = Double.parseDouble(line.substring(line.lastIndexOf("$") + 1));
                        Purchase purchase = new Purchase(type, productName, productPrice);
                        listOfPurchases.add(purchase);
                    }
                }
            }
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
}