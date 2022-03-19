package com.example.rest_api.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class URLGenerator {
    public Currency currency;
    public String date;

    public URLGenerator(Currency currency, Date date){
        this.currency= currency;
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        this.date = simpleDateFormat.format(date);
    }

    public String getFirstUrl(){
        return String.format("https://api.exchangerate.host/historical?base=%s&date=%s", currency.toString(), date);
    }

    public String getSecondUrl(){
        return String.format("https://api.currencyapi.com/v3/historical?apikey=jo2lqDUlbTCIgIEnzTjy8Tcj3AriN7qcxS2TjbkF&base_currency=%s&date=%s", currency.toString(), date);

    }

    public String getThirdUrl(){
        return String.format("https://api.getgeoapi.com/v2/currency/historical/%s?api_key=66ad9aeb3409a85029d49490039c0028ef93f0c1&from=%s", date, currency.toString());

    }

}