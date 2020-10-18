package es.deusto.prog3.cap01.resueltos;

/** Función de ejemplo a testar
 * @author andoni.eguiluz @ ingenieria.deusto.es
 */
public class FuncionParaTest {

	// Corregida con las pruebas
	
	/** Devuelve el factorial de un número (producto de ese número por todos los anteriores hasta 1).
	 *  El factorial de 0 es 1.
	 * @param x	Valor del que calcular el factorial
	 * @return	Resultado del factorial
	 * @throws ArithmeticException	Lanzada cuando se intenta un factorial inviable (negativo) o cuando el resultado es incorrecto
	 */
	public static int factorial( int x ) throws ArithmeticException {
		if (x<0) throw new ArithmeticException( "Factorial de negativo es incorrecto" ); // ORIGINALMENTE NO ESTÁ - SE VE CON LAS PRUEBAS 
		if (x>12) throw new ArithmeticException( "Factorial no cabe en un int" ); // ORIGINALMENTE NO ESTÁ - SE VE CON LAS PRUEBAS 
		int fact = 1;
		for (int i=1; i<=x; i++) {
			fact *= i;
			// ORIGINALMENTE SI ESTABA PERO NO FUNCIONA - SE VE CON LAS PRUEBAS // if (fact<0) throw new ArithmeticException( "Factorial no cabe en un int" );
		}
		return fact;
	}
	
}
