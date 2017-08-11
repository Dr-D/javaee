package com.drd.chapter2.ejbs;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * @author darrenp - 2017-08-11.
 */
@Startup
@Singleton
public class MySingleEJB implements MySingle {

    long counter = 0L;

    @PostConstruct
    public void init() {
       long test = counter;
       System.out.print(test + "\n");
    }

    public long getCounter() {
        return counter;
    }

    public void setCounter(long counter) {
        this.counter = counter;
    }
}
