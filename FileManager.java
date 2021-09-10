package pl.glownia.pamela;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

class FileManager {
    private final File file;

    FileManager() {
        this.file = new File("./src/pl/glownia/pamela/purchases.txt");
    }

    void savePurchasesInTheFile(List<Purchase> foodList, List<Purchase> clothesList, List<Purchase> entertainmentList, List<Purchase> otherList, double balance) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(String.format("Balance: $ %.2f \n", balance));
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

    void readListOfPurchasesFromFile() {
        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNext()) {
                System.out.println(scan.nextLine() + " ");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File doesn't exist.");
        }
    }
}
