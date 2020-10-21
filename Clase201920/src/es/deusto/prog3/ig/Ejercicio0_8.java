package es.deusto.prog3.ig;

import java.text.SimpleDateFormat;
import java.util.*;

import es.deusto.prog3.utils.tabla.*;
import es.deusto.prog3.utils.tabla.iu.*;

	
/** Prueba de carga de un CSV de datos de ATP en tabla visual
 * @author andoni.eguiluz @ ingenieria.deusto.es
 */
public class Ejercicio0_8 {

	public static void main( String[] s ) {
		atp();
	}
	
		private static VentanaDatos newVentanaTabla( VentanaGeneral vg, Tabla tabla, String codTabla, int posX, int posY ) {
			try {
				String tit = codTabla + " (" + tabla.size() + ")";
				VentanaDatos vd = new VentanaDatos( vg, codTabla, tit ); 
				vd.setSize( 1400, 800 );
				vd.setTabla( tabla ); 
				vg.addVentanaInterna( vd, codTabla );
				vd.setLocation( posX, posY );
				vd.addBoton( "-> clipboard", new Tabla.CopyToClipboard( tabla, vd ) );
				vd.setVisible( true ); 
				try { Thread.sleep( 100 ); } catch (InterruptedException e) {}
				return vd;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
	private static VentanaGeneral ventana;
	private static final SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );

	private static HashMap<String,ArrayList<Partido>> mapaTenistas;
	
	public static HashMap<String,ArrayList<Partido>> getMapaTenistas() {
		return mapaTenistas;
	}
	
	private static void atp() {
		try {
			String urlATP = "dataATP.csv";
			
			ventana = new VentanaGeneral();
			ventana.setSize( 1800, 1000 );
			ventana.setEnCierre( new Runnable() { public void run() {  } } );
			ventana.setTitle( "Revisión de datos de Inspira 2020" );
			ventana.setVisible( true );

			// Crea la tabla con todos los datos
			Tabla tablaATPBruto = Tabla.processCSV( Ejercicio0_8.class.getResource( urlATP ) );
			System.out.println( tablaATPBruto.getHeadersTabs( "" ) );
			
			// Filtra solo las columnas interesantes y muestra la ventana
			Tabla tablaATPFiltrada = tablaATPBruto.crearTablaConCols( "ATP", "Location", "Tournament", "Date", "Series", "Court", "Surface", "Round", "Best of", "Winner", "Loser", "WRank", "LRank", "W1", "L1", "W2", "L2", "W3", "L3", "W4", "L4", "W5", "L5", "Wsets", "Lsets" );
			newVentanaTabla( ventana, tablaATPFiltrada, "ATP Filtrada", 20, 20 );
			
			// Hace algo con los datos (cambiar esto si se quiere hacer otra cosa)
			
			// Crea un mapa cuya clave sea un tenista (string) 
			// y cuyo valor sea una lista de partidos
			// Carga en el mapa todos los partidos de todos los tenistas, metiendo cada partido en dos listas del mapa: el ganador y el perdedor. (es decir, en el mapa habrá una entrada por cada tenista y el valor asociado será la lista de todos los partidos que ha jugado, algunos perdidos y otros ganados).
			mapaTenistas = new HashMap<>();
			for (int i=0; i<tablaATPFiltrada.size(); i++) {
				Date fecha = tablaATPFiltrada.getDate( i, "Date" );
				String torneo = tablaATPFiltrada.get( i, "Tournament" );
				String tipo = tablaATPFiltrada.get( i, "Series" );
				String ronda = tablaATPFiltrada.get( i, "Round" );
				String ganador = tablaATPFiltrada.get( i, "Winner" );
				String perdedor = tablaATPFiltrada.get( i, "Loser" );
				int setsGanados = tablaATPFiltrada.getInt( i, "Wsets" );
				int setsPerdidos = tablaATPFiltrada.getInt( i, "Lsets" );
				// Ejercicio 0.8
				Partido partido = new Partido(fecha, torneo, tipo, ronda, ganador, perdedor, setsGanados, setsPerdidos);
				ArrayList<Partido> lista = mapaTenistas.get( ganador );
				if (lista==null) {
					lista = new ArrayList<Partido>();
					mapaTenistas.put( ganador, lista );
				}
				lista.add( partido );
				lista = mapaTenistas.get( perdedor );
				if (lista==null) {
					lista = new ArrayList<Partido>();
					mapaTenistas.put( perdedor, lista );
				}
				lista.add( partido );
			}
			// Recorre el mapa para crear un objeto por cada jugador 
			// calculando el número de partidos ganados y perdidos 
			// de ese jugador. Añade esos objetos a un conjunto ordenado 
			// de jugadores.
			TreeSet<Jugador> conjuntoJugadores;
			conjuntoJugadores = new TreeSet<Jugador>();
			for (String nombre : mapaTenistas.keySet()) {
				System.out.println( nombre );
				Jugador jugador = new Jugador(nombre);
				for (Partido partido : mapaTenistas.get(nombre)) {
					if (partido.getGanador().equals(nombre)) {
						jugador.incNumGanados();
					} else {  // if partido.getPerdedor().equals(nombre)
						jugador.incNumPerdidos();
					}
				}
				conjuntoJugadores.add( jugador );
			}
			int cont = 0;
			for (Jugador jugador : conjuntoJugadores) {
				System.out.println( jugador );
				cont++;
				if (cont>10) break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

