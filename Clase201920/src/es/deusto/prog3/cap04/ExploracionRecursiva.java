package es.deusto.prog3.cap04;

/** Pruebas de aprendizaje de recursividad
 * @author andoni.eguiluz @ ingenieria.deusto.es
 */
public class ExploracionRecursiva {

	private static int global = 0;  // ¿Dónde se crea en memoria? ¿Cuánto tiempo está? [hasta que el programa acabe -> Global]
	
	public static void main(String[] args) {
		prueba1();  // Prueba recursiva inicial
		factorial(); // Prueba factorial
		factorialv2();
		prodConSuma();
		aLaLuna();
	}
	
	private static void aLaLuna() {
		calcDobleces( 0.00015, 384400000.0, 0 );
	}
	
//	while (grosor>=distancia) {
//		grosor = grosor*2;
//      numDobleces = numDobleces+1;
//	}
//	System.out.println( numDobleces );
	private static void calcDobleces( double grosor, double distancia, int numDobleces ) {
		if (grosor>=distancia) {
			System.out.println( numDobleces );
		} else {
			calcDobleces( grosor*2, distancia, numDobleces+1 );
		}
	}
	
	public static void prodConSuma() {
		System.out.println( producto( 6, 5 ));
	}
	
	// Calcula el producto de m y n utilizando solo sumas
	// Definición:  m*n = m + m*(n-1)           producto(m,n) = m + producto(m,n-1)
	//              0 si n==0
	private static int producto( int m, int n ) {
		if (n==0) {
			return 0;
		} else {
			return m + producto( m, n-1 );
		}
	}
	
	
	public static void factorialv2() {
		fact2( 0, 1, 6 );
	}
	
	private static void fact2( int nInicial, long valorInicial, int nFinal ) {
		if (nInicial==nFinal) {
			System.out.println( valorInicial );
		} else {
			fact2( nInicial+1, valorInicial*(nInicial+1), nFinal );
		}
	}
	
	public static void factorial() {
		System.out.println( fact(21) );
		System.out.println( Long.MAX_VALUE );
	}
	
	private static long fact(int n) {
		if (n==0) {
			return 1;
		} else {
			return n * fact(n-1);
		}
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
