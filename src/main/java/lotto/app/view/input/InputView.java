package lotto.app.view.input;

import java.util.List;
import lotto.app.model.Bonus;
import lotto.app.model.Budget;
import lotto.app.model.Lotto;
import lotto.app.model.Lottos;
import lotto.app.model.WinningCondition;

public interface InputView {

    Budget getBudget(String value);
    WinningCondition getWinningCondition(String winningNumbers, String bonus);

    Lotto getLotto(String value);
    Bonus getBonus(String value);

    Lottos getLottos(List<String> strings);
}
