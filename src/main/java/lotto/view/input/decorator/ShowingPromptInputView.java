package lotto.view.input.decorator;

import lotto.message.PromptMessage;
import lotto.model.Bonus;
import lotto.model.Budget;
import lotto.model.Lotto;
import lotto.model.WinningCondition;
import lotto.view.input.InputView;

public class ShowingPromptInputView implements InputView {

    private final InputView delegate;
    private final InputPromptHandler inputPromptHandler;

    public ShowingPromptInputView(InputView delegate,  InputPromptHandler inputPromptHandler) {
        this.delegate = delegate;
        this.inputPromptHandler = inputPromptHandler;
    }

    @Override
    public Budget getBudget() {
        inputPromptHandler.showPrompt(PromptMessage.BUDGET.getMessage());
        return delegate.getBudget();
    }

    @Override
    public WinningCondition getWinningCondition() {
        return delegate.getWinningCondition();
    }

    @Override
    public Lotto getLotto() {
        inputPromptHandler.showPrompt(PromptMessage.LOTTO.getMessage());
        return delegate.getLotto();
    }

    @Override
    public Bonus getBonus() {
        inputPromptHandler.showPrompt(PromptMessage.BONUS.getMessage());
        return delegate.getBonus();
    }
}
