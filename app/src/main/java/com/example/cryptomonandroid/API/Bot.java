package com.example.cryptomonandroid.API;
import android.util.Pair;

import org.json.JSONException;

import java.util.*;

public abstract class Bot {


    protected HashMap<Pair<String, String>, String> dictionary_of_pairs_name;
    protected HashMap<Pair<String, String>, String> tradeable_coins;
    public Bot()
    {
        dictionary_of_pairs_name = new HashMap<Pair<String, String>, String>();
        pairs_data = new HashMap<String, PairData>();
        tradeable_coins = new HashMap<Pair<String, String> , String>();
    }

    public String Name;
    protected HashMap<String, PairData> pairs_data;

    protected abstract String pair_translator(Pair<String, String> pair);
    public final void setPairs(Vector<Pair<String, String>> pairs)
    {
        tradeable_coins.clear();
        for (Pair<String, String> pair: pairs)
        {
            tradeable_coins.put(pair, pair_translator(pair));
        }

    }

    public void reload_data(final int depth) {


        Thread orderBook =  new Thread(
                new Runnable() {
                    public void run() {
                        try {
                            get_order_books(depth);
                        }catch (JSONException je){
                            System.out.print(je.toString());
                        }
                    }
                }
        );
        orderBook.start();

        Thread tickers =  new Thread(
                new Runnable() {
                    public void run() {
                        try {
                            get_tickers(depth);
                        }catch (JSONException je){
                            System.out.print(je.toString());
                        }
                    }
                }
        );
        tickers.start();


    }

    protected abstract void get_order_books(int depth) throws JSONException;
    protected abstract void get_tickers(int depth) throws JSONException;

    public PairData get_pair_info( Pair<String, String> pair )
    {
        try
        {
            return pairs_data.get(pair_translator(pair));
        }
        catch (RuntimeException e)
        {
            return null;
        }
    }

}