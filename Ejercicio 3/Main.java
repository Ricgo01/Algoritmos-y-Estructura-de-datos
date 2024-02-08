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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.lang.model.util.Elements;

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
        
       
        
        for(int i = 0; i < 3000; i += 11) {
        	int remaining = 3000 - i;
        	int blockToRead = Math.min(11, remaining);
       
        

        while (condition) {
            System.out.println("1. Gnome Sort");
            System.out.println("2. Merge Sort");
            System.out.println("3. Quick Sort");
            System.out.println("4. Radix Sort");
            System.out.println("5. Insertion Sort");
            System.out.println("Seleccione el algoritmo de ordenamiento que desea utilizar: ");

            switch (lector.nextInt()) { 
            case 1: 
                for(int i = 11; i < numbers.length; i++) {
                	int[] arr0 = numbers.clone();
                    GnomeSort.gnomeSort(numbers);
                    for(int j = 0; j< arr0.length; j++) {
                    	System.out.println(arr0[j] + "");
                    }
       
                }
                break;

            case 2: 
                for(int i = 11; i < numbers.length; i++) {
                	int[] arr1 = numbers.clone();
                    MergeSort.mergeSort(numbers);
                    for(int j = 0; j< arr1.length; j++) {
                    	System.out.println(arr1[j] + "");
                    }
                }
                break;

            case 3:
                for(int i = 11 ; i < numbers.length; i++) {
                	int[] arr2 = numbers.clone();
                    QuickSort.quickSort(numbers, 0, numbers.length - 1);
                    for(int j = 0; j< arr2.length; j++) {
                    	System.out.println(arr2[j] + "");
                    }
                    //shuffleArray(numbers);
                }
                break;

            case 4:
                for(int i = 11; i < numbers.length; i++) {
                	int[] arr3 = numbers.clone();
                    RadixSort.radixSort(numbers, count);
                    for(int j = 0; j< arr3.length; j++) {
                    	System.out.println(arr3[j] + "");
                    }
                    //shuffleArray(numbers);
                }
                break;

            case 5:
                for(int i = 11; i < numbers.length; i++) {
                	int[] arr4 = numbers.clone();
                    InsertionSort.insertionSort(numbers);
                    for(int j = 0; j< arr4.length; j++) {
                    	System.out.println(arr4[j] + "");
                    }
                   // shuffleArray(numbers);
                }
                break;
            }

            System.out.println("Desea continuar? (1. Si, 2. No, 3. Imprimir números)");
            if (lector.nextInt() == 2) {
                condition = false;
            }
            else if (lector.nextInt() == 1) {
                condition = true;
                shuffleArray(numbers);
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