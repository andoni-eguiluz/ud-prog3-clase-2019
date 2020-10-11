package es.deusto.prog3.ig;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class VentanaUsuarioFoto extends VentanaUsuario {
	JLabel lFoto;
	public static void main(String[] args) {
		VentanaUsuarioFoto v = new VentanaUsuarioFoto();
		v.setVisible( true );
	}
	public VentanaUsuarioFoto() {
		// super();  // Llamada al constructor padre
		setSize( 1000, 900 );
		lFoto = new JLabel( new ImageIcon( "src/es/deusto/prog3/cap00/resueltos/edicionSpritesV2/ej-sprites-1.jpg" ) ); 
		pAdicional.setLayout( new BorderLayout() );
		pAdicional.add( lFoto, BorderLayout.CENTER );
	}
	
	@Override
	public String getNombre() {
		return super.getNombre() + " (tiene foto)";
	}
	
}
