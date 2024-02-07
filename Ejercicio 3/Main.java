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



import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Main {
    public static void main(String[] args) {
    	
    	
        String filePath = "randomNumbers.txt"; 
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
        
        
        
        GnomeSort.gnomeSort(numbers); 
        for (int number : numbers) {
            System.out.println(number);
            
        }
        System.out.println("Se han ordenado los números con GnomeSort");
        
        MergeSort.mergeSort(numbers);
        for (int number : numbers) {
            System.out.println(number);
            
        }
        System.out.println("Se han ordenado los números con MergeSort");

        QuickSort.quickSort(numbers, 0, numbers.length - 1);
        for (int number : numbers) {
            System.out.println(number);
            
        }
        System.out.println("Se han ordenado los números con QuickSort");
        
        RadixSort.radixSort(numbers, count);
        for (int number : numbers) {
            System.out.println(number);
            
        }
        System.out.println("Se han ordenado los números con RadixSort");

        InsertionSort.insertionSort(numbers);
        for (int number : numbers) {
            System.out.println(number);
        }
        System.out.println("Se han ordenado los números con InsertionSort");
    }
}
    