
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
 * Clase que implementa el algoritmo de ordenamiento Gnome Sort.
 * Gnome Sort, también conocido como Sorting by Stupidity, es un algoritmo de ordenamiento
 * que se basa en el concepto de un gnomo de jardín que ordena sus macetas. La idea es simple:
 * el gnomo mira la maceta siguiente y la anterior; si están en el orden correcto, avanza,
 * de lo contrario, las intercambia y da un paso atrás. El borde del array es el punto de parada.
 */
public class GnomeSort {

     /**
     * Ordena un array de enteros utilizando el algoritmo de ordenamiento Gnome Sort.
     * 
     * @param arr Array de enteros a ordenar.
     */
    public static void gnomeSort(int[] arr) {
        int index = 0;
        while (index < arr.length) {
            if (index == 0 || arr[index - 1] <= arr[index]) {
                index++;
            } else {
                int temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
    }
}
