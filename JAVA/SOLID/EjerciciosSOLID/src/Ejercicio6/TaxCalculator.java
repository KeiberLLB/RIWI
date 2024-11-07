package Ejercicio6;

import Ejercicio6.interfaces.TaxStrategyUK;
import Ejercicio6.interfaces.TaxStrategyUSA;

public class TaxCalculator {

  private TaxStrategyUK taxStrategyUK;
  private TaxStrategyUSA taxStrategyUSA;

  public double calculateTax(String country) {
    if (country.equals("USA")) {
      return this.taxStrategyUSA.calculateTaxUSA();
    } else if (country.equals("UK")) {
      return this.taxStrategyUK.calculateTaxUK();
    }
    return 0;
  }
}
