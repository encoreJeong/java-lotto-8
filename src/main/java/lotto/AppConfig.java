package lotto;

import lotto.io.ConsoleInputProvider;
import lotto.io.ConsoleOutputProvider;
import lotto.io.InputProvider;
import lotto.io.OutputProvider;
import lotto.service.MatchingService;
import lotto.service.MatchingServiceFactory;
import lotto.service.PrizeService;
import lotto.service.PrizeServiceFactory;
import lotto.view.View;
import lotto.view.ViewBuilder;

public class AppConfig {

    public LottoController lottoController() {

        InputProvider in = new ConsoleInputProvider();
        OutputProvider out = new ConsoleOutputProvider();
        View view = new ViewBuilder()
                .input(in)
                .output(out)
                .withExceptionHandling()
                .build();

        MatchingServiceFactory matchingFactory = MatchingService::new;
        PrizeServiceFactory prizeFactory = PrizeService::new;

        return new LottoController(view, matchingFactory, prizeFactory);
    }
}
