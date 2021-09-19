package pl.glownia.pamela;

enum PurchaseType {
    FOOD(1, "Food"),
    CLOTHES(2, "Clothes"),
    ENTERTAINMENT(3, "Entertainment"),
    OTHER(4, "Other"),
    ALL(5, "All");

    private final int number;
    private final String name;

    PurchaseType(int number, String name) {
        this.number = number;
        this.name = name;
    }

    int getNumber() {
        return number;
    }

    String getName() {
        return name;
    }

    static PurchaseType choosePurchaseType(int userDecision) {
        PurchaseType chosenType = ALL;
        for (PurchaseType type : PurchaseType.values()) {
            if (type.getNumber() == userDecision) {
                chosenType = type;
            }
        }
        return chosenType;
    }
}