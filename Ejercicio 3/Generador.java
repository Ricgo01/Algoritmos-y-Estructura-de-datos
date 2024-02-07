import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Generador {
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