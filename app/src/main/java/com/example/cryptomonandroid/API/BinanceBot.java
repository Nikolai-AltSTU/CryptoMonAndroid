package com.example.cryptomonandroid.API;

import android.util.Pair;

import com.binance.api.client.domain.general.ExchangeInfo;
import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.domain.market.OrderBook;
import com.binance.api.client.domain.market.TickerPrice;

import java.util.HashMap;
import java.util.List;


public class BinanceBot extends Bot {

    BinanceApiClientFactory factory;
    BinanceApiRestClient client;

    public BinanceBot(){

        Thread con =  new Thread(

                new Runnable() {
                    public void run() {
                        try {
                            connect();
                        }catch (Exception je){
                            System.out.print(je.toString());
                        }
                    }
                }
        );
        con.start();
}

    private void connect() {
        factory = BinanceApiClientFactory.newInstance("", "");
        client = factory.newRestClient();
        set_dictionary_of_pairs_name();
    }

    private void set_dictionary_of_pairs_name(){

        dictionary_of_pairs_name.put(new Pair<String, String>("ETH", "BTC"), "ETHBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("LTC", "BTC"), "LTCBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("BNB", "BTC"), "BNBBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("NEO", "BTC"), "NEOBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("QTUM", "ETH"), "QTUMETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("EOS", "ETH"), "EOSETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("SNT", "ETH"), "SNTETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("BNT", "ETH"), "BNTETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("BCC", "BTC"), "BCCBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("GAS", "BTC"), "GASBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("BNB", "ETH"), "BNBETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("BTC", "USDT"), "BTCUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("ETH", "USDT"), "ETHUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("HSR", "BTC"), "HSRBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("OAX", "ETH"), "OAXETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("DNT", "ETH"), "DNTETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("MCO", "ETH"), "MCOETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("ICN", "ETH"), "ICNETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("MCO", "BTC"), "MCOBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("WTC", "BTC"), "WTCBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("WTC", "ETH"), "WTCETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("LRC", "BTC"), "LRCBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("LRC", "ETH"), "LRCETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("QTUM", "BTC"), "QTUMBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("YOYO", "BTC"), "YOYOBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("OMG", "BTC"), "OMGBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("OMG", "ETH"), "OMGETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("ZRX", "BTC"), "ZRXBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("ZRX", "ETH"), "ZRXETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("STRAT", "BTC"), "STRATBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("STRAT", "ETH"), "STRATETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("SNGLS", "BTC"), "SNGLSBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("SNGLS", "ETH"), "SNGLSETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("BQX", "BTC"), "BQXBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("BQX", "ETH"), "BQXETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("KNC", "BTC"), "KNCBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("KNC", "ETH"), "KNCETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("FUN", "BTC"), "FUNBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("FUN", "ETH"), "FUNETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("SNM", "BTC"), "SNMBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("SNM", "ETH"), "SNMETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("NEO", "ETH"), "NEOETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("IOTA", "BTC"), "IOTABTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("IOTA", "ETH"), "IOTAETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("LINK", "BTC"), "LINKBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("LINK", "ETH"), "LINKETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("XVG", "BTC"), "XVGBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("XVG", "ETH"), "XVGETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("SALT", "BTC"), "SALTBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("SALT", "ETH"), "SALTETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("MDA", "BTC"), "MDABTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("MDA", "ETH"), "MDAETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("MTL", "BTC"), "MTLBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("MTL", "ETH"), "MTLETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("SUB", "BTC"), "SUBBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("SUB", "ETH"), "SUBETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("EOS", "BTC"), "EOSBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("SNT", "BTC"), "SNTBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("ETC", "ETH"), "ETCETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("ETC", "BTC"), "ETCBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("MTH", "BTC"), "MTHBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("MTH", "ETH"), "MTHETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("ENG", "BTC"), "ENGBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("ENG", "ETH"), "ENGETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("DNT", "BTC"), "DNTBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("ZEC", "BTC"), "ZECBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("ZEC", "ETH"), "ZECETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("BNT", "BTC"), "BNTBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("AST", "BTC"), "ASTBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("AST", "ETH"), "ASTETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("DASH", "BTC"), "DASHBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("DASH", "ETH"), "DASHETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("OAX", "BTC"), "OAXBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("ICN", "BTC"), "ICNBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("BTG", "BTC"), "BTGBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("BTG", "ETH"), "BTGETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("EVX", "BTC"), "EVXBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("EVX", "ETH"), "EVXETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("REQ", "BTC"), "REQBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("REQ", "ETH"), "REQETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("VIB", "BTC"), "VIBBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("VIB", "ETH"), "VIBETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("HSR", "ETH"), "HSRETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("TRX", "BTC"), "TRXBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("TRX", "ETH"), "TRXETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("POWR", "BTC"), "POWRBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("POWR", "ETH"), "POWRETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("ARK", "BTC"), "ARKBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("ARK", "ETH"), "ARKETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("YOYO", "ETH"), "YOYOETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("XRP", "BTC"), "XRPBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("XRP", "ETH"), "XRPETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("MOD", "BTC"), "MODBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("MOD", "ETH"), "MODETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("ENJ", "BTC"), "ENJBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("ENJ", "ETH"), "ENJETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("STORJ", "BTC"), "STORJBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("STORJ", "ETH"), "STORJETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("BNB", "USDT"), "BNBUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("VEN", "BNB"), "VENBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("YOYO", "BNB"), "YOYOBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("POWR", "BNB"), "POWRBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("VEN", "BTC"), "VENBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("VEN", "ETH"), "VENETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("KMD", "BTC"), "KMDBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("KMD", "ETH"), "KMDETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("NULS", "BNB"), "NULSBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("RCN", "BTC"), "RCNBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("RCN", "ETH"), "RCNETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("RCN", "BNB"), "RCNBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("NULS", "BTC"), "NULSBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("NULS", "ETH"), "NULSETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("RDN", "BTC"), "RDNBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("RDN", "ETH"), "RDNETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("RDN", "BNB"), "RDNBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("XMR", "BTC"), "XMRBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("XMR", "ETH"), "XMRETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("DLT", "BNB"), "DLTBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("WTC", "BNB"), "WTCBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("DLT", "BTC"), "DLTBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("DLT", "ETH"), "DLTETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("AMB", "BTC"), "AMBBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("AMB", "ETH"), "AMBETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("AMB", "BNB"), "AMBBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("BCC", "ETH"), "BCCETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("BCC", "USDT"), "BCCUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("BCC", "BNB"), "BCCBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("BAT", "BTC"), "BATBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("BAT", "ETH"), "BATETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("BAT", "BNB"), "BATBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("BCPT", "BTC"), "BCPTBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("BCPT", "ETH"), "BCPTETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("BCPT", "BNB"), "BCPTBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("ARN", "BTC"), "ARNBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("ARN", "ETH"), "ARNETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("GVT", "BTC"), "GVTBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("GVT", "ETH"), "GVTETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("CDT", "BTC"), "CDTBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("CDT", "ETH"), "CDTETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("GXS", "BTC"), "GXSBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("GXS", "ETH"), "GXSETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("NEO", "USDT"), "NEOUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("NEO", "BNB"), "NEOBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("POE", "BTC"), "POEBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("POE", "ETH"), "POEETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("QSP", "BTC"), "QSPBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("QSP", "ETH"), "QSPETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("QSP", "BNB"), "QSPBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("BTS", "BTC"), "BTSBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("BTS", "ETH"), "BTSETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("BTS", "BNB"), "BTSBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("XZC", "BTC"), "XZCBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("XZC", "ETH"), "XZCETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("XZC", "BNB"), "XZCBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("LSK", "BTC"), "LSKBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("LSK", "ETH"), "LSKETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("LSK", "BNB"), "LSKBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("TNT", "BTC"), "TNTBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("TNT", "ETH"), "TNTETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("FUEL", "BTC"), "FUELBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("FUEL", "ETH"), "FUELETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("MANA", "BTC"), "MANABTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("MANA", "ETH"), "MANAETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("BCD", "BTC"), "BCDBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("BCD", "ETH"), "BCDETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("DGD", "BTC"), "DGDBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("DGD", "ETH"), "DGDETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("IOTA", "BNB"), "IOTABNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("ADX", "BTC"), "ADXBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("ADX", "ETH"), "ADXETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("ADX", "BNB"), "ADXBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("ADA", "BTC"), "ADABTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("ADA", "ETH"), "ADAETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("PPT", "BTC"), "PPTBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("PPT", "ETH"), "PPTETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("CMT", "BTC"), "CMTBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("CMT", "ETH"), "CMTETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("CMT", "BNB"), "CMTBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("XLM", "BTC"), "XLMBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("XLM", "ETH"), "XLMETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("XLM", "BNB"), "XLMBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("CND", "BTC"), "CNDBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("CND", "ETH"), "CNDETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("CND", "BNB"), "CNDBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("LEND", "BTC"), "LENDBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("LEND", "ETH"), "LENDETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("WABI", "BTC"), "WABIBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("WABI", "ETH"), "WABIETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("WABI", "BNB"), "WABIBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("LTC", "ETH"), "LTCETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("LTC", "USDT"), "LTCUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("LTC", "BNB"), "LTCBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("TNB", "BTC"), "TNBBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("TNB", "ETH"), "TNBETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("WAVES", "BTC"), "WAVESBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("WAVES", "ETH"), "WAVESETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("WAVES", "BNB"), "WAVESBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("GTO", "BTC"), "GTOBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("GTO", "ETH"), "GTOETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("GTO", "BNB"), "GTOBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("ICX", "BTC"), "ICXBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("ICX", "ETH"), "ICXETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("ICX", "BNB"), "ICXBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("OST", "BTC"), "OSTBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("OST", "ETH"), "OSTETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("OST", "BNB"), "OSTBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("ELF", "BTC"), "ELFBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("ELF", "ETH"), "ELFETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("AION", "BTC"), "AIONBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("AION", "ETH"), "AIONETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("AION", "BNB"), "AIONBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("NEBL", "BTC"), "NEBLBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("NEBL", "ETH"), "NEBLETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("NEBL", "BNB"), "NEBLBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("BRD", "BTC"), "BRDBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("BRD", "ETH"), "BRDETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("BRD", "BNB"), "BRDBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("MCO", "BNB"), "MCOBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("EDO", "BTC"), "EDOBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("EDO", "ETH"), "EDOETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("WINGS", "BTC"), "WINGSBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("WINGS", "ETH"), "WINGSETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("NAV", "BTC"), "NAVBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("NAV", "ETH"), "NAVETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("NAV", "BNB"), "NAVBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("LUN", "BTC"), "LUNBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("LUN", "ETH"), "LUNETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("TRIG", "BTC"), "TRIGBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("TRIG", "ETH"), "TRIGETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("TRIG", "BNB"), "TRIGBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("APPC", "BTC"), "APPCBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("APPC", "ETH"), "APPCETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("APPC", "BNB"), "APPCBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("VIBE", "BTC"), "VIBEBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("VIBE", "ETH"), "VIBEETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("RLC", "BTC"), "RLCBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("RLC", "ETH"), "RLCETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("RLC", "BNB"), "RLCBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("INS", "BTC"), "INSBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("INS", "ETH"), "INSETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("PIVX", "BTC"), "PIVXBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("PIVX", "ETH"), "PIVXETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("PIVX", "BNB"), "PIVXBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("IOST", "BTC"), "IOSTBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("IOST", "ETH"), "IOSTETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("CHAT", "BTC"), "CHATBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("CHAT", "ETH"), "CHATETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("STEEM", "BTC"), "STEEMBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("STEEM", "ETH"), "STEEMETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("STEEM", "BNB"), "STEEMBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("NANO", "BTC"), "NANOBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("NANO", "ETH"), "NANOETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("NANO", "BNB"), "NANOBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("VIA", "BTC"), "VIABTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("VIA", "ETH"), "VIAETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("VIA", "BNB"), "VIABNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("BLZ", "BTC"), "BLZBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("BLZ", "ETH"), "BLZETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("BLZ", "BNB"), "BLZBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("AE", "BTC"), "AEBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("AE", "ETH"), "AEETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("AE", "BNB"), "AEBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("RPX", "BTC"), "RPXBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("RPX", "ETH"), "RPXETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("RPX", "BNB"), "RPXBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("NCASH", "BTC"), "NCASHBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("NCASH", "ETH"), "NCASHETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("NCASH", "BNB"), "NCASHBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("POA", "BTC"), "POABTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("POA", "ETH"), "POAETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("POA", "BNB"), "POABNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("ZIL", "BTC"), "ZILBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("ZIL", "ETH"), "ZILETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("ZIL", "BNB"), "ZILBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("ONT", "BTC"), "ONTBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("ONT", "ETH"), "ONTETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("ONT", "BNB"), "ONTBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("STORM", "BTC"), "STORMBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("STORM", "ETH"), "STORMETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("STORM", "BNB"), "STORMBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("QTUM", "BNB"), "QTUMBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("QTUM", "USDT"), "QTUMUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("XEM", "BTC"), "XEMBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("XEM", "ETH"), "XEMETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("XEM", "BNB"), "XEMBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("WAN", "BTC"), "WANBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("WAN", "ETH"), "WANETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("WAN", "BNB"), "WANBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("WPR", "BTC"), "WPRBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("WPR", "ETH"), "WPRETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("QLC", "BTC"), "QLCBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("QLC", "ETH"), "QLCETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("SYS", "BTC"), "SYSBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("SYS", "ETH"), "SYSETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("SYS", "BNB"), "SYSBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("QLC", "BNB"), "QLCBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("GRS", "BTC"), "GRSBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("GRS", "ETH"), "GRSETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("ADA", "USDT"), "ADAUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("ADA", "BNB"), "ADABNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("CLOAK", "BTC"), "CLOAKBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("CLOAK", "ETH"), "CLOAKETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("GNT", "BTC"), "GNTBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("GNT", "ETH"), "GNTETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("GNT", "BNB"), "GNTBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("LOOM", "BTC"), "LOOMBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("LOOM", "ETH"), "LOOMETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("LOOM", "BNB"), "LOOMBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("XRP", "USDT"), "XRPUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("BCN", "BTC"), "BCNBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("BCN", "ETH"), "BCNETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("BCN", "BNB"), "BCNBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("REP", "BTC"), "REPBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("REP", "ETH"), "REPETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("REP", "BNB"), "REPBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("BTC", "TUSD"), "BTCTUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("TUSD", "BTC"), "TUSDBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("ETH", "TUSD"), "ETHTUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("TUSD", "ETH"), "TUSDETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("TUSD", "BNB"), "TUSDBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("ZEN", "BTC"), "ZENBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("ZEN", "ETH"), "ZENETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("ZEN", "BNB"), "ZENBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("SKY", "BTC"), "SKYBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("SKY", "ETH"), "SKYETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("SKY", "BNB"), "SKYBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("EOS", "USDT"), "EOSUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("EOS", "BNB"), "EOSBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("CVC", "BTC"), "CVCBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("CVC", "ETH"), "CVCETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("CVC", "BNB"), "CVCBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("THETA", "BTC"), "THETABTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("THETA", "ETH"), "THETAETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("THETA", "BNB"), "THETABNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("XRP", "BNB"), "XRPBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("TUSD", "USDT"), "TUSDUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("IOTA", "USDT"), "IOTAUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("XLM", "USDT"), "XLMUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("IOTX", "BTC"), "IOTXBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("IOTX", "ETH"), "IOTXETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("QKC", "BTC"), "QKCBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("QKC", "ETH"), "QKCETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("AGI", "BTC"), "AGIBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("AGI", "ETH"), "AGIETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("AGI", "BNB"), "AGIBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("NXS", "BTC"), "NXSBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("NXS", "ETH"), "NXSETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("NXS", "BNB"), "NXSBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("ENJ", "BNB"), "ENJBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("DATA", "BTC"), "DATABTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("DATA", "ETH"), "DATAETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("ONT", "USDT"), "ONTUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("TRX", "BNB"), "TRXBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("TRX", "USDT"), "TRXUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("ETC", "USDT"), "ETCUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("ETC", "BNB"), "ETCBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("ICX", "USDT"), "ICXUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("SC", "BTC"), "SCBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("SC", "ETH"), "SCETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("SC", "BNB"), "SCBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("NPXS", "BTC"), "NPXSBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("NPXS", "ETH"), "NPXSETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("VEN", "USDT"), "VENUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("KEY", "BTC"), "KEYBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("KEY", "ETH"), "KEYETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("NAS", "BTC"), "NASBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("NAS", "ETH"), "NASETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("NAS", "BNB"), "NASBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("MFT", "BTC"), "MFTBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("MFT", "ETH"), "MFTETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("MFT", "BNB"), "MFTBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("DENT", "BTC"), "DENTBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("DENT", "ETH"), "DENTETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("ARDR", "BTC"), "ARDRBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("ARDR", "ETH"), "ARDRETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("ARDR", "BNB"), "ARDRBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("NULS", "USDT"), "NULSUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("HOT", "BTC"), "HOTBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("HOT", "ETH"), "HOTETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("VET", "BTC"), "VETBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("VET", "ETH"), "VETETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("VET", "USDT"), "VETUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("VET", "BNB"), "VETBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("DOCK", "BTC"), "DOCKBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("DOCK", "ETH"), "DOCKETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("POLY", "BTC"), "POLYBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("POLY", "BNB"), "POLYBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("PHX", "BTC"), "PHXBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("PHX", "ETH"), "PHXETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("PHX", "BNB"), "PHXBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("HC", "BTC"), "HCBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("HC", "ETH"), "HCETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("GO", "BTC"), "GOBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("GO", "BNB"), "GOBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("PAX", "BTC"), "PAXBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("PAX", "BNB"), "PAXBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("PAX", "USDT"), "PAXUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("PAX", "ETH"), "PAXETH");
        dictionary_of_pairs_name.put(new Pair<String, String>("RVN", "BTC"), "RVNBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("RVN", "BNB"), "RVNBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("DCR", "BTC"), "DCRBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("DCR", "BNB"), "DCRBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("USDC", "BNB"), "USDCBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("MITH", "BTC"), "MITHBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("MITH", "BNB"), "MITHBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("BCHABC", "BTC"), "BCHABCBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("BCHSV", "BTC"), "BCHSVBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("BCHABC", "USDT"), "BCHABCUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("BCHSV", "USDT"), "BCHSVUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("BNB", "PAX"), "BNBPAX");
        dictionary_of_pairs_name.put(new Pair<String, String>("BTC", "PAX"), "BTCPAX");
        dictionary_of_pairs_name.put(new Pair<String, String>("ETH", "PAX"), "ETHPAX");
        dictionary_of_pairs_name.put(new Pair<String, String>("XRP", "PAX"), "XRPPAX");
        dictionary_of_pairs_name.put(new Pair<String, String>("EOS", "PAX"), "EOSPAX");
        dictionary_of_pairs_name.put(new Pair<String, String>("XLM", "PAX"), "XLMPAX");
        dictionary_of_pairs_name.put(new Pair<String, String>("REN", "BTC"), "RENBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("REN", "BNB"), "RENBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("BNB", "TUSD"), "BNBTUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("XRP", "TUSD"), "XRPTUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("EOS", "TUSD"), "EOSTUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("XLM", "TUSD"), "XLMTUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("BNB", "USDC"), "BNBUSDC");
        dictionary_of_pairs_name.put(new Pair<String, String>("BTC", "USDC"), "BTCUSDC");
        dictionary_of_pairs_name.put(new Pair<String, String>("ETH", "USDC"), "ETHUSDC");
        dictionary_of_pairs_name.put(new Pair<String, String>("XRP", "USDC"), "XRPUSDC");
        dictionary_of_pairs_name.put(new Pair<String, String>("EOS", "USDC"), "EOSUSDC");
        dictionary_of_pairs_name.put(new Pair<String, String>("XLM", "USDC"), "XLMUSDC");
        dictionary_of_pairs_name.put(new Pair<String, String>("USDC", "USDT"), "USDCUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("ADA", "TUSD"), "ADATUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("TRX", "TUSD"), "TRXTUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("NEO", "TUSD"), "NEOTUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("TRX", "XRP"), "TRXXRP");
        dictionary_of_pairs_name.put(new Pair<String, String>("XZC", "XRP"), "XZCXRP");
        dictionary_of_pairs_name.put(new Pair<String, String>("PAX", "TUSD"), "PAXTUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("USDC", "TUSD"), "USDCTUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("USDC", "PAX"), "USDCPAX");
        dictionary_of_pairs_name.put(new Pair<String, String>("LINK", "USDT"), "LINKUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("LINK", "TUSD"), "LINKTUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("LINK", "PAX"), "LINKPAX");
        dictionary_of_pairs_name.put(new Pair<String, String>("LINK", "USDC"), "LINKUSDC");
        dictionary_of_pairs_name.put(new Pair<String, String>("WAVES", "USDT"), "WAVESUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("WAVES", "TUSD"), "WAVESTUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("WAVES", "PAX"), "WAVESPAX");
        dictionary_of_pairs_name.put(new Pair<String, String>("WAVES", "USDC"), "WAVESUSDC");
        dictionary_of_pairs_name.put(new Pair<String, String>("BCHABC", "TUSD"), "BCHABCTUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("BCHABC", "PAX"), "BCHABCPAX");
        dictionary_of_pairs_name.put(new Pair<String, String>("BCHABC", "USDC"), "BCHABCUSDC");
        dictionary_of_pairs_name.put(new Pair<String, String>("BCHSV", "TUSD"), "BCHSVTUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("BCHSV", "PAX"), "BCHSVPAX");
        dictionary_of_pairs_name.put(new Pair<String, String>("BCHSV", "USDC"), "BCHSVUSDC");
        dictionary_of_pairs_name.put(new Pair<String, String>("LTC", "TUSD"), "LTCTUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("LTC", "PAX"), "LTCPAX");
        dictionary_of_pairs_name.put(new Pair<String, String>("LTC", "USDC"), "LTCUSDC");
        dictionary_of_pairs_name.put(new Pair<String, String>("TRX", "PAX"), "TRXPAX");
        dictionary_of_pairs_name.put(new Pair<String, String>("TRX", "USDC"), "TRXUSDC");
        dictionary_of_pairs_name.put(new Pair<String, String>("BTT", "BTC"), "BTTBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("BTT", "BNB"), "BTTBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("BTT", "USDT"), "BTTUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("BNB", "USDS"), "BNBUSDS");
        dictionary_of_pairs_name.put(new Pair<String, String>("BTC", "USDS"), "BTCUSDS");
        dictionary_of_pairs_name.put(new Pair<String, String>("USDS", "USDT"), "USDSUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("USDS", "PAX"), "USDSPAX");
        dictionary_of_pairs_name.put(new Pair<String, String>("USDS", "TUSD"), "USDSTUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("USDS", "USDC"), "USDSUSDC");
        dictionary_of_pairs_name.put(new Pair<String, String>("BTT", "PAX"), "BTTPAX");
        dictionary_of_pairs_name.put(new Pair<String, String>("BTT", "TUSD"), "BTTTUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("BTT", "USDC"), "BTTUSDC");
        dictionary_of_pairs_name.put(new Pair<String, String>("ONG", "BNB"), "ONGBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("ONG", "BTC"), "ONGBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("ONG", "USDT"), "ONGUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("HOT", "BNB"), "HOTBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("HOT", "USDT"), "HOTUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("ZIL", "USDT"), "ZILUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("ZRX", "BNB"), "ZRXBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("ZRX", "USDT"), "ZRXUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("FET", "BNB"), "FETBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("FET", "BTC"), "FETBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("FET", "USDT"), "FETUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("BAT", "USDT"), "BATUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("XMR", "BNB"), "XMRBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("XMR", "USDT"), "XMRUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("ZEC", "BNB"), "ZECBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("ZEC", "USDT"), "ZECUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("ZEC", "PAX"), "ZECPAX");
        dictionary_of_pairs_name.put(new Pair<String, String>("ZEC", "TUSD"), "ZECTUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("ZEC", "USDC"), "ZECUSDC");
        dictionary_of_pairs_name.put(new Pair<String, String>("IOST", "BNB"), "IOSTBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("IOST", "USDT"), "IOSTUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("CELR", "BNB"), "CELRBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("CELR", "BTC"), "CELRBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("CELR", "USDT"), "CELRUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("ADA", "PAX"), "ADAPAX");
        dictionary_of_pairs_name.put(new Pair<String, String>("ADA", "USDC"), "ADAUSDC");
        dictionary_of_pairs_name.put(new Pair<String, String>("NEO", "PAX"), "NEOPAX");
        dictionary_of_pairs_name.put(new Pair<String, String>("NEO", "USDC"), "NEOUSDC");
        dictionary_of_pairs_name.put(new Pair<String, String>("DASH", "BNB"), "DASHBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("DASH", "USDT"), "DASHUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("NANO", "USDT"), "NANOUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("OMG", "BNB"), "OMGBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("OMG", "USDT"), "OMGUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("THETA", "USDT"), "THETAUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("ENJ", "USDT"), "ENJUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("MITH", "USDT"), "MITHUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("MATIC", "BNB"), "MATICBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("MATIC", "BTC"), "MATICBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("MATIC", "USDT"), "MATICUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("ATOM", "BNB"), "ATOMBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("ATOM", "BTC"), "ATOMBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("ATOM", "USDT"), "ATOMUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("ATOM", "USDC"), "ATOMUSDC");
        dictionary_of_pairs_name.put(new Pair<String, String>("ATOM", "PAX"), "ATOMPAX");
        dictionary_of_pairs_name.put(new Pair<String, String>("ATOM", "TUSD"), "ATOMTUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("ETC", "USDC"), "ETCUSDC");
        dictionary_of_pairs_name.put(new Pair<String, String>("ETC", "PAX"), "ETCPAX");
        dictionary_of_pairs_name.put(new Pair<String, String>("ETC", "TUSD"), "ETCTUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("BAT", "USDC"), "BATUSDC");
        dictionary_of_pairs_name.put(new Pair<String, String>("BAT", "PAX"), "BATPAX");
        dictionary_of_pairs_name.put(new Pair<String, String>("BAT", "TUSD"), "BATTUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("PHB", "BNB"), "PHBBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("PHB", "BTC"), "PHBBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("PHB", "USDC"), "PHBUSDC");
        dictionary_of_pairs_name.put(new Pair<String, String>("PHB", "TUSD"), "PHBTUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("PHB", "PAX"), "PHBPAX");
        dictionary_of_pairs_name.put(new Pair<String, String>("TFUEL", "BNB"), "TFUELBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("TFUEL", "BTC"), "TFUELBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("TFUEL", "USDT"), "TFUELUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("TFUEL", "USDC"), "TFUELUSDC");
        dictionary_of_pairs_name.put(new Pair<String, String>("TFUEL", "TUSD"), "TFUELTUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("TFUEL", "PAX"), "TFUELPAX");
        dictionary_of_pairs_name.put(new Pair<String, String>("ONE", "BNB"), "ONEBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("ONE", "BTC"), "ONEBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("ONE", "USDT"), "ONEUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("ONE", "TUSD"), "ONETUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("ONE", "PAX"), "ONEPAX");
        dictionary_of_pairs_name.put(new Pair<String, String>("ONE", "USDC"), "ONEUSDC");
        dictionary_of_pairs_name.put(new Pair<String, String>("FTM", "BNB"), "FTMBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("FTM", "BTC"), "FTMBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("FTM", "USDT"), "FTMUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("FTM", "TUSD"), "FTMTUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("FTM", "PAX"), "FTMPAX");
        dictionary_of_pairs_name.put(new Pair<String, String>("FTM", "USDC"), "FTMUSDC");
        dictionary_of_pairs_name.put(new Pair<String, String>("BTCB", "BTC"), "BTCBBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("BCPT", "TUSD"), "BCPTTUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("BCPT", "PAX"), "BCPTPAX");
        dictionary_of_pairs_name.put(new Pair<String, String>("BCPT", "USDC"), "BCPTUSDC");
        dictionary_of_pairs_name.put(new Pair<String, String>("ALGO", "BNB"), "ALGOBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("ALGO", "BTC"), "ALGOBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("ALGO", "USDT"), "ALGOUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("ALGO", "TUSD"), "ALGOTUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("ALGO", "PAX"), "ALGOPAX");
        dictionary_of_pairs_name.put(new Pair<String, String>("ALGO", "USDC"), "ALGOUSDC");
        dictionary_of_pairs_name.put(new Pair<String, String>("USDSB", "USDT"), "USDSBUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("USDSB", "USDS"), "USDSBUSDS");
        dictionary_of_pairs_name.put(new Pair<String, String>("GTO", "USDT"), "GTOUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("GTO", "PAX"), "GTOPAX");
        dictionary_of_pairs_name.put(new Pair<String, String>("GTO", "TUSD"), "GTOTUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("GTO", "USDC"), "GTOUSDC");
        dictionary_of_pairs_name.put(new Pair<String, String>("ERD", "BNB"), "ERDBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("ERD", "BTC"), "ERDBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("ERD", "USDT"), "ERDUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("ERD", "PAX"), "ERDPAX");
        dictionary_of_pairs_name.put(new Pair<String, String>("ERD", "USDC"), "ERDUSDC");
        dictionary_of_pairs_name.put(new Pair<String, String>("DOGE", "BNB"), "DOGEBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("DOGE", "BTC"), "DOGEBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("DOGE", "USDT"), "DOGEUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("DOGE", "PAX"), "DOGEPAX");
        dictionary_of_pairs_name.put(new Pair<String, String>("DOGE", "USDC"), "DOGEUSDC");
        dictionary_of_pairs_name.put(new Pair<String, String>("DUSK", "BNB"), "DUSKBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("DUSK", "BTC"), "DUSKBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("DUSK", "USDT"), "DUSKUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("DUSK", "USDC"), "DUSKUSDC");
        dictionary_of_pairs_name.put(new Pair<String, String>("DUSK", "PAX"), "DUSKPAX");
        dictionary_of_pairs_name.put(new Pair<String, String>("BGBP", "USDC"), "BGBPUSDC");
        dictionary_of_pairs_name.put(new Pair<String, String>("ANKR", "BNB"), "ANKRBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("ANKR", "BTC"), "ANKRBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("ANKR", "USDT"), "ANKRUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("ANKR", "TUSD"), "ANKRTUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("ANKR", "PAX"), "ANKRPAX");
        dictionary_of_pairs_name.put(new Pair<String, String>("ANKR", "USDC"), "ANKRUSDC");
        dictionary_of_pairs_name.put(new Pair<String, String>("ONT", "PAX"), "ONTPAX");
        dictionary_of_pairs_name.put(new Pair<String, String>("ONT", "USDC"), "ONTUSDC");
        dictionary_of_pairs_name.put(new Pair<String, String>("WIN", "BNB"), "WINBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("WIN", "BTC"), "WINBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("WIN", "USDT"), "WINUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("WIN", "USDC"), "WINUSDC");
        dictionary_of_pairs_name.put(new Pair<String, String>("COS", "BNB"), "COSBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("COS", "BTC"), "COSBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("COS", "USDT"), "COSUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("TUSDB", "TUSD"), "TUSDBTUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("NPXS", "USDT"), "NPXSUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("NPXS", "USDC"), "NPXSUSDC");
        dictionary_of_pairs_name.put(new Pair<String, String>("COCOS", "BNB"), "COCOSBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("COCOS", "BTC"), "COCOSBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("COCOS", "USDT"), "COCOSUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("MTL", "USDT"), "MTLUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("TOMO", "BNB"), "TOMOBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("TOMO", "BTC"), "TOMOBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("TOMO", "USDT"), "TOMOUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("TOMO", "USDC"), "TOMOUSDC");
        dictionary_of_pairs_name.put(new Pair<String, String>("PERL", "BNB"), "PERLBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("PERL", "BTC"), "PERLBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("PERL", "USDC"), "PERLUSDC");
        dictionary_of_pairs_name.put(new Pair<String, String>("PERL", "USDT"), "PERLUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("DENT", "USDT"), "DENTUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("MFT", "USDT"), "MFTUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("KEY", "USDT"), "KEYUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("STORM", "USDT"), "STORMUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("DOCK", "USDT"), "DOCKUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("WAN", "USDT"), "WANUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("FUN", "USDT"), "FUNUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("CVC", "USDT"), "CVCUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("BTT", "TRX"), "BTTTRX");
        dictionary_of_pairs_name.put(new Pair<String, String>("WIN", "TRX"), "WINTRX");
        dictionary_of_pairs_name.put(new Pair<String, String>("CHZ", "BNB"), "CHZBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("CHZ", "BTC"), "CHZBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("CHZ", "USDT"), "CHZUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("BAND", "BNB"), "BANDBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("BAND", "BTC"), "BANDBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("BAND", "USDT"), "BANDUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("BNB", "BUSD"), "BNBBUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("BTC", "BUSD"), "BTCBUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("BUSD", "USDT"), "BUSDUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("BEAM", "BNB"), "BEAMBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("BEAM", "BTC"), "BEAMBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("BEAM", "USDT"), "BEAMUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("XTZ", "BNB"), "XTZBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("XTZ", "BTC"), "XTZBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("XTZ", "USDT"), "XTZUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("REN", "USDT"), "RENUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("RVN", "USDT"), "RVNUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("HC", "USDT"), "HCUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("HBAR", "BNB"), "HBARBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("HBAR", "BTC"), "HBARBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("HBAR", "USDT"), "HBARUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("NKN", "BNB"), "NKNBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("NKN", "BTC"), "NKNBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("NKN", "USDT"), "NKNUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("XRP", "BUSD"), "XRPBUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("ETH", "BUSD"), "ETHBUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("BCHABC", "BUSD"), "BCHABCBUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("LTC", "BUSD"), "LTCBUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("LINK", "BUSD"), "LINKBUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("ETC", "BUSD"), "ETCBUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("STX", "BNB"), "STXBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("STX", "BTC"), "STXBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("STX", "USDT"), "STXUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("KAVA", "BNB"), "KAVABNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("KAVA", "BTC"), "KAVABTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("KAVA", "USDT"), "KAVAUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("BUSD", "NGN"), "BUSDNGN");
        dictionary_of_pairs_name.put(new Pair<String, String>("BNB", "NGN"), "BNBNGN");
        dictionary_of_pairs_name.put(new Pair<String, String>("BTC", "NGN"), "BTCNGN");
        dictionary_of_pairs_name.put(new Pair<String, String>("ARPA", "BNB"), "ARPABNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("ARPA", "BTC"), "ARPABTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("ARPA", "USDT"), "ARPAUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("TRX", "BUSD"), "TRXBUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("EOS", "BUSD"), "EOSBUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("IOTX", "USDT"), "IOTXUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("RLC", "USDT"), "RLCUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("MCO", "USDT"), "MCOUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("XLM", "BUSD"), "XLMBUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("ADA", "BUSD"), "ADABUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("CTXC", "BNB"), "CTXCBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("CTXC", "BTC"), "CTXCBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("CTXC", "USDT"), "CTXCUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("BCH", "BNB"), "BCHBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("BCH", "BTC"), "BCHBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("BCH", "USDT"), "BCHUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("BCH", "USDC"), "BCHUSDC");
        dictionary_of_pairs_name.put(new Pair<String, String>("BCH", "TUSD"), "BCHTUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("BCH", "PAX"), "BCHPAX");
        dictionary_of_pairs_name.put(new Pair<String, String>("BCH", "BUSD"), "BCHBUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("BTC", "RUB"), "BTCRUB");
        dictionary_of_pairs_name.put(new Pair<String, String>("ETH", "RUB"), "ETHRUB");
        dictionary_of_pairs_name.put(new Pair<String, String>("XRP", "RUB"), "XRPRUB");
        dictionary_of_pairs_name.put(new Pair<String, String>("BNB", "RUB"), "BNBRUB");
        dictionary_of_pairs_name.put(new Pair<String, String>("TROY", "BNB"), "TROYBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("TROY", "BTC"), "TROYBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("TROY", "USDT"), "TROYUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("BUSD", "RUB"), "BUSDRUB");
        dictionary_of_pairs_name.put(new Pair<String, String>("QTUM", "BUSD"), "QTUMBUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("VET", "BUSD"), "VETBUSD");
        dictionary_of_pairs_name.put(new Pair<String, String>("VITE", "BNB"), "VITEBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("VITE", "BTC"), "VITEBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("VITE", "USDT"), "VITEUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("FTT", "BNB"), "FTTBNB");
        dictionary_of_pairs_name.put(new Pair<String, String>("FTT", "BTC"), "FTTBTC");
        dictionary_of_pairs_name.put(new Pair<String, String>("FTT", "USDT"), "FTTUSDT");
        dictionary_of_pairs_name.put(new Pair<String, String>("BTC", "TRY"), "BTCTRY");
        dictionary_of_pairs_name.put(new Pair<String, String>("BNB", "TRY"), "BNBTRY");
        dictionary_of_pairs_name.put(new Pair<String, String>("BUSD", "TRY"), "BUSDTRY");
        dictionary_of_pairs_name.put(new Pair<String, String>("ETH", "TRY"), "ETHTRY");
        dictionary_of_pairs_name.put(new Pair<String, String>("XRP", "TRY"), "XRPTRY");
        dictionary_of_pairs_name.put(new Pair<String, String>("USDT", "TRY"), "USDTTRY");
        dictionary_of_pairs_name.put(new Pair<String, String>("USDT", "RUB"), "USDTRUB");


        /*try {
            Thread.sleep(5000);
        } catch(InterruptedException ex) {}

        ExchangeInfo exchangeInfo = client.getExchangeInfo();

        for( int i = 0; i < exchangeInfo.getSymbols().size(); i++){
            dictionary_of_pairs_name.put(
                    new Pair<String, String>(
                            exchangeInfo.getSymbols().get(i).getBaseAsset(),
                            exchangeInfo.getSymbols().get(i).getQuoteAsset()
                    ),
                    exchangeInfo.getSymbols().get(i).getSymbol());
        }

         */
    }

    @Override
    protected String pair_translator(Pair<String, String> pair) {
        if( dictionary_of_pairs_name.containsKey(pair))
            return dictionary_of_pairs_name.get(pair);
        if(pair.second.equals("USD") )
            return dictionary_of_pairs_name.get( new Pair<String, String>(pair.first, "USDT") );
        if(pair.first.equals("USD"))
            return dictionary_of_pairs_name.get( new Pair<String, String>("USDT",pair.second) );
        return null;

    }

    @Override
    protected void get_order_books(int depth) {

        for (String p : tradeable_coins.values()) {
            try {
                if (!pairs_data.containsKey(p)) {
                    pairs_data.put(p, new PairData());
                }

                OrderBook orderBook = client.getOrderBook(p, depth);
                pairs_data.get(p).Asks.clear();
                pairs_data.get(p).Bids.clear();
                for (int i = 0; i < depth; i++) {


                    pairs_data.get(p).Asks.add(new Pair<Double, Double>(Double.parseDouble(orderBook.getAsks().get(i).getPrice()),
                            Double.parseDouble(orderBook.getAsks().get(0).getQty())));
                    pairs_data.get(p).Bids.add(new Pair<Double, Double>(Double.parseDouble(orderBook.getBids().get(i).getPrice()),
                            Double.parseDouble(orderBook.getBids().get(0).getQty())));
                }
            } catch (Exception e) {

            }
        }
    }

    @Override
    protected void get_tickers(int depth){
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(e);
        }


        try {
            List<TickerPrice> allPrices = client.getAllPrices();
            for (TickerPrice p : allPrices) {
                String s = p.getSymbol();
                if (tradeable_coins.containsValue(p.getSymbol())) {
                    if (!pairs_data.containsKey(p.getSymbol())) {
                        pairs_data.put(p.getSymbol(), new PairData());
                    }
                    pairs_data.get(p.getSymbol()).lastprice = Double.parseDouble(p.getPrice());
                    pairs_data.get(p.getSymbol()).exchagename = "Binance";
                }
            }
        }catch (Exception e){

        }
    }
}
