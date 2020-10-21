package es.deusto.prog3.ig;

import java.util.Date;

public class Partido {
	private Date fecha;
	private String torneo;
	private String tipo;
	private String ronda;
	private String ganador;
	private String perdedor;
	private int setsGanados;
	private int setsPerdidos;
	
	public Partido(Date fecha, String torneo, String tipo, String ronda, String ganador, String perdedor,
			int setsGanados, int setsPerdidos) {
		super();
		this.fecha = fecha;
		this.torneo = torneo;
		this.tipo = tipo;
		this.ronda = ronda;
		this.ganador = ganador;
		this.perdedor = perdedor;
		this.setsGanados = setsGanados;
		this.setsPerdidos = setsPerdidos;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTorneo() {
		return torneo;
	}

	public void setTorneo(String torneo) {
		this.torneo = torneo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getRonda() {
		return ronda;
	}

	public void setRonda(String ronda) {
		this.ronda = ronda;
	}

	public String getGanador() {
		return ganador;
	}

	public void setGanador(String ganador) {
		this.ganador = ganador;
	}

	public String getPerdedor() {
		return perdedor;
	}

	public void setPerdedor(String perdedor) {
		this.perdedor = perdedor;
	}

	public int getSetsGanados() {
		return setsGanados;
	}

	public void setSetsGanados(int setsGanados) {
		this.setsGanados = setsGanados;
	}

	public int getSetsPerdidos() {
		return setsPerdidos;
	}

	public void setSetsPerdidos(int setsPerdidos) {
		this.setsPerdidos = setsPerdidos;
	}	
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
