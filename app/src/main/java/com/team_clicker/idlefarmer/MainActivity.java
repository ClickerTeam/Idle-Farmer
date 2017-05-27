package com.team_clicker.idlefarmer;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.team_clicker.idlefarmer.adapter.CerealAdapter;
import com.team_clicker.idlefarmer.model.Cereal;
import com.team_clicker.idlefarmer.service.GameService;

import java.util.ArrayList;
import java.util.List;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class MainActivity extends AppCompatActivity {
    private GameService service = new GameService(this);
    private TextView money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        service.init();

        money = (TextView) findViewById(R.id.valueMoney);
        money.setText(String.valueOf(service.getGame().getMoney()) + "$");

        List<Cereal> cerealsList = service.getGame().getCereals();

        ListView ls = (ListView)findViewById(R.id.cereals);
        CerealAdapter adapter = new CerealAdapter(getApplicationContext(), cerealsList);
        ls.setAdapter(adapter);
    }

}