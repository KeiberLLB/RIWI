package Ejercicio6.services;

import Ejercicio6.interfaces.TaxStrategyUK;

public class UKTaxStrategy implements TaxStrategyUK{

  @Override
  public double calculateTaxUK() {
    return 0.2;
  }
}
