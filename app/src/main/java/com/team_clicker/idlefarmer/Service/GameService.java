package com.team_clicker.idlefarmer.Service;

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

    public void init(Activity activity){
        GameDao gDao = new GameDao(activity);
        CerealDao cDao = new CerealDao(activity);
        TechnologyDao tDao = new TechnologyDao(activity);

        game = gDao.getGame();
        game.initMapCereal(cDao.getAll());
        game.setTechnologies(tDao.getAll());
    }

    public void saveGame(Activity activity){
        GameDao gDao = new GameDao(activity);
        CerealDao cDao = new CerealDao(activity);
        TechnologyDao tDao = new TechnologyDao(activity);

        for(Technology technology : game.getTechnologies()){
            tDao.update(technology);
        }

        for(Cereal cereal : game.getCerealByName().values()){
            cDao.update(cereal);
        }

        gDao.update(game);
    }

    public Game getGame() {
        return game;
    }
}
