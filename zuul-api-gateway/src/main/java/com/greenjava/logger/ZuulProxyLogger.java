package com.greenjava.logger;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ZuulProxyLogger extends ZuulFilter {
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

        System.out.println("request "+request+" uri "+request.getRequestURI());
        return null;
    }
}
