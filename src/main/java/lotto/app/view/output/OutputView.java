package lotto.app.view.output;

import lotto.mvc.dto.response.PurchaseResultDto;
import java.util.Map;
import lotto.app.io.OutputProvider;

public class OutputView {

    OutputProvider outputProvider;

    public OutputView(OutputProvider outputProvider) {
        this.outputProvider = outputProvider;
    }

    public void show(String message) {
        outputProvider.show(message);
    }

    public String showPurchaseResult(PurchaseResultDto dto, Map<String, Object> model){
        model.put("issuedLottos", dto.issuedLottos());
        model.put("lottoQuantity", dto.lottoQuantity());
        model.put("message", dto.message());

        return "jsonView";
    }

    public String showMatchingResult(String result, Map<String, Object> model) {
        model.put("result", result);
        return "textView";
    }
}
