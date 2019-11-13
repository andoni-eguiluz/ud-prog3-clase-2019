package es.deusto.prog3.cap04;

public class ExploracionRecursiva {

	private static String nombre = "Prueba";
	
	public static void main(String[] args) {
		prueba1();
	}
	
	private static void prueba1() {
		int n = 5;
		
		f( 1 );
		
		
		
	}
	
	private static void f( int n ) {
		if (n<1000) {
			System.out.println( "antes " + n );
			f( n+1 );
			System.out.println( "después " + n );
		} else {
			// Nada
		}
	}
	
	private static void fIterativo( int n ) {
		while (n<1000) {
			System.out.println( n );
			n = n+1;
		}
	}

}
