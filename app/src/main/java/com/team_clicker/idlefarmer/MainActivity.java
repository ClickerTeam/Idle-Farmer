package com.team_clicker.idlefarmer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.team_clicker.idlefarmer.adapter.CerealAdapter;
import com.team_clicker.idlefarmer.model.Cereal;
import com.team_clicker.idlefarmer.service.GameService;

import java.util.List;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class MainActivity extends AppCompatActivity {
    private GameService service = new GameService(this);
    private TextView tvMoney;
        private ListView listViewCereals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        service.init();

        tvMoney = (TextView) findViewById(R.id.valueMoney);
        setTextMoneyTV(service.getGame().getMoney());

        List<Cereal> cerealsList = service.getGame().getCereals();

        listViewCereals = (ListView)findViewById(R.id.cereals);
        listViewCereals.setOnItemClickListener(cerealClick);

        CerealAdapter adapter = new CerealAdapter(getApplicationContext(), cerealsList);
        listViewCereals.setAdapter(adapter);
    }

    private AdapterView.OnItemClickListener cerealClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Cereal entry = (Cereal)parent.getAdapter().getItem(position);
            if(service.getGame().getMoney() >= entry.getCurrentPrice()){
                entry.setLevel(entry.getLevel() + 1);
                double money = service.getGame().getMoney() - entry.getCurrentPrice();
                service.getGame().setMoney(money);
                service.updateCereal(entry);

                setTextMoneyTV(money);

                listViewCereals.invalidateViews();
                listViewCereals.refreshDrawableState();
            }

        }
    };

    private void setTextMoneyTV(double money){
        if(money > 999999){
            tvMoney.setText(String.format("%.2e",money) + "$");
        } else {
            tvMoney.setText(String.format("%.2f",money) + "$");
        }
    }
}