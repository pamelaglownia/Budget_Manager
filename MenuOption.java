package pl.glownia.pamela;

enum MenuOption {
    ADD_INCOME(1, "Add income"), ADD_PURCHASE(2, "Add purchase"), SHOW_LIST_OF_PURCHASES(3, "Show list of purchases"), BALANCE(4, "Balance"), SAVE(5, "Save"), LOAD(6, "Load"), ANALYZE(7, "Analyze (sort)"), EXIT(0, "Exit");

    private final int number;
    private final String name;

    MenuOption(int number, String name) {
        this.number = number;
        this.name = name;
    }

    int getNumber() {
        return number;
    }

    String getName() {
        return name;
    }
}