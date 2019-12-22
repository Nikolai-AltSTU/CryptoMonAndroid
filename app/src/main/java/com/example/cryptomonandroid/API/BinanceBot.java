package com.example.cryptomonandroid.API;

import android.provider.Settings;
import android.util.Pair;
import com.binance.api.client.domain.market.BookTicker;
import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.*;


public class BinanceBot extends Bot {

    BinanceApiClientFactory factory;
    BinanceApiRestClient client;

    public BinanceBot(){
        BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance("API-KEY", "SECRET");
        BinanceApiRestClient client = factory.newRestClient();
    }

    @Override
    protected String pair_translator(Pair<String, String> pair) {

        return null;
    }

    @Override
    public void reload_data(int depth) {

    }
}
