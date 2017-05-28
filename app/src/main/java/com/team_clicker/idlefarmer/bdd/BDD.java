package com.team_clicker.idlefarmer.bdd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.team_clicker.idlefarmer.model.Cereal;
import com.team_clicker.idlefarmer.model.Game;
import com.team_clicker.idlefarmer.model.Technology;

import java.sql.SQLException;

/**
 * Created by pierr on 17/05/2017.
 */

public class BDD {
    BDDHelper helper;
    SQLiteDatabase base;

    public BDD() {
    }

    public void open(Context activity) throws SQLException {
        helper = new BDDHelper(activity);
        base = helper.getWritableDatabase();
    }

    public int getInsertID(String table) {
        final String MY_QUERY = "SELECT MAX(_id) FROM " + table;
        Cursor cur = base.rawQuery(MY_QUERY, null);
        cur.moveToFirst();
        int ID = cur.getInt(0);
        cur.close();
        return ID;
    }

    public void remove(String table, int id){
        base.delete(table, "_id=" + id, null);
    }

    public void update(String table, int id, ContentValues args){
        String strFilter = "_id=" + id;
        base.update(table, args, strFilter, null);
    }

    public Cursor getCereals(){
        return base.rawQuery("SELECT _id, name, level, basePrice, baseYield, currentPrice, currentYield, growthTime, coeff FROM cereals", null);
    }

    public Cursor getCereal(int id){
        return base.rawQuery("SELECT _id, name, level, basePrice, baseYield, currentPrice, currentYield, growthTime, coeff FROM cereals where _id = " + id, null);
    }

    public void removeCereal(int id){
        remove("cereals", id);
    }

    public void updateCereal(Cereal cereal){
        ContentValues args = new ContentValues();

        args.put("name", cereal.getName());
        args.put("level", cereal.getLevel());
        args.put("basePrice", cereal.getBasePrice());
        args.put("baseYield", cereal.getBaseYield());
        args.put("currentPrice", cereal.getCurrentPrice());
        args.put("currentYield", cereal.getCurrentYield());
        args.put("growthTime", cereal.getGrowthTime());
        args.put("coeff", cereal.getCoeff());

        update("cereals ", cereal.getId(), args);
    }

    public Cursor getGame(){
        return base.rawQuery("SELECT _id, exp, money, earnBySeconds,dbtIdle FROM game", null);
    }

    public void removeGame(int id){
        remove("game", id);
    }

    public void updateGame(Game game){
        ContentValues args = new ContentValues();

        args.put("exp", game.getExp());
        args.put("money", game.getMoney());
        args.put("earnBySeconds", game.getEarnBySeconds());
        args.put("dbtIdle", game.getDbtIdle());

        update("game ", game.getId(), args);
    }

    public Cursor getTechnologies(){
        return base.rawQuery("SELECT _id, name, price, coeff FROM technologies", null);
    }

    public Cursor getTechnology(int id){
        return base.rawQuery("SELECT _id, name, price, coeff FROM technologies where _id = " + id, null);
    }

    public void removeTechnology(int id){
        remove("technologies", id);
    }

    public void updateTechnology(Technology technology){
        ContentValues args = new ContentValues();

        args.put("name", technology.getName());
        args.put("price", technology.getPrice());
        args.put("coeff", technology.getCoeff());

        update("technologies ", technology.getId(), args);
    }


}
