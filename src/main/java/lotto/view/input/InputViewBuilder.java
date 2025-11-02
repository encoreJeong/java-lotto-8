package lotto.view.input;

import lotto.io.InputProvider;
import lotto.view.input.decorator.ExceptionHandlingInputView;
import lotto.view.input.decorator.InputExceptionHandler;
import lotto.view.input.decorator.InputPromptHandler;
import lotto.view.input.decorator.ShowingPromptInputView;

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

    public InputViewBuilder retryWhenException(InputExceptionHandler exceptionHandler) {
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
