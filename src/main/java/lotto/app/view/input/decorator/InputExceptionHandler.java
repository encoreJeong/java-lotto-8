package lotto.app.view.input.decorator;

@FunctionalInterface
public interface InputExceptionHandler {
    void handle(IllegalArgumentException e);
}
