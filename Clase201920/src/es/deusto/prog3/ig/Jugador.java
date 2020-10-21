package es.deusto.prog3.ig;

public class Jugador implements Comparable<Jugador> {
	// Crea una clase Jugador que contenga nombre de tenista, número de partidos ganados y número de partidos perdidos.
	private String nombre;
	private int numGanados;
	private int numPerdidos;
	public Jugador(String nombre) {
		this.nombre = nombre;
		numGanados = 0;
		numPerdidos = 0;
	}
	public Jugador(String nombre, int numGanados, int numPerdidos) {
		super();
		this.nombre = nombre;
		this.numGanados = numGanados;
		this.numPerdidos = numPerdidos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumGanados() {
		return numGanados;
	}
	public void setNumGanados(int numGanados) {
		this.numGanados = numGanados;
	}
	public void incNumGanados() {
		numGanados++;
	}
	public int getNumPerdidos() {
		return numPerdidos;
	}
	public void setNumPerdidos(int numPerdidos) {
		this.numPerdidos = numPerdidos;
	}
	public void incNumPerdidos() {
		numPerdidos++;
	}
	
	// Criterio de ordenación
	// Define la ordenación de ese conjunto para que los tenistas 
	// se ordenen por diferencia de partidos ganados menos perdidos 
	// (primero los de mayor diferencia), 
	// y a igualdad por mayor número de partidos ganados.
	@Override
	public int compareTo(Jugador o) {
		// return nombre.compareTo(o.nombre);
		int dif = numGanados - numPerdidos;  // Dif del tenista 1
		int dif2 = o.numGanados - o.numPerdidos; // Dif del tenista 2
		// Primer nivel de comparación (prioridad 1)
		if (dif>dif2) return -1;  // el tenista 1 va antes
		else if (dif<dif2) return +1;  // el tenista 1 va después
		else {
			// Segundo nivel (prioridad 2)
			// if (numGanados > o.numGanados) return -1;
			// else (numGanados < o.numGanados) return +1;
			// else return 0;
			return -(numGanados - o.numGanados);
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	@Override
	public String toString() {
		return nombre + " - G:" + numGanados + ", P:" + numPerdidos;
	}
}
