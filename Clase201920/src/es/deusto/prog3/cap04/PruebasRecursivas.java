package es.deusto.prog3.cap04;

public class PruebasRecursivas {

	public static void main(String[] args) {
		// Pruebas recursivas iniciales
		//f(0);  // Recursividad simplona
		System.out.println( factorial(12) );  // Factorial recursivo
		System.out.println( string1_10_1(1) );  // Visualizar números 1 al 10 al derecho y al revés
		System.out.println( c(10) );  // Ejemplo de división /4 recursiva
		System.out.println( fib(45) );
	}
	
	/** Devuelve el enésimo número de Fibonacci
	 * Usando la definición recursiva
	 * fib(n) = fib(n-1) + fib(n-2)  si n>2
	 *        = 1                    si n==1 o n==2
	 * @param n	Número del cual calcular la función
	 * @return	Valor de la función fib(n)
	 */
	private static long fib( long n ) {
		if (n==1) {
			return 1;   // Caso base 1
		} else if (n==2) {
			return 1;   // Caso base 2
		} else {
			return fib(n-1) + fib(n-2);
		}
	}
	
	// Ejemplo de división recursiva
	private static double c(int n) { if (n==1) return 1/4.0; else return c(n-1)/4.0; } 
	
	/** Devuelve un string formado de todos los números
	 * subiendo entre n y 10 y bajando de nuevo hasta n
	 * Ejemplo: "1 2 3 ... 9 10 9 ... 3 2 1". 
	 * @param n	número en el que empezar (menor o igual a 10)
	 * @return String buscado
	 */
	private static String string1_10_1( int n ) {
		// Definición recursiva
		// devuelvo n + " " + string_1_10_1(n+1) + " " + n
		// caso base: n==10 devuelvo "10"
		if (n==10)
			return "10";
		else
			return n + " " + string1_10_1(n+1) + " " + n;
	}

	/** Devuelve el factorial de un número
	 * @param n	Número mayor o igual a 0
	 * @return	Factorial de n
	 */
	private static long factorial(long n) {
		// Definición factorial:
		// factorial(n) = n * factorial(n-1)  si n>0
		// factorial(n) = 1 si n==0
		if (n==0)
			return 1;
		else
			return n * factorial(n-1);
	}

	// Recursividad simplona
	private static void f(int i) {
		if (i<1000)
			f(i+1);
		// else caso base
		System.out.println( i );
	}
		
	
}
