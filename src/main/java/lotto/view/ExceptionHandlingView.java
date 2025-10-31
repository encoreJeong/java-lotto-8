package lotto.view;

import lotto.model.Budget;

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
                continue;
            }
        }
    }

    @Override
    public void show(String message) {
        delegate.show(message);
    }
}
