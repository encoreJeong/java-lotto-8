package lotto.view;

import lotto.model.Budget;
import lotto.model.Lotto;

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
    public void show(String message) {
        delegate.show(message);
    }
}
