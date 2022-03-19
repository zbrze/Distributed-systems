package com.example.rest_api.model;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class CurrencyResponse {
    URL url;

    public CurrencyResponse(String url) throws IOException {
        this.url = new URL(url);
    }

    public String getJson() throws ResponseException{
        try {
            HttpURLConnection request = (HttpURLConnection) this.url.openConnection();
            request.setRequestMethod("GET");
            request.setUseCaches(false);
            request.setAllowUserInteraction(false);
            request.setConnectTimeout(1000);
            request.setReadTimeout(1000);
            request.connect();
            int responseCode = request.getResponseCode();
            if(responseCode == 200){
                //we can process json
                BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line+"\n");
                }
                br.close();
                return sb.toString();
            }else{
                //smth went wrong

                System.out.println(url +" did not worked");
                throw new ResponseException("REQUEST_EXCEPTION", url + " returned " + responseCode);
            }
        }catch (Exception e){
            throw new ResponseException("REQUEST_EXCEPTION", url + " is not able to connect");
        }
    }
}
