package es.deusto.prog3.cap01.ejercicios;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestUtilsString {

	@Before
	public void setUp() throws Exception {
		System.out.println( "before");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testquitarTabsYSaltosLinea() {
		String prueba = "Hola\nEsto es un string con tres líneas\ny\tvarios\ttabuladores.";
		String prueba2 = "Hola#Esto es un string con tres líneas#y|varios|tabuladores.";
		assertEquals( prueba2, UtilsString.quitarTabsYSaltosLinea(prueba));
//		if (prueba2.equals(UtilsString.quitarTabsYSaltosLinea(prueba))) {
//			// System.out.println( "OK" );
//			assertTrue( true );
//		} else {
//			System.out.println( "FAIL" );
//			fail();
//		}
	}
	
	public void a() {
		System.out.println( "a" );
	}

}
