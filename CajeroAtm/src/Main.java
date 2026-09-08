
import java.util.ArrayList;
import java.util.Scanner;

class CajeroAutomaticoV2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Crear ArrayList de cuentas
        ArrayList<Cuenta> cuentas = new ArrayList<>();

        // Agregar cuentas
        cuentas.add(new Cuenta("1001", "Juan Pérez", 5000));
        cuentas.add(new Cuenta("1002", "María López", 8500));
        cuentas.add(new Cuenta("1003", "Pedro García", 3200));
        cuentas.add(new Cuenta("1004", "Ana Martínez", 12000));

        String numeroCuenta;
        Cuenta cuentaActual = null;

        // Solicitar número de cuenta
        System.out.println("===== CAJERO AUTOMÁTICO =====");
        System.out.print("Ingrese su número de cuenta: ");

        numeroCuenta = scanner.nextLine();

        // Buscar la cuenta
        for (Cuenta cuenta : cuentas) {

            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                cuentaActual = cuenta;
                break;
            }
        }

        // Verificar si la cuenta existe
        if (cuentaActual == null) {

            System.out.println("Error: la cuenta no existe.");

        } else {

            System.out.println("\nBienvenido: " + cuentaActual.getTitular());
            System.out.println("Número de cuenta: " +
                    cuentaActual.getNumeroCuenta());

            int opcion;
            double cantidad;

            do {

                System.out.println("\n===== MENÚ PRINCIPAL =====");
                System.out.println("1. Consultar saldo");
                System.out.println("2. Depositar dinero");
                System.out.println("3. Retirar dinero");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");

                opcion = scanner.nextInt();

                switch (opcion) {

                    case 1:

                        System.out.println(
                                "Saldo actual: $" +
                                        cuentaActual.getSaldo()
                        );

                        break;

                    case 2:

                        System.out.print(
                                "Cantidad a depositar: $"
                        );

                        cantidad = scanner.nextDouble();

                        if (cantidad > 0) {

                            cuentaActual.depositar(cantidad);

                            System.out.println(
                                    "Depósito exitoso."
                            );

                        } else {

                            System.out.println(
                                    "Error: el depósito debe ser mayor a $0."
                            );
                        }

                        System.out.println(
                                "Saldo actual: $" +
                                        cuentaActual.getSaldo()
                        );

                        break;

                    case 3:

                        System.out.print(
                                "Cantidad a retirar: $"
                        );

                        cantidad = scanner.nextDouble();

                        if (cantidad <= 0) {

                            System.out.println(
                                    "Error: la cantidad debe ser mayor a $0."
                            );

                        } else if (cantidad >
                                cuentaActual.getSaldo()) {

                            System.out.println(
                                    "Error: saldo insuficiente."
                            );

                        } else {

                            cuentaActual.retirar(cantidad);

                            System.out.println(
                                    "Retiro exitoso."
                            );
                        }

                        System.out.println(
                                "Saldo actual: $" +
                                        cuentaActual.getSaldo()
                        );

                        break;

                    case 4:

                        System.out.println(
                                "Gracias por utilizar el cajero automático."
                        );

                        break;

                    default:

                        System.out.println(
                                "Error: opción no válida."
                        );
                }

            } while (opcion != 4);
        }

        scanner.close();
    }
}