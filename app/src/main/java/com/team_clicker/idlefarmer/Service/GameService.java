package com.team_clicker.idlefarmer.service;

import android.app.Activity;

import com.team_clicker.idlefarmer.dao.CerealDao;
import com.team_clicker.idlefarmer.dao.GameDao;
import com.team_clicker.idlefarmer.dao.TechnologyDao;
import com.team_clicker.idlefarmer.model.Cereal;
import com.team_clicker.idlefarmer.model.Game;
import com.team_clicker.idlefarmer.model.Technology;

import java.io.Serializable;

/**
 * Created by pierr on 26/05/2017.
 */

public class GameService implements Serializable {
    private Game game;
    private Activity activity;

    public GameService(Activity activity) {
        this.activity = activity;
    }

    public void init(){
        GameDao gDao = new GameDao(activity);
        CerealDao cDao = new CerealDao(activity);
        TechnologyDao tDao = new TechnologyDao(activity);

        game = gDao.getGame();
        game.setCereals(cDao.getAll());
        game.setTechnologies(tDao.getAll());
    }

    public void updateCereal(Cereal cereal){
        // x + log1p(x) où x = le rendement de la propriété
        // x * coeff où x = prix à payer
        Cereal previousCereal = game.getCereals().get(cereal.getId() - 1);
        int levelRise = cereal.getLevel() - previousCereal.getLevel();
        double price = cereal.getCurrentPrice();
        double yield = cereal.getCurrentYield();
        for(int i = 0; i < levelRise; i++){
            price *= cereal.getCoeff();
            yield += Math.log1p(yield);
        }
        cereal.setCurrentPrice(price);
        cereal.setCurrentYield(yield);
        game.getCereals().set(cereal.getId() - 1, cereal);

        CerealDao cDao = new CerealDao(activity);
        cDao.update(cereal);
    }

    public void saveGame(Activity activity){
        GameDao gDao = new GameDao(activity);
        CerealDao cDao = new CerealDao(activity);
        TechnologyDao tDao = new TechnologyDao(activity);

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
