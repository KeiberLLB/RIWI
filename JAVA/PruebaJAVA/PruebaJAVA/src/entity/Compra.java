package entity;

import java.sql.Date;

public class Compra {
    private int id_compra;
    private int id_cliente;
    private int id_producto;
    private Date fecha_compra;
    private int cantidad;
    private int id_tienda;
    private Producto objProducto;
    private Cliente objCliente;
    private Tienda objTienda;

    public Tienda getObjTienda() {
        return objTienda;
    }

    public void setObjTienda(Tienda objTienda) {
        this.objTienda = objTienda;
    }

    public Compra() {
    }

    public int getId_tienda() {
        return id_tienda;
    }

    public void setId_tienda(int id_tienda) {
        this.id_tienda = id_tienda;
    }

    public Producto getObjProducto() {
        return objProducto;
    }

    public void setObjProducto(Producto objProducto) {
        this.objProducto = objProducto;
    }

    public Cliente getObjCliente() {
        return objCliente;
    }

    public void setObjCliente(Cliente objCliente) {
        this.objCliente = objCliente;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public Date getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        double totalCompra = objProducto.getPrecio() * cantidad;
        double totalPago = totalCompra - (totalCompra * 1.19);
        return "FACTURA VENTA\n"+
                "Id Compra: "+id_compra+"\n"+
                objTienda.toString()+"\n"+
                objCliente.toString()+"\n"+
                "RESUMEN COMPRA: \n"+
                objProducto.getNombre_producto()+": "+cantidad+"\n"+
                "       Total Compra: "+"$ "+totalCompra+"\n"+
                "       TOTAL A PAGAR: "+"$ "+totalPago+"\n"+
                "------------------------------------------------\n";
    }
}
