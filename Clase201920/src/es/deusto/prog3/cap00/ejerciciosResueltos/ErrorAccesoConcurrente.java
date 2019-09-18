package es.deusto.prog3.cap00.ejerciciosResueltos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.*;

/** Ejemplo sencillo de por qué hay que definir estructuras synchronized
 * en los programas con modificación concurrente de varios hilos
 * @author andoni.eguiluz @ ingenieria.deusto.es
 */
public class ErrorAccesoConcurrente {

	private static long CONPAUSA = 0; // msgs de pausa en los hilos
	
	private static JTextArea taSalida = new JTextArea();
	// TODO
	// Probar que con esto hay problemas...
	// private static ArrayList<Long> listaNums = new ArrayList<>();
	// Y con esto no:
	private static List<Long> listaNums = Collections.synchronizedList( new ArrayList<Long>() );
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize( 1000, 800 );
		// f.setLocation( 2000, 0 );
		taSalida.setEditable( false );
		f.add( new JScrollPane( taSalida ) );
		f.setVisible( true );
		// Empezamos con la lista [0]
		listaNums.add( 0L ); 
		// Hacemos un hilo que solo va añadiendo números a la lista por el final
		Thread t1 = new Thread( ) {
			@Override
			public void run() {
				long ultimoNumero = 0L;
				while (true) {
					listaNums.add( ++ultimoNumero ); // Añadimos el último número incrementado
					// Ojo que esto daría problemas hasta con la lista concurrente...
					// listaNums.add( listaNums.get(listaNums.size()-1) + 1L );
					// ...porque la operación *NO ES ATÓMICA*
					// (una operación es el size(), otra el get() y otra el add()
					//  y en medio de esas operaciones el otro hilo puede estar cambiando cosas)
					println( "Añadido: " + listaNums.toString() );
					if (CONPAUSA>0) try { Thread.sleep(CONPAUSA); } catch (InterruptedException ex) {}
				}
			}
		};
		t1.start();
		// Otro hilo que solo va quitando números por el principio
		Thread t2 = new Thread( ) {
			@Override
			public void run() {
				while (true) {
					if (!listaNums.isEmpty()) {
						listaNums.remove(0);
						println( "Borrado: " + listaNums.toString() );
					}
					if (CONPAUSA>0) try { Thread.sleep(CONPAUSA); } catch (InterruptedException ex) {}
				}
			}
		};
		t2.start();
		// A partir de ahora se tiene que ir viendo en pantalla una lista donde se añaden números por el final 
		// y se quitan por el principio... salvo que haya algún problema de concurrencia y uno de los dos 
		// hilos deje de hacer bien su trabajo
	}

	// Lo hacemos syncrhonized para que no haya interferencia entre los hilos a la hora de visualizar
	// probar que si se quita el synchronized hay problemas)
	private static synchronized void println( String mens ) {
		taSalida.append( mens + "\n" );
		taSalida.setSelectionStart( taSalida.getText().length() );
		taSalida.setSelectionEnd( taSalida.getText().length() );
		if (taSalida.getText().length()>100000) {  // Para que no se llene la textarea vamos quitando de vez en cuando
			taSalida.replaceRange( "", 0, 50000 );
		}
		// Sería más correcto hacer esto para respetar a Swing (que no es Thread-safe):
		// try {
		// 	SwingUtilities.invokeAndWait( new Runnable() {
		// 		@Override
		// 		public void run() {
		// 			taSalida.append( mens + "\n" );
		// 			taSalida.setSelectionStart( taSalida.getText().length() );
		// 			taSalida.setSelectionEnd( taSalida.getText().length() );
		// 			if (taSalida.getText().length()>100000) {  // Para que no se llene la textarea vamos quitando de vez en cuando
		// 				taSalida.replaceRange( "", 0, 50000 );
		// 			}
		// 		}
		// 	});
		// } catch (Exception e) {
		// 	e.printStackTrace();
		// }
	}

}
