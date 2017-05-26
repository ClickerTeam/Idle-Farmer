package com.team_clicker.idlefarmer.model;

import java.io.Serializable;

/**
 * Created by pierre on 17/05/2017.
 */

public class Technology implements Serializable {
    private int id;
    private String name;
    private double coeff;
    private double price;

    public Technology() {
    }

    public Technology(int id, String name, double coeff, double price) {
        this.id = id;
        this.name = name;
        this.coeff = coeff;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCoeff() {
        return coeff;
    }

    public void setCoeff(double coeff) {
        this.coeff = coeff;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
