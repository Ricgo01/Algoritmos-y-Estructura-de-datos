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
 * JUnit tests
 *  
*/





import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GeneradorTest {

	@Test
	public void testGnomeSort() {
	
	    int[] arr = {5, 2, 7, 3, 9, 1};
	    int[] expected = {1, 2, 3, 5, 7, 9};
	
	    GnomeSort.gnomeSort(arr);
	
	    assertArrayEquals(expected, arr);
	}
		
	@Test
    public void testMergeSort() {
        // Arrange
        int[] arr = {5, 2, 7, 3, 9, 1};
        int[] expected = {1, 2, 3, 5, 7, 9};

        // Act
        MergeSort.mergeSort(arr);

        // Assert
        assertArrayEquals(expected, arr);
    }
	
	
	@Test
    public void testQuickSort() {
        // Arrange
        int[] arr = {5, 2, 7, 3, 9, 1};
        int[] expected = {1, 2, 3, 5, 7, 9};

        // Act
        QuickSort.quickSort(arr, 0, arr.length - 1);

        // Assert
        assertArrayEquals(expected, arr);
        
        
    }
	
	 @Test
	    public void testRadixSort() {
	        // Arrange
	        int[] arr = {5, 2, 7, 3, 9, 1};
	        int[] expected = {1, 2, 3, 5, 7, 9};

	        // Act
	        RadixSort.radixSort(arr, arr.length);

	        // Assert
	        assertArrayEquals(expected, arr);
	    }
	 
	 @Test
	    public void testInsertionSort() {
	        // Arrange
	        int[] arr = {5, 2, 7, 3, 9, 1};
	        int[] expected = {1, 2, 3, 5, 7, 9};

	        // Act
	        InsertionSort.insertionSort(arr);

	        // Assert
	        assertArrayEquals(expected, arr);
	    }


}
