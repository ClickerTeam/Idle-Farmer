package com.team_clicker.idlefarmer.runnable;

import android.os.Handler;

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
                handler.sendEmptyMessage(0);
            } catch(InterruptedException ie) {

            }
        }
    }

    public void stopTimer(){
        this.stop = true;
    }

    public void startTimer(){
        this.stop = false;
    }
}
