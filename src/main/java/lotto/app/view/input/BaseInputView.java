package lotto.app.view.input;

import java.util.List;
import lotto.app.io.InputProvider;
import lotto.app.model.Bonus;
import lotto.app.model.Budget;
import lotto.app.model.Lotto;
import lotto.app.model.Lottos;
import lotto.app.model.WinningCondition;

public class BaseInputView implements InputView {

    InputProvider inputProvider;

    public BaseInputView(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    @Override
    public Budget getBudget(String value) {
        return Budget.of(readInteger(value));
    }

    @Override
    public WinningCondition getWinningCondition(String rawWinningNumbers, String rawBonus) {
        Lotto winningNumbers = getLotto(rawWinningNumbers);
        Bonus bonus = getBonus(rawBonus);
        return WinningCondition.of(winningNumbers, bonus);
    }

    @Override
    public Lotto getLotto(String winningNumbers) {
        return new Lotto(readIntegers(winningNumbers));
    }

    @Override
    public Bonus getBonus(String bonus) {
        return Bonus.of(readInteger(bonus));
    }

    @Override
    public Lottos getLottos(List<String> strings) {
        return Lottos.of(strings.stream().map(this::getLotto).toList());
    }

    private Integer readInteger(String value) {
        return inputProvider.readInteger(value);
    }

    private List<Integer> readIntegers(String values) {
        return inputProvider.readIntegers(values);
    }

}
