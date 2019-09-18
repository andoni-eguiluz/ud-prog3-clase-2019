package es.deusto.prog3.cap01.ejerciciosResueltos;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

import javax.swing.*;

/** Ejercicio de logger: sacar a fichero el registro de lo que hace el programa, al menos estas cosas:
 * - Cuando se lanza la ventana
 * - Cuando se pulsa el botón
 * - Cuando se edita el textfield
 * - Cada carpeta que se visualiza el número de ficheros
 * - Observa que hay un posible error si la carpeta no existe. Atrapa esta excepción y añádela al log indicando un mensaje al usuario
 * @author andoni.eguiluz @ ingenieria.deusto.es
 */
public class EjercicioLogger {
	
	// Resuelto
	private static Logger logger = Logger.getLogger( "prueba-logger" );
	
	private static JTextField tfEntrada = new JTextField( 60 );
	private static JLabel lMensaje = new JLabel( " " );
	public static void main(String[] args) {
		// Activación de logger para fichero xml
		try {
			logger.setLevel( Level.FINEST );
			logger.addHandler( new FileHandler( "prueba-logger.xml") ); // Y también a un xml
		} catch (Exception e) {}
		// Ventana de ejemplo para el ejercicio
		final JFrame f = new JFrame( "Ventana rápida para ejercicio logger" );  // Ventana a visualizar
		f.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		f.setSize( 800, 150 );
		f.setLocationRelativeTo( null );
		JPanel pSuperior = new JPanel();
		JPanel pInferior = new JPanel();
		JButton bBuscar = new JButton( "Buscar" );
		pSuperior.add( new JLabel("Indica carpeta") ); 
		pSuperior.add( tfEntrada );
		pSuperior.add( bBuscar );
		pInferior.add( lMensaje );
		f.add( pSuperior, BorderLayout.CENTER );
		f.add( pInferior, BorderLayout.SOUTH );
		tfEntrada.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.log( Level.INFO, "Editado textfield" );
				sacaFicheros();
			}
		});
		bBuscar.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.log( Level.INFO, "Pulsado botón Buscar" );
				// Saca un diálogo de búsqueda de fichero con JFileChooser
				JFileChooser f = new JFileChooser();
				f.setFileSelectionMode( JFileChooser.DIRECTORIES_ONLY );
				int cod = f.showOpenDialog( f );
				if (cod==JFileChooser.APPROVE_OPTION) {
					File dir = f.getSelectedFile();
					tfEntrada.setText( dir.getAbsolutePath() );
					sacaFicheros();
				}
			}
		});
		f.setVisible( true );
		logger.log( Level.INFO, "Ventana iniciada" );
	}
	
	// Saca el número de ficheros de la carpeta indicada
	private static  void sacaFicheros() {
		try {
			File f = new File( tfEntrada.getText() );
			File[] listDir = f.listFiles();
			lMensaje.setText( "Ficheros+directorios en la carpeta: " + listDir.length );
			logger.log( Level.INFO, "Carpeta buscada:" + f.getAbsolutePath() );
		} catch (Exception e) {
			logger.log( Level.SEVERE, "Error en sacaFicheros", e );
		}
	}

}
