package es.deusto.prog3.cap00.resueltos;

import java.util.Random;
import java.util.Set;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/** Ejercicio de hilos con ventanas. Programa esta clase para que se cree una ventana
 * que pida un dato de texto al usuario y un botón de confirmar para que se confirme.
 * Haz que al pulsar el botón de confirmación se llame al procesoConfirmar()
 * que simula un proceso de almacenamiento externo que tarda unos segundos.
 * Observa que hasta que ocurre esta confirmación la ventana no responde.
 * 1. Arréglalo para que la ventana no se quede "frita" hasta que se acabe de confirmar.
 * 2. Haz que el botón de "confirmar" no se pueda pulsar dos veces mientras el proceso
 * de confirmación se esté realizando
 * @author andoni.eguiluz @ ingenieria.deusto.es
 */
public class VentanaConfirmacionLenta {

	
		private static Random r = new Random();
	// Este método simula un proceso que tarda un tiempo en hacerse (entre 5 y 10 segundos)
	private static void procesoConfirmar() {
		try {
			Thread.sleep( 5000 + 1000*r.nextInt(6) );
		} catch (InterruptedException e) {
			System.out.println( "Interrumpido" );
		}
	}
	
	public static void main(String[] args) {
		JFrame v = new JFrame();  // Se pueden crear ventanas directamente desde las clases de Swing (aunque es deseable cuando son un poco elaboradas hacerlas con clases nuevas que extiendan JFrame)
		v.setSize( 600, 400 );
		v.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );  // Si no se hace esto ¿qué pasa? Problema de la parada de Swing - todas las ventanas tienen que ser liberadas (dispose)
		JTextField tfDatos = new JTextField( 20 );
		v.add( tfDatos, BorderLayout.NORTH );  // Si no se indica segundo parámetro, se añade al centro - porque el layout determina el añadido y el layout por defecto es BorderLayout
		JButton bAceptar = new JButton( "Aceptar" );
		v.add( bAceptar, BorderLayout.SOUTH );  // Ojo que si no se indica el segundo parámetro se añade al centro, sustituyendo a cualquier cosa que hubiera en el centro
		v.setVisible( true );  // Esto activa la ventana y lanza el hilo de Swing
		bAceptar.addActionListener( new ActionListener() { // Clase anónima que implementa ActionListener para crear el objeto escuchador 
			// Este objeto escuchador es un "paquete" de trabajo que se le manda a Swing pero que no se ejecuta... será Swing quien lo ejecute
			@Override
			public void actionPerformed(ActionEvent e) {
				Thread hilo = new Thread() {  // Clase anónima heredada de Thread para crear el hilo
					public void run() {  // Método principal que debe tener todo hilo - es como el main para cada hilo
						System.out.println( "Empiezo" );  // Para ver cuándo empieza en consola
						procesoConfirmar();
						System.out.println( "Acabo" );  // Para ver cuándo acaba en consola
					}
				};
				hilo.start();  // hilo.run(); ejecutaría desde el mismo hilo (Swing) - no solucionaría nada
			}
		} );
	}

}
