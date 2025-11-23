package lotto.mvc;

import lotto.mvc.filter.CorsFilter;
import lotto.mvc.filter.ExceptionHandlingFilter;
import jakarta.servlet.Filter;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.FilterDef;
import org.apache.tomcat.util.descriptor.web.FilterMap;

public class WebConfig {

    /**
     *  필터 등록
     */
    public static void registerFilters(Context context) {

        addFilter(context,
                "exceptionHandlingFilter",
                ExceptionHandlingFilter.class,
                "/*");

        addFilter(context,
                "corsFilter",
                CorsFilter.class,
                "/*");
    }

    /**
     * Tomcat에 DispatcherServlet을 등록
     */
    public static void registerServlet(Context context) {
        Tomcat.addServlet(context, "dispatcher", new LottoDispatcherServlet())
                .addMapping("/*");
    }


    private static void addFilter(Context context,
                                  String filterName,
                                  Class<? extends Filter> filterClass,
                                  String urlPattern) {

        FilterDef def = new FilterDef();
        def.setFilterName(filterName);
        def.setFilterClass(filterClass.getName());
        context.addFilterDef(def);

        FilterMap map = new FilterMap();
        map.setFilterName(filterName);
        map.addURLPattern(urlPattern);
        context.addFilterMap(map);
    }
}
