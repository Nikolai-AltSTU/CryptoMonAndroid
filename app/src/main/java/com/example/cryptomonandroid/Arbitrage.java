package com.example.cryptomonandroid;

import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.solver.GoalRow;
import androidx.fragment.app.Fragment;

import com.example.cryptomonandroid.API.Bot;
import com.example.cryptomonandroid.API.PairData;

import java.util.Vector;

public class Arbitrage extends GridPade {

    protected Vector<Bot> bots;
    protected Vector<Pair<String, String>> pairs;
    protected Vector<Arbitr_situation> arbitr_situations;

    public Arbitrage(){
        arbitr_situations = new Vector<>();
    }

    public void show_table(Vector<Bot> botVector, Vector<Pair<String, String>> pairVector, Double persent,Double profit){
        bots = botVector;
        pairs = pairVector;
        if(table == null)
            table = root.findViewById(R.id.table_arbitrage);
        find_arbitrage(persent, profit);
        //table.removeAllViews();
        show_content();
    }


    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.arbitrage, container, false);
        return root;
    }

    protected class Arbitr_situation{
        Pair<String, String> pair;
        Bot sell = null;
        Double buy_quantity = 0.;
        Double sell_quantity = 0.;
        Double buy_price = 0.;
        Double sell_price = 0.;
        Bot buy = null;
        Double profit = 0.;
        Double persent = 0.;
    }


    protected double Volume( Vector<Pair<Double, Double>>  l, int depth)
    {
        double sum = 0;

        if (l.size() < depth) depth = l.size();

        // price - first
        // quantuty - second
        for(int i = 0; i < depth; i++)
        {
            sum += l.get(depth).first * l.get(depth).second;
        }
        return sum;
    }

    protected double Count(  Vector<Pair<Double, Double>>  l, int depth)
    {
        double sum = 0;

        if (l.size() < depth) depth = l.size();

        // quantuty - second
        for(int i = 0; i < depth; i++)
        {
            sum += l.get(i).second;
        }
        return sum;
    }


    private void find_arbitrage(Double persent, Double profit){

        arbitr_situations.clear();
        persent = persent / 100;

        for(int i = 0; i < bots.size(); i++)
        {   // buy
            for(Pair<String,String> p : pairs)
            {
                Vector<Pair<Double, Double>> Asks;
                try
                {
                    Asks = bots.get(i).get_pair_info(p).Asks;
                }
                catch (Exception e) {
                    continue;
                }
                if(Asks.size() > 0)
                    for (int j = 0; j < bots.size(); j++)
                    {   // sell
                        if (i == j) continue;
                        Vector<Pair<Double, Double>> Bids;
                        try
                        {
                            Bids = bots.get(j).get_pair_info(p).Bids;
                        }
                        catch (Exception e)
                        {
                            continue;
                        }
                        // price - 0
                        // quantity - 1
                        if (Bids.size() > 0 && ((Bids.get(0).first / Asks.get(0).first) > (1 + persent) ))
                        {
                            double max_persent = 0;
                            double max_volume = 0;
                            int A = 0, B = 0; // идеальные параметры глубины торгов
                            double balance = 0; // объем продажи - объем покупки
                            for (int a = 0, b = 0; a < Asks.size() - 1 && b < Bids.size() - 1;)
                            {
                                if (balance >= 0)
                                {   // покупаем
                                    a++;
                                    balance = Volume(Bids, b) - Volume(Asks, a);
                                }
                                else
                                {   // продаем
                                    b++;
                                    balance = Volume( Bids, b) - Volume(Asks, a);
                                }

                                if (balance > max_volume)
                                {
                                    max_volume = balance;
                                    A = a; B = b;
                                }
                                if (Volume( Bids, B) / Volume( Asks, A) > 1 + max_persent)
                                {
                                    max_persent = Volume( Bids, B) / Volume( Asks, A) - 1;
                                }

                                if (Volume( Bids, B) / Volume( Asks, A) < 1 + persent)
                                    break;

                            }

                            double trade_persent = Bids.get(B).first / Asks.get(A).first - 1;

                            if (trade_persent < persent)
                                continue;

                            double volume = (Count(Asks, A) > Count(Bids, B)) ? Count(Bids, B) : Count(Asks, A);

                            double Profit = volume * (Bids.get(B).first - Asks.get(A).first);

                            // выводим арбитражную ситуацию
                            arbitr_situations.add( new Arbitr_situation());

                            //заполняем поля
                            arbitr_situations.lastElement().pair = new Pair<>(p.first, p.second);
                            arbitr_situations.lastElement().buy = bots.get(i);
                            arbitr_situations.lastElement().sell = bots.get(j);
                            arbitr_situations.lastElement().buy_price = Asks.get(A).first;
                            arbitr_situations.lastElement().sell_price = Bids.get(B).first;
                            arbitr_situations.lastElement().buy_quantity = Count(Asks, A);
                            arbitr_situations.lastElement().sell_quantity = Count(Bids, B);
                            arbitr_situations.lastElement().persent = trade_persent * 100;
                            arbitr_situations.lastElement().profit = Profit;

                        }

                    }
            }

        }

    }

    protected void show_content(){

        table = root.findViewById(R.id.table_arbitrage);
        TableRow.LayoutParams params = new TableRow.LayoutParams();
        params.leftMargin = 25;
        params.topMargin = 15;
        params.width = 200;
        TableRow.LayoutParams params_pair = new TableRow.LayoutParams();
        params_pair.leftMargin = 25;
        params_pair.topMargin = 15;
        params_pair.width = 100;
        table.removeAllViews();
        TableRow.LayoutParams row_params = new TableRow.LayoutParams();
        row_params.leftMargin = 5;
        row_params.topMargin = 15;
        table.removeAllViews();
        rows.clear();

        // добавление заголовков
        rows.add(new TableRow(this.table.getContext()));

        TextView t1 = new TextView(this.rows.elementAt(0).getContext());
        t1.setText("Пара ");
        rows.elementAt(0).addView(t1, params_pair);
        TextView t2 = new TextView(this.rows.elementAt(0).getContext());
        t2.setText("Купить ");
        rows.elementAt(0).addView(t2, params);
        TextView t3 = new TextView(this.rows.elementAt(0).getContext());
        t3.setText("Продать ");
        rows.elementAt(0).addView(t3, params);
        TextView t4 = new TextView(this.rows.elementAt(0).getContext());
        t4.setText("Процент ");
        rows.elementAt(0).addView(t4, params);
        TextView t5 = new TextView(this.rows.elementAt(0).getContext());
        t5.setText("Прибыль ");
        rows.elementAt(0).addView(t5, params);

        table.addView(rows.elementAt(0));
        try {

            // добавление арбитражных ситуаций
            for (int i = 0; i < arbitr_situations.size(); i++) {
                rows.add(new TableRow(this.table.getContext()));
                rows.elementAt(i + 1).layout(10, 5, 3, 5);

                // название
                TextView pair_name = new TextView(this.rows.elementAt(i + 1).getContext());
                pair_name.setText(arbitr_situations.get(i).pair.first + "/" + arbitr_situations.get(i).pair.second);
                rows.elementAt(i + 1).addView(pair_name, params_pair);

                // buy
                TextView buy_tv = new TextView(this.rows.elementAt(i + 1).getContext());
                buy_tv.setText(arbitr_situations.get(i).buy.Name +" $" + arbitr_situations.get(i).buy_price);
                rows.elementAt(i + 1).addView(buy_tv, params);

                // sell
                TextView sell_tv = new TextView(this.rows.elementAt(i + 1).getContext());
                sell_tv.setText(arbitr_situations.get(i).sell.Name +" $" + arbitr_situations.get(i).sell_price);
                rows.elementAt(i + 1).addView(sell_tv, params);

                // persent
                TextView persent_tv = new TextView(this.rows.elementAt(i + 1).getContext());
                persent_tv.setText(arbitr_situations.get(i).persent.toString());
                rows.elementAt(i + 1).addView(persent_tv, params);

                // profit
                TextView profit_tv = new TextView(this.rows.elementAt(i + 1).getContext());
                profit_tv.setText(" $ " + arbitr_situations.get(i).profit.toString());
                rows.elementAt(i + 1).addView(profit_tv, params);

                table.addView(rows.elementAt(i + 1));
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }

}


