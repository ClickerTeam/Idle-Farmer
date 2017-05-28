package com.team_clicker.idlefarmer.service;

import android.app.Activity;
import android.util.Log;
import android.widget.TextView;

import com.team_clicker.idlefarmer.MainActivity;
import com.team_clicker.idlefarmer.dao.CerealDao;
import com.team_clicker.idlefarmer.dao.GameDao;
import com.team_clicker.idlefarmer.dao.TechnologyDao;
import com.team_clicker.idlefarmer.model.Cereal;
import com.team_clicker.idlefarmer.model.Game;
import com.team_clicker.idlefarmer.model.Technology;
import com.team_clicker.idlefarmer.runnable.CerealRun;

import java.io.Serializable;
import java.util.Timer;
import java.util.logging.Handler;

/**
 * Created by pierr on 26/05/2017.
 */

public class GameService implements Serializable {
    private Game game;
    private Activity activity;
    private GameDao gDao;
    private CerealDao cDao;
    private TechnologyDao tDao;

    public GameService(Activity activity) {
        this.activity = activity;
    }

    public void init(){
        gDao = new GameDao(activity);
        cDao = new CerealDao(activity);
        tDao = new TechnologyDao(activity);

        game = gDao.getGame();
        game.setCereals(cDao.getAll());
        game.setTechnologies(tDao.getAll());
    }

    public void updateCereal(Cereal cereal){
        Cereal previousCereal = cDao.get(cereal.getId());
        int levelRise = cereal.getLevel() - previousCereal.getLevel();
        double price = cereal.getCurrentPrice();
        double yield = cereal.getCurrentYield();

        for(int i = 0; i < levelRise; i++){
            price *= cereal.getCoeff();
            if(cereal.getLevel() == 1){
                yield = cereal.getBaseYield();
            } else {
                yield += Math.log1p(yield);
            }

        }

        cereal.setCurrentPrice(price);
        cereal.setCurrentYield(yield);
        game.setEarnBySeconds(game.getEarnBySeconds() + yield);

        game.getCereals().set(cereal.getId() - 1, cereal);

       // cDao.update(cereal);
        //gDao.update(game);
    }

    public void saveGame(Activity activity){
        for(Technology technology : game.getTechnologies()){
            tDao.update(technology);
        }

        for(Cereal cereal : game.getCereals()){
            cDao.update(cereal);
        }

        gDao.update(game);
    }

    public Game getGame() {
        return game;
    }
}
