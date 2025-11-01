package lotto.view;

import lotto.model.Bonus;
import lotto.model.Budget;
import lotto.model.Lotto;
import lotto.model.WinningCondition;

public class ExceptionHandlingView implements View {

    private final View delegate;

    public ExceptionHandlingView(View delegate) {
        this.delegate = delegate;
    }

    @Override
    public Budget getBudget() {
        while (true) {
            try {
                return delegate.getBudget();
            } catch (IllegalArgumentException e) {
                show(e.getMessage());
            }
        }
    }

    @Override
    public WinningCondition getWinningCondition() {

        Lotto winningNumbers = getLotto();

        while (true) {
            try {
                Bonus number =  getBonus();
                return WinningCondition.of(winningNumbers, number);
            } catch (IllegalArgumentException e) {
                show(e.getMessage());
            }
        }
    }

    @Override
    public Lotto getLotto() {
        while (true) {
            try {
                return delegate.getLotto();
            } catch (IllegalArgumentException e) {
                show(e.getMessage());
            }
        }
    }

    @Override
    public Bonus getBonus() {
        while (true) {
            try {
                return delegate.getBonus();
            } catch (IllegalArgumentException e) {
                show(e.getMessage());
            }
        }
    }

    @Override
    public void show(String message) {
        delegate.show(message);
    }
}
