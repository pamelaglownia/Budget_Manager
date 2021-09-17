package pl.glownia.pamela;

import java.text.NumberFormat;
import java.util.Locale;

class Purchase {
    private PurchaseType purchaseType;
    private String productName;
    private double productPrice;

    double getProductPrice() {
        return productPrice;
    }

    PurchaseType getPurchaseType() {
        return purchaseType;
    }

    void setPurchaseType(PurchaseType purchaseType) {
        this.purchaseType = purchaseType;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        NumberFormat dollar = NumberFormat.getCurrencyInstance(Locale.US);
        return productName + " " + dollar.format(productPrice);
    }
}