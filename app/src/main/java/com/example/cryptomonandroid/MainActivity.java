package com.example.cryptomonandroid;

import android.os.Bundle;

import com.example.cryptomonandroid.API.BinanceBot;
import com.example.cryptomonandroid.API.Bot;
import com.example.cryptomonandroid.API.ExmoBot;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.os.CountDownTimer;
import android.util.Pair;
import android.view.View;
import android.widget.Button;

import com.example.cryptomonandroid.ui.main.SectionsPagerAdapter;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    private SectionsPagerAdapter sectionsPagerAdapter;
    boolean flag = false;
    CountDownTimer countDownTimer;
    private Timer timer = null;
    private TimerTask timerTask = null;
    protected Vector<Bot> bots; // = new Vector<Bot>();
    protected Vector<Pair<String, String>> pairs;
    Double persent = 0.0;
    Double profit = 0.1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        bots = new Vector<Bot>();
        pairs = new Vector<>();

        try {
            bots.add(new ExmoBot());
        }
        catch (Exception e){
            System.out.println(e);
        }
        try {
            bots.add(new BinanceBot());
        }
        catch (Exception e){
            System.out.println(e);
        }


        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        pairs.clear();
                        pairs.add(new Pair<String, String>("BTC", "USD"));
                        pairs.add(new Pair<String, String>("LTC", "USD"));
                        pairs.add(new Pair<String, String>("TRX", "USD"));

                        for(Bot bot: bots){
                            if(bot == null)
                                continue;
                            bot.setPairs(pairs);
                            bot.reload_data(50);
                        }
                        update();
                    }
                });
            }
        }, 0, 7000);
    }

    protected void update(){
        if(flag) {


            ((Costs) sectionsPagerAdapter.getItem(0)).show_table(bots, pairs);
            ((Arbitrage) sectionsPagerAdapter.getItem(1)).show_table(bots, pairs, persent, profit);
        }
    }

    public void ButtonClick(View view){
        flag = flag ^ true;
    }

}