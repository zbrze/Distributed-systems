package com.example.rest_api;

import com.example.rest_api.model.CurrencyForm;
import com.example.rest_api.model.CurrencyResponse;
import com.example.rest_api.model.ResponseException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Currency;
import java.util.concurrent.CompletableFuture;

@Service
public class RestService {
    private RestTemplate restTemplate;

    RestService(){
    }

    @Async("asyncExecutor")
    public CompletableFuture<Float> getCurrencyRates(String url, CurrencyForm currencyForm) throws InterruptedException, IOException {
        System.out.println("Looking up" + url);
        Thread.sleep(1000L);
        float results = (float) 14.4;
        CurrencyResponse currencyResponse = new CurrencyResponse(url);
        try {
            String jsonString = currencyResponse.getJson();
            JSONObject jsonObject = new JSONObject(jsonString);
            jsonObject.getJSONObject("motd").getJSONObject("rates").getString("slogan");

        }catch (ResponseException e){
            System.out.println("Unable to collect data from " + url);

        }

        return CompletableFuture.completedFuture(results);
    }
//    }
}
