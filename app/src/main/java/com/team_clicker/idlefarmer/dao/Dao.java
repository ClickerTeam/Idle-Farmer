package com.team_clicker.idlefarmer.dao;

import android.app.Activity;

import com.team_clicker.idlefarmer.bdd.BDD;

import java.sql.SQLException;
import java.util.List;


/**
 * Created by pcormier2015 on 03/05/2017.
 **/
public abstract class Dao<E> {
    protected Activity context;

    public Dao (Activity context){
        this.context = context;
    }

    public abstract List<E> getAll();

    public abstract E get(int id);

    public abstract void add(E entity);

    public abstract void update(E entity);

    public abstract void remove(int id);

    protected int getInsertId(String table){
        int id = 0;
        BDD bdd = new BDD();

        bdd.open(context);
        id = bdd.getInsertID(table);

        return id;
    }
}
