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

    public double lastprice;

    public int depth;

    public double spread;

    public double volume;

    public double lowprice;

    public double hightprice;

    public double openingprice;

    public Vector<Pair<Double, Double>> Asks;
    public Vector<Pair<Double, Double>> Bids;

};
