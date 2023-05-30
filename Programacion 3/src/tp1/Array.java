package tp1;

public class Array {

	
	//Ejercicio 10
	public boolean estaOrdenadoAscendente(int[] arr, int lenght) {
	    // Caso base
	    if (lenght == 1) {
	        return true;
	    }else {
	    	// Caso recursivo
	    	if(arr[lenght - 1] >= arr[lenght - 2]) {
	    		return estaOrdenadoAscendente(arr, lenght - 1);
	    	}
	    }
	    return false;
	}
	
	//Ejercicio 11
	public int busquedaBinaria(int[]arr, int elemento, int inicio, int fin) {
		int medio = (int) Math.floor((inicio + fin-1)/2);
		if(inicio > fin) {
			return -1;
		}else {
			if(elemento > arr[medio]) {
				return busquedaBinaria(arr, elemento, medio+1, fin);
			}else {
				if(elemento < arr[medio]) {
					return busquedaBinaria(arr, elemento, inicio, medio-1);
				}else {
					return medio;
				}
			}
		}
		
	}
}
