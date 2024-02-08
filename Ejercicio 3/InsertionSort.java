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
 * Clase que implementa el algoritmo de ordenamiento por inserción.
 * El ordenamiento por inserción es un simple algoritmo de ordenamiento que construye
 * el array final (ordenado) uno por uno. Es mucho menos eficiente en listas grandes
 * que algoritmos más avanzados como quicksort, heapsort o mergesort.
 */
public class InsertionSort{
    /**
     * Ordena un array de enteros utilizando el algoritmo de ordenamiento por inserción.
     * 
     * @param array Array de enteros a ordenar.
     */
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = current;
        }
    }
}