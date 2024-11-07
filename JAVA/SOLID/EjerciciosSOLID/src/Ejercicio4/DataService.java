package Ejercicio4;

import Ejercicio4.interfaces.DataStorage;

public class DataService {
  private DataStorage dataStorage;
  
  public void DataService() {
    dataStorage.save();
  }
}
