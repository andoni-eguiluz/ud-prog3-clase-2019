package es.deusto.prog3.cap01.ejerciciosResueltos;

import java.util.regex.Pattern;

/** Programa en esta clase:<br/>
 * 
 * - un método estático boolean telefCorrecto( String ) que indique cuándo un teléfono es correcto<br/>
 * - un método estático boolean emailCorrecto( String ) que indique cuándo un email es correcto<br/>
 * 
 * Puedes usar las variantes que quieras. Al menos podrías considerar<br/>
 * - Teléfono válido: 
 *   999999999 o 999 999 999 o (99)9999999<br/>
 * - Email válido: 
 *   cualquier combinación de letra, dígitos, punto, _, %, + o -
 *   seguido de una arroba
 *   seguido de un nombre de dominio (letras, dígitos, puntos o guiones)
 *   seguido de un punto
 *   seguido de una extensión de dominio (letras) <br/>
 * 
 * Prueba que los métodos funcionan utilizando una prueba de unidad.<br/>
 * 
 * @author andoni.eguiluz @ ingenieria.deusto.es
 */
public class EjercicioPatternYTest {

	// Expresión regular de 
	private static final Pattern REGEX_TELEFONO_VALIDO = Pattern.compile(
		"\\d{9}|\\d{3}\\s\\d{3}\\s\\d{3}|\\(\\d{2}\\)\\d{7}" ); // {n} indica un número de repeticiones obligatorio, \s un carácter de espacio
		
	// Expresión regular de email
	public static final Pattern REGEX_EMAIL_VALIDO = Pattern.compile( 
		"[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",  // el {2,6} limita la longitud a 2-6 caracteres
		Pattern.CASE_INSENSITIVE );  // No diferencia mayúsculas de minúsculas

	/** Comprueba si un string tiene formato de teléfono correcto de acuerdo a las posibilidades 
	 *  999999999 o 999 999 999 o (99)9999999
	 * @param string	String a probar
	 * @return	true si cumple el formato, false en caso contrario
	 */
	public static boolean telefCorrecto( String string ) {
		return REGEX_TELEFONO_VALIDO.matcher(string).matches();
	}
	
	/** Comprueba si un email tiene formato de email correcto
	 * @param string	Email a probar
	 * @return	true si es correcto, false en caso contrario
	 */
	public static boolean emailCorrecto( String string ) {
		return REGEX_EMAIL_VALIDO.matcher(string).matches();
	}
	
}
