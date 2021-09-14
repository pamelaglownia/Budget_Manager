package pl.glownia.pamela;

public enum SortingOption {
    ALL_PURCHASES(1, "Sort all purchases"), TYPE(2, "Sort by type"), CERTAIN_TYPE(3, "Sort certain type"), BACK(4, "Back");

    private final int number;
    private final String option;

    SortingOption(int number, String option) {
        this.number = number;
        this.option = option;
    }

    public int getNumber() {
        return number;
    }

    public String getOption() {
        return option;
    }
}