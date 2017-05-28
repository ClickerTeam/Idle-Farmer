package com.team_clicker.idlefarmer.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pierre on 17/05/2017.
 */

public class Game implements Serializable {
    private int id;
    private double exp;
    private double money;
    private double earnBySeconds;
    private long dbtIdle;
    private List<Cereal> cereals;
    private List<Technology> technologies;

    public Game() {
    }

    public Game(double exp, double money, double earnBySeconds, List<Cereal> cereals, List<Technology> technologies) {
        this.exp = exp;
        this.money = money;
        this.earnBySeconds = earnBySeconds;
        this.cereals = cereals;
        this.technologies = technologies;
    }

    public void addMoney(double money){
        this.money += money;
    }

    public void removeMoney(double money){
        this.money -= money;
    }

    public double getExp() {
        return exp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setExp(double exp) {
        this.exp = exp;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getEarnBySeconds() {
        return earnBySeconds;
    }

    public void setEarnBySeconds(double earnBySeconds) {
        this.earnBySeconds = earnBySeconds;
    }

    public long getDbtIdle() {
        return dbtIdle;
    }

    public void setDbtIdle(long dbtIdle) {
        this.dbtIdle = dbtIdle;
    }

    public List<Cereal> getCereals() {
        return cereals;
    }

    public void setCereals(List<Cereal> cereals) {
        this.cereals = cereals;
    }

    public List<Technology> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<Technology> technologies) {
        this.technologies = technologies;
    }
}
