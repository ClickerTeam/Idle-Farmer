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
    private Map<String, Cereal> cerealByName;
    private List<Technology> technologies;

    public Game() {
    }

    public Game(double exp, double money, double earnBySeconds, Map<String, Cereal> cerealByName, List<Technology> technologies) {
        this.exp = exp;
        this.money = money;
        this.earnBySeconds = earnBySeconds;
        this.cerealByName = cerealByName;
        this.technologies = technologies;
    }

    public void initMapCereal(List<Cereal> cereals){
        cerealByName = new HashMap<>();
        for(Cereal cereal : cereals){
            cerealByName.put(cereal.getName(), cereal);
        }
    }

    public Cereal getCerealByName (String name){
        return cerealByName.get(name);
    }

    public void updateCereal(Cereal cereal){
        cerealByName.remove(cereal.getName());
        cerealByName.put(cereal.getName(), cereal);
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

    public Map<String, Cereal> getCerealByName() {
        return cerealByName;
    }

    public void setCerealByName(Map<String, Cereal> cerealByName) {
        this.cerealByName = cerealByName;
    }

    public List<Technology> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<Technology> technologies) {
        this.technologies = technologies;
    }
}
