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
 * Clase que implementa el algoritmo de ordenamiento QuickSort.
 * QuickSort es un algoritmo de ordenamiento dividir y conquistar. Este algoritmo
 * selecciona un elemento como pivote y particiona el array dado alrededor del pivote elegido.
 */


public class QuickSort {

    /**
     * Método para ordenar un array de enteros utilizando el algoritmo QuickSort.
     * 
     * @param array El array de enteros a ordenar.
     * @param low Índice del inicio del segmento del array a ordenar.
     * @param high Índice del fin del segmento del array a ordenar.
     */

    
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
             // Particiona el array y obtiene el índice del pivote.
            int pi = partition(array, low, high);

            // Ordena recursivamente las dos subpartes.
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    /**
     * Método auxiliar para particionar el array alrededor de un pivote.
     * Los elementos menores que el pivote se colocan antes de este y los mayores después.
     * 
     * @param array El array de enteros a particionar.
     * @param low Índice del inicio del segmento del array a particionar.
     * @param high Índice del pivote en el array.
     * @return El índice del pivote después de la partición.
     */

    private static int partition(int[] array, int low, int high) {
        // Selecciona el último elemento como pivote.
        int pivot = array[high];

        // Puntero para el mayor elemento.
        int i = (low - 1);
        // Recorre todos los elementos excepto el pivote.
        for (int j = low; j < high; j++) {
            
            if (array[j] <= pivot) {
                i++;

                // Intercambia los elementos en i y j.
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Coloca el pivote en su posición correcta.
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        
        return i + 1;
    }
    /**
     * Método principal para probar el algoritmo QuickSort.
     * 
     * @param args Argumentos de línea de comando (no utilizados).
     */
    
    public static void main(String[] args) {
        int[] array = {10, 7, 8, 9, 1, 5};
        int n = array.length;

        // Ordena el array utilizando QuickSort.
        quickSort(array, 0, n - 1);
        // Muestra el array ordenado.
        System.out.println("Array ordenado: ");
        for (int value : array) {
            System.out.print(value + " ");
        }
    }
}
