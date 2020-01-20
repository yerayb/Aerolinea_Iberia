package server.data.dto;

import java.io.Serializable;

public class VueloDTO implements Serializable {
	private static final long serialVersionUID = 8829744013340172113L;
	
	private String nomAerolinea;
	private String numVuelo;
	private String aeropuertoDestino;
	private String aeropuertoOrigen;
	private String fecha;
	private int numAsientos;
	private int asientosDisponibles;
	private int precio;
	
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
	
	
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nomAerolinea + ";" + numVuelo + ";" + aeropuertoDestino + ";" + aeropuertoOrigen + ";" + fecha + ";" + numAsientos + ";" + asientosDisponibles + ";" + precio;

	}
	
	
	


}
