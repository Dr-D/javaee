package com.drd.interceptor.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 * Created by dr-d on 22/09/15
 */
public class DemoLogger {

    private final static Logger log = LoggerFactory.getLogger(DemoLogger.class);

    @AroundInvoke
    public Object logMethodEntry(InvocationContext invocationContext) throws Exception {
        String name = invocationContext.getMethod().getName();
        Object target = invocationContext.getTarget();
        log.info("Class: '{}', entering method: '{}'", target.getClass(), name);
        return invocationContext.proceed();
    }
}
