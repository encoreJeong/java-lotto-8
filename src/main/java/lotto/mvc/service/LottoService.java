package lotto.mvc.service;

import lotto.mvc.dto.Mapper;
import lotto.mvc.dto.response.PurchaseResultDto;
import java.util.List;
import lotto.app.enums.WinningRank;
import lotto.app.model.Budget;
import lotto.app.model.Lottos;
import lotto.app.model.WinningCondition;
import lotto.app.service.MatchingService;
import lotto.app.service.MatchingServiceFactory;
import lotto.app.service.PrizeService;
import lotto.app.service.PrizeServiceFactory;

public class LottoService {

    private final MatchingServiceFactory matchingServiceFactory;
    private final PrizeServiceFactory prizeServiceFactory;

    public LottoService(MatchingServiceFactory matchingServiceFactory, PrizeServiceFactory prizeServiceFactory) {
        this.matchingServiceFactory = matchingServiceFactory;
        this.prizeServiceFactory = prizeServiceFactory;
    }

    public PurchaseResultDto getLottos(Budget budget) {

        int lottoQuantity = budget.getAffordableLottoQuantity();
        Lottos issuedLottos = Lottos.issueLottoForNTimes(lottoQuantity);

        return Mapper.toPurchaseResultDto(issuedLottos, lottoQuantity);
    }

    public String getMatchingResult(Lottos issuedLottos, WinningCondition winningCondition, Budget budget) {

        MatchingService matcherService = matchingServiceFactory.create(issuedLottos, winningCondition);
        List<WinningRank> result = matcherService.getMatchResults();

        PrizeService prizeService =  prizeServiceFactory.create(result, budget);
        double roi = prizeService.calculateROI();

        return Mapper.toMatchingResultDto(result, roi);
    }
}
