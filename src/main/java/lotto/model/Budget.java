package lotto.model;

import lotto.enums.LottoRule;
import lotto.message.ExceptionMessage;

public class Budget {

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
        if(calculateAffordableLottoQuantity(budget) < LottoRule.MIN_PURCHASE_QUANTITY.value) {
            throw new IllegalArgumentException(ExceptionMessage.BUDGET_INSUFFICIENT.getMessage());
        }
    }

    private static void validateNoRemainder(int budget) {
        if(budget % LottoRule.LOTTO_PRICE.value != 0) {
            throw new IllegalArgumentException(ExceptionMessage.REMAINDER_EXIST.getMessage());
        }
    }

    private static int calculateAffordableLottoQuantity(int budget) {
        return budget / LottoRule.LOTTO_PRICE.value;
    }

    public int getAffordableLottoQuantity() {
        return budget / LottoRule.LOTTO_PRICE.value;
    }


    public int getInt() {
        return budget;
    }

}
