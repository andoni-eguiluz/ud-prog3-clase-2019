package es.deusto.prog3.cap04;

public class PruebaRecursividad {

	public static void main(String[] args) { 
		fSubir(1);
		// fBajar(3000);
		System.out.println( factorial( 7 ));
		// prod en función de suma m * n = m + m + m ... + m   (n veces)
		System.out.println( producto( 25, 7 ) );
		// Recorrer un string  visualizando caracter a caracter al derecho y al revés
		recorrerString( "Hola voy a salir al derecho y al revés" );
	}
	
	
	/** Visualiza un string primero al derecho y luego al revés (carácter a carácter)
	 * @param s
	 */
	public static void recorrerString( String s ) {
		recorrerString( s, 0 );
	}
	
	// recString = si indice = long-1 nada que hacer
	//           = si no, 
	private static void recorrerString( String s, int indice ) {
		if (indice==s.length()) {
			System.out.println();
			return;
		} else {
			char c = s.charAt( indice );
			System.out.print( c );
			recorrerString( s, indice+1 );
			System.out.print( c );
		}
	}
	
	// Calcula el producto de dos números de la siguiente forma:
	// sumando * num = sumando + (sumando * (num-1))
	// sumando * 0 = 0
	private static int producto( int sumando, int num ) {
		if (num==0) {  // Caso base
			System.out.println( "fin de llamadas");
			return 0;
		} else {  // Caso recursivo
			System.out.println( "ahora sumo " + sumando + " y " + (num-1) );
			int ret = sumando + producto( sumando, num-1 );
			System.out.println( "ahora retorno " + ret );
			return ret;
		}
	}
	
	// Calcula el factorial:
	// factorial(n) = n * factorial(n-1)
	// factorial(0) = 1
	private static int factorial( int n ) {
		if (n==0) {
			return 1;
		} else {
			return n * factorial( n-1 );
		}
	}

	// Método que visualiza un número y todos los siguientes de 1 en 1 hasta 3000 (inclusive)
	// OJO: N NO PUEDE SER MAYOR QUE 3000!!!!!
	private static void fSubir(int n) {
		if (n==3001) {  // Caso base: NO HAY QUE HACER RECURSIVIDAD
			return;
		} else { // Caso recursivo: HAY QUE SEGUIR HACIENDO RECURSIVIDAD
			System.out.println( "mi número es: " + n );
			fSubir( n+1 );
			// Hola?
			System.out.println( "bajando es: " + n );
		}
	}
	
//	private static void fBajar(int n) {
//		if (n>=1) {
//			System.out.println( "mi número es: " + n );
//			fBajar( n-1 );
//		} else {
//			return;  // Caso base
//		}
//	}
//	
}
