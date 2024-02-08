/*
 * Algoritmos y Estructura de Datos
 * 3 Semestre
 * Facultad de Ingenieria
 * Departamento de Ciencias de la Computacion
 * Fecha inicio: 28/01/2024
 * Fecha final: 07/02/2024
 *
 * @author Vianka Castro 23201
 * 		   Ricardo Godinez 23247
 * 
 *  
 * Clase Main 
 *  
*/

import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    /**
     * Punto de entrada principal del programa. Ejecuta el proceso de comparación
     * de algoritmos de ordenamiento.
     *
     * @param args Argumentos de línea de comando. No se utilizan en este programa.
     */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        String filePath = "randomNumbers.txt";
        int count = 3000;

        // Genera números aleatorios y los guarda en un archivo.
        Generador.generateNumbers(filePath, count);
        System.out.println("Se han generado " + count + " números aleatorios en el archivo " + filePath);

        int[] numbers = new int[count];
        try (Scanner scanner = new Scanner(new File(filePath))) {
            for (int i = 0; i < count; i++) {
                numbers[i] = scanner.nextInt();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return;

        }

        while (true) {
            System.out.println("Seleccione el algoritmo de ordenamiento que desea utilizar: ");
            System.out.println("1. Gnome Sort");
            System.out.println("2. Merge Sort");
            System.out.println("3. Quick Sort");
            System.out.println("4. Radix Sort");
            System.out.println("5. Insertion Sort");

            int option = lector.nextInt();
            for (int subArraySize = 11; subArraySize <= count; subArraySize++) {
                int[] subArray = new int[subArraySize];
                System.arraycopy(numbers, 0, subArray, 0, subArraySize);

                long startTime = System.nanoTime();
                
                switch (option) {
                    case 1:
                        GnomeSort.gnomeSort(subArray);
                        break;
                    case 2:
                        MergeSort.mergeSort(subArray);
                        break;
                    case 3:
                        QuickSort.quickSort(subArray, 0, subArray.length - 1);
                        break;
                    case 4:
                        RadixSort.radixSort(subArray, subArraySize);
                        break;
                    case 5:
                        InsertionSort.insertionSort(subArray);
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }

                long endTime = System.nanoTime();
                long duration = endTime - startTime;
                System.out.println("Ordenando " + subArraySize + " elementos: " + duration + " nanosegundos");
            }

            System.out.println("Desea probar otro algoritmo? (1. Si, 2. No)");
            int decision = lector.nextInt();
            if (decision != 1) {
                break;
            }
        }
        lector.close();
    }
}
