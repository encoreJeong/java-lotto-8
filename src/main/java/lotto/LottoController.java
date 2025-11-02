package lotto;

import java.util.List;
import lotto.enums.WinningRank;
import lotto.model.Budget;
import lotto.model.Lottos;
import lotto.model.WinningCondition;
import lotto.service.MatchingService;
import lotto.service.MatchingServiceFactory;
import lotto.service.PrizeService;
import lotto.service.PrizeServiceFactory;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final MatchingServiceFactory matchingServiceFactory;
    private final PrizeServiceFactory prizeServiceFactory;

    public LottoController(InputView inputView, OutputView outputView, MatchingServiceFactory matchingServiceFactory, PrizeServiceFactory prizeServiceFactory) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.matchingServiceFactory = matchingServiceFactory;
        this.prizeServiceFactory = prizeServiceFactory;
    }

    public void run() {

        Budget budget = inputView.getBudget();

        int lottoQuantity = budget.getAffordableLottoQuantity();
        Lottos issuedLottos = Lottos.issueLottoForNTimes(lottoQuantity);

        outputView.showLottoQuantity(lottoQuantity);
        outputView.showLottos(issuedLottos);

        WinningCondition winningCondition = inputView.getWinningCondition();

        MatchingService matcherService = matchingServiceFactory.create(issuedLottos, winningCondition);
        List<WinningRank> result = matcherService.getMatchResults();

        PrizeService prizeService =  prizeServiceFactory.create(result, budget);
        float roi = prizeService.calculateROI();

        outputView.showResult(result, roi);

    }
}
