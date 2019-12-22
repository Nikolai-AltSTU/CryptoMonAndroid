package com.example.cryptomonandroid.API;

import android.util.Pair;
import java.util.HashMap;
import com.example.cryptomonandroid.API.exmo.Exmo;

public class ExmoBot extends Bot {

    private Exmo bot;

    private final String[] coins = new String[]{"EXM", "USD", "EUR", "RUB", "PLN", "TRY", "UAH", "BTC", "LTC", "DOGE",
            "DASH", "ETH", "WAVES", "ZEC", "USDT", "XMR", "XRP", "KICK", "ETC", "BCH", "BTG", "EOS",
            "BTCZ", "DXT", "XLM", "MNX", "OMG", "TRX", "ADA", "INK", "NEO", "GAS", "ZRX", "GNT", "GUSD",
            "LSK", "XEM", "SMART", "QTUM", "HB", "DAI", "MKR", "MNC", "PTI", "ATMCASH", "ETZ", "USDC",
            "ROOBEE", "DCR", "XTZ", "ZAG", "BTT", "VLX"};


    public ExmoBot(){
        bot = new Exmo(" ", " ");
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

    private void get_order_books(int depth)
    {

        HashMap<String, String> request_line = new HashMap<String, String>();
        request_line.put("pair", "BTC_USD");
        request_line.put("limit", "50");

       /* for (String s : dictionary_of_pairs_name.values())
        {
            request_line.put("pair", request_line.get("pair") + s + ',');
        }
        */
        //request_line.put("limit", String.valueOf(depth));

        //JSONObject order_book = new JSONObject();

        String answer = bot.Request("order_book", request_line);

        /*
        for (String p : dictionary_of_pairs_name.values())
        {
            try
            {
                if (!pair_dic.containsKey(p))
                {
                    pair_dic.put(p, new PairData());
                }
                /*
                ArrayList<Object> ask = order_book[p]["ask"].ToList();
                ArrayList<Object> bid = order_book[p]["bid"].ToList();

                for (int i = 0; i < depth; i++)
                {
//C# TO JAVA CONVERTER TODO TASK: Tuple variables are not converted by C# to Java Converter:
                    Pair<Double, Double> asks = new Pair<Double, Double>(0.0, 0.0);
//C# TO JAVA CONVERTER TODO TASK: Tuple variables are not converted by C# to Java Converter:
                    Pair<Double, Double> bids = new Pair<Double, Double>(0.0, 0.0);
                    /*
                    ArrayList<Object> a = ask.get(i).ToList();
                    ArrayList<Object> b = bid.get(i).ToList();

                    tangible.OutObject<Double> tempOut_Item1 = new tangible.OutObject<Double>();
                    tangible.TryParseHelper.tryParseDouble(a.get(0).toString(), tempOut_Item1);
                    asks.Item1 = tempOut_Item1.argValue;
                    tangible.OutObject<Double> tempOut_Item2 = new tangible.OutObject<Double>();
                    tangible.TryParseHelper.tryParseDouble(a.get(1).toString(), tempOut_Item2);
                    asks.Item2 = tempOut_Item2.argValue;
                    tangible.OutObject<Double> tempOut_Item12 = new tangible.OutObject<Double>();
                    tangible.TryParseHelper.tryParseDouble(b.get(0).toString(), tempOut_Item12);
                    bids.Item1 = tempOut_Item12.argValue;
                    tangible.OutObject<Double> tempOut_Item22 = new tangible.OutObject<Double>();
                    tangible.TryParseHelper.tryParseDouble(b.get(1).toString(), tempOut_Item22);
                    bids.Item2 = tempOut_Item22.argValue;
                    if (asks.Item1 == 0 || asks.Item2 == 0)
                    {
                        tangible.OutObject<Double> tempOut_Item13 = new tangible.OutObject<Double>();
                        tangible.TryParseHelper.tryParseDouble(a.get(0).toString().replace('.', ','), tempOut_Item13);
                        asks.Item1 = tempOut_Item13.argValue;
                        tangible.OutObject<Double> tempOut_Item23 = new tangible.OutObject<Double>();
                        tangible.TryParseHelper.tryParseDouble(a.get(1).toString().replace('.', ','), tempOut_Item23);
                        asks.Item2 = tempOut_Item23.argValue;
                        tangible.OutObject<Double> tempOut_Item14 = new tangible.OutObject<Double>();
                        tangible.TryParseHelper.tryParseDouble(b.get(0).toString().replace('.', ','), tempOut_Item14);
                        bids.Item1 = tempOut_Item14.argValue;
                        tangible.OutObject<Double> tempOut_Item24 = new tangible.OutObject<Double>();
                        tangible.TryParseHelper.tryParseDouble(b.get(1).toString().replace('.', ','), tempOut_Item24);
                        bids.Item2 = tempOut_Item24.argValue;
                    }

                    pair_dic[p].Asks.Add(asks);
                    pair_dic[p].Bids.Add(bids);
                }

            }
            catch (RuntimeException e)
            {
                System.out.println("Exmo order book" + e);
            }
        }*/
    }

    public void reload_data()
    {
        reload_data(50);
    }

    @Override
    public void reload_data(int depth) {
        //get_order_books(depth);
    }
}