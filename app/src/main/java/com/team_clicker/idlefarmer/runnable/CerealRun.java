package com.team_clicker.idlefarmer.runnable;

import android.os.Handler;
import android.os.Message;

import com.team_clicker.idlefarmer.MainActivity;
import com.team_clicker.idlefarmer.model.Cereal;
import com.team_clicker.idlefarmer.model.Game;

import java.util.TimerTask;

/**
 * Created by pierr on 28/05/2017.
 */

public class CerealRun extends TimerTask {
    private Cereal cereal;
    private Game game;
    private Handler mHandler;

    public CerealRun(Cereal cereal, Game game, Handler mHandler) {
        this.cereal = cereal;
        this.game = game;
        this.mHandler = mHandler;
    }

    public void run() {
        if(cereal.getLevel() > 0){
            game.addMoney(cereal.getCurrentYield() * cereal.getGrowthTime());
            sendMessage(game.getMoney());
        }
    }

    private void sendMessage(double money){
        Message moneyMessage = new Message();
        moneyMessage.what = MainActivity.MESSAGE_MONEY;
        moneyMessage.obj = money;
        mHandler.sendMessage(moneyMessage);
    }
}
