package lotto.view;

import java.util.List;
import lotto.enums.WinningRank;
import lotto.io.InputProvider;
import lotto.io.MessageFormatter;
import lotto.io.OutputProvider;
import lotto.message.PromptMessage;
import lotto.model.Bonus;
import lotto.model.Budget;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningCondition;

public class BaseView implements View {

    InputProvider inputProvider;
    OutputProvider outputProvider;

    public BaseView(InputProvider inputProvider, OutputProvider outputProvider) {
        this.inputProvider = inputProvider;
        this.outputProvider = outputProvider;
    }

    @Override
    public Budget getBudget() {
        show(PromptMessage.BUDGET.getMessage());
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
        show(PromptMessage.LOTTO.getMessage());
        return new Lotto(readIntegers());
    }

    @Override
    public Bonus getBonus() {
        show(PromptMessage.BONUS.getMessage());
        return Bonus.of(readInteger());
    }

    @Override
    public void showLottoQuantity(int quantity) {
        show(MessageFormatter.formatQuantity(quantity));
    }

    @Override
    public void showLottos(Lottos lottos) {
        show(MessageFormatter.formatLottos(lottos));
    }

    @Override
    public void showResult(List<WinningRank> result, float roi) {
        show(MessageFormatter.formatResult(result, roi));
    }

    @Override
    public void show(String message) {
        outputProvider.show(message);
    }

    private Integer readInteger() {
        return inputProvider.readInteger();
    }

    private List<Integer> readIntegers() {
        return inputProvider.readIntegers();
    }

}
