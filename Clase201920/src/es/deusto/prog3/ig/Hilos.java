package es.deusto.prog3.ig;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

/** Ejemplo de hilos (solución parcial de ejercicio 0.6)
 * @author andoni.eguiluz @ ingenieria.deusto.es
 *
 */
public class Hilos {
	private static JFrame v;
	private static JLabel lNumero;
	private static ArrayList<Integer> lNumeros;
	public static void main(String[] args) {
		lNumeros = new ArrayList<>();
		v = new JFrame();
		v.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		v.setSize( 600, 400 );
		v.setLocation( -1500, 0 );
		v.setVisible( true );
		JButton b = new JButton( "Aleatorio!" );
		v.setLayout( new BorderLayout() );
		v.add( b, BorderLayout.SOUTH );
		lNumero = new JLabel( " Hola " );
		lNumero.setFont( new Font( "Arial", Font.PLAIN, 40 ) );
		v.add( lNumero, BorderLayout.CENTER );
		b.addActionListener( new ActionListener() {
			Random r = new Random();
			@Override
			public void actionPerformed(ActionEvent e) {
				// Manera 1 de crear un hilo - heredando de la clase Thread
//				Thread t = new Thread() {
//					@Override
//					public void run() {
//						...
//					}
//				};
				// Manera 2 - implementando Runnable
				Runnable ejecutable = new Runnable() {
					public void run() {
						long tiempo1 = System.currentTimeMillis();
						while (tiempo1 + 3000 > System.currentTimeMillis()) {
							// lNumero.setText( "" + ((int) (Math.random()*1000) + 1) );
							int dato = (r.nextInt( 1000 ) + 1);
							lNumero.setText( "" + dato );
							anyadirALista( dato );
						}
						System.out.println( lNumeros.size() );
					}
				};
				Thread t2 = new Thread(ejecutable);
				t2.start();
			}
		});
	}
	
	private synchronized static void anyadirALista( int dato ) {
		lNumeros.add( dato );
	}
}
