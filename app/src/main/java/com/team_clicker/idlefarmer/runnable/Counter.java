package com.team_clicker.idlefarmer.runnable;

import android.os.Handler;
import android.os.Message;

import com.team_clicker.idlefarmer.MainActivity;

/**
 * Created by Melto on 29/05/2017.
 */

public class Counter implements Runnable {

    private Handler handler;
    private boolean stop;

    public Counter(Handler handler){
        this.handler = handler;
        startTimer();
    }


    @Override
    public void run() {

        while(!stop){
            try{
                Thread.sleep(1000);
                sendMessage();
            } catch(InterruptedException ie) {

            }
        }
    }

    private void sendMessage(){
        Message moneyMessage = new Message();
        moneyMessage.what = MainActivity.MESSAGE_PB;
        handler.sendMessage(moneyMessage);
    }

    public void stopTimer(){
        this.stop = true;
    }

    public void startTimer(){
        this.stop = false;
    }
}
