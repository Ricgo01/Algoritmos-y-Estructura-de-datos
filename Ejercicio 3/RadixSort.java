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
 * Clase que implementa el algoritmo de ordenamiento Radix Sort.
 * Radix Sort es un algoritmo de ordenamiento no comparativo que ordena los datos con claves enteras
 * procesando las representaciones digitales de dichas claves en varias pasadas.
 */





public class RadixSort {

	/**
     * Ordena un array de enteros utilizando Radix Sort.
     * 
     * @param arr Array de enteros a ordenar.
     * @param n Tamaño del array.
     */
    public static void radixSort(int[] arr, int n) {
    	
    	int max = getMax(arr, n);
    	
    	for(int exp = 1; max/exp > 0; exp *=10) {
    		countingSort(arr, n, exp);
    	}
    	
    	
    }
    
  /**
     * Método auxiliar para realizar el conteo de sort en arr[] según
     * el dígito representado por exp.
     * 
     * @param arr Array de entrada a ordenar.
     * @param n Tamaño del array.
     * @param exp Exponente que representa el dígito actual a considerar.
     */
    
    public static void countingSort(int arr[], int n, int exp ) {
    	
    	int output[] = new int[n];
    	 
    	int count[] = new int[10];
    	
    	for (int i = 0; i<n ; i++) {
    		count[(arr[i]/exp) % 10]++;
    	}
    	
    	for(int i = 1; i < 10; i++) {
    		count[i] += count[i -1];
    	}
    	
    	for(int i = n - 1; i >= 0; i--) {
    		output[count[(arr[i]/exp)%10]-1] = arr[i];
    		count[(arr[i]/exp)%10]--;	
    		
    	 
    	}
    	System.arraycopy(output, 0, arr, 0, n);
    	
    }
    
    /**
     * Método auxiliar para obtener el valor máximo en arr[].
     * 
     * @param arr Array de entrada.
     * @param n Tamaño del array.
     * @return El valor máximo en arr[].
     */
    
    static int getMax(int arr[], int n) {
    	int mx = arr[0];
    	
    	for(int i = 1; i<n; i ++) {
    		
    		if(arr[i]>mx)
    			
    			mx = arr[i];
    	}
		return mx;
    }
}
