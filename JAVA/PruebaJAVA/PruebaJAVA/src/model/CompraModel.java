package model;

import database.CRUD;
import database.ConfigDB;
import entity.Cliente;
import entity.Compra;
import entity.Producto;
import entity.Tienda;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompraModel implements CRUD {

    @Override
    public Object insert(Object object) {
        Connection objConnection = ConfigDB.openConnection();
        Compra objCompra = (Compra) object;
        try {
            String sql = "INSERT INTO compra(fecha_compra, cantidad, id_cliente, id_producto, id_tienda) values(?, ?, ?, ?, ?);";
            PreparedStatement objPS = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPS.setDate(1, objCompra.getFecha_compra());
            objPS.setInt(2, objCompra.getCantidad());
            objPS.setInt(3, objCompra.getId_cliente());
            objPS.setInt(4, objCompra.getId_producto());
            objPS.setInt(5, objCompra.getId_tienda());
            objPS.execute();
            ResultSet objResult = objPS.getGeneratedKeys();
            while (objResult.next()) {
                objCompra.setId_compra(objResult.getInt(1));
            }
            objPS.close();
            JOptionPane.showMessageDialog(null, "Compra guardada correctamente!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Error " + e.getMessage());
        }
        ConfigDB.closeConnection();
        return objCompra;
    }

    @Override
    public boolean update(Object object) {
        boolean isUpdate = false;
        Compra objCompra = (Compra) object;
        Connection objConnection = ConfigDB.openConnection();
        try {
            String sql = "UPDATE compra SET fecha_compra = ?, cantidad = ?, id_cliente = ?, id_producto = ? WHERE id_compra = ?;";
            PreparedStatement objPS = objConnection.prepareStatement(sql);
            objPS.setDate(1, objCompra.getFecha_compra());
            objPS.setInt(2, objCompra.getCantidad());
            objPS.setInt(3, objCompra.getId_cliente());
            objPS.setInt(4, objCompra.getId_producto());
            objPS.setInt(5, objCompra.getId_compra());
            int totalAffected = objPS.executeUpdate();
            if (totalAffected > 0) {
                isUpdate = true;
                JOptionPane.showMessageDialog(null, "Compra actualizada correctamente");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Error " + e.getMessage());
        }
        ConfigDB.closeConnection();
        return isUpdate;
    }

    @Override
    public boolean delete(Object object) {
        boolean isDelete = false;
        Compra objCompra = (Compra) object;
        Connection objConnection = ConfigDB.openConnection();
        try {
            String sql = "DELETE FROM compra WHERE id_compra = ?;";
            PreparedStatement objPS = objConnection.prepareStatement(sql);
            objPS.setInt(1, objCompra.getId_compra());
            int totalAffected = objPS.executeUpdate();
            if (totalAffected > 0) {
                isDelete = true;
                JOptionPane.showMessageDialog(null, "Compra eliminada");
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
        List<Object> listCompras = new ArrayList<>();
        try {
            String sql = "SELECT * FROM compra\n" +
                    "INNER JOIN cliente on compra.id_cliente = cliente.id_cliente\n" +
                    "INNER JOIN producto on compra.id_producto = producto.id_producto\n" +
                    "INNER JOIN tienda on producto.id_tienda = tienda.id_tienda;";

            PreparedStatement objPS = objConnection.prepareStatement(sql);
            ResultSet objResult = objPS.executeQuery();
            while (objResult.next()) {
                Compra objC = new Compra();
                Producto objProducto = new Producto();
                Tienda objTienda = new Tienda();
                Cliente objCliente = new Cliente();

                objC.setId_compra(objResult.getInt("compra.id_compra"));
                objC.setId_cliente(objResult.getInt("compra.id_cliente"));
                objC.setId_tienda(objResult.getInt("compra.id_tienda"));
                objC.setId_producto(objResult.getInt("compra.id_producto"));
                objC.setFecha_compra(objResult.getDate("compra.fecha_compra"));
                objC.setCantidad(objResult.getInt("compra.cantidad"));

                objTienda.setId_tienda(objResult.getInt("tienda.id_tienda"));
                objTienda.setNombre(objResult.getString("tienda.nombre"));
                objTienda.setUbicacion(objResult.getString("tienda.ubicacion"));

                objProducto.setId_producto(objResult.getInt("producto.id_producto"));
                objProducto.setNombre_producto(objResult.getString("producto.nombre_producto"));
                objProducto.setPrecio(objResult.getDouble("producto.precio"));
                objProducto.setId_tienda(objResult.getInt("producto.id_tienda"));
                objProducto.setStock(objResult.getInt("producto.stock"));
                objProducto.setObjTienda(objTienda);

                objCliente.setId_cliente(objResult.getInt("cliente.id_cliente"));
                objCliente.setNombre_cliente(objResult.getString("cliente.nombre_cliente"));
                objCliente.setApellido_cliente(objResult.getString("cliente.apellido_cliente"));
                objCliente.setCedula_cliente(objResult.getString("cliente.cedula_cliente"));
                objCliente.setEmail(objResult.getString("cliente.email"));

                objC.setObjCliente(objCliente);
                objC.setObjProducto(objProducto);
                objC.setObjTienda(objTienda);

                listCompras.add(objC);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Error " + e.getMessage());
        }
        ConfigDB.closeConnection();
        return listCompras;
    }
}
