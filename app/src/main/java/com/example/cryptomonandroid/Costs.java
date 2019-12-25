package com.example.cryptomonandroid;

import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

import com.example.cryptomonandroid.API.BinanceBot;
import com.example.cryptomonandroid.API.Bot;
import com.example.cryptomonandroid.API.ExmoBot;



public class Costs extends GridPade {

    protected Vector<Bot> bots = new Vector<Bot>();
    public Vector<Pair<String, String>> pairs;

    public Costs(){
        bots.add(new ExmoBot());
        bots.add(new BinanceBot());
        pairs = new Vector<>();

    }

    public void reload_data(){
        pairs.add(new Pair<String, String>("BTC", "USD"));
        for(Bot bot: bots){
            bot.setPairs(pairs);
            bot.reload_data(50);
        }
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.costs, container, false);
        //show_content();
        return root;
    }

}


