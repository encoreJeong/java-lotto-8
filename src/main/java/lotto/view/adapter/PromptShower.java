package lotto.view.adapter;

import lotto.view.input.decorator.InputPromptHandler;
import lotto.view.output.OutputView;

public class PromptShower implements InputPromptHandler {

    private final OutputView outputView;

    public PromptShower(OutputView outputView) {
        this.outputView = outputView;
    }

    @Override
    public void showPrompt(String prompt) {
        outputView.show(prompt);
    }
}
