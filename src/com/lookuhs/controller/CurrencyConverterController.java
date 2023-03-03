package com.lookuhs.controller;

import com.lookuhs.model.CurrencyConverter;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrencyConverterController {
  
  private CurrencyConverter currencyConverter;
  
  public CurrencyConverterController() {
    currencyConverter = new CurrencyConverter();
  }
  
  public void updateExchangeRates() {
    try {
      URL url = new URL("https://v6.exchangerate-api.com/v6/YOUR-API-KEY/latest/USD");
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");
      
      int responseCode = connection.getResponseCode();
      
      if (responseCode == HttpURLConnection.HTTP_OK) {
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String response = in.readLine();
        in.close();
  
        JSONObject jsonResponse = new JSONObject(response);
        JSONObject rates = jsonResponse.getJSONObject("conversion_rates");
        
        currencyConverter.setExchangeRates("USD", rates.getDouble("USD"));
        currencyConverter.setExchangeRates("EUR", rates.getDouble("EUR"));
        currencyConverter.setExchangeRates("GBP", rates.getDouble("GBP"));
        currencyConverter.setExchangeRates("JPY", rates.getDouble("JPY"));
        currencyConverter.setExchangeRates("KRW", rates.getDouble("KRW"));
        
      }
    } catch (IOException | JSONException e) {
      e.printStackTrace();
    }
  }
}
