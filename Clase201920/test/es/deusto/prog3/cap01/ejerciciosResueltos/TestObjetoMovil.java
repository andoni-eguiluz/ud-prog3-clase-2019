package es.deusto.prog3.cap01.ejerciciosResueltos;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.deusto.prog3.cap01.ejercicios.ObjetoMovil;

public class TestObjetoMovil {

	// Comprueba que en un disparo vertical la velocidad de subida inicial coincide con la inversa de la de llegada y el tiempo de subida coincide con el de bajada
	@Test
	public void testMoverVertical() {
		prueba( 1, -1000.0 );
		prueba( 1, -5000.0 );
		prueba( 1, -100.0 );
	}
	
	private void prueba( long PRECISION_MSG, double velIni ) {
		ObjetoMovil movil = new ObjetoMovil();
		movil.setPosX( 0 );
		movil.setPosY( 0 );
		double velocidadInicial = velIni;
		movil.setVelY( velocidadInicial );
		long tiempoSubida = 0;
		while (movil.getVelY()<0) {  // Mientras está subiendo
			System.out.println( "Subida " + tiempoSubida + " vel " + movil.getVelY() );
			movil.mueve( PRECISION_MSG, 0, 980.0 ); // Movemos (con gravedad de 980px/sg2)
			tiempoSubida += PRECISION_MSG;
		}
		long tiempoBajada = 0;
		while (movil.getPosY()<0.0) {  // Mientras está bajando
			System.out.println( "Bajada " + tiempoBajada + " vel " + movil.getVelY() );
			movil.mueve( PRECISION_MSG, 0, 980.0 ); // Movemos (con gravedad de 980px/sg2)
			tiempoBajada += PRECISION_MSG;
		}
		assertEquals( tiempoBajada, tiempoSubida );  // El tiempo de subida debe coincidir con el de bajada
		assertEquals( -movil.getVelY(), velocidadInicial, 5.0 ); // La velocidad inicial debe coincidir con la opuesta de la de final
	}

}
