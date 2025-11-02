package lotto.view.output;

import java.util.List;
import lotto.enums.WinningRank;
import lotto.io.MessageFormatter;
import lotto.io.OutputProvider;
import lotto.model.Lottos;

public class OutputView {

    OutputProvider outputProvider;

    public OutputView(OutputProvider outputProvider) {
        this.outputProvider = outputProvider;
    }

    public void showLottoQuantity(int quantity) {
        show(MessageFormatter.formatQuantity(quantity));
    }

    public void showLottos(Lottos lottos) {
        show(MessageFormatter.formatLottos(lottos));
    }

    public void showResult(List<WinningRank> result, float roi) {
        show(MessageFormatter.formatResult(result, roi));
    }

    public void show(String message) {
        outputProvider.show(message);
    }
}
