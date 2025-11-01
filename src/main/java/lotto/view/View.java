package lotto.view;

import lotto.model.Bonus;
import lotto.model.Budget;
import lotto.model.Lotto;
import lotto.model.WinningCondition;

public interface View {
    public Budget getBudget();
    public WinningCondition getWinningCondition();
    public void show(String message);

    public Lotto getLotto();
    public Bonus getBonus();
}
