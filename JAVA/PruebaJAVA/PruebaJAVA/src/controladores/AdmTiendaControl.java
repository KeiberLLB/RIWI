package controladores;

import Servicios.ProductoServicio;
import Servicios.TiendaServicio;
import entity.Producto;
import model.CompraModel;
import model.ProductoModel;

import javax.swing.*;

public class AdmTiendaControl {

    ProductoControl productoControl = new ProductoControl();
    TiendaServicio objTiendaServicio = new TiendaServicio();
    TiendaControl objTiendaControl = new TiendaControl();
    CompraControl objCompraControl = new CompraControl();
    CompraModel objCompraModel = new CompraModel();

    public void adminTienda() {
        String list = this.objTiendaControl.getAll(objTiendaServicio.findAll());

        int id_tienda = Integer.parseInt(JOptionPane.showInputDialog(list + "\nIngrese el id de la tienda: "));
        String option = "";
        do {
            option = JOptionPane.showInputDialog("""
                    MENU TIENDA
                    1. Nueva Venta
                    2. Registrar Nuevo Producto
                    3. Actualizar Producto
                    4. Eliminar Producto
                    5. Ventas de la tienda
                    6. Anular Venta
                    7. Actualizar Venta
                    8. Salir
                    """);
            switch (option) {
                case "1":
                    objCompraControl.insertC(id_tienda);
                    break;
                case "2":
                    productoControl.insertP(id_tienda);
                    break;
                case "3":
                    productoControl.updateP(id_tienda);
                    break;
                case "4":
                    productoControl.deleteP(id_tienda);
                    break;
                case "5":
                    JOptionPane.showMessageDialog(null, objCompraControl.getAll(objCompraModel.findAll(), id_tienda));
                    break;
                case "6":
                    objCompraControl.anularVenta(id_tienda);
                    break;
                case "7":
                    objCompraControl.updateC(id_tienda);
                    break;
                case "8":
            }
        } while (!option.equals("8"));
    }
}
