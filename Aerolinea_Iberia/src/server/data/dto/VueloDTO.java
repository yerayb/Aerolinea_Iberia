package server.data.dto;

import java.io.Serializable;

public class VueloDTO implements Serializable {

	private String nomAerolinea;
	private String numVuelo;
	private String aeropuertoDestino;
	private String aeropuertoOrigen;
	private String fecha;
	private int numAsientos;
	private int asientosDisponibles;
	
	public String getNomAerolinea() {
		return nomAerolinea;
	}
	public void setNomAerolinea(String nomAerolinea) {
		this.nomAerolinea = nomAerolinea;
	}
	public String getNumVuelo() {
		return numVuelo;
	}
	public void setNumVuelo(String numVuelo) {
		this.numVuelo = numVuelo;
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
	public int getNumAsientos() {
		return numAsientos;
	}
	public void setNumAsientos(int numAsientos) {
		this.numAsientos = numAsientos;
	}
	public int getAsientosDisponibles() {
		return asientosDisponibles;
	}
	public void setAsientosDisponibles(int asientosDisponibles) {
		this.asientosDisponibles = asientosDisponibles;
	}
	
	


}
