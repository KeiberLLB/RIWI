package Ejercicio6.services;

import Ejercicio6.interfaces.TaxStrategyUSA;

public class USATaxStrategy implements TaxStrategyUSA{

  @Override
  public double calculateTaxUSA() {
    return 0.1;
  }
}
