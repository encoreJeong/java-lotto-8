package lotto.app.model;

import lotto.app.enums.LottoRule;
import lotto.app.message.ExceptionMessage;

public class Bonus {

    private final int number;

    private Bonus(int number) {
        this.number = number;
    }

    public static Bonus of(final int bonus) {
        validate(bonus);
        return new Bonus(bonus);
    }

    private static void validate(int bonus) {
        validateBetween(LottoRule.MIN_NUMBER, LottoRule.MAX_NUMBER, bonus);
    }

    private static void validateBetween(LottoRule min, LottoRule max, int bonus) {
        if(bonus < min.value || bonus > max.value)
            throw new IllegalArgumentException(ExceptionMessage.NOT_A_BONUS.getMessage());
    }

    public int getNumber() {
        return number;
    }

}
