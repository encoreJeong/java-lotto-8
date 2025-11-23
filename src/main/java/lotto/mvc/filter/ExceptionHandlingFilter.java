package lotto.mvc.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionHandlingFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlingFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException {
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        try {
            filterChain.doFilter(servletRequest, resp);

        } catch (ServletException e) {
            logger.error(e.getMessage());
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write(e.getMessage());

        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write("Internal Server Error");
        }
    }
}
