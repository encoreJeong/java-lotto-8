package lotto.view;

import lotto.io.InputProvider;
import lotto.io.OutputProvider;

public class ViewBuilder {
    private InputProvider in;
    private OutputProvider out;
    private boolean withExceptionHandling;

    public ViewBuilder input(InputProvider in) {
        this.in = in;
        return this;
    }
    public ViewBuilder output(OutputProvider out) {
        this.out = out;
        return this;
    }
    public ViewBuilder withExceptionHandling() {
        this.withExceptionHandling = true;
        return this;
    }

    public View build() {
        View view = new BaseView(in, out);
        if (withExceptionHandling)
            view = new ExceptionHandlingView(view);

        return view;
    }
}
