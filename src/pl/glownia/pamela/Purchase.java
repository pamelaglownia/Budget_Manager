package pl.glownia.pamela;

import java.text.NumberFormat;
import java.util.Locale;

class Purchase {
    private final PurchaseType purchaseType;
    private final String productName;
    private final double productPrice;

    public Purchase(PurchaseType purchaseType, String productName, double productPrice) {
        this.purchaseType = purchaseType;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    double getProductPrice() {
        return productPrice;
    }

    PurchaseType getPurchaseType() {
        return purchaseType;
    }

    @Override
    public String toString() {
        NumberFormat dollar = NumberFormat.getCurrencyInstance(Locale.US);
        return productName + " " + dollar.format(productPrice);
    }
}