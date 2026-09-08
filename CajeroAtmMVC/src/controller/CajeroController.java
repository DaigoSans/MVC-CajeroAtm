package controller;
import java.util.ArrayList;
import model.Cuenta;
import view.CajeroView;
public class CajeroController {
    private ArrayList<Cuenta> cuentas;
    private CajeroView vista;

    public CajeroController(ArrayList<Cuenta> cuentas, CajeroView vista) {
        this.cuentas = cuentas;
        this.vista = vista;
    }

    public void iniciar() {
        vista.mostrarMensaje("===== CAJERO AUTOMÁTICO =====");
        String numeroCuenta = vista.pedirNumeroCuenta();
        Cuenta cuentaActual = buscarCuenta(numeroCuenta);
        if (cuentaActual == null) {
            vista.mostrarMensaje("Error: la cuenta no existe.");
            return;
        }
        vista.mostrarMensaje(
                "\nBienvenido: " + cuentaActual.getTitular());
        vista.mostrarMensaje(
                "Número de cuenta: " + cuentaActual.getNumeroCuenta());
        int op;
        do {
            op = vista.mostrarMenu();

            switch (op) {
                case 1:
                    vista.mostrarMensaje(
                            "Saldo actual: $" + cuentaActual.getSaldo());
                    break;
                case 2:
                    double deposito = vista.pedirCantidad("depositar");
                    if (deposito > 0) {
                        cuentaActual.depositar(deposito);
                        vista.mostrarMensaje(
                                "Depósito exitoso.");
                    } else {
                        vista.mostrarMensaje(
                                "Error: el depósito debe ser mayor a $0.");
                    }
                    break;
                case 3:
                    double retiro = vista.pedirCantidad("retirar");
                    if (retiro <= 0) {
                        vista.mostrarMensaje("Error: la cantidad debe ser mayor a $0.");
                    } else if (cuentaActual.retirar(retiro)) {
                        vista.mostrarMensaje("Retiro exitoso.");
                    }
                    else {
                        vista.mostrarMensaje("Error: saldo insuficiente.");
                    }
                    break;
                case 4:
                    vista.mostrarMensaje("Gracias por utilizar el cajero automático.");
                    break;
                default:
                    vista.mostrarMensaje("Error: opción no válida.");
            }
        } while (op != 4);
        vista.cerrarScanner();
    }

    private Cuenta buscarCuenta(String numeroCuenta) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                return cuenta;
            }
        }
        return null;
    }
}
