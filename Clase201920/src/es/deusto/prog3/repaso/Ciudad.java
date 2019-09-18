package es.deusto.prog3.repaso;

import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

/** Ejemplo de clase para dudas de HashSet/TreeSet y HashMap/TreeMap
 */
public class Ciudad implements Comparable<Ciudad> {
	private String nombre;
	private String provincia;
	public Ciudad(String nombre, String provincia) {
		super();
		this.nombre = nombre;
		this.provincia = provincia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	@Override
	public String toString() {
		return nombre + " (" + provincia + ")";
	}
	@Override
	public int hashCode() {
		return nombre.hashCode() + provincia.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Ciudad) {
			Ciudad c2 = (Ciudad) obj;
			return nombre.equals(c2.nombre) && provincia.equals(c2.provincia);
		} else {
			return false;
		}
	}
	
	@Override
	public int compareTo(Ciudad o) {
		int res = nombre.compareTo(o.nombre);
		if (res!=0) return res;
		return provincia.compareTo(o.provincia);
	}
	
	public static void main(String[] args) {
		// Hashset de ciudades
		HashSet<Ciudad> set1 = new HashSet<>();
		set1.add( new Ciudad( "Bilbao", "Bizkaia" ) );
		set1.add( new Ciudad( "Vera", "Almería" ) );
		set1.add( new Ciudad( "Vera", "Cáceres" ) );
		set1.add( new Ciudad( "Vera", "Almería" ) );
		System.out.println( set1 );
		for (Ciudad c : set1) {
			System.out.println( c + " - " + c.hashCode() );
		}
		System.out.println( new Ciudad( "Vera", "Almería" ).equals(
				new Ciudad( "Vera", "Almería" ) ) );
		Ciudad c1 = new Ciudad( "Vera", "Almería" );
		if (set1.contains( c1 )) {
			System.out.println( "Está" );
		}
		
		TreeSet<Ciudad> set2 = new TreeSet<>();
		set2.add( new Ciudad( "Bilbao", "Bizkaia" ) );
		set2.add( new Ciudad( "Vera", "Almería" ) );
		set2.add( new Ciudad( "Vera", "Cáceres" ) );
		set2.add( new Ciudad( "Vera", "Almería" ) );
		System.out.println( set2 );
		System.out.println( "zsdf".compareTo("aa") );
		
		Ciudad c5 = new Ciudad( "Bilbao", "Bizkaia" );
		Ciudad c2 = new Ciudad( "Vera", "Almería" );
		Ciudad c3 = new Ciudad( "Vera", "Cáceres" );
		Ciudad c4 = new Ciudad( "Vera", "Almería" );
		
		TreeMap<String,Ciudad> mapaC = new TreeMap<>();
		mapaC.put( c5.getNombre()+c5.getProvincia(), c5 );
		mapaC.put( c2.getNombre()+c2.getProvincia(), c2 );
		mapaC.put( c3.getNombre()+c3.getProvincia(), c3 );
		mapaC.put( c4.getNombre()+c4.getProvincia(), c4 );
		System.out.println( mapaC );
		for (Ciudad c : mapaC.values()) {
			System.out.println( c );
		}
	}
	
}
