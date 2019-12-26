package com.example.cryptomonandroid;

import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.cryptomonandroid.API.Bot;

import java.util.Vector;

public class Arbitrage extends GridPade {


    protected Vector<Bot> bots;
    protected Vector<Pair<String, String>> pairs;

    public Arbitrage(){

    }

    public void show_table(Vector<Bot> botVector, Vector<Pair<String, String>> pairVector){
        bots = botVector;
        pairs = pairVector;
        if(table == null)
            table = root.findViewById(R.id.table_arbitrage);
        show_content();
    }


    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.arbitrage, container, false);
        return root;
    }

    protected void show_content(){

        table = root.findViewById(R.id.table_arbitrage);
        TableRow.LayoutParams params = new TableRow.LayoutParams();
        params.leftMargin = 25;
        params.topMargin = 15;

        table.removeAllViews();
        rows.clear();

        // добавление заголовков
        rows.add(new TableRow(this.table.getContext()));
        TextView t = new TextView(this.rows.elementAt(0).getContext());
        t.setText("Пары ");
        rows.elementAt(0).addView(t, params);

        try {
            for (int i = 0; i < bots.size(); i++) {
                TextView tt = new TextView(this.rows.elementAt(0).getContext());
                String s = bots.get(i).Name;
                tt.setText(bots.get(i).Name);
                rows.elementAt(0).addView(tt, params);
            }
            table.addView(rows.elementAt(0));

            // добавление котировок
            for (int i = 0; i < pairs.size(); i++) {
                rows.add(new TableRow(this.table.getContext()));
                rows.elementAt(i + 1).layout(10, 5, 3, 5);

                // названия
                TextView pair_name = new TextView(this.rows.elementAt(i + 1).getContext());
                pair_name.setText(pairs.get(i).first + "/" + pairs.get(i).second);
                rows.elementAt(i + 1).addView(pair_name, params);

                // котировки
                for (int j = 0; j < bots.size(); j++) {
                    TextView tt = new TextView(this.rows.elementAt(i + 1).getContext());
                    tt.setText(bots.get(j).get_pair_info(pairs.get(i)).lastprice.toString());
                    rows.elementAt(i + 1).addView(tt, params);
                }
                table.addView(rows.elementAt(i + 1));
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }

}


