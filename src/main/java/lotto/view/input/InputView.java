package lotto.view.input;

import lotto.model.Bonus;
import lotto.model.Budget;
import lotto.model.Lotto;
import lotto.model.WinningCondition;

public interface InputView {

    Budget getBudget();
    WinningCondition getWinningCondition();

    Lotto getLotto();
    Bonus getBonus();

}
