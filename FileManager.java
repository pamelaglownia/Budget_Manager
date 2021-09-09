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

    void savePurchasesInTheFile(List<Purchase> listOfAllPurchases) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            for (Purchase element : listOfAllPurchases) {
                fileWriter.write(element.toString() + "\n");
            }
            fileWriter.close();
            System.out.println("Purchases were saved!");
        } catch (IOException e) {
            System.out.printf("An exception occurs %s", e.getMessage());
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
