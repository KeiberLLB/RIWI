package Ejercicio1;

import java.util.List;

public class Order {
  private List<String> items;
  private double totalAmount;

  public Order(List<String> items, double totalAmount) {
    this.items = items;
    this.totalAmount = totalAmount;
  }

  public Order() {
  }

  public List<String> getItems() {
    return items;
  }

  public void setItems(List<String> items) {
    this.items = items;
  }

  public double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(double totalAmount) {
    this.totalAmount = totalAmount;
  }
  
  
}
