package com.drd.ejb;

/**
 * Author: darren 2017-07-07
 */
public class Seat {
    private int id;
    private String name;
    private int price;
    private boolean booked;

    public Seat(int id, String name, int price) {
        this(id, name, price, false);
    }

    private Seat(int id, String name, int price, boolean booked) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.booked = booked;
    }

    public Seat getBookedSeat() {
        return new Seat(this.id, this.name, this.price, true);
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public boolean isBooked() {
        return booked;
    }
}
