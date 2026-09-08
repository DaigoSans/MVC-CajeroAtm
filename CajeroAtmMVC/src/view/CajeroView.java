package view;
import java.util.Scanner;

public class CajeroView {

    private Scanner scanner;

    public CajeroView() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public String pedirNumeroCuenta() {
        System.out.print("Ingrese su número de cuenta: ");
        return scanner.nextLine();
    }

    public int mostrarMenu() {

        System.out.println("\n===== MENÚ PRINCIPAL =====");
        System.out.println("1. Consultar saldo");
        System.out.println("2. Depositar dinero");
        System.out.println("3. Retirar dinero");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");

        return scanner.nextInt();
    }

    public double pedirCantidad(String operacion) {

        System.out.print("Cantidad a " + operacion + ": $");
        return scanner.nextDouble();
    }

    public void cerrarScanner() {
        scanner.close();
    }
}
