package server.data;

import java.io.Serializable;

public class VueloIberia {

	
	private String nomAerolinea;
	private String numVuelo;
	private String aeropuertoDestino;
	private String aeropuertoOrigen;
	private String fecha;
	private int numAsientos;
	private int asientosDisponibles;
	

	
	public VueloIberia() {
		
	}
	
	
	
	public VueloIberia(String nomAerolinea, String aeropuertoDestino, String aeropuertoOrigen, String fecha,
			int numAsientos) {
		super();
		this.nomAerolinea = nomAerolinea;
		this.aeropuertoDestino = aeropuertoDestino;
		this.aeropuertoOrigen = aeropuertoOrigen;
		this.fecha = fecha;
		this.numAsientos = numAsientos;
	}



	public void testToString() {
		System.out.println(aeropuertoDestino);
		System.out.println(aeropuertoOrigen);
		System.out.println(fecha);
		System.out.println(numAsientos);
		System.out.println(nomAerolinea);
	}

	public String getNomAerolinea() {
		return nomAerolinea;
	}



	public void setNomAerolinea(String nomAerolinea) {
		this.nomAerolinea = nomAerolinea;
	}



	public int getNumAsientos() {
		return numAsientos;
	}
	public void setNumAsientos(int numAsientos) {
		this.numAsientos = numAsientos;
	}
	public String getAeropuertoDestino() {
		return aeropuertoDestino;
	}
	public void setAeropuertoDestino(String aeropuertoDestino) {
		this.aeropuertoDestino = aeropuertoDestino;
	}
	public String getAeropuertoOrigen() {
		return aeropuertoOrigen;
	}
	public void setAeropuertoOrigen(String aeropuertoOrigen) {
		this.aeropuertoOrigen = aeropuertoOrigen;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}



	public String getNumVuelo() {
		return numVuelo;
	}



	public void setNumVuelo(String numVuelo) {
		this.numVuelo = numVuelo;
	}



	public int getAsientosDisponibles() {
		return asientosDisponibles;
	}



	public void setAsientosDisponibles(int asientosDisponibles) {
		this.asientosDisponibles = asientosDisponibles;
	}
	
	
	

}