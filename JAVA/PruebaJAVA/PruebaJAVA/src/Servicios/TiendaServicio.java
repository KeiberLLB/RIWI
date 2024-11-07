package Servicios;

import database.ConfigDB;
import entity.Tienda;
import entity.Tienda;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TiendaServicio {
    public List<Object> findAll() {
        Connection objConnection = ConfigDB.openConnection();
        List<Object> listaTiendas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tienda ORDER BY tienda.id_tienda ASC;";
            PreparedStatement objPS = objConnection.prepareStatement(sql);
            ResultSet objResult = objPS.executeQuery();
            while (objResult.next()){
                Tienda objTienda = new Tienda();
                objTienda.setId_tienda(objResult.getInt("id_tienda"));
                objTienda.setNombre(objResult.getString("nombre"));
                objTienda.setUbicacion(objResult.getString("ubicacion"));
                listaTiendas.add(objTienda);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Error " + e.getMessage());
        }
        ConfigDB.closeConnection();
        return listaTiendas;
    }
    public Object findById(int id) {
        Connection objConnection = ConfigDB.openConnection();
        Tienda objTienda = null;
        try {
            String sql = "SELECT * FROM tienda WHERE id_tienda = ?;";
            PreparedStatement objPS = objConnection.prepareStatement(sql);
            objPS.setInt(1, id);
            ResultSet objResult = objPS.executeQuery();
            while (objResult.next()) {
                objTienda = new Tienda();
                objTienda.setNombre(objResult.getString("id_tienda"));
                objTienda.setUbicacion(objResult.getString("ubicacion"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Error " + e.getMessage());
        }
        ConfigDB.closeConnection();
        return objTienda;
    }
}
