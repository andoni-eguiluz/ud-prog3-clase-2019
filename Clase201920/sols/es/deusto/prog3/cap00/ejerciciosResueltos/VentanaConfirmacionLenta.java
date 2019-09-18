package es.deusto.prog3.cap00.ejerciciosResueltos;

import java.util.Random;
import java.awt.*;
import java.awt.event.*;
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
		} catch (InterruptedException e) {}
	}
	
	public static void main(String[] args) {
		// Definición
		JFrame f = new JFrame();
		f.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		f.setSize( 400, 320 );
		f.setLocation( 2000, 100 );
		JTextField tfNombre;
		tfNombre = new JTextField();
		JButton bAceptar = new JButton( "Aceptar" );
		f.add( tfNombre, BorderLayout.NORTH );
		f.add( bAceptar, BorderLayout.SOUTH );
		// Eventos
		// Esto sería con clase interna (con nombre)
		// bAceptar.addActionListener( new MiActionListener() );
		// Y esto con clase interna anónima:
		bAceptar.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bAceptar.setEnabled( false );
				Thread t = new Thread( new Runnable() {
					@Override
					public void run() {
						System.out.println( "Inicio hilo");
						procesoConfirmar();
						System.out.println( "Fin hilo");
						bAceptar.setEnabled( true );
					}
				});
				t.start();
			}
			
		});
		f.setVisible( true );
	}

	// Esto sería la clase interna con nombre del escuchador si lo hiciéramos así
//	static class MiActionListener implements ActionListener {
//		@Override
//		public void actionPerformed(ActionEvent e) {
//		}
//	}
	
}
