package controladores;

import Servicios.ClienteServicio;
import Servicios.CompraServicio;
import Servicios.ProductoServicio;
import Servicios.TiendaServicio;
import entity.Cliente;
import entity.Compra;
import entity.Producto;
import entity.Tienda;
import model.CompraModel;
import model.ProductoModel;

import javax.swing.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CompraControl {
    CompraModel compraModel = new CompraModel();
    CompraServicio compraServicio = new CompraServicio();
    ClienteServicio clienteServicio = new ClienteServicio();
    ClienteControl clienteControl = new ClienteControl();
    ProductoModel productoModel = new ProductoModel();
    ProductoControl productoControl = new ProductoControl();
    ProductoServicio productoServicio = new ProductoServicio();
    TiendaServicio tiendaServicio = new TiendaServicio();

    public String getAll(List<Object> object, int id_tienda) {
        String list = "Lista de Ventas: \n";
        for (Object venta : object) {
            Compra objVenta = (Compra) venta;
            if (objVenta.getId_tienda() == id_tienda) {
                list += objVenta + "\n";
            }
        }
        return list;
    }

    public String facturacion(Compra compra) {
        Tienda objTienda = (Tienda) tiendaServicio.findById(compra.getId_tienda());
        Producto objProducto = (Producto) productoServicio.findById(compra.getId_producto());
        objProducto.setObjTienda(objTienda);
        Cliente objCliente = (Cliente) clienteServicio.findById(compra.getId_cliente());
        double totalCompra = (double) compra.getCantidad() * objProducto.getPrecio();
        double totalPago = totalCompra * 1.19;
        String factura = "FACTURA VENTA\n" +
                objTienda.toString() + "\n" +
                objCliente.toString() + "\n" +
                "RESUMEN COMPRA: \n" +
                objProducto.getNombre_producto() + ": " + compra.getCantidad() + "\n" +
                "       Total Compra: " + "$ " + totalCompra + "\n" +
                "       TOTAL A PAGAR: " + "$ " + totalPago + "\n" +
                "------------------------------------------------\n";
        return factura;
    }

    public int controlCompraCantidad(int id_producto) {
        Producto objProducto = (Producto) productoServicio.findById(id_producto);
        int stock = objProducto.getStock();
        int cantidadV = 0;
        boolean compraCorrect = false;
        while (!compraCorrect) {
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad que desea comprar: "));
            if (cantidad <= stock) {
                cantidadV = cantidad;
                compraCorrect = true;
            } else {
                JOptionPane.showMessageDialog(null, "La cantidad que desea comprar no puede ser mayor a la cantidad disponible");
            }
        }
        return cantidadV;
    }

    public void insertC(int id_tienda) {
        Compra compra = new Compra();
        compra.setId_tienda(id_tienda);
        String cedula_cliente = JOptionPane.showInputDialog("Ingrese la cedula del cliente: ");
        Cliente objCliente = (Cliente) clienteServicio.findByCC(cedula_cliente);
        if (objCliente == null) {
            clienteControl.insertC(cedula_cliente);
            objCliente = (Cliente) clienteServicio.findByCC(cedula_cliente);
            compra.setId_cliente(objCliente.getId_cliente());
        } else {
            compra.setId_cliente(objCliente.getId_cliente());
        }
        String listProductos = productoControl.getAll(productoModel.findAll(), id_tienda);
        int id_producto = Integer.parseInt(JOptionPane.showInputDialog(listProductos + "\nIngrese el Id del producto"));
        int cantidad = this.controlCompraCantidad(id_producto);
        compra.setId_producto(id_producto);
        compra.setCantidad(cantidad);
        boolean dateCorrect = false;
        while (!dateCorrect) {
            try {
                String inputDate = JOptionPane.showInputDialog("Ingrese la fecha de la cita (YYYY-MM-DD):");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate fechaNacimiento = LocalDate.parse(inputDate, formatter);
                Date fechaCompra = null;
                // Convertimos el String a un objeto Date
                fechaCompra = Date.valueOf(fechaNacimiento);
                compra.setFecha_compra(fechaCompra);
                dateCorrect = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Utilice el formato YYYY-MM-DD.\n" + e.getMessage());
            }
        }
        compraModel.insert(compra);
        Producto objProducto = (Producto) productoServicio.findById(id_producto);
        objProducto.setStock(objProducto.getStock() - cantidad);
        productoModel.update(objProducto);
        JOptionPane.showMessageDialog(null, this.facturacion(compra));
    }

    public void anularVenta(int id_tienda) {
        int confirm = 1;
        int id_compra = Integer.parseInt(JOptionPane.showInputDialog(getAll(compraModel.findAll(), id_tienda) + "\nIngrise el Id de la venta que desea anular: "));
        Compra objCompra = (Compra) compraServicio.findById(id_compra);
        if (objCompra == null) {
            JOptionPane.showMessageDialog(null, "Compra no encontrada");
        } else {
            confirm = JOptionPane.showConfirmDialog(null, "¿Estas seguro? : " + objCompra);
            if (confirm == 0) {
                Producto objProducto = (Producto) objCompra.getObjProducto();
                int stock = objCompra.getCantidad() + objProducto.getStock();
                objProducto.setStock(stock);
                productoModel.update(objProducto);
                this.compraModel.delete(objCompra);
            }
        }
    }

    public void updateC(int id) {
        String listaC = getAll(compraModel.findAll(), id);
        int id_venta = Integer.parseInt(JOptionPane.showInputDialog(listaC + "\nIngrese el Id de la venta: "));
        Compra objCompra = (Compra) compraServicio.findById(id_venta);
        int confirm = 1;
        if (objCompra == null) {
            JOptionPane.showMessageDialog(null, "Busqueda sin resultados.");
        } else {
            String cedula_cliente = JOptionPane.showInputDialog(null, "Ingrese la cedula del cliente: ", objCompra.getObjCliente().getCedula_cliente());
            Cliente objCliente = (Cliente) clienteServicio.findByCC(cedula_cliente);
            if (objCliente == null) {
                clienteControl.insertC(cedula_cliente);
                objCliente = (Cliente) clienteServicio.findByCC(cedula_cliente);
                objCompra.setId_cliente(objCliente.getId_cliente());
            } else {
                objCompra.setId_cliente(objCliente.getId_cliente());
            }

            String listProductos = productoControl.getAll(productoModel.findAll(), objCompra.getId_tienda());
            Producto objProducto = objCompra.getObjProducto();

            objProducto.setStock(objProducto.getStock() + objCompra.getCantidad());
            productoModel.update(objProducto);

            int id_producto = Integer.parseInt(JOptionPane.showInputDialog(listProductos + "\nIngrese el Id del producto", objCompra.getId_producto()));
            int cantidad = this.controlCompraCantidad(id_producto);

            objCompra.setId_producto(id_producto);
            objCompra.setCantidad(cantidad);

            Producto objProductoAct = (Producto) productoServicio.findById(id_producto);
            int stock = objProductoAct.getStock() - cantidad;
            objProducto.setStock(stock);
            productoModel.update(objProductoAct);

            this.compraModel.update(objCompra);
            JOptionPane.showMessageDialog(null, "Nueva Factura" + this.facturacion(objCompra));
        }
    }
}
