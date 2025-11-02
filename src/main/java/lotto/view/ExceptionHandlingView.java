package lotto.view;

import java.util.List;
import lotto.enums.WinningRank;
import lotto.model.Bonus;
import lotto.model.Budget;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningCondition;

public class ExceptionHandlingView implements View {

    private final View delegate;

    public ExceptionHandlingView(View delegate) {
        this.delegate = delegate;
    }

    @Override
    public Budget getBudget() {
        while (true) {
            try {
                return delegate.getBudget();
            } catch (IllegalArgumentException e) {
                show(e.getMessage());
            }
        }
    }

    @Override
    public WinningCondition getWinningCondition() {

        Lotto winningNumbers = getLotto();

        while (true) {
            try {
                Bonus number =  getBonus();
                return WinningCondition.of(winningNumbers, number);
            } catch (IllegalArgumentException e) {
                show(e.getMessage());
            }
        }
    }

    @Override
    public void showLottoQuantity(int quantity) {
        delegate.showLottoQuantity(quantity);
    }

    @Override
    public void showLottos(Lottos lottos) {
        delegate.showLottos(lottos);
    }

    @Override
    public void showResult(List<WinningRank> result, float roi) {
        delegate.showResult(result, roi);
    }

    @Override
    public Lotto getLotto() {
        while (true) {
            try {
                return delegate.getLotto();
            } catch (IllegalArgumentException e) {
                show(e.getMessage());
            }
        }
    }

    @Override
    public Bonus getBonus() {
        while (true) {
            try {
                return delegate.getBonus();
            } catch (IllegalArgumentException e) {
                show(e.getMessage());
            }
        }
    }

    @Override
    public void show(String message) {
        delegate.show(message);
    }
}
