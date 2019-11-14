package es.deusto.prog3.cap04;

/** Pruebas de aprendizaje de recursividad
 * @author andoni.eguiluz @ ingenieria.deusto.es
 */
public class ExploracionRecursiva {

	private static int global = 0;  // ¿Dónde se crea en memoria? ¿Cuánto tiempo está? [hasta que el programa acabe -> Global]
	
	public static void main(String[] args) {
		prueba1();  // Prueba recursiva inicial
	}

	// Prueba recursiva inicial
	private static void prueba1() {
		int n = 5;  // ¿Dónde se crea en memoria? ¿Cuánto tiempo está? [Solo el tiempo que esté ejecutándose el método -> Stack]
		f( 1 );
	}

	// Función recursiva de sacar números naturales en consola hasta el 999
	private static void f( int n ) {  // n también va al stack
		if (n<1000) {  // Si no se hace el if --- stackoverflow!!!!
			System.out.println( "antes " + n ); // Lo que se hace antes de la llamada va en sentido ascendente
			f( n+1 );
			System.out.println( "después " + n ); // Lo que se hace antes de la llamada va en sentido descendente (gracias a la propia pila)
		} else {
			// Nada
		}
	}
	
	// Función iterativa de sacar números naturales en consola hasta el 999
	// Observa el parecido con la recursiva, con el while en lugar del if
	private static void fIterativo( int n ) {
		while (n<1000) {
			System.out.println( n );
			n = n+1;
		}
	}
	
	
	
}
