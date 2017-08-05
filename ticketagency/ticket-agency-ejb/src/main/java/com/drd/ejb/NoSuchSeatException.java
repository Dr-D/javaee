package com.drd.ejb;

/**
 * Author: darren 2017-07-07
 */
public class NoSuchSeatException extends Exception {
    public NoSuchSeatException(String message) {
        super(message);
    }
}
