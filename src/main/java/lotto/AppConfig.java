package lotto;

import lotto.io.ConsoleInputProvider;
import lotto.io.ConsoleOutputProvider;
import lotto.io.InputProvider;
import lotto.io.OutputProvider;
import lotto.service.MatchingService;
import lotto.service.MatchingServiceFactory;
import lotto.service.PrizeService;
import lotto.service.PrizeServiceFactory;
import lotto.view.adapter.ErrorPrinter;
import lotto.view.input.InputView;
import lotto.view.input.InputViewBuilder;
import lotto.view.adapter.PromptShower;
import lotto.view.output.OutputView;

public class AppConfig {

    public LottoController lottoController() {

        OutputProvider out = new ConsoleOutputProvider();
        InputProvider in = new ConsoleInputProvider();

        OutputView outputView = new OutputView(out);
        InputView inputView = new InputViewBuilder(in)
                .withPrompt(new PromptShower(outputView))
                .retryWhenException(new ErrorPrinter(outputView))
                .build();

        MatchingServiceFactory matchingFactory = MatchingService::new;
        PrizeServiceFactory prizeFactory = PrizeService::new;

        return new LottoController(inputView, outputView, matchingFactory, prizeFactory);
    }
}
