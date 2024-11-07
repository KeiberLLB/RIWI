package model;

import database.CRUD;
import database.ConfigDB;
import entity.Cliente;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteModel implements CRUD {
    @Override
    public Object insert(Object object) {
            //Establecer Conexión con la base de datos
            Connection objConnection = ConfigDB.openConnection();
            //Se cambia la clase del objeto recibido
            Cliente objCliente = (Cliente) object;
            //Estructuración y ejecución comando SQL
            try {
                String sql = "insert into cliente(nombre_cliente,apellido_cliente,email,cedula_cliente) values(?,?,?,?);";
                PreparedStatement objPS = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                objPS.setString(1, objCliente.getNombre_cliente());
                objPS.setString(2, objCliente.getApellido_cliente());
                objPS.setString(3, objCliente.getEmail());
                objPS.setString(4, objCliente.getCedula_cliente());
                objPS.execute();
                ResultSet objResult = objPS.getGeneratedKeys();
                while (objResult.next()) {
                    objCliente.setId_cliente(objResult.getInt(1));
                }
                objPS.close();
                JOptionPane.showMessageDialog(null, "Cliente registrado correctamente!");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data Error " + e.getMessage());
            }
            ConfigDB.closeConnection();
            return objCliente;    }

    @Override
    public boolean update(Object object) {
        boolean isUpdate = false;
        Cliente objCliente = (Cliente) object;
        Connection objConnection = ConfigDB.openConnection();
        try {
            String sql = "UPDATE cliente SET nombre_cliente = ?, apellido_cliente = ?, email = ?, cedula_cliente = ? WHERE id_cliente = ?;";
            PreparedStatement objPS = objConnection.prepareStatement(sql);
            objPS.setString(1, objCliente.getNombre_cliente());
            objPS.setString(2, objCliente.getApellido_cliente());
            objPS.setString(3, objCliente.getEmail());
            objPS.setString(4, objCliente.getCedula_cliente());
            objPS.setInt(5, objCliente.getId_cliente());
            int totalAffected = objPS.executeUpdate();
            if (totalAffected > 0) {
                isUpdate = true;
                JOptionPane.showMessageDialog(null, "Cliente actualizado correctamente.");
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
        Cliente objCliente = (Cliente) object;
        Connection objConnection = ConfigDB.openConnection();
        try {
            String sql = "DELETE FROM cliente WHERE id_cliente = ?;";
            PreparedStatement objPS = objConnection.prepareStatement(sql);
            objPS.setInt(1, objCliente.getId_cliente());
            int totalAffected = objPS.executeUpdate();
            if (totalAffected > 0) {
                isDelete = true;
                JOptionPane.showMessageDialog(null, "Cliente eliminado");
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
        List<Object> listaClientes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM cliente ORDER BY cliente.id_cliente ASC;";
            PreparedStatement objPS = objConnection.prepareStatement(sql);
            ResultSet objResult = objPS.executeQuery();
            while (objResult.next()){
                Cliente objCliente = new Cliente();
                objCliente.setId_cliente(objResult.getInt("id_cliente"));
                objCliente.setNombre_cliente(objResult.getString("nombre_cliente"));
                objCliente.setApellido_cliente(objResult.getString("apellido_cliente"));
                objCliente.setEmail(objResult.getString("email"));
                objCliente.setCedula_cliente(objResult.getString("cedula_cliente"));
                listaClientes.add(objCliente);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Error " + e.getMessage());
        }
        ConfigDB.closeConnection();
        return listaClientes;
    }
}
