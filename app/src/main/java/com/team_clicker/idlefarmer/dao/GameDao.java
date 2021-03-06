package com.team_clicker.idlefarmer.dao;

import android.app.Activity;
import android.database.Cursor;
import android.util.Log;

import com.team_clicker.idlefarmer.bdd.BDD;
import com.team_clicker.idlefarmer.model.Cereal;
import com.team_clicker.idlefarmer.model.Game;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pcormier2015 on 03/05/2017.
 **/
public class GameDao extends Dao<Game>{

    public GameDao(Activity context){
        super(context);
    }

    @Override
    public List<Game> getAll() {
        BDD bdd = new BDD();
        List<Game> games = new ArrayList<>();
        try {
            bdd.open(context);
            Cursor cursor = bdd.getGame();

            while(cursor.moveToNext()){
                Game game = new Game();

                game.setId(cursor.getInt(cursor.getColumnIndex("_id")));
                game.setExp(cursor.getDouble(cursor.getColumnIndex("exp")));
                game.setMoney(cursor.getInt(cursor.getColumnIndex("money")));
                game.setEarnBySeconds(cursor.getDouble(cursor.getColumnIndex("earnBySeconds")));
                game.setDbtIdle(cursor.getLong(cursor.getColumnIndex("dbtIdle")));

                games.add(game);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return games;
    }

    public Game getGame(){
        List<Game> games = getAll();
        if(games.size() > 0){
            return games.get(0);
        }

        return null;
    }

    @Override
    public Game get(int id) {

        return null;
    }

    @Override
    public void add(Game entity) {
    }

    @Override
    public void update(Game entity) {
        BDD bdd = new BDD();
        try {
            bdd.open(context);
            bdd.updateGame(entity);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        BDD bdd = new BDD();
        try {
            bdd.open(context);
            bdd.removeGame(id);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
