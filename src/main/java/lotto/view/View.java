package lotto.view;

import java.util.List;
import lotto.enums.WinningRank;
import lotto.model.Bonus;
import lotto.model.Budget;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningCondition;

public interface View {
    Budget getBudget();
    WinningCondition getWinningCondition();

    void showLottoQuantity(int quantity);
    void showLottos(Lottos lottos);
    void showResult(List<WinningRank> result, float roi);

    void show(String message);

    Lotto getLotto();
    Bonus getBonus();

}
