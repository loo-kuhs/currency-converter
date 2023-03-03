package com.lookuhs.view;

import com.lookuhs.model.Currency;

import javax.swing.*;

public class CurrencyInputPanel extends JPanel {
  private JLabel label;
  private JTextField textField;
  private JComboBox<Currency> comboBox;
  
  public CurrencyInputPanel(String labelText, Currency[] currencies) {
    label = new JLabel(labelText);
    textField = new JTextField(10);
    comboBox = new JComboBox<>(currencies);
    
    add(label);
    add(textField);
    add(comboBox);
  }
  
  public double getAmount() {
    try {
      return Double.parseDouble(textField.getText());
    } catch (NumberFormatException e) {
      return 0.0;
    }
  }
  
  public Currency getCurrency() {
    return (Currency) comboBox.getSelectedItem();
  }
}
