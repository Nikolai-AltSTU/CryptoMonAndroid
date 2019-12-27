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
import com.example.cryptomonandroid.API.PairData;

import org.json.JSONException;


public class Costs extends GridPade {

    protected Vector<Bot> bots; // = new Vector<Bot>();
    protected Vector<Pair<String, String>> pairs;

    public Costs(){

    }

    public void show_table(Vector<Bot> botVector, Vector<Pair<String, String>> pairVector){
        bots = botVector;
        pairs = pairVector;
        if(table == null)
            table = root.findViewById(R.id.table_costs);
        show_content();
    }


    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.costs, container, false);
        return root;
    }

    protected void show_content(){

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
                    PairData p = bots.get(j).get_pair_info(pairs.get(i));

                    TextView tt = new TextView(this.rows.elementAt(i + 1).getContext());
                    if(p != null)
                        tt.setText(p.lastprice.toString());
                    else
                        tt.setText("недоступно");
                    rows.elementAt(i + 1).addView(tt, params);
                }
                table.addView(rows.elementAt(i + 1));
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }

}


