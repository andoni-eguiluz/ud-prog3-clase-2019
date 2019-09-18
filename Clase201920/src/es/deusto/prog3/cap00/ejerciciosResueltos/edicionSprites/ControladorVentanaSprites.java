package es.deusto.prog3.cap00.ejerciciosResueltos.edicionSprites;

/** Clase controladora de la ventana de sprites
 * @author andoni.eguiluz @ ingenieria.deusto.es
 */
public class ControladorVentanaSprites {
	
	private VentanaEdicionSprites miVentana;  // Ventana controlada
	
	/** Constructor de controlador de ventana de edición de sprites
	 * @param vent	Ventana a controlar
	 */
	public ControladorVentanaSprites( VentanaEdicionSprites vent ) {
		miVentana = vent;
	}
	
	/** Click sobre el botón buscar */
	public void clickBBuscar() {
		// TODO Sacar un diálogo de búsqueda de fichero con JFileChooser
		// y cargar la lista de ficheros lSprites a través de su modelo
		// Por ejemplo:
		miVentana.mSprites.clear();
		miVentana.mSprites.addElement( new java.io.File( "c:/datos/ejemplo/ejemplo.png" ) );
		miVentana.mSprites.addElement( new java.io.File( "c:/datos/ejemplo/ejemplo2.png" ) );
		miVentana.lCarpetaSel.setText( "c:/datos/ejemplo/" );
	}
	
	// TODO Resto de controladores
	
	
}
