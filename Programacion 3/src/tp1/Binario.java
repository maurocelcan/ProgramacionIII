package tp1;

public class Binario {

	public Binario() {
		
	}
	
	public String decimalABinario(int decimal) {
	    if(decimal == 0) {
	        return "";
	    } else {
	        int resto = decimal % 2;
	        String binario = decimalABinario(decimal / 2) + resto;
	        return binario;
	    }
	}
}
