package com.drd.myejbs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

/**
 * Author: darren 2017-07-15
 */

@Stateful
public class TestEJB implements Test {
    private static final Logger log = LoggerFactory.getLogger(TestEJB.class);
    private int count;

    @PostConstruct
    public void init() {
        log.debug("PostConstruct called");
        count = 10;
    }

    @Override
    public void add() {
        count ++;
    }

    @Override
    public int getCount() {
        return count;
    }
}
