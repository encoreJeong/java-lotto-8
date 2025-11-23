package lotto.app.view.input.decorator;

import java.util.List;
import lotto.app.message.PromptMessage;
import lotto.app.model.Bonus;
import lotto.app.model.Budget;
import lotto.app.model.Lotto;
import lotto.app.model.Lottos;
import lotto.app.model.WinningCondition;
import lotto.app.view.input.InputView;

public class ShowingPromptInputView implements InputView {

    private final InputView delegate;
    private final InputPromptHandler inputPromptHandler;

    public ShowingPromptInputView(InputView delegate,  InputPromptHandler inputPromptHandler) {
        this.delegate = delegate;
        this.inputPromptHandler = inputPromptHandler;
    }

    @Override
    public Budget getBudget(String rawBonus) {
        inputPromptHandler.showPrompt(PromptMessage.BUDGET.getMessage());
        return delegate.getBudget(rawBonus);
    }

    @Override
    public WinningCondition getWinningCondition(String winningNumbers, String bonus) {
        return delegate.getWinningCondition(winningNumbers, bonus);
    }

    @Override
    public Lotto getLotto(String value) {
        inputPromptHandler.showPrompt(PromptMessage.LOTTO.getMessage());
        return delegate.getLotto(value);
    }

    @Override
    public Bonus getBonus(String value) {
        inputPromptHandler.showPrompt(PromptMessage.BONUS.getMessage());
        return delegate.getBonus(value);
    }

    @Override
    public Lottos getLottos(List<String> strings) {
        inputPromptHandler.showPrompt(PromptMessage.LOTTO.getMessage());
        return delegate.getLottos(strings);
    }
}
