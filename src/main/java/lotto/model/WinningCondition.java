package lotto.model;

import static lotto.message.ExceptionMessage.DUPLICATED_BONUS;

public class WinningCondition {

    private final Lotto winningNumbers;
    private final Bonus number;

    private WinningCondition(final Lotto winningNumbers, final Bonus number) {
        this.winningNumbers = winningNumbers;
        this.number = number;
    }

    public static WinningCondition of(final Lotto lotto, final Bonus bonus) {
        validate(lotto, bonus);
        return new WinningCondition(lotto, bonus);
    }

    private static void validate(final Lotto lotto, final Bonus bonus) {
        validateNotDup(lotto, bonus);
    }

    private static void validateNotDup(Lotto lotto, Bonus bonus) {
        if(lotto.contains(bonus))
            throw new IllegalArgumentException(DUPLICATED_BONUS.getMessage());
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public Bonus getBonus() {
        return number;
    }

}
