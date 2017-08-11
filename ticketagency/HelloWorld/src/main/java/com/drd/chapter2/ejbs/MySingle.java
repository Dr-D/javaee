package com.drd.chapter2.ejbs;

/**
 * @author darrenp - 2017-08-11.
 */
public interface MySingle {
    public void init();

    long getCounter();

    void setCounter(long counter);
}
