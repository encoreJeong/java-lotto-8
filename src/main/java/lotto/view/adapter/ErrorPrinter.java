package lotto.view.adapter;

import lotto.view.input.decorator.InputExceptionHandler;
import lotto.view.output.OutputView;

public class ErrorPrinter implements InputExceptionHandler {

    private final OutputView outputView;

    public ErrorPrinter(OutputView outputView) {
        this.outputView = outputView;
    }

    @Override
    public void handle(IllegalArgumentException e) {
        outputView.show(e.getMessage());
    }
}
