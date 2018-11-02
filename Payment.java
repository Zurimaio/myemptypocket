package com.floridia.maurizio.myemptypocket;

import java.util.Date;

public class Payment {

    private String location;
    private Float price;
    private Date date;

    public Payment() {
    }

    public Payment(String location, Float price) {
        this.location = location;
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }


    public void setDate(Date date) {
        this.date = date;
    }
}
