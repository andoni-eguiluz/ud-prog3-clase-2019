package es.deusto.prog3.cap05.sols;

import java.util.*;

import es.deusto.prog3.cap06.pr0506resuelta.gui.VentanaBancoDePruebas;

public class EjemploACorregirSets {
	static HashSet<Fantasma> hS;
	static TreeSet<Fantasma> hSS;
	public static void main(String[] args) {
		hS = new HashSet<>();
		hS.add( new Fantasma( "casper", 1, 2) );
		hS.add( new Fantasma( "opera phantom", 4, 2) );
		hS.add( new Fantasma( "casper", 1, 2) );
		hS.add( new Fantasma( "myrtle", 5, 10) );
		System.out.println( hS );
		hSS = new TreeSet<>();
		hSS.add( new Fantasma( "casper", 1, 2) );
		hSS.add( new Fantasma( "opera phantom", 4, 2) );
		hSS.add( new Fantasma( "casper", 1, 2) );
		hSS.add( new Fantasma( "myrtle", 5, 10) );
		System.out.println( hSS );
	}
	
	private static class Fantasma implements Comparable<Fantasma> {
		String nombre;
		int x;
		int y;
		public Fantasma(String nombre, int x, int y) {
			super();
			this.nombre = nombre;
			this.x = x;
			this.y = y;
		}	
		@Override
		public String toString() {
			return nombre + " (" + x + "," + y + ")";
		}
		
		// Métodos para HashSet
		@Override
		public int hashCode() {
			return nombre.hashCode();
		}
		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Fantasma)) return false;
			Fantasma f2 = (Fantasma) obj;
			return nombre.equals(f2.nombre);
		}
		@Override
		public int compareTo(Fantasma f2) {
			return nombre.compareTo(f2.nombre);
		}
		
	}
	
}
