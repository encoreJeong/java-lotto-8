package lotto.app;

import lotto.app.io.ConsoleOutputProvider;
import lotto.app.io.InputProvider;
import lotto.app.io.OutputProvider;
import lotto.app.io.ProgrammaticInputProvider;
import lotto.app.service.MatchingService;
import lotto.app.service.MatchingServiceFactory;
import lotto.app.service.PrizeService;
import lotto.app.service.PrizeServiceFactory;
import lotto.app.view.input.InputView;
import lotto.app.view.input.InputViewBuilder;
import lotto.app.view.output.OutputView;
import lotto.mvc.service.LottoService;

public class AppConfig {

    public LottoService lottoService() {
        /**
         * Service는 두가지 이상의 모델 동작을 오케스트레이션 한다.
         * 이들은 필요한 인자가 런타임에 결정된다.
         * 따라서, controller에는 factory를 넘겨 런터임에 Service 객체를 생성할 수 있게한다.
         */
        MatchingServiceFactory matchingFactory = MatchingService::new;
        PrizeServiceFactory prizeFactory = PrizeService::new;

        return new LottoService(matchingFactory, prizeFactory);
    }

    /**
     * InputView를 구현하는 BaseInputView는 오직 사용자의 입력을 받는 기능만 갖고 있다. 그외 기능은 데코레이터 패턴으로 추가한다.
     * 사용자에게 입력 힌트를 보이고 싶다면, withPrompt 옵션에 힌트를 표시할 방법을 인자로 넘긴다.
     * 예외 발생시 동작을 구현하려면, withExceptionHandling 옵션에 에러 발생시 처리할 방법을 인자로 넘긴다.
     * 데코레이터 추가시 추가 순서에 유의할 것.
     */
    public InputView inputView() {
        InputProvider in = new ProgrammaticInputProvider();
        return new InputViewBuilder(in)
                .build();
    }

    /**
     *  입출력 제공자를 인터페이스로 만들어두면, 입출력 환경이 변할 때 View를 변경할 필요가 없다.
     *  새로운 입출력 환경이 필요하다면, OutputProvider와 InputProvider를 구현하는 구체 클래스를 구현할 것
     */
    public OutputView outputView() {
        OutputProvider out = new ConsoleOutputProvider();
        return new OutputView(out);
    }
}
