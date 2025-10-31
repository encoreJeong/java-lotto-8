package lotto.view;

import java.util.List;
import lotto.io.InputProvider;
import lotto.io.OutputProvider;
import lotto.message.PromptMessage;
import lotto.model.Budget;
import lotto.model.Lotto;

public class BaseView implements View {

    InputProvider inputProvider;
    OutputProvider outputProvider;

    public BaseView(InputProvider inputProvider, OutputProvider outputProvider) {
        this.inputProvider = inputProvider;
        this.outputProvider = outputProvider;
    }

    @Override
    public Budget getBudget() {
        show(PromptMessage.BUDGET.getMessage());
        return Budget.of(readInteger());
    }

    @Override
    public Lotto getLotto() {
        show(PromptMessage.LOTTO.getMessage());
        return new Lotto(readIntegers());
    }

    @Override
    public void show(String message) {
        outputProvider.show(message);
    }

    private Integer readInteger() {
        return inputProvider.readInteger();
    }

    private List<Integer> readIntegers() {
        return inputProvider.readIntegers();
    }

}
