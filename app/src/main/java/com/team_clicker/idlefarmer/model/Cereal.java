package com.team_clicker.idlefarmer.model;

import android.support.annotation.NonNull;
import android.widget.ProgressBar;

import java.io.Serializable;

/**
 * Created by pierre on 17/05/2017.
 */

public class Cereal implements Serializable, Comparable<Cereal> {
    private int id;
    private String name;
    private double basePrice;
    private double baseYield;
    private int level;
    private double currentPrice;
    private double currentYield;
    private ProgressBar progressBar;
    //TODO Gestion  de l'image
    //private Image picture;
    private int growthTime;
    private double coeff;

    public Cereal() {

    }

    public Cereal(int id, String name, double basePrice, double baseYield, int level, double currentPrice, double currentYield, int growthTime, double coeff) {
        this.id = id;
        this.name = name;
        this.basePrice = basePrice;
        this.baseYield = baseYield;
        this.level = level;
        this.currentPrice = currentPrice;
        this.currentYield = currentYield;
        this.growthTime = growthTime;
        this.coeff = coeff;
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

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getBaseYield() {
        return baseYield;
    }

    public void setBaseYield(double baseYield) {
        this.baseYield = baseYield;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public double getCurrentYield() {
        return currentYield;
    }

    public void setCurrentYield(double currentYield) {
        this.currentYield = currentYield;
    }

    public int getGrowthTime() {
        return growthTime;
    }

    public void setGrowthTime(int growthTime) {
        this.growthTime = growthTime;
    }

    public double getCoeff() {
        return coeff;
    }

    public void setCoeff(double coeff) {
        this.coeff = coeff;
    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }

    public void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    @Override
    public int compareTo(@NonNull Cereal o) {
        return getId() - o.getId();
    }
}
