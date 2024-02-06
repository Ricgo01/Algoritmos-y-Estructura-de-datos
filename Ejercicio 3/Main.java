


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
        
        
        MergeSort.mergeSort(numbers);
        for (int number : numbers) {
            System.out.println(number);
            
        }
    }
}
    