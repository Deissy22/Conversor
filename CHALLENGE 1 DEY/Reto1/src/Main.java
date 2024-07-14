import java.io.IOException;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        CambioDeTasaCliente cliente = new CambioDeTasaCliente();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Mostrar las opciones disponibles
            System.out.println("Bienvenido al conversor de moneda");
            System.out.println("Opciones:");
            System.out.println("1. ARS a BRL");
            System.out.println("2. BOB a COP");
            System.out.println("3. CLP a USD");
            System.out.println("4. USD a COP");
            System.out.println("5. Salir");
            // Pedir la opción al usuario
            System.out.print("Seleccione una opción (1-5): ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            if (opcion == 5) {
                System.out.println("¡Hasta luego!");
                break;
            }

            // Pedir la cantidad a convertir
            System.out.print("Ingrese la cantidad a convertir: ");
            double cantidad = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer de entrada

            // Realizar la conversión según la opción seleccionada
            double resultado = 0.0;
            switch (opcion) {
                case 1:
                    resultado = convertirARSaBRL(cliente, cantidad);
                    break;
                case 2:
                    resultado = convertirBOBaCOP(cliente, cantidad);
                    break;
                case 3:
                    resultado = convertirCLPaUSD(cliente, cantidad);
                    break;
                case 4:
                    resultado = convertirUSDaCOP(cliente, cantidad);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    continue;
            }

            // Mostrar el resultado de la conversión
            System.out.println("Resultado de la conversión: " + resultado);
            System.out.println();
        }

        scanner.close();
    }

    // Métodos de conversión específicos

    private static double convertirARSaBRL(CambioDeTasaCliente cliente, double cantidad) throws IOException, InterruptedException {
        double tasa = cliente.getTasaDeCambio("ARS", "BRL");
        return cliente.conversionDinero(tasa, cantidad);
    }

    private static double convertirBOBaCOP(CambioDeTasaCliente cliente, double cantidad) throws IOException, InterruptedException {
        double tasa = cliente.getTasaDeCambio("BOB", "COP");
        return cliente.conversionDinero(tasa, cantidad);
    }

    private static double convertirCLPaUSD(CambioDeTasaCliente cliente, double cantidad) throws IOException, InterruptedException {
        double tasa = cliente.getTasaDeCambio("CLP", "USD");
        return cliente.conversionDinero(tasa, cantidad);
    }

    private static double convertirUSDaCOP(CambioDeTasaCliente cliente, double cantidad) throws IOException, InterruptedException {
        double tasa = cliente.getTasaDeCambio("USD", "COP");
        return cliente.conversionDinero(tasa, cantidad);
    }
}
