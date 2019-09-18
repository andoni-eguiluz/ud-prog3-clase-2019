package es.deusto.prog3.cap01.ejerciciosResueltos;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Consumer;

import javax.swing.*;

/** Ejemplo/ejercicio para mostrar la sintaxis funcional de Java 8
 * Ejercicio: haz que el botón procese la lista de strings que mete el usuario en el cuadro de texto
 * y que muestre los enteros uno a uno (2 segundos cada uno) en el label de mensaje
 * UTILIZANDO EN LO POSIBLE JAVA FUNCIONAL
 */
public class JavaFuncional {

	private static JLabel lSalida = new JLabel( " " );
	private static JTextField tfEntrada = new JTextField( 20 );
	private static ArrayList<String> nombresFunciones = new ArrayList<String>( Arrays.asList( 
				new String[] { "Visualizar cada 2 sgs.", "Media" }
			));
	private static ArrayList<Consumer<ArrayList<Integer>>> funciones = initFunciones();
	private static ArrayList<Consumer<ArrayList<Integer>>> initFunciones() {
		ArrayList<Consumer<ArrayList<Integer>>> ret = new ArrayList<>();
		ret.add( JavaFuncional::visualizarCada2Segs );
		ret.add( JavaFuncional::calcularMedia );
		return ret;
	}
			
	private static JComboBox<String> cbOpciones = new JComboBox();
	
	/** Crea ventana de ejemplo con un cuadro de texto y un botón
	 * @param args	No utilizado
	 */
	public static void main(String[] args) {
		// Creación y configuración ventana
		JFrame f = new JFrame( "Ejemplo de lambda en Java 8" );
		f.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		// Componentes
		JPanel pEntrada = new JPanel();
		JButton bProcesar = new JButton( "Procesar" );
		pEntrada.add( new JLabel( "lista de enteros entre comas:" ) );
		pEntrada.add( tfEntrada );
		pEntrada.add( bProcesar );
		f.add( pEntrada, BorderLayout.NORTH );
		f.add( lSalida, BorderLayout.SOUTH );
		f.add( cbOpciones, BorderLayout.CENTER );
		// Inicializar el combo
		for (String s : nombresFunciones)
			cbOpciones.addItem( s );
		// Programar eventos
		bProcesar.addActionListener( 
			// ActionListener - public void actionPerformed(ActionEvent e)
			(e) -> { proceso();	}  // Paso código (Java 8) en vez de un ActionListener
		);
		f.addWindowListener( new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				// Hacer algo en el cierre
			}
		});
		// Visualizar
		f.pack();
		f.setLocationRelativeTo( null );
		f.setVisible( true );
		try { Thread.sleep(100); } catch (Exception e) {}
		f.setLocation( f.getLocation().x + 2000, f.getLocation().y );
	}
	
	private static void proceso() {
		ArrayList<String> listaStrings = listaDeStrings( tfEntrada.getText() );
		ArrayList<Integer> listaEnteros = listaDeInts( listaStrings );
		if (cbOpciones.getSelectedIndex()!=-1) {
			funciones.get( cbOpciones.getSelectedIndex() ).accept( listaEnteros );
		}
	}
	
	private static void visualizarCada2Segs( ArrayList<Integer> listaEnteros ) {
		if (listaEnteros==null) return;
		Thread t = new Thread( 
			() -> { 
				for (int i : listaEnteros) {
					lSalida.setText( i + "" );
					try { Thread.sleep( 2000 ); } catch (InterruptedException e) {}
				}
				lSalida.setText( " " );
			}
		);
		t.start();
	}
	
	private static void calcularMedia( ArrayList<Integer> listaEnteros ) {
		if (listaEnteros==null || listaEnteros.isEmpty()) return;
		int suma = 0;
		for (int i : listaEnteros) {
			suma += i;
		}
		lSalida.setText( "Media de los números = " + (suma*1.0/listaEnteros.size()));
	}
	
	/** Devuelve un arraylist de strings partiendo de un string con comas
	 * @param lista	Lista de substrings separados por comas
	 * @return	Devuelve una lista de strings separando los substrings que estén con comas (quitando los espacios)
	 */
	private static ArrayList<String> listaDeStrings( String lista ) {
		ArrayList<String> ret = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer( lista, "," );
		while (st.hasMoreTokens()) {
			ret.add( st.nextToken().trim() );  // Mete el siguiente substring quitando espacios
		}
		return ret;
	}
	
	/** Devuelve una lista de enteros partiendo de una lista de strings
	 * @param lista	Lista de strings que representan a enteros
	 * @return	Lista de los enteros en la lista de strings (si algún string no es un entero válido, se ignora)
	 */
	private static ArrayList<Integer> listaDeInts( ArrayList<String> lista ) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		for (String string : lista) {
			try {
				ret.add( Integer.parseInt( string ) );
			} catch (NumberFormatException e) {
				// Se ignora el string que no es un entero válido
			}
		}
		return ret;
	}

}

//
//Interfaces predefinidos clásicos para notación lambda:  
//(excepto Runnable, todos en java.util.function)
//
//Runnable --> run()
//Consumer<T> --> void accept(T)
//Predicate<T> --> boolean test(T)
//Supplier<T> --> T get()
//Function<T,R> --> R apply(T)
