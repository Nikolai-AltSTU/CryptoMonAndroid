package com.example.cryptomonandroid.API;


import android.util.Pair;

import java.util.Vector;

public class PairData extends Object{

    public PairData() {
        this(50);
    }

    public PairData(int depth) {
        this.depth = depth;
        Asks = new Vector<>(depth);
        Bids = new Vector<>(depth);
    }

    public String pairname;

    public String exchagename;

    public Double lastprice;

    public int depth;

    public Double spread;

    public Double volume;

    public Double lowprice;

    public Double hightprice;

    public Double openingprice;

    public Vector<Pair<Double, Double>> Asks;
    public Vector<Pair<Double, Double>> Bids;

};
