import controladores.AdmTiendaControl;
import controladores.ClienteControl;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        AdmTiendaControl objATC = new AdmTiendaControl();
        ClienteControl objCliente = new ClienteControl();

        String option = "";
        do {
            option = JOptionPane.showInputDialog("""
                    MENU PRINCIPAL
                    1. Administrador Tienda:
                    2. Control Clientes:
                    3. Salir
                    """);
            switch (option) {
                case "1":
                    objATC.adminTienda();
                    break;
                case "2":
                    objCliente.menuCliente();

                    break;
            }
        } while (!option.equals("3"));

    }
}