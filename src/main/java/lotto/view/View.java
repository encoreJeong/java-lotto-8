package lotto.view;

import lotto.model.Budget;

public interface View {
    public Budget getBudget();
    public void show(String message);
}
