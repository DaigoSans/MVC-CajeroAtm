package view;
import controller.CajeroController;
import model.Cuenta;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        //Ejemplos del código original:
        cuentas.add(
                new Cuenta(
                        "1001",
                        "Juan Pérez",
                        5000));
        cuentas.add(
                new Cuenta(
                        "1002",
                        "María López",
                        8500));
        cuentas.add(
                new Cuenta(
                        "1003",
                        "Pedro García",
                        3200));
        cuentas.add(
                new Cuenta(
                        "1004",
                        "Ana Martínez",
                        12000));
        CajeroView vista = new CajeroView();
        CajeroController controlador =
                new CajeroController(
                        cuentas,
                        vista);
        controlador.iniciar();
    }
}