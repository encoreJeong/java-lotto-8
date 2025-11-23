package lotto.mvc.controller;

import com.encorejeong.encoreframework.web.handler.RestController;
import com.encorejeong.encoreframework.web.request.vo.RequestBody;
import com.encorejeong.encoreframework.web.request.vo.RequestParams;
import lotto.mvc.dto.Mapper;
import java.io.IOException;
import java.util.Map;
import lotto.app.AppConfig;
import lotto.mvc.service.LottoService;
import lotto.app.model.Budget;
import lotto.app.view.input.InputView;
import lotto.app.view.output.OutputView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PurchaseLottosController implements RestController {

    private final static AppConfig appConfig = new AppConfig();
    private final static InputView inputView = appConfig.inputView();
    private final static OutputView outputView = appConfig.outputView();
    private final static LottoService service  = appConfig.lottoService();

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String handle(RequestParams params, RequestBody body, Map<String, Object> model) throws IOException {
        logger.info("[PurchaseLottosController.handle]");

        Budget budget = inputView.getBudget(Mapper.toBudgetDto(body).budget());

        return outputView.showPurchaseResult(service.getLottos(budget), model);
    }
}
