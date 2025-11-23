package lotto.mvc.controller;

import com.encorejeong.encoreframework.web.handler.RestController;
import com.encorejeong.encoreframework.web.request.vo.RequestBody;
import com.encorejeong.encoreframework.web.request.vo.RequestParams;
import lotto.mvc.dto.Mapper;
import lotto.mvc.dto.request.WinningConditionDto;
import java.io.IOException;
import java.util.Map;
import lotto.app.AppConfig;
import lotto.mvc.service.LottoService;
import lotto.app.model.Budget;
import lotto.app.model.Lottos;
import lotto.app.model.WinningCondition;
import lotto.app.view.input.InputView;
import lotto.app.view.output.OutputView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetMatchingResultController implements RestController {

    private final static AppConfig appConfig = new AppConfig();
    private final static InputView inputView = appConfig.inputView();
    private final static OutputView outputView = appConfig.outputView();
    private final static LottoService service  = appConfig.lottoService();

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String handle(RequestParams params, RequestBody body, Map<String, Object> model) throws IOException {

        logger.info("[GetMatchingResultController.handle]");

        WinningConditionDto winningConditionDto = Mapper.toWinningConditionDto(body);

        Lottos issuedLottos = inputView.getLottos(winningConditionDto.issuedLottos());
        WinningCondition winningCondition = inputView.getWinningCondition(winningConditionDto.winningNumbers(), winningConditionDto.bonus());
        Budget budget = inputView.getBudget(winningConditionDto.budget());

        return outputView.showMatchingResult(service.getMatchingResult(issuedLottos, winningCondition, budget), model);
    }
}
