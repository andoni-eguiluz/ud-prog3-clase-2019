package es.deusto.prog3.repaso;

import java.util.*;

public class Dudas {
	public static void main(String[] args) {
		TreeSet<String> miSet = new TreeSet<>();
		miSet.add( "aa" );
		miSet.add( "ba" );
		miSet.add( "cbbb" );
		for (String s : miSet) {
			System.out.println( s );
		}
		// Código nuevo - controlar
		String nuevo = "ba";
		if (miSet.contains( nuevo ) ) {
			System.out.println( "Existe" );
		}
		// String busqueda = miSet.get( nuevo );
		TreeSet<Farmacia> mF = new TreeSet<>();
	}
	
	private static class Farmacia implements Comparable<Farmacia> {
		String zona;
		String direccion;
		long horaDesde;
		long horaHasta;
		@Override
		public int compareTo(Farmacia o) {
			if (horaDesde!=o.horaDesde) 
				return (new Long(horaDesde)).compareTo(o.horaDesde);
			if (horaDesde!=o.horaDesde) return (int) (horaDesde-o.horaDesde);
			// else ...
			if (horaHasta!=o.horaHasta) return (int) (horaHasta-o.horaHasta);
			// else ...
			return (zona+direccion).compareTo( o.zona+o.direccion );
		}
	}
}
