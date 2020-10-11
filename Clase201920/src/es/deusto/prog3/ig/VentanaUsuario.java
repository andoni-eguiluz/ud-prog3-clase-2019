package es.deusto.prog3.ig;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class VentanaUsuario extends JFrame {
	public static void main(String[] args) {
		VentanaUsuario v = new VentanaUsuario();
		v.setVisible( true );
	}
	
	
	protected JTextField tfNombre;
	protected JTextField tfPass;	
	protected JPanel pAdicional = null;
	public VentanaUsuario() {
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 800, 400 );
		tfNombre = new JTextField( " " );
		tfPass = new JTextField( " " );
		add( tfNombre, BorderLayout.NORTH );
		add( tfPass, BorderLayout.SOUTH );
		pAdicional = new JPanel();
		add( pAdicional, BorderLayout.CENTER );
	}
	
	public String getNombre() {
		return tfNombre.getText();
	}
	
	public JTextField getTfNombre() {
		return tfNombre;
	}
	
}
