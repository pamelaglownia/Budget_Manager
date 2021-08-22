package pl.glownia.pamela;

public class Calculator {
    private Input input = new Input();

    double calculatePurchases(String list) {
        double count = 0.00;
        String numberOnly = list.replaceAll("[a-zA-Z]", "");
        String[] array = numberOnly.split("\\$");
        for (int i = 0; i < array.length; i++) {
            if (array[i].substring(0, 1).matches("[0-9]")) {
                for (int j = 0; j < array[i].length() - 2; j++) {
                    if (array[i].charAt(j) == '.') {
                        String priceOfProduct = array[i].substring(0, j + 3);
                        count += Double.parseDouble(priceOfProduct);
                    }
                }
            }
        }
        return count;
    }
}