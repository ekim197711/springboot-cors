package com.codeinvestigator.corsfilter.weatherforecast;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
@Order(2)
public class MyCorsFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("Initializing my CORS filter");
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        log.info("The Filter itself");
        HttpServletResponse httpresponse = (HttpServletResponse)response;
        httpresponse.setHeader("Access-Control-Allow-Origin","*");
        httpresponse.setHeader("Access-Control-Allow-Methods","GET, POST, OPTIONS, PUT, DELETE");
        httpresponse.setHeader("Access-Control-Allow-Headers","Origin, Content-Type, Accept, Customheader, *");
        httpresponse.setHeader("Access-Control-Max-Age","3600");
        httpresponse.setHeader("Access-Control-Expose-Headers","*");
        chain.doFilter(request, httpresponse);
    }

    @Override
    public void destroy() {
        log.info("Destroying my CORS filter");
    }
}
