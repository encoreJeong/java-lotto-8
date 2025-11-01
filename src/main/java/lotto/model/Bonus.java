package lotto.model;

import lotto.message.ExceptionMessage;

public class Bonus {

    private static final int MIN = 1;
    private static final int MAX = 45;

    private final int number;

    private Bonus(int number) {
        this.number = number;
    }

    public static Bonus of(final int bonus) {
        validate(bonus);
        return new Bonus(bonus);
    }

    private static void validate(int bonus) {
        validateBetween(MIN, MAX, bonus);
    }

    private static void validateBetween(int min, int max, int bonus) {
        if(bonus < min || bonus > max)
            throw new IllegalArgumentException(ExceptionMessage.NOT_A_BONUS.getMessage());
    }

    public int getNumber() {
        return number;
    }

}
