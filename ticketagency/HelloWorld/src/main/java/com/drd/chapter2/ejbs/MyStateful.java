package com.drd.chapter2.ejbs;

import javax.annotation.PostConstruct;

/**
 * @author darrenp - 2017-08-11.
 */
public interface MyStateful {
    @PostConstruct
    void init();

    long incrementCount();

    long getCount();
}
