package com.example.cryptomonandroid.API;


public class PairData extends Object{

    public PairData() {
        this(50);
    }

    public PairData(int depth) {
        setDepth(depth);
        setPair_name("none");
        setExchage_name("none");
        setLast_price(0.0);
        setSpread(0.3);

    }

    private String _pair_name;

    public String getPair_name() {
        return _pair_name;
    }

    public String setPair_name(String value) {
        _pair_name = value;
        return _pair_name;
    }


    private String _exchage_name;

    public String getExchage_name() {
        return _exchage_name;
    }

    public String setExchage_name(String value) {
        _exchage_name = value;
        return _exchage_name;
    }


    private double _last_price;

    public double getLast_price() {
        return _last_price;
    }

    public void setLast_price(double value) {
        _last_price = value;
    }


    private int _depth;

    public int getDepth() {
        return _depth;
    }

    public void setDepth(int value) {
        _depth = value;
    }


    private double _spread;

    public double getSpread() {
        return _spread;
    }

    public void setSpread(double value) {
        _spread = value;
    }


    private double _volume;

    public double getVolume() {
        return _volume;
    }

    public void setVolume(double value) {
        _volume = value;
    }


    private double _low_price;

    public double getLow_price() {
        return _low_price;
    }

    public void setLow_price(double value) {
        _low_price = value;
    }


    private double _hight_price;

    public double getHight_price() {
        return _hight_price;
    }

    public void setHight_price(double value) {
        _hight_price = value;
    }


    private double _opening_price;

    public double getOpening_price() {
        return _opening_price;
    }

    public void setOpening_price(double value) {
        _opening_price = value;
    }

};
