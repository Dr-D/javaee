package com.drd.chapter2.ejbs;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;

/**
 * @author darrenp - 2017-08-11.
 */
@Stateful
public class MyStatefulEJB implements MyStateful {

    private long count;

    @PostConstruct
    public void init() {
        count = 0;
    }

    public long incrementCount() {
        return ++count;
    }

    public long getCount() {
        return count;
    }
}
