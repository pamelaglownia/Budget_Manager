package pl.glownia.pamela;

import java.text.NumberFormat;
import java.util.Locale;

class Purchase {
    private final String productName;
    private final double productPrice;

    Purchase(String productName, double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    double getProductPrice() {
        return productPrice;
    }

    @Override
    public String toString() {
        NumberFormat dollar = NumberFormat.getCurrencyInstance(Locale.US);
        return productName + " " + dollar.format(productPrice);
    }
}