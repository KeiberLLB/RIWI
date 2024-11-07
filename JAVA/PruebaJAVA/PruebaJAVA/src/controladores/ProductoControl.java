package controladores;

import Servicios.ProductoServicio;
import entity.Producto;
import entity.Producto;
import model.ProductoModel;

import javax.swing.*;
import java.util.List;

public class ProductoControl {
    ProductoModel productoModel = new ProductoModel();
    ProductoServicio productoServicio = new ProductoServicio();

    public String getAll(List<Object> object, int id_tienda) {
        String list = "Lista de Productos: \n";
        for (Object producto : object) {
            Producto objProducto = (Producto) producto;
            if (objProducto.getId_tienda() == id_tienda && objProducto.getStock() > 0) {
                list += objProducto.toString() + "\n";
            }
        }
        return list;
    }

    public void insertP(int id_tienda) {
        Producto producto = new Producto();
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del nuevo producto: ");
        int stock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Stock inicial del producto: "));
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto: "));

        producto.setId_tienda(id_tienda);
        producto.setStock(stock);
        producto.setNombre_producto(nombre);
        producto.setPrecio(precio);

        producto = (Producto) this.productoModel.insert(producto);
        JOptionPane.showMessageDialog(null, producto);
    }

    public void updateP(int id_tienda) {
        String list = this.getAll(productoModel.findAll(), id_tienda);
        int id_producto = Integer.parseInt(JOptionPane.showInputDialog(list + "Ingrese el ID del producto: "));
        Producto producto = (Producto) productoServicio.findById(id_producto);
        if (producto == null) {
            JOptionPane.showMessageDialog(null, "Busqueda sin resultados.");
        } else {
            producto.setNombre_producto(JOptionPane.showInputDialog(null, "Ingrese el nombre del producto", producto.getNombre_producto()));
            producto.setPrecio(Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el precio del producto", producto.getPrecio())));
            producto.setStock(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nuevo stock del producto(si es necesario)", producto.getStock())));
            producto.setId_tienda(id_tienda);
            this.productoModel.update(producto);
        }
    }

    public void deleteP(int id_tienda) {
        int confirm = 1;
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(this.getAll(productoModel.findAll(), id_tienda) + "\nIngrese el Id de la especialidad a eliminar: "));
        Producto objProducto = (Producto) productoServicio.findById(idDelete);
        if (objProducto == null) {
            JOptionPane.showMessageDialog(null, "Producto no encontrado");
        } else {
            confirm = JOptionPane.showConfirmDialog(null, "Estas seguro? : \n" + objProducto);
            if (confirm == 0) {
                productoModel.delete(objProducto);
            }
        }
    }
}
