package com.lookuhs.view;

import com.lookuhs.controller.CurrencyConverterController;
import com.lookuhs.model.Currency;

import javax.swing.*;

public class CurrencyConverterView {
  private CurrencyConverterController currencyConverterController;
  private JComboBox<Currency> fromCurrencyComboBox;
  private JComboBox<Currency> toCurrencyComboBox;
  private JTextField amountTextField;
  private JLabel resultLabel;
  
  public CurrencyConverterView(CurrencyConverterController currencyConverterController) {
    this.currencyConverterController = currencyConverterController;
    
    fromCurrencyComboBox = new JComboBox<>(Currency.values());
    toCurrencyComboBox = new JComboBox<>(Currency.values());
    
    amountTextField = new JTextField();
    
    resultLabel = new JLabel();
    
    JPanel panel = new JPanel();
    panel.add(new JLabel("From: "));
    panel.add(fromCurrencyComboBox);
    panel.add(new JLabel("To: "));
    panel.add(toCurrencyComboBox);
    panel.add(new JLabel("Amount: "));
    panel.add(amountTextField);
    panel.add(new JLabel("Result: "));
    panel.add(resultLabel);
    
    JFrame frame = new JFrame("Currency Converter");
    frame.add(panel);
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
  
  public void init() {
    fromCurrencyComboBox.addActionListener(e -> currencyConverterController.convertCurrency());
    toCurrencyComboBox.addActionListener(e -> currencyConverterController.convertCurrency());
    amountTextField.addActionListener(e -> currencyConverterController.convertCurrency());
  }
  
  public Currency getFromCurrency() {
    return (Currency) fromCurrencyComboBox.getSelectedItem();
  }
  
  public Currency getToCurrency() {
    return (Currency) toCurrencyComboBox.getSelectedItem();
  }
  
  public double getAmount() {
    try {
      return Double.parseDouble(amountTextField.getText());
    } catch (NumberFormatException e) {
      return 0.0;
    }
  }
  
  public void setResult(double result) {
    resultLabel.setText(String.format("%.2f", result));
  }

}
