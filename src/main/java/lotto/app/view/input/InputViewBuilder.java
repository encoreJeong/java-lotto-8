package lotto.app.view.input;

import lotto.app.io.InputProvider;
import lotto.app.view.input.decorator.ExceptionHandlingInputView;
import lotto.app.view.input.decorator.InputExceptionHandler;
import lotto.app.view.input.decorator.InputPromptHandler;
import lotto.app.view.input.decorator.ShowingPromptInputView;

public class InputViewBuilder {

    private InputProvider inputProvider;
    private InputExceptionHandler exceptionHandler;
    private InputPromptHandler promptHandler;

    public InputViewBuilder(InputProvider in) {
        this.inputProvider = in;
    }

    public InputViewBuilder input(InputProvider in) {
        this.inputProvider = in;
        return this;
    }

    public InputViewBuilder withExceptionHandling(InputExceptionHandler exceptionHandler) {
        this.exceptionHandler = exceptionHandler;
        return this;
    }

    public InputViewBuilder withPrompt(InputPromptHandler promptHandler) {
        this.promptHandler = promptHandler;
        return this;
    }

    public InputView build() {

        InputView inputView = new BaseInputView(inputProvider);

        if (promptHandler != null)
            inputView = new ShowingPromptInputView(inputView, promptHandler);
        if (exceptionHandler != null)
            inputView = new ExceptionHandlingInputView(inputView, exceptionHandler);

        return inputView;
    }
}
