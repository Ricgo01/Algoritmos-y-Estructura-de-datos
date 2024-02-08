import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
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
 * Clase que proporciona una funcionalidad para generar números aleatorios y escribirlos en un archivo.
 * Esta clase utiliza la clase {@link Random} para generar números aleatorios dentro de un rango especificado
 * y {@link BufferedWriter} junto con {@link FileWriter} para escribir los números generados en un archivo.
 */

public class Generador {

    /**
     * Genera una cantidad especificada de números aleatorios y los escribe en un archivo.
     * 
     * @param filePath La ruta del archivo donde se escribirán los números aleatorios.
     * @param count La cantidad de números aleatorios a generar.
     */
    public static void generateNumbers(String filePath, int count) {
        Random random = new Random();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < count; i++) {
                int randomNumber = random.nextInt(10000);
                writer.write(randomNumber + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}