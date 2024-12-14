package org.example;

/** Esta clase contiene el proyecto de Navidad de Programación OPERACION "CAMELLO"
 * @author: Mauro Hernández
 * @version: 1.0 (13/12/24)
 */

import java.util.Scanner;


public class Main {

    static Scanner teclado;

    /**
     * Lee y procesa un caso de prueba. Si el caso es válido, calcula el número de días necesarios
     * para alcanzar el objetivo o determina si es imposible. Si se ingresan los valores -1, -1, -1,
     * el programa termina.
     *
     * @return true si se debe continuar procesando casos; false si se debe finalizar.
     */
    public static boolean casoDePrueba() {
        // Leer caso de prueba
        int[] funcion1 = pedirVariables();

        // Salir del programa si se ingresan los valores de terminación
        if (funcion1[0] == -1 && funcion1[1] == -1 && funcion1[2] == -1) {
            return false;
        } else {
            // Verificar y calcular según los valores ingresados
            verificacion(funcion1);
            return true;
        }
    }

    /**
     * Método principal que ejecuta el programa. Se procesa cada caso de prueba hasta que
     * el usuario ingrese los valores para terminar el programa.
     */
    public static void main(String[] args) {
        teclado = new Scanner(System.in);
        while (casoDePrueba()) {
            // Continuar procesando casos de prueba
        }
    }

    /**
     * Solicita al usuario un conjunto de tres valores separados por espacios,
     * los convierte a un array de enteros y los devuelve para su procesamiento.
     * Además nos aseguramos de que la entrada sea la pedida. O bien, un vector
     * [23 23 23] con este formato o [-1 -1 -1] para salir del programa.
     *
     * @return Un array de tres enteros que representa los parámetros ingresados.
     */
    public static int[] pedirVariables() {
        String[] pesos = new String[3];
        int[] pesosint = new int[3];

        System.out.println("Introduce tus parámetros: ");
        String parametros = teclado.nextLine();
        if (!parametros.matches("^(\\d+ \\d+ \\d+|-1 -1 -1)$"))  {
            System.err.println("Introduce los parámetros correctos.");
            return pedirVariables();  // Solicitar nuevamente los parámetros si la entrada es incorrecta
        }
        pesos = parametros.split(" "); // Dividir la entrada en tres valores

        // Convertir los valores de String a int
        for (int i = 0; i < 3; i++) {
            pesosint[i] = Integer.parseInt(pesos[i]);
        }
        return pesosint;
    }

    /**
     * Verifica y calcula los días necesarios para alcanzar un peso deseado.
     * Si la pérdida diaria es menor o igual a la ganancia diaria mínima, imprime
     * "OLVIDA LOS CAMELLOS". De lo contrario, calcula el número de días necesarios.
     *
     * @param funcion1 Un array de enteros con los siguientes valores:
     *                 - funcion1[0]: Peso inicial.
     *                 - funcion1[1]: Pérdida diaria de peso.
     *                 - funcion1[2]: Ganancia diaria.
     */
    public static void verificacion(int[] funcion1) {
        // Validar si el objetivo es imposible
        if (funcion1[1] <= funcion1[2]) {
            System.out.println("OLVIDA LOS CAMELLOS");
        } else {
            // Calcular el número de días necesarios
            int dias = 0;
            int pesoActual = funcion1[0];

            /**
             * Mientras el peso actual sea mayor o igual a la ganancia diaria,
             * se calcula el peso restante después de restar la pérdida diaria
             * y sumar la ganancia diaria mínima.
             */
            while (pesoActual >= funcion1[2]) {
                pesoActual = pesoActual - funcion1[1] + funcion1[2];
                dias++; // Incrementar el contador de días
            }

            // Imprimir el número de días calculados
            System.out.println(dias);
        }
    }
}
