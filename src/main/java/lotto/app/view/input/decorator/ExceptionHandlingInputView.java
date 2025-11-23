package lotto.app.view.input.decorator;

import java.util.List;
import lotto.app.model.Bonus;
import lotto.app.model.Budget;
import lotto.app.model.Lotto;
import lotto.app.model.Lottos;
import lotto.app.model.WinningCondition;
import lotto.app.view.input.InputView;

public class ExceptionHandlingInputView implements InputView {

    private final InputView delegate;
    private final InputExceptionHandler exceptionHandler;

    public ExceptionHandlingInputView(InputView delegate, InputExceptionHandler exceptionHandler) {
        this.delegate = delegate;
        this.exceptionHandler = exceptionHandler;
    }

    @Override
    public Budget getBudget(String value) {
        try {
            return delegate.getBudget(value);
        } catch (IllegalArgumentException e) {
            exceptionHandler.handle(e);
            return null;
        }
    }

    @Override
    public WinningCondition getWinningCondition(String rawWinningNumbers, String bonus) {

        Lotto winningNumbers = getLotto(rawWinningNumbers);

        try {
            Bonus number =  getBonus(bonus);
            return WinningCondition.of(winningNumbers, number);
        } catch (IllegalArgumentException e) {
            exceptionHandler.handle(e);
            return null;
        }
    }

    @Override
    public Lotto getLotto(String value) {
        try {
            return delegate.getLotto(value);
        } catch (IllegalArgumentException e) {
            exceptionHandler.handle(e);
            return null;
        }
    }

    @Override
    public Bonus getBonus(String value) {
        try {
            return delegate.getBonus(value);
        } catch (IllegalArgumentException e) {
            exceptionHandler.handle(e);
            return null;
        }
    }

    @Override
    public Lottos getLottos(List<String> strings) {
        try {
            return delegate.getLottos(strings);
        } catch (IllegalArgumentException e) {
            exceptionHandler.handle(e);
            return null;
        }
    }
}
