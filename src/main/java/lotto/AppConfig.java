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

        /**
         *  입출력 제공자를 인터페이스로 만들어두면, 입출력 환경이 변할 때 View를 변경할 필요가 없다.
         *  새로운 입출력 환경이 필요하다면, OutputProvider와 InputProvider를 구현하는 구체 클래스를 구현할 것
         */
        OutputProvider out = new ConsoleOutputProvider();
        InputProvider in = new ConsoleInputProvider();

        /**
         * InputView를 구현하는 BaseInputView는 오직 사용자의 입력을 받는 기능만 갖고 있다. 그외 기능은 데코레이터 패턴으로 추가한다.
         * 사용자에게 입력 힌트를 보이고 싶다면, withPrompt 옵션에 힌트를 표시할 방법을 인자로 넘긴다.
         * 예외 발생시 재입력 하도록 하고 싶다면, retryWhenException 옵션에 에러 발생시 처리할 방법을 인자로 넘긴다.
         * 데코레이터 추가시 추가 순서에 유의할 것.
         */
        OutputView outputView = new OutputView(out);
        InputView inputView = new InputViewBuilder(in)
                .withPrompt(new PromptShower(outputView))
                .retryWhenException(new ErrorPrinter(outputView))
                .build();

        /**
         * 아래의 Service들은 런타임에 필요한 인자가 결정된다.
         * 따라서, controller에는 factory를 넘겨 런터임에 Service 객체를 생성할 수 있게한다.
         */
        MatchingServiceFactory matchingFactory = MatchingService::new;
        PrizeServiceFactory prizeFactory = PrizeService::new;

        return new LottoController(inputView, outputView, matchingFactory, prizeFactory);
    }
}
