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
import lotto.view.View;

public class LottoController {

    private final View view;
    private final MatchingServiceFactory matchingServiceFactory;
    private final PrizeServiceFactory prizeServiceFactory;

    public LottoController(View view, MatchingServiceFactory matchingServiceFactory, PrizeServiceFactory prizeServiceFactory) {
        this.view = view;
        this.matchingServiceFactory = matchingServiceFactory;
        this.prizeServiceFactory = prizeServiceFactory;
    }

    public void run() {

        Budget budget = view.getBudget();

        int lottoQuantity = budget.getAffordableLottoQuantity();
        Lottos issuedLottos = Lottos.issueLottoForNTimes(lottoQuantity);

        view.showLottoQuantity(lottoQuantity);
        view.showLottos(issuedLottos);

        WinningCondition winningCondition = view.getWinningCondition();

        MatchingService matcherService = matchingServiceFactory.create(issuedLottos, winningCondition);
        List<WinningRank> result = matcherService.getMatchResults();

        PrizeService prizeService =  prizeServiceFactory.create(result, budget);
        float roi = prizeService.calculateROI();

        view.showResult(result, roi);

    }
}
