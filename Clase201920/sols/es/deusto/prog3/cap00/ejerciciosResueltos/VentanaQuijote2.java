package es.deusto.prog3.cap00.ejerciciosResueltos;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/** Ejercicio resuelto con varios hilos
 */
public class VentanaQuijote2 extends JFrame {

	private JTextArea taTexto;
	private JScrollPane spTexto;
	
	public VentanaQuijote2() {
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setTitle( "Don Quijote de la Mancha" );
		setSize( 800, 600 );
		setLocationRelativeTo( null );  // Pone la ventana relativa a la pantalla
		taTexto = new JTextArea();
		spTexto = new JScrollPane( taTexto );
		add( spTexto, BorderLayout.CENTER );
		JPanel pBotonera = new JPanel();
		JButton bPagArriba = new JButton( "^" );
		JButton bPagAbajo = new JButton( "v" );
		pBotonera.add( bPagArriba );
		pBotonera.add( bPagAbajo );
		add( pBotonera, BorderLayout.SOUTH );
		bPagArriba.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				muevePagina( -(spTexto.getHeight()-20) );
			}
		});
		bPagAbajo.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				muevePagina( (spTexto.getHeight()-20) );
			}
		});
	}
	
	// En vez de esto...
	// private ArrayList<Thread> hilosPendientes = new ArrayList<>();
	// Mejor esto, que es una lista sincronizada (que evita problemas de modificación concurrente):
	private java.util.List<Thread> hilosPendientes = 
		Collections.synchronizedList( new ArrayList<Thread>() );
	// Esta estructura asegura que no se van a hacer actualizaciones coincidentes
	
	private void muevePagina( int pixelsVertical ) {
		Thread t = new Thread() {
			@Override
			public void run() {
				hilosPendientes.add( this );
				while (hilosPendientes.get(0) != this) {
					try {
						System.out.println( "Espero a " + hilosPendientes.get(0) );
						hilosPendientes.get(0).join();  // alternativa a sleep
					} catch (InterruptedException e) {}
				}
				JScrollBar bVertical = spTexto.getVerticalScrollBar();
				System.out.println( "Moviendo texto de " + bVertical.getValue() + " a " + (bVertical.getValue()+pixelsVertical) );
				int dif = (pixelsVertical<0) ? -1 : +1;
				int fin = (bVertical.getValue() + pixelsVertical);
				for (int valVert=bVertical.getValue(); valVert!=fin; valVert += dif ) {
					// SwingUtilities.invokeLater(...);  // Siempre que modifiquemos algún componente en Swing esto es más seguro porque Swing no es trhread-safe
					bVertical.setValue( valVert );
					System.out.println( hilosPendientes + " - " + valVert + " - " + (bVertical.getValue() + pixelsVertical) );
					try { Thread.sleep( 10 ); } catch (InterruptedException e) {}
				}
				hilosPendientes.remove(0);
			}
		};
		t.start();
	}
	
	private void cargaQuijote() {
		try {
			Scanner scanner = new Scanner( VentanaQuijote2.class.getResourceAsStream( "DonQuijote.txt" ), "UTF-8" );
			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				taTexto.append( linea + "\n" );
			}
			scanner.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog( this, "No se ha podido cargar el texto" );
		}
	}

	public static void main(String[] args) {
		VentanaQuijote2 v = new VentanaQuijote2();
		v.setVisible( true );
		v.cargaQuijote();
	}

}
