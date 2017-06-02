package com.team_clicker.idlefarmer.view;

import android.widget.ProgressBar;

import com.team_clicker.idlefarmer.model.Cereal;

/**
 * Created by pierr on 02/06/2017.
 */

public class CerealView {
    private Cereal cereal;
    private ProgressBar progressBar;
    private double priceDisplayed;

    public CerealView() {
    }

    public CerealView(Cereal cereal, double priceDisplayed) {
        this.cereal = cereal;
        this.priceDisplayed = priceDisplayed;
    }

    public CerealView(Cereal cereal, ProgressBar progressBar, double priceDisplayed) {
        this.cereal = cereal;
        this.progressBar = progressBar;
        this.priceDisplayed = priceDisplayed;
    }

    public void calculateNewPriceToDisplay(int level){
        double price = cereal.getCurrentPrice();
        double priceToPay = price;

        for(int i = 0; i < level - 1; i++){
            price *= cereal.getCoeff();
            priceToPay += price;
        }

        this.priceDisplayed = priceToPay;
    }

    public Cereal getCereal() {
        return cereal;
    }

    public void setCereal(Cereal cereal) {
        this.cereal = cereal;
    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }

    public void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    public double getPriceDisplayed() {
        return priceDisplayed;
    }

    public void setPriceDisplayed(double priceDisplayed) {
        this.priceDisplayed = priceDisplayed;
    }
}
