package lotto.mvc;

import com.encorejeong.encoreframework.web.dispatcher.DispatcherServlet;
import com.encorejeong.encoreframework.web.handler.adapter.DefaultHandlerAdapter;
import com.encorejeong.encoreframework.web.handler.adapter.HandlerAdapter;
import com.encorejeong.encoreframework.web.handler.adapter.RestHandlerAdapter;
import com.encorejeong.encoreframework.web.handler.mapping.HandlerMapping;
import com.encorejeong.encoreframework.web.handler.mapping.RestHandlerMapping;
import com.encorejeong.encoreframework.web.handler.mapping.UrlWithMethodMapping;
import com.encorejeong.encoreframework.web.view.ViewResolver;
import com.encorejeong.encoreframework.web.view.json.JsonViewResolver;
import com.encorejeong.encoreframework.web.view.text.PlainTextViewResolver;
import lotto.mvc.controller.GetMatchingResultController;
import lotto.mvc.controller.PurchaseLottosController;
import java.util.List;

public class LottoDispatcherServlet extends DispatcherServlet {

    @Override
    protected List<HandlerMapping> initHandlerMappings() {

        //Mapping by HTTP Method, Path Variable, Query Parameter, Url
        RestHandlerMapping restHandlerMapping = new RestHandlerMapping();
        restHandlerMapping.register("POST", "/budget", new PurchaseLottosController());

        UrlWithMethodMapping urlWithMethodMapping = new UrlWithMethodMapping();
        urlWithMethodMapping.register("POST", "/winning-condition", new GetMatchingResultController());

        return List.of(restHandlerMapping, urlWithMethodMapping);
    }

    @Override
    protected List<HandlerAdapter> initHandlerAdapters() {
        return List.of(
                new DefaultHandlerAdapter(),
                new RestHandlerAdapter()
        );
    }

    @Override
    protected List<ViewResolver> initViewResolvers() {
        return List.of(
                new JsonViewResolver(),
                new PlainTextViewResolver()
        );
    }
}
