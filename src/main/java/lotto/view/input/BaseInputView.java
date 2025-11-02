package lotto.view.input;

import java.util.List;
import lotto.io.InputProvider;
import lotto.message.PromptMessage;
import lotto.model.Bonus;
import lotto.model.Budget;
import lotto.model.Lotto;
import lotto.model.WinningCondition;

public class BaseInputView implements InputView {

    InputProvider inputProvider;

    public BaseInputView(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    @Override
    public Budget getBudget() {
        return Budget.of(readInteger());
    }

    @Override
    public WinningCondition getWinningCondition() {
        Lotto winningNumbers = getLotto();
        Bonus bonus = getBonus();
        return WinningCondition.of(winningNumbers, bonus);
    }

    @Override
    public Lotto getLotto() {
        return new Lotto(readIntegers());
    }

    @Override
    public Bonus getBonus() {
        return Bonus.of(readInteger());
    }

    private Integer readInteger() {
        return inputProvider.readInteger();
    }

    private List<Integer> readIntegers() {
        return inputProvider.readIntegers();
    }

}
