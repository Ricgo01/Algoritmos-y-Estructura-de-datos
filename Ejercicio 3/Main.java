/*
 * Algoritmos y Estructura de Datos
 * 3 Semestre
 * Facultad de Ingenieria
 * Departamento de Ciencias de la Computacion
 * Fecha inicio: 28/01/2024
 * Fecha final: 06/02/2024
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

import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        String filePath = "randomNumbers.txt";
        boolean condition = true;

        // for count = 11 to 300
        int count = 3000;
        Generador.generateNumbers(filePath, count);
        System.out.println("Se han generado " + count + " números aleatorios en el archivo " + filePath);

        int[] numbers = new int[count];
        try (Scanner scanner = new Scanner(new File(filePath))) {
            for (int i = 0; i < count; i++) {
                numbers[i] = scanner.nextInt();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        while (condition) {
            System.out.println("Seleccione el algoritmo de ordenamiento que desea utilizar: ");
            System.out.println("1. Gnome Sort");
            System.out.println("2. Merge Sort");
            System.out.println("3. Quick Sort");
            System.out.println("4. Radix Sort");
            System.out.println("5. Insertion Sort");

            int option = lector.nextInt();
            long[] times = new long[3000]; // Array para almacenar los tiempos de ejecución

            switch (option) {
                case 1:
                    for (int i = 0; i < 3000; i++) {
                        int[] arr0 = numbers.clone();
                        long startTime = System.nanoTime();
                        GnomeSort.gnomeSort(arr0);
                        long endTime = System.nanoTime();
                        times[i] = endTime - startTime;
                    }
                    printTimeTable("Gnome Sort", times);
                    break;

                case 2:
                    for (int i = 0; i < 3000; i++) {
                        int[] arr1 = numbers.clone();
                        long startTime = System.nanoTime();
                        MergeSort.mergeSort(arr1);
                        long endTime = System.nanoTime();
                        times[i] = endTime - startTime;
                    }
                    printTimeTable("Merge Sort", times);
                    break;

                case 3:
                    for (int i = 0; i < 3000; i++) {
                        int[] arr2 = numbers.clone();
                        long startTime = System.nanoTime();
                        QuickSort.quickSort(arr2, 0, arr2.length - 1);
                        long endTime = System.nanoTime();
                        times[i] = endTime - startTime;
                    }
                    printTimeTable("Quick Sort", times);
                    break;

                case 4:
                    for (int i = 0; i < 3000; i++) {
                        int[] arr3 = numbers.clone();
                        long startTime = System.nanoTime();
                        RadixSort.radixSort(arr3, count);
                        long endTime = System.nanoTime();
                        times[i] = endTime - startTime;
                    }
                    printTimeTable("Radix Sort", times);
                    break;

                case 5:
                    for (int i = 0; i < 3000; i++) {
                        int[] arr4 = numbers.clone();
                        long startTime = System.nanoTime();
                        InsertionSort.insertionSort(arr4);
                        long endTime = System.nanoTime();
                        times[i] = endTime - startTime;
                    }
                    printTimeTable("Insertion Sort", times);
                    break;
            }

            System.out.println("Desea continuar? (1. Si, 2. No, 3. Imprimir números)");
            int decision = lector.nextInt();
            if (decision == 2) {
                condition = false;
            } else if (decision == 1) {
                condition = true;
                shuffleArray(numbers);
            } else if (decision == 3) {
                for (int i = 0; i < count; i++) {
                    System.out.println(numbers[i]);
                }
            }
        }
        lector.close();
    }

    private static void shuffleArray(int[] array) {
        Random rand = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            // Intercambio simple
            int a = array[index];
            array[index] = array[i];
            array[i] = a;
        }
    }

    private static void printTimeTable(String algorithm, long[] times) {
        System.out.println("Tiempo promedio para " + algorithm + ":");
        System.out.println("Iteración | Tiempo (nanosegundos)");
        System.out.println("----------------------------------");
        for (int i = 0; i < times.length; i++) {
            System.out.printf("%9d | %20d\n", i + 1, times[i]);
        }
    }
}
