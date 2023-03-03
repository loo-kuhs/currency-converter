package com.lookuhs.model;

import java.util.EnumMap;
import java.util.Map;

public class CurrencyConverter {
  public Map<Currency, Double> exchangeRates;
  
  public CurrencyConverter(Currency[] currencies){
    exchangeRates = new EnumMap<>(Currency.class);
  }
  
  public double convert(double amount, Currency fromCurrency, Currency toCurrency){
    double fromRate = exchangeRates.get(fromCurrency);
    double toRate = exchangeRates.get(toCurrency);
    return amount * (toRate / fromRate);
  }
  
  public void setExchangeRates(String currencyCode, double rate){
    Currency currency = Currency.valueOf(currencyCode);
    exchangeRates.put(currency, rate);
  }
  
  public double getExchangeRate(String currencyCode){
    Currency currency = Currency.valueOf(currencyCode);
    return exchangeRates.get(currency);
  }
}
