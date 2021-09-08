package pl.glownia.pamela;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

class FileManager {
    private final File file;

    FileManager() {
        this.file = new File("./src/pl/glownia/pamela/purchases.txt");
    }

    void savePurchasesInTheFile(List<Purchase> listOfAllPurchases) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        for (Purchase element : listOfAllPurchases) {
            fileWriter.write(element.toString() + "\n");
        }
        fileWriter.close();
        System.out.println("Purchases were saved!");
    }
}
