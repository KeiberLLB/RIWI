package model;

import database.CRUD;
import database.ConfigDB;
import entity.Producto;
import entity.Tienda;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoModel implements CRUD {
    @Override
    public Object insert(Object object) {
        //Establecer Conexión con la base de datos
        Connection objConnection = ConfigDB.openConnection();
        //Se cambia la clase del objeto recibido
        Producto objProducto = (Producto) object;
        //Estructuración y ejecución comando SQL
        try {
            String sql = "insert into producto(nombre_producto, precio, id_tienda, stock) values(?, ?, ?, ?);";
            PreparedStatement objPS = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPS.setString(1, objProducto.getNombre_producto());
            objPS.setDouble(2, objProducto.getPrecio());
            objPS.setInt(3, objProducto.getId_tienda());
            objPS.setInt(4, objProducto.getStock());
            objPS.execute();
            ResultSet objResult = objPS.getGeneratedKeys();
            while (objResult.next()) {
                objProducto.setId_producto(objResult.getInt(1));
            }
            objPS.close();
            JOptionPane.showMessageDialog(null, "Producto guardado correctamente!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Error " + e.getMessage());
        }
        ConfigDB.closeConnection();
        return objProducto;
    }

    @Override
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

    @Override
    public boolean delete(Object object)    {
        boolean isDelete = false;
        Producto objProducto = (Producto) object;
        Connection objConnection = ConfigDB.openConnection();
        try {
            String sql = "DELETE FROM producto WHERE id_producto=?;";
            PreparedStatement objPS = objConnection.prepareStatement(sql);
            objPS.setInt(1, objProducto.getId_producto());
            int totalAffected = objPS.executeUpdate();
            if (totalAffected > 0) {
                isDelete = true;
                JOptionPane.showMessageDialog(null, "Producto eliminado");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Error " + e.getMessage());
        }
        ConfigDB.closeConnection();
        return isDelete;
    }

    @Override
    public List<Object> findAll() {
        Connection objConnection = ConfigDB.openConnection();
        List<Object> listaProductos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM producto INNER JOIN tienda on tienda.id_tienda = producto.id_tienda ORDER BY producto.id_producto ASC;";
            PreparedStatement objPS = objConnection.prepareStatement(sql);
            ResultSet objResult = objPS.executeQuery();
            while (objResult.next()) {
                Tienda objTienda = new Tienda();
                Producto objProducto = new Producto();
                objProducto.setId_producto(objResult.getInt("producto.id_producto"));
                objProducto.setNombre_producto(objResult.getString("producto.nombre_producto"));
                objProducto.setPrecio(objResult.getDouble("producto.precio"));
                objProducto.setId_tienda(objResult.getInt("producto.id_tienda"));
                objProducto.setStock(objResult.getInt("producto.stock"));
                objTienda.setId_tienda(objResult.getInt("tienda.id_tienda"));
                objTienda.setNombre(objResult.getString("tienda.nombre"));
                objTienda.setUbicacion(objResult.getString("tienda.ubicacion"));

                objProducto.setObjTienda(objTienda);
                listaProductos.add(objProducto);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Error " + e.getMessage());
        }
        ConfigDB.closeConnection();
        return listaProductos;
    }
}
