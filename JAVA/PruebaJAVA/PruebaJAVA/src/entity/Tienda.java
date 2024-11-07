package entity;

public class Tienda {
    private int id_tienda;
    private String nombre;
    private String ubicacion;

    public Tienda() {
    }

    public int getId_tienda() {
        return id_tienda;
    }

    public void setId_tienda(int id_tienda) {
        this.id_tienda = id_tienda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "Tienda\n" +
                "   Id Tienda: " + id_tienda + "\n" +
                "   Nombre: " + nombre + "\n" +
                "   Dirección: " + ubicacion + "\n";
    }
}
