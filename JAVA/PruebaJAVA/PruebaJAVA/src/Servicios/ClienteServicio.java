package Servicios;

import database.ConfigDB;
import entity.Cliente;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteServicio {
    public Object findById(int id) {
        Connection objConnection = ConfigDB.openConnection();
        Cliente objCliente = null;
        try {
            String sql = "SELECT * FROM cliente WHERE id_cliente = ?;";
            PreparedStatement objPS = objConnection.prepareStatement(sql);
            objPS.setInt(1, id);
            ResultSet objResult = objPS.executeQuery();
            while (objResult.next()) {
                objCliente = new Cliente();
                objCliente.setId_cliente(objResult.getInt("id_cliente"));
                objCliente.setNombre_cliente(objResult.getString("nombre_cliente"));
                objCliente.setApellido_cliente(objResult.getString("apellido_cliente"));
                objCliente.setEmail(objResult.getString("email"));
                objCliente.setCedula_cliente(objResult.getString("cedula_cliente"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Error " + e.getMessage());
        }
        ConfigDB.closeConnection();
        return objCliente;
    }
    public Object findByCC(String CC) {
        Connection objConnection = ConfigDB.openConnection();
        Cliente objCliente = null;
        try {
            String sql = "SELECT * FROM cliente WHERE cedula_cliente = ?;";
            PreparedStatement objPS = objConnection.prepareStatement(sql);
            objPS.setString(1, CC);
            ResultSet objResult = objPS.executeQuery();
            while (objResult.next()) {
                objCliente = new Cliente();
                objCliente.setId_cliente(objResult.getInt("id_cliente"));
                objCliente.setNombre_cliente(objResult.getString("nombre_cliente"));
                objCliente.setApellido_cliente(objResult.getString("apellido_cliente"));
                objCliente.setEmail(objResult.getString("email"));
                objCliente.setCedula_cliente(objResult.getString("cedula_cliente"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Error " + e.getMessage());
        }
        ConfigDB.closeConnection();
        return objCliente;
    }
}
