package com.team_clicker.idlefarmer;import android.content.DialogInterface;import android.os.Handler;import android.os.Message;import android.support.v7.app.AlertDialog;import android.support.v7.app.AppCompatActivity;import android.os.Bundle;import android.util.Log;import android.view.View;import android.widget.AdapterView;import android.widget.ListView;import android.widget.ProgressBar;import android.widget.TextView;import com.team_clicker.idlefarmer.adapter.CerealAdapter;import com.team_clicker.idlefarmer.model.Cereal;import com.team_clicker.idlefarmer.runnable.CerealRun;import com.team_clicker.idlefarmer.runnable.Counter;import com.team_clicker.idlefarmer.service.GameService;import java.util.ArrayList;import java.util.Calendar;import java.util.List;import java.util.Timer;/** * An example full-screen activity that shows and hides the system UI (i.e. * status bar and navigation/system bar) with user interaction. */public class MainActivity extends AppCompatActivity {    public final static int MESSAGE_MONEY = 1;    private GameService service = new GameService(this);    private TextView tvMoney;    private ListView listViewCereals;    private List<Timer> timers = new ArrayList<>();    private List<ProgressBar> progressBars;    private Counter counter;    private Handler handler =  new Handler(){        @Override        public void handleMessage(Message msg){        }    };    @Override    protected void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.activity_main);        tvMoney = (TextView) findViewById(R.id.valueMoney);        listViewCereals = (ListView)findViewById(R.id.cereals);        listViewCereals.setOnItemClickListener(cerealClick);        progressBars = new ArrayList<>();    }    @Override    protected void onPause() {        super.onPause();        Calendar now = Calendar.getInstance();        service.getGame().setDbtIdle(now.getTimeInMillis());        for(Timer timer : timers){            timer.cancel();        }        service.saveGame();    }    @Override    protected void onResume() {        super.onResume();        service.init();        if(service.getGame().getDbtIdle() > 0){            Calendar now = Calendar.getInstance();            long diffSeconds = (now.getTimeInMillis() - service.getGame().getDbtIdle()) / 1000;            double moneyEarns = diffSeconds * service.getGame().getEarnBySeconds();            dialog(moneyEarns);            service.getGame().addMoney(moneyEarns);        }        setTextMoneyTV(service.getGame().getMoney());        for(Cereal cereal : service.getGame().getCereals()){            if(cereal.getLevel() > 0){                Timer timer = new Timer();                timer.schedule(new CerealRun(cereal, service.getGame(), moneyHandler), 0, cereal.getGrowthTime()*1000);                timers.add(timer);            }        }        List<Cereal> cerealsList = service.getGame().getCereals();        CerealAdapter adapter = new CerealAdapter(getApplicationContext(), cerealsList);        listViewCereals.setAdapter(adapter);        for(int i = 0; i<listViewCereals.getCount(); i++){            Cereal c = (Cereal) listViewCereals.getAdapter().getItem(i);            if(c.getProgressBar() == null)            {                Log.d("c", "ProgressBar Null for "+c.getName());            }        }}    private AdapterView.OnItemClickListener cerealClick = new AdapterView.OnItemClickListener() {        @Override        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {            Cereal entry = (Cereal)parent.getAdapter().getItem(position);            updateProgressBar();            if(service.getGame().getMoney() >= entry.getCurrentPrice()){                entry.setLevel(entry.getLevel() + 1);                if(entry.getLevel() == 1){                    Timer timer = new Timer();                    timer.schedule(new CerealRun(entry, service.getGame(), moneyHandler), 0, entry.getGrowthTime()*1000);                    timers.add(timer);                }                service.getGame().removeMoney(entry.getCurrentPrice());                service.updateCereal(entry);                setTextMoneyTV(service.getGame().getMoney());                listViewCereals.invalidateViews();                listViewCereals.refreshDrawableState();            }        }    };    private void dialog(double money){        String moneyString = "";        if(money > 999999){            moneyString = String.format("%.2e",money) + "$";        } else {            moneyString = String.format("%.2f",money) + "$";        }        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);        dialog.setCancelable(false);        dialog.setTitle("Argent Gagné");        dialog.setMessage("Vous avez gagne " + moneyString);        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {            @Override            public void onClick(DialogInterface dialog, int id) {            }        });        AlertDialog alert = dialog.create();        alert.show();    }    private Handler moneyHandler = new Handler(){        @Override        public void handleMessage(Message msg) {            super.handleMessage(msg);            if(msg.what == MESSAGE_MONEY){                double money = (double)msg.obj;                setTextMoneyTV(money);            }        }    };    private void setTextMoneyTV(double money){        if(money > 999999){            tvMoney.setText(String.format("%.2e",money) + "$");        } else {            tvMoney.setText(String.format("%.2f",money) + "$");        }    }    private void updateProgressBar(){        for(ProgressBar pb : progressBars){            int value = pb.getProgress();            Log.d("c", ""+value);        }    }}