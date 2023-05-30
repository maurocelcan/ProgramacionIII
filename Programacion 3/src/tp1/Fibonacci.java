package tp1;

public class Fibonacci {

	public Fibonacci() {
		
	}
	
	public String secuenciaFibonacci(int n) {
	    String secuencia = "";
	    for (int i = 0; i < n; i++) {
	        secuencia += fibonacci(i) + " ";
	    }
	    return secuencia.trim();
	}
	
	public int fibonacci(int n) {
	    if (n <= 1) {
	        return n;
	    } else {
	        return fibonacci(n-1) + fibonacci(n-2);
	    }
	}
	    
}
