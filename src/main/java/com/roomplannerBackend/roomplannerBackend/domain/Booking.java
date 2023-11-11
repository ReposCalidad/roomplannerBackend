package com.roomplannerBackend.roomplannerBackend.domain;

import com.roomplannerBackend.roomplannerBackend.persistence.entity.Cliente;

import java.sql.Date;

public class Booking {
    private int bookingId;
    private String customerId;

    private Date date1;

    private Date date2;

    private Double price;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
