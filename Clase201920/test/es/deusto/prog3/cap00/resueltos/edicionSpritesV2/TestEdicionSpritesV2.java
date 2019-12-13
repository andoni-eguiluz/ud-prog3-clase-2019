package es.deusto.prog3.cap00.resueltos.edicionSpritesV2;

import static org.junit.Assert.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.deusto.prog3.cap00.resueltos.edicionSpritesV2.VentanaEdicionSprites;

/** Prueba de unidad (parcial) de ventana de edición de sprites
 */
public class TestEdicionSpritesV2 {

	private static final long PAUSA = 500; 
	
	private es.deusto.prog3.cap00.resueltos.edicionSpritesV2.VentanaEdicionSprites v;
	@Before
	public void setUp() throws Exception {
		v = new VentanaEdicionSprites();
		v.setLocation(2000,0); // Esto es solo para colocar la ventana donde quieras (quitar)
	}

	@After
	public void tearDown() throws Exception {
		try { Thread.sleep(PAUSA); } catch (Exception e) {}
		v.dispose();
	}

	// Prueba programática de relación entre slider y textfield
	@Test
	public void testSliderAngulo() {
		v.setVisible( true );
		try { Thread.sleep(PAUSA); } catch (Exception e) {} // Esperamos a que swing saque la ventana
		v.slAngulo.setValue( 44 ); // SIMULO QUE EL USUARIO CAMBIA EL SLIDER A 44
		try { Thread.sleep(PAUSA); } catch (Exception e) {} // Esperamos a que actúe el escuchador
		assertEquals( "44", v.tfAngulo.getText() );  // Al mover el sl cambia el tf
		v.tfAngulo.requestFocus(); // Simulamos foco en el textfield
		v.tfAngulo.setText( "45" );
		v.tfAncho.requestFocus(); // Simulamos salida de foco del textfield
		try { Thread.sleep(PAUSA); } catch (Exception e) {} // Esperamos a que actúe el escuchador
		assertEquals( 45, v.slAngulo.getValue() );  // Al cambiar el tf cambia el sl
	}
	
	// Ejemplo de prueba de interacción simulando ratón
	@Test
	public void testCambioSecuencia() {
		try {
			// Ponemos algunos gráficos de ejemplo en la secuencia (ojo que tienen que estar localizables - a menudo los recursos de test se dejan en la misma carpeta de test
			File ej1 = new File( "test/es/deusto/prog3/cap00/resueltos/edicionSpritesV2/img/Attack__000.png" );
			File ej2 = new File( "test/es/deusto/prog3/cap00/resueltos/edicionSpritesV2/img/Attack__001.png" );
			v.getController().anyadirSpriteASecuencia( ej1 );
			v.getController().anyadirSpriteASecuencia( ej2 );
			v.setVisible( true );
			try { Thread.sleep(PAUSA); } catch (Exception e) {}
			File f = v.mSecuencia.getElementAt(0);  // elemento 0
			Robot r = new Robot();
			Point listaSec = v.lSecuencia.getLocationOnScreen();  // Posición de la lista
			for (int i=0;i<10;i++) {  // Por raro que parezca en algunas pantallas no se mueve bien la primera vez y hay que repetirlo:   https://bugs.openjdk.java.net/browse/JDK-8186063
				r.mouseMove( listaSec.x + 20, listaSec.y + 10 ); // Ratón al primer elemento (20 píxels a la derecha y 10 abajo de la esquina)
				// System.out.println( MouseInfo.getPointerInfo().getLocation() );
			}
			try { Thread.sleep(PAUSA); } catch (Exception e) {}
			r.mousePress( InputEvent.BUTTON1_DOWN_MASK );
			r.mouseRelease( InputEvent.BUTTON1_DOWN_MASK );  // Simulamos click
			try { Thread.sleep(PAUSA); } catch (Exception e) {} // Esperamos a que actúe el escuchador
			v.bAbajo.doClick(); // Simulación programática de click de botón de abajo
			try { Thread.sleep(PAUSA); } catch (Exception e) {} // Esperamos a que actúe el escuchador
			assertEquals( f, v.mSecuencia.getElementAt(1) ); // El elemento en 0 tiene que haber bajado a 1
		} catch (AWTException e) {}
	}
	
	// Ejemplo de prueba de interacción simulando teclado
	@Test
	public void testCambioRotacionPorTeclado() {
		try {
			v.setVisible( true );
			try { Thread.sleep(PAUSA); } catch (Exception e) {}
			v.tfRotacionAnim.setText( "" );
			v.tfRotacionAnim.requestFocus();
			try { Thread.sleep(PAUSA); } catch (Exception e) {}
			Robot r = new Robot();
			r.keyPress( KeyEvent.VK_5 );
			r.keyRelease( KeyEvent.VK_5 );
			r.keyPress( KeyEvent.VK_0 );
			r.keyRelease( KeyEvent.VK_0 );
			r.keyPress( KeyEvent.VK_TAB );
			r.keyRelease( KeyEvent.VK_TAB );
			try { Thread.sleep(PAUSA); } catch (Exception e) {}  // Esperamos a que actúe el escuchador
			assertEquals( "50", v.tfRotacionAnim.getText() ); // El elemento en 0 tiene que haber bajado a 1
			assertEquals( 50, v.slRotacionAnim.getValue() ); // El elemento en 0 tiene que haber bajado a 1
		} catch (AWTException e) {}
	}
	
}
