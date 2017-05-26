package com.team_clicker.idlefarmer.dao;

import android.app.Activity;
import android.database.Cursor;

import com.team_clicker.idlefarmer.bdd.BDD;
import com.team_clicker.idlefarmer.model.Cereal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pcormier2015 on 03/05/2017.
 **/
public class CerealDao extends Dao<Cereal>{

    public CerealDao (Activity context){
        super(context);
    }

    @Override
    public List<Cereal> getAll() {
        BDD bdd = new BDD();
        List<Cereal> cereals = new ArrayList<>();
        bdd.open(context);
        Cursor cursor = bdd.getCereals();

        while(cursor.moveToNext()){
            Cereal cereal = new Cereal();

            cereal.setId(cursor.getInt(cursor.getColumnIndex("_id")));
            cereal.setName(cursor.getString(cursor.getColumnIndex("name")));
            cereal.setLevel(cursor.getInt(cursor.getColumnIndex("level")));
            cereal.setBasePrice(cursor.getDouble(cursor.getColumnIndex("basePrice")));
            cereal.setBaseYield(cursor.getDouble(cursor.getColumnIndex("baseYield")));
            cereal.setCurrentPrice(cursor.getDouble(cursor.getColumnIndex("currentPrice")));
            cereal.setCurrentYield(cursor.getDouble(cursor.getColumnIndex("currentYield")));
            cereal.setGrowthTime(cursor.getInt(cursor.getColumnIndex("growthTime")));

            cereals.add(cereal);
        }

        return cereals;
    }

    @Override
    public Cereal get(int id) {
        BDD bdd = new BDD();
        Cereal cereal = new Cereal();
        bdd.open(context);
        Cursor cursor = bdd.getCereal(id);

        while(cursor.moveToNext()){
            cereal.setId(cursor.getInt(cursor.getColumnIndex("_id")));
            cereal.setName(cursor.getString(cursor.getColumnIndex("name")));
            cereal.setLevel(cursor.getInt(cursor.getColumnIndex("level")));
            cereal.setBasePrice(cursor.getDouble(cursor.getColumnIndex("basePrice")));
            cereal.setBaseYield(cursor.getDouble(cursor.getColumnIndex("baseYield")));
            cereal.setCurrentPrice(cursor.getDouble(cursor.getColumnIndex("currentPrice")));
            cereal.setCurrentYield(cursor.getDouble(cursor.getColumnIndex("currentYield")));
            cereal.setGrowthTime(cursor.getInt(cursor.getColumnIndex("growthTime")));
        }

        return cereal;
    }

    @Override
    public void add(Cereal entity) {
    }

    @Override
    public void update(Cereal entity) {
        BDD bdd = new BDD();
        bdd.open(context);
        bdd.updateCereal(entity);
    }

    @Override
    public void remove(int id) {
        BDD bdd = new BDD();
        bdd.open(context);
        bdd.removeCereal(id);
    }
}
