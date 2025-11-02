package lotto.view.input.decorator;

import lotto.model.Bonus;
import lotto.model.Budget;
import lotto.model.Lotto;
import lotto.model.WinningCondition;
import lotto.view.input.InputView;

public class ExceptionHandlingInputView implements InputView {

    private final InputView delegate;
    private final InputExceptionHandler exceptionHandler;

    public ExceptionHandlingInputView(InputView delegate, InputExceptionHandler exceptionHandler) {
        this.delegate = delegate;
        this.exceptionHandler = exceptionHandler;
    }

    @Override
    public Budget getBudget() {
        while (true) {
            try {
                return delegate.getBudget();
            } catch (IllegalArgumentException e) {
                exceptionHandler.handle(e);
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
                exceptionHandler.handle(e);
            }
        }
    }

    @Override
    public Lotto getLotto() {
        while (true) {
            try {
                return delegate.getLotto();
            } catch (IllegalArgumentException e) {
                exceptionHandler.handle(e);
            }
        }
    }

    @Override
    public Bonus getBonus() {
        while (true) {
            try {
                return delegate.getBonus();
            } catch (IllegalArgumentException e) {
                exceptionHandler.handle(e);
            }
        }
    }

}
