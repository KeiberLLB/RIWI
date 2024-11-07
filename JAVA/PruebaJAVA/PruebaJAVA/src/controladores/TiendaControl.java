package controladores;

import entity.Tienda;

import java.util.List;

public class TiendaControl {
    public String getAll(List<Object> object) {
        String list = "Lista de Tiendas: \n";
        for (Object tienda : object) {
            Tienda objTienda = (Tienda) tienda;
            list += objTienda.toString() + "\n";
        }
        return list;
    }
}
