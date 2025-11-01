package lotto;

import java.util.List;
import lotto.enums.WinningRank;
import lotto.model.Budget;
import lotto.io.ConsoleInputProvider;
import lotto.io.ConsoleOutputProvider;
import lotto.io.InputProvider;
import lotto.io.OutputProvider;
import lotto.model.Lotto;
import lotto.service.MatchingService;
import lotto.model.Lottos;
import lotto.model.WinningCondition;
import lotto.service.PrizeService;
import lotto.view.View;
import lotto.view.ViewBuilder;

public class Application {
    public static void main(String[] args) {

        InputProvider inputProvider = new ConsoleInputProvider();
        OutputProvider outputProvider = new ConsoleOutputProvider();

        View view = new ViewBuilder()
                .input(inputProvider)
                .output(outputProvider)
                .withExceptionHandling()
                .build();

        Budget budget = view.getBudget();
        WinningCondition winningCondition = view.getWinningCondition();

        int lottoQuantity = budget.getAffordableLottoQuantity();

        Lottos issuedLottos = Lottos.none();
        for(int i = 0; i < lottoQuantity; i++) {
            issuedLottos.add(Lotto.issue());
        }

        MatchingService matcherService = new MatchingService(issuedLottos, winningCondition);
        List<WinningRank> result = matcherService.getMatchResults();

        PrizeService prizeService =  new PrizeService(result, budget);
        long totalPrize = prizeService.calculateTotalPrize();
        float roi = prizeService.calculateROI();



    }

}
