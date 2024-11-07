package Servicios;


import database.ConfigDB;
import entity.*;
import entity.Compra;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompraServicio {

    public Object findById(int id) {
        Connection objCompraonnection = ConfigDB.openConnection();
        Compra objCompra = null;
        try {
            String sql = "SELECT * FROM compra\n"+
                    "INNER JOIN cliente ON compra.id_cliente = cliente.id_cliente\n"+
                    "INNER JOIN producto ON compra.id_producto = producto.id_producto\n"+
                    "INNER JOIN tienda ON producto.id_tienda = tienda.id_tienda\n"+
                    "WHERE id_compra = ?;";
            PreparedStatement objPS = objCompraonnection.prepareStatement(sql);
            objPS.setInt(1, id);
            ResultSet objResult = objPS.executeQuery();
            while (objResult.next()) {
                objCompra = new Compra();
                Producto objProducto = new Producto();
                Tienda objTienda = new Tienda();
                Cliente objCompraliente = new Cliente();

                objCompra.setId_compra(objResult.getInt("compra.id_compra"));
                objCompra.setId_cliente(objResult.getInt("compra.id_cliente"));
                objCompra.setId_tienda(objResult.getInt("compra.id_tienda"));
                objCompra.setId_producto(objResult.getInt("compra.id_producto"));
                objCompra.setFecha_compra(objResult.getDate("compra.fecha_compra"));
                objCompra.setCantidad(objResult.getInt("compra.cantidad"));

                objTienda.setId_tienda(objResult.getInt("tienda.id_tienda"));
                objTienda.setNombre(objResult.getString("tienda.nombre"));
                objTienda.setUbicacion(objResult.getString("tienda.ubicacion"));

                objProducto.setId_producto(objResult.getInt("producto.id_producto"));
                objProducto.setNombre_producto(objResult.getString("producto.nombre_producto"));
                objProducto.setPrecio(objResult.getDouble("producto.precio"));
                objProducto.setId_tienda(objResult.getInt("producto.id_tienda"));
                objProducto.setStock(objResult.getInt("producto.stock"));
                objProducto.setObjTienda(objTienda);

                objCompraliente.setId_cliente(objResult.getInt("cliente.id_cliente"));
                objCompraliente.setNombre_cliente(objResult.getString("cliente.nombre_cliente"));
                objCompraliente.setApellido_cliente(objResult.getString("cliente.apellido_cliente"));
                objCompraliente.setEmail(objResult.getString("cliente.email"));

                objCompra.setObjCliente(objCompraliente);
                objCompra.setObjProducto(objProducto);
                objCompra.setObjTienda(objTienda);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Error " + e.getMessage());
        }
        ConfigDB.closeConnection();
        return objCompra;
    }


}
