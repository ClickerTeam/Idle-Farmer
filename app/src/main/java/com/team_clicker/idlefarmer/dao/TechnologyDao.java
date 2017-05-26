package com.team_clicker.idlefarmer.dao;

import android.app.Activity;
import android.database.Cursor;

import com.team_clicker.idlefarmer.bdd.BDD;
import com.team_clicker.idlefarmer.model.Cereal;
import com.team_clicker.idlefarmer.model.Technology;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pcormier2015 on 03/05/2017.
 **/
public class TechnologyDao extends Dao<Technology>{

    public TechnologyDao(Activity context){
        super(context);
    }

    @Override
    public List<Technology> getAll() {
        BDD bdd = new BDD();
        List<Technology> technologies = new ArrayList<>();
        bdd.open(context);
        Cursor cursor = bdd.getCereals();

        while(cursor.moveToNext()){
            Technology technology = new Technology();

            technology.setId(cursor.getInt(cursor.getColumnIndex("_id")));
            technology.setName(cursor.getString(cursor.getColumnIndex("name")));
            technology.setPrice(cursor.getDouble(cursor.getColumnIndex("price")));
            technology.setCoeff(cursor.getDouble(cursor.getColumnIndex("coeff")));

            technologies.add(technology);
        }

        return technologies;
    }

    @Override
    public Technology get(int id) {
        BDD bdd = new BDD();
        Technology technology = new Technology();
        bdd.open(context);
        Cursor cursor = bdd.getCereal(id);

        while(cursor.moveToNext()){
            technology.setId(cursor.getInt(cursor.getColumnIndex("_id")));
            technology.setName(cursor.getString(cursor.getColumnIndex("name")));
            technology.setPrice(cursor.getDouble(cursor.getColumnIndex("price")));
            technology.setCoeff(cursor.getDouble(cursor.getColumnIndex("coeff")));
        }

        return technology;
    }

    @Override
    public void add(Technology entity) {
    }

    @Override
    public void update(Technology entity) {
        BDD bdd = new BDD();
        bdd.open(context);
        bdd.updateTechnology(entity);
    }

    @Override
    public void remove(int id) {
        BDD bdd = new BDD();
        bdd.open(context);
        bdd.removeTechnology(id);
    }
}
