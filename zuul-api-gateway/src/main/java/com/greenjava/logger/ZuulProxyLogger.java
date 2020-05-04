package com.greenjava.logger;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ZuulProxyLogger extends ZuulFilter {

    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Override
    public String filterType() {

        // "pre" for all before request
        // "post" for all after request
        // "error" for all error
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        HttpServletRequest request =
                RequestContext.getCurrentContext().getRequest();

        logger.info("request -> {} request-uri {}",request,request.getRequestURI());
        return null;
    }
}
