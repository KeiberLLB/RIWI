package entity;

public class Cliente {
    private int id_cliente;
    private String nombre_cliente;
    private String apellido_cliente;
    private String email;
    private String cedula_cliente;

    public Cliente() {
    }

    public Cliente(String nombre_cliente, String apellido_cliente, String email, String cedula_cliente) {
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
        this.email = email;
        this.cedula_cliente = cedula_cliente;
    }

    public String getCedula_cliente() {
        return cedula_cliente;
    }

    public void setCedula_cliente(String cedula_cliente) {
        this.cedula_cliente = cedula_cliente;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getApellido_cliente() {
        return apellido_cliente;
    }

    public void setApellido_cliente(String apellido_cliente) {
        this.apellido_cliente = apellido_cliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente\n" +
                "   Id Cliente: " + id_cliente + "\n" +
                "   Nombre Cliente: " + nombre_cliente + "\n" +
                "   Cédula Cliente: " + cedula_cliente + "\n" +
                "   Apellido Cliente: " + apellido_cliente + "\n" +
                "   email: " + email + "\n";
    }
}
