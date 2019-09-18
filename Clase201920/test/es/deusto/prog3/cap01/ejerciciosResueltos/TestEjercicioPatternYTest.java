package es.deusto.prog3.cap01.ejerciciosResueltos;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestEjercicioPatternYTest {

	private static final String[] testsTelsOk = {
			"943 210 876",
			"987654321",
			"(94)4444444"
		};
		
		private static final String[] testsTelsNoOk = {
				"943 210 87",
				"943 210 876 5",
				"9432108765",
				"94321087",
				"(94) 444 44 44",
				"(94)444444",
				"(944)444444",
			};
			
	private static final String[] testsEmailsOk = {
		"andoni.eguiluz@deusto.es",
		"a@a.com",
		"a.b.c@a.b.c.net",
		"a1.b_c%_+_-@dom1234567890.org",
	};
	
	private static final String[] testsEmailsNoOk = {
			"@deusto.es",
			"andoni eguiluz@deusto.es",
			"andoni/eguiluz@deusto.es",
			"a.b.c@ a.b.c.net",
			"a1.b_c%_+_-@dom1234567890.123", // Ext de dominio numérica
			"a@dominio.extensiondemasiadolarga"  // Ext de dominio demasiado larga
		};
		
	@Test
	public void testTelefCorrectoOk() {
		for (String s : testsTelsOk)
			assertTrue( EjercicioPatternYTest.telefCorrecto( s ) );
	}

	@Test
	public void testTelefCorrectoNoOk() {
		for (String s : testsTelsNoOk)
			assertFalse( EjercicioPatternYTest.telefCorrecto( s ) );
	}

	@Test
	public void testEmailCorrectoOk() {
		for (String s : testsEmailsOk)
			assertTrue( EjercicioPatternYTest.emailCorrecto( s ) );
	}

	@Test
	public void testEmailCorrectoNoOk() {
		for (String s : testsEmailsNoOk)
			assertFalse( EjercicioPatternYTest.emailCorrecto( s ) );
	}

}
