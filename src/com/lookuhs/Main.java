package com.lookuhs;

import com.lookuhs.controller.CurrencyConverterController;
import com.lookuhs.model.Currency;
import com.lookuhs.view.CurrencyConverterView;

public class Main {
  
  public static void main(String[] args) {
    Currency[] currencies = CurrencyConverterController.getCurrencies();
  
    CurrencyConverterController currencyConverterController = new CurrencyConverterController(currencies);
    CurrencyConverterView currencyConverterView = new CurrencyConverterView(currencyConverterController);
    currencyConverterView.init();
  }
}
