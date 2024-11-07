package entity;

public class Producto {
    private int id_producto;
    private String nombre_producto;
    private double precio;
    private int id_tienda;
    private int stock;
    private Tienda objTienda;

    public Producto() {
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId_tienda() {
        return id_tienda;
    }

    public void setId_tienda(int id_tienda) {
        this.id_tienda = id_tienda;
    }

    public Tienda getObjTienda() {
        return objTienda;
    }

    public void setObjTienda(Tienda objTienda) {
        this.objTienda = objTienda;
    }

    @Override
    public String toString() {
        return "    Producto\n" +
                "       Id Producto: " + id_producto + "\n" +
                "       Nombre Producto: " + nombre_producto + "\n" +
                "       Precio: " + "$ " + precio + "\n" +
                "       Stock: " + stock;
    }
}
