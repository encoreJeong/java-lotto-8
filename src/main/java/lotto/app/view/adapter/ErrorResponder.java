package lotto.app.view.adapter;

import lotto.app.view.input.decorator.InputExceptionHandler;

public class ErrorResponder implements InputExceptionHandler {

    @Override
    public void handle(IllegalArgumentException e) {
        throw e;
    }
}
