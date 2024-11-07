package controladores;

import Servicios.ClienteServicio;
import entity.Cliente;
import model.ClienteModel;

import javax.swing.*;
import java.util.List;

public class ClienteControl {
    ClienteModel clienteModel = new ClienteModel();
    ClienteServicio clienteServicio = new ClienteServicio();

    public void menuCliente() {
        String option = "";
        do {
            option = JOptionPane.showInputDialog("""
                    MENU CLIENTE
                    1. Nuevo Cliente
                    2. Actualizar Cliente
                    3. Eliminar Cliente
                    4. Salir
                    """);
            switch (option) {
                case "1":
                    this.insertC();
                    break;
                case "2":
                    this.updateC();
                    break;
                case "3":
                    this.deleteC();
                    break;
            }
        } while (!option.equals("4"));
    }

    public String getAll(List<Object> objectList) {
        String list = "Lista de Clientes: \n";
        for (Object cliente : objectList) {
            Cliente objCliente = (Cliente) cliente;
            list += objCliente.toString() + "\n";
        }
        return list;
    }

    public void insertC() {
        Cliente cliente = new Cliente();
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del Cliente");
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del Cliente");
        String email = JOptionPane.showInputDialog("Ingrese el email del Cliente");
        String cedula = JOptionPane.showInputDialog("Ingrese la cédula del Cliente");

        cliente.setNombre_cliente(nombre);
        cliente.setApellido_cliente(apellido);
        cliente.setEmail(email);
        cliente.setCedula_cliente(cedula);

        cliente = (Cliente) clienteModel.insert(cliente);
        JOptionPane.showMessageDialog(null, cliente);
    }

    public void insertC(String CC) {
        Cliente cliente = new Cliente();
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del Cliente");
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del Cliente");
        String email = JOptionPane.showInputDialog("Ingrese el email del Cliente");

        cliente.setNombre_cliente(nombre);
        cliente.setApellido_cliente(apellido);
        cliente.setEmail(email);
        cliente.setCedula_cliente(CC);

        cliente = (Cliente) clienteModel.insert(cliente);
        JOptionPane.showMessageDialog(null, cliente);
    }

    public void updateC() {
        String list = getAll(this.clienteModel.findAll());
        int Cliente = Integer.parseInt(JOptionPane.showInputDialog(list + "Ingrese el ID del Cliente"));
        Cliente cliente = (Cliente) this.clienteServicio.findById(Cliente);
        if (cliente == null) {
            JOptionPane.showMessageDialog(null, "Busqueda sin resultados.");
        } else {
            cliente.setNombre_cliente(JOptionPane.showInputDialog(null, "Ingrese el nombre si es necesario: ", cliente.getNombre_cliente()));
            cliente.setApellido_cliente(JOptionPane.showInputDialog(null, "Ingresa la descripcion si es necesario: ", cliente.getApellido_cliente()));
            cliente.setEmail(JOptionPane.showInputDialog(null, "Ingrese el email si es necesario: ", cliente.getEmail()));
            cliente.setCedula_cliente(JOptionPane.showInputDialog(null, "Ingrese la cedula si es necesario: ", cliente.getCedula_cliente()));
            this.clienteModel.update(cliente);
        }
    }

    public void deleteC() {
        int confirm = 1;
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(getAll(clienteModel.findAll()) + "\nIngrese el Id del Cliente a eliminar: "));
        Cliente objCliente = (Cliente) clienteServicio.findById(idDelete);
        if (objCliente == null) {
            JOptionPane.showMessageDialog(null, "Cliente no encontrada");
        } else {
            confirm = JOptionPane.showConfirmDialog(null, "Estas seguro? : \n" + objCliente);
            if (confirm == 0) {
                clienteModel.delete(objCliente);
            }
        }
    }
}
