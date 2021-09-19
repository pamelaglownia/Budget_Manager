package pl.glownia.pamela;

enum SortingOption {
    ALL_PURCHASES(1, "Sort all purchases"),
    TYPE(2, "Sort by type"),
    CERTAIN_TYPE(3, "Sort certain type"),
    BACK(4, "Back");

    private final int number;
    private final String option;

    SortingOption(int number, String option) {
        this.number = number;
        this.option = option;
    }

    int getNumber() {
        return number;
    }

    String getOption() {
        return option;
    }

    static int checkUserDecision(int userDecision) {
        int decision = 4;
        for (SortingOption option : SortingOption.values()) {
            if (option.getNumber() == userDecision) {
                decision = option.getNumber();
            }
        }
        return decision;
    }
}