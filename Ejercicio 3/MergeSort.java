
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
 * Clase que implementa el algoritmo de ordenamiento Merge Sort.
 * Merge Sort es un algoritmo de ordenamiento de tipo dividir y conquistar que divide el array en
 * mitades hasta que cada segmento contenga un solo elemento, y luego los combina en orden ascendente.
 */
public class MergeSort {

    /**
     * Método público para ordenar un array de enteros utilizando el algoritmo Merge Sort.
     * 
     * @param arr Array de enteros a ordenar.
     */
	
    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right;

        if (arr.length % 2 == 0) {
            right = new int[mid];
        } else {
            right = new int[mid + 1];
        }

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }

        for (int j = 0; j < right.length; j++) {
            right[j] = arr[mid + j];
        }

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    /**
     * Método privado para combinar dos subarrays en uno solo de forma ordenada.
     * 
     * @param arr Array original que será modificado para contener los elementos combinados.
     * @param left Subarray izquierdo.
     * @param right Subarray derecho.
     */

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
 
        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

}
