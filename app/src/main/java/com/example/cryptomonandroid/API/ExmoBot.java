package com.example.cryptomonandroid.API;

import android.util.AndroidRuntimeException;
import android.util.Pair;
import java.util.HashMap;
import com.example.cryptomonandroid.API.exmo.Exmo;
import org.json.*;


public class ExmoBot extends Bot {

    private Exmo bot;

    private final String[] coins = new String[]{"EXM", "USD", "EUR", "RUB", "PLN", "TRY", "UAH", "BTC", "LTC", "DOGE",
            "DASH", "ETH", "WAVES", "ZEC", "USDT", "XMR", "XRP", "KICK", "ETC", "BCH", "BTG", "EOS",
            "BTCZ", "DXT", "XLM", "MNX", "OMG", "TRX", "ADA", "INK", "NEO", "GAS", "ZRX", "GNT", "GUSD",
            "LSK", "XEM", "SMART", "QTUM", "HB", "DAI", "MKR", "MNC", "PTI", "ATMCASH", "ETZ", "USDC",
            "ROOBEE", "DCR", "XTZ", "ZAG", "BTT", "VLX"};

    public ExmoBot(){
        bot = new Exmo(" ", " ");
        this.Name = "Exmo";

        tradeable_coins = (HashMap<Pair<String, String>, String>) dictionary_of_pairs_name.clone();

    }

    private boolean in_coins(String s){
        for(int i = 0; i < coins.length; i++){
            if(coins[i] == s){
                return true;
            }
        }
        return false;
    }

    @Override
    protected String pair_translator(Pair<String, String> pair) {
        String res;
        try
        {
            if (super.dictionary_of_pairs_name.containsKey(pair))
                return super.dictionary_of_pairs_name.get(pair);
            if (in_coins(pair.first) && in_coins(pair.second))
            {
                res = (pair.first) + '_' + (pair.second);
                res.toUpperCase();
                super.dictionary_of_pairs_name.put(pair, res);
                return res;
            }
        }
        catch (Exception e)
        {
        }
        return "don't exist";
    }

    @Override
    protected void get_order_books(int depth) throws JSONException {
        HashMap<String, String> request_line = new HashMap<String, String>();
        request_line.put("pair", "");

        for (String s : tradeable_coins.values())
        {
            request_line.put("pair", request_line.get("pair") + s + ',');
        }

        request_line.put("limit", String.valueOf(depth));
        String answer;
        try {
            answer = bot.Request("order_book", request_line);
        }
        catch (AndroidRuntimeException e){
            return;
        }
        JSONObject order_book = null;

        try {
            order_book = new JSONObject(answer);
        }
        catch (JSONException je){
            System.out.print(je.toString());
        }
        for (String p : tradeable_coins.values())
        {
            try
            {
                if (!pairs_data.containsKey(p))
                {
                    pairs_data.put(p, new PairData());
                }
                JSONObject pair_json = order_book.getJSONObject(p);

                JSONArray asks_json = pair_json.getJSONArray("ask");
                JSONArray bids_json = pair_json.getJSONArray("bid");


                pairs_data.get(p). Asks.clear();
                pairs_data.get(p). Bids.clear();

                for (int i = 0; i < depth; i++)
                {
                    pairs_data.get(p). Asks.add(new Pair<Double, Double>(
                            asks_json.getJSONArray(i).getDouble(0),
                            asks_json.getJSONArray(i).getDouble(1)));

                    pairs_data.get(p). Bids.add(new Pair<Double, Double>(
                            bids_json.getJSONArray(i).getDouble(0),
                            bids_json.getJSONArray(i).getDouble(1)));
                }

            }
            catch (RuntimeException e)
            {
                System.out.println("Exmo order book" + e);
            }
        }
    }

    protected void get_tickers(int depth) throws JSONException{
        JSONObject ticker = null;
        String answer;
        try {
            answer = bot.Request("ticker", null);
        }
        catch (AndroidRuntimeException e){
            return;
        }
        try
        {
            ticker = new JSONObject(answer);
        }
        catch (Exception je){
            System.out.print(je.toString());
        }
        for (String p : tradeable_coins.values())
        {
            try
            {
                if (!pairs_data.containsKey(p))
                {
                    pairs_data.put(p, new PairData());
                }
                JSONObject pair_json = ticker.getJSONObject(p);

                pairs_data.get(p).exchagename = super.Name;
                 pairs_data.get(p).pairname = p;
                 pairs_data.get(p).depth = depth;
                 pairs_data.get(p).lastprice = pair_json.getDouble("last_trade");
                 pairs_data.get(p).volume = pair_json.getDouble("vol");;
                 pairs_data.get(p).openingprice = -1.0;
                 pairs_data.get(p).lowprice = pair_json.getDouble("low");
                 pairs_data.get(p).hightprice = pair_json.getDouble("high");
            }
            catch (JSONException je){
                ;
            }
        }
    };

    public void reload_data()
    {
        reload_data(50);
    }
}