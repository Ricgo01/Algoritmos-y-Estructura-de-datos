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
            System.out.println("1. Gnome Sort");
            System.out.println("2. Merge Sort");
            System.out.println("3. Quick Sort");
            System.out.println("4. Radix Sort");
            System.out.println("5. Insertion Sort");
            System.out.println("Seleccione el algoritmo de ordenamiento que desea utilizar: ");

            switch (lector.nextInt()) { 
            case 1: 
                for(int i = 0; i < 100; i++) {
                    GnomeSort.gnomeSort(numbers);
                    shuffleArray(numbers);
                }
                break;

            case 2: 
                for(int i = 0; i < 100; i++) {
                    MergeSort.mergeSort(numbers);
                    shuffleArray(numbers);
                }
                break;

            case 3:
                for(int i = 0; i < 100; i++) {
                    QuickSort.quickSort(numbers, 0, numbers.length - 1);
                    shuffleArray(numbers);
                }
                break;

            case 4:
                for(int i = 0; i < 100; i++) {
                    RadixSort.radixSort(numbers, count);
                    shuffleArray(numbers);
                }
                break;

            case 5:
                for(int i = 0; i < 100; i++) {
                    InsertionSort.insertionSort(numbers);
                    shuffleArray(numbers);
                }
                break;
            }

            System.out.println("Desea continuar? (1. Si, 2. No, 3. Imprimir números)");
            if (lector.nextInt() == 2) {
                condition = false;
            }
            else if (lector.nextInt() == 1) {
                condition = true;
            }
            else if (lector.nextInt() == 3) {
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
}
    