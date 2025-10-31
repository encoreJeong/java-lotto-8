package lotto.view;

import lotto.model.Budget;
import lotto.model.Lotto;

public interface View {
    public Budget getBudget();
    public Lotto getLotto();
    public void show(String message);
}
