package Servicios;

import database.ConfigDB;
import entity.Producto;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoServicio {
    public Object findById(int id) {
        Connection objConnection = ConfigDB.openConnection();
        Producto objProducto = null;
        try {
            String sql = "SELECT * FROM producto WHERE id_producto = ?;";
            PreparedStatement objPS = objConnection.prepareStatement(sql);
            objPS.setInt(1, id);
            ResultSet objResult = objPS.executeQuery();
            while (objResult.next()) {
                objProducto = new Producto();
                objProducto.setId_producto(objResult.getInt("id_producto"));
                objProducto.setNombre_producto(objResult.getString("nombre_producto"));
                objProducto.setPrecio(objResult.getDouble("precio"));
                objProducto.setId_tienda(objResult.getInt("id_tienda"));
                objProducto.setStock(objResult.getInt("stock"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Error " + e.getMessage());
        }
        ConfigDB.closeConnection();
        return objProducto;
    }
    public boolean update(Object object) {
        boolean isUpdate = false;
        Producto objProducto = (Producto) object;
        Connection objConnection = ConfigDB.openConnection();
        try {
            String sql = "UPDATE producto SET nombre_producto = ?, precio = ?, id_tienda = ?, stock = ? WHERE id_producto = ?;";
            PreparedStatement objPS = objConnection.prepareStatement(sql);
            objPS.setString(1, objProducto.getNombre_producto());
            objPS.setDouble(2, objProducto.getPrecio());
            objPS.setInt(3, objProducto.getId_tienda());
            objPS.setInt(4, objProducto.getStock());
            objPS.setInt(5, objProducto.getId_producto());
            int totalAffected = objPS.executeUpdate();
            if (totalAffected > 0) {
                isUpdate = true;
                JOptionPane.showMessageDialog(null, "Producto actualizado correctamente");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Error " + e.getMessage());
        }
        ConfigDB.closeConnection();
        return isUpdate;
    }
}
