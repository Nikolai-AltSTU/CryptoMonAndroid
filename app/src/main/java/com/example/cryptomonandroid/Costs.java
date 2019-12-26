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
        //bots.add(new ExmoBot());
        bots.add(new BinanceBot());
        pairs = new Vector<>();

    }


    public void reload_data(){
        pairs.clear();
        pairs.add(new Pair<String, String>("BTC", "USD"));
        pairs.add(new Pair<String, String>("LTC", "USD"));
        pairs.add(new Pair<String, String>("TRX", "USD"));
        for(Bot bot: bots){
            bot.setPairs(pairs);
            bot.reload_data(50);
        }
    }



    public void show_content(){

        if(table == null)
            table = root.findViewById(R.id.table_costs);

        TableRow.LayoutParams params = new TableRow.LayoutParams();
        params.leftMargin = 10;
        params.topMargin = 10;

        table.removeAllViews();
        rows.clear();

        // добавление заголовков
        rows.add(new TableRow(this.table.getContext()));
        TextView t = new TextView(this.rows.elementAt(0).getContext());
        t.setText("Пары ");
        rows.elementAt(0).addView(t, params);

        for(int i = 0; i < bots.size(); i++) {
            TextView tt = new TextView(this.rows.elementAt(0).getContext());
            String s = bots.get(i).Name;
            tt.setText(bots.get(i).Name);
            rows.elementAt(0).addView(tt, params);
        }
        table.addView(rows.elementAt(0));

        // добавление котировок
        for(int i = 0; i < pairs.size(); i++){
            rows.add(new TableRow(this.table.getContext()));
            rows.elementAt(i + 1).layout(10,5,3,5);

            // названия
            TextView pair_name = new TextView(this.rows.elementAt(i+1).getContext());
            pair_name.setText(pairs.get(i).first + "/0" + pairs.get(i).second);
            rows.elementAt(i + 1).addView(pair_name, params);

            // котировки
            for(int j = 0; j < bots.size(); j++) {
                TextView tt = new TextView(this.rows.elementAt(i+1).getContext());
                tt.setText( bots.get(j).get_pair_info( pairs.get(i) ).lastprice.toString() )  ;
                rows.elementAt(i+1).addView(tt,params);
            }
            table.addView(rows.elementAt(i+1));
        }

    }

}


