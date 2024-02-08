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

public class Main {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        String filePath = "randomNumbers.txt";
        boolean condition = true;

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

        for (int i = 11; i < numbers.length; i++) {
            int[] arr = numbers.clone();
            GnomeSort.gnomeSort(arr);
            printArray(arr);

            arr = numbers.clone();
            MergeSort.mergeSort(arr);
            printArray(arr);

            arr = numbers.clone();
            QuickSort.quickSort(arr, 0, arr.length - 1);
            printArray(arr);

            arr = numbers.clone();
            RadixSort.radixSort(arr, count);
            printArray(arr);

            arr = numbers.clone();
            InsertionSort.insertionSort(arr);
            printArray(arr);
        }

        lector.close();
    }

    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
