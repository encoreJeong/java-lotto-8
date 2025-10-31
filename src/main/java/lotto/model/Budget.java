package lotto.model;

import lotto.message.ExceptionMessage;

public class Budget {

    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_PURCHASE_QUANTITY = 1;

    private final int budget;

    private Budget(final int budget) {
        this.budget = budget;
    }

    public static Budget of(final int budget) {
        validateBudget(budget);
        return new Budget(budget);
    }

    private static void validateBudget(final int budget) {
        validateAffordable(budget);
        validateNoRemainder(budget);
    }

    private static void validateAffordable(int budget) {
        if(getAffordableLottoQuantity(budget) < MIN_PURCHASE_QUANTITY) {
            throw new IllegalArgumentException(ExceptionMessage.BUDGET_INSUFFICIENT.getMessage());
        }
    }

    private static void validateNoRemainder(int budget) {
        if(budget % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.REMAINDER_EXIST.getMessage());
        }
    }

    private static int getAffordableLottoQuantity(int budget) {
        return budget / LOTTO_PRICE;
    }

    public int getInt() {
        return budget;
    }

}
