package pl.glownia.pamela;

public enum MenuOption {
    ADD_INCOME(1, "Add income"), ADD_PURCHASE(2, "Add purchase"), SHOW_LIST_OF_PURCHASES(3, "Show list of purchases"), BALANCE(4, "Balance"), SAVE(5, "Save"), LOAD(6, "Load"), EXIT(0, "Exit");

    private final int number;
    private final String name;

    MenuOption(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
