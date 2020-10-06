package es.deusto.prog3.cap01.ejercicios;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UtilsStringTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void quitarTabsYSaltosDeLinea1() {
		String prueba = "Hola\nEsto es un string con tres líneas\ny\tvarios\ttabuladores.";
		String prueba2 = "Hola#Esto es un string con tres líneas#y|varios|tabuladores.";
		assertEquals( prueba2, UtilsString.quitarTabsYSaltosLinea(prueba) );
	}
	@Test
	public void wrapString1() {
		String prueba = "Hola\nEsto es un string con tres líneas\ny\tvarios\ttabuladores.";
		assertEquals( "Hol...", UtilsString.wrapString( prueba, 3) );
		assertEquals( "Hola...", UtilsString.wrapString( prueba, 4) );
		assertEquals( "Hola\n...", UtilsString.wrapString( prueba, 5) );
	}

}
