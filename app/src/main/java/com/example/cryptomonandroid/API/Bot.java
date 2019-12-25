package com.example.cryptomonandroid.API;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;

import java.util.*;

public abstract class Bot {


    protected HashMap<Pair<String, String>, String> dictionary_of_pairs_name;
    protected HashMap<Pair<String, String>, String>  tradeable_coins;
    public Bot()
    {
        dictionary_of_pairs_name = new HashMap<Pair<String, String>, String>();
        pair_dic = new HashMap<String, PairData>();
        tradeable_coins = new HashMap<Pair<String, String> , String>();
    }

    public String Name;
    protected HashMap<String, PairData> pair_dic;

    protected abstract String pair_translator(Pair<String, String> pair);
    public final void setPairs(ArrayList<Pair<String, String>> pairs)
    {
        if (pairs != null)
        {
            this.dictionary_of_pairs_name.clear();
            for (Pair<String, String> pair: pairs)
            {
                pair_translator(pair);
            }
        }
    }

    public final void add_pairs(ArrayList<Pair<String, String>> pairs)
    {
        if (!pairs.isEmpty())
        {
            for (Pair<String, String> p : pairs)
            {
                pair_translator(p);
            }
        }
    }


    public abstract void reload_data(int depth);
    protected abstract void get_order_books(int depth);

    public PairData get_pair_info( Pair<String, String> pair )
    {
        try
        {
            return pair_dic.get(pair_translator(pair));
        }
        catch (RuntimeException e)
        {
            return null;
        }
    }

}