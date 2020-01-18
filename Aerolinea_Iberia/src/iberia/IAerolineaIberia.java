package iberia;

import java.util.ArrayList;


public interface IAerolineaIberia {
	static String IP = "127.0.0.1";
	static String Puerto = "";
	static String Service = "";
//TODO Aerolinea Gateways method

	/** 
	 * @return Devuelve toda la lista de vuelos que hay en la Aerolinea
	 */
	public  ArrayList<Vuelo> getAllVuelos();
	
	/**
	 * @param aeropuertoDestino
	 * @param aeropuertoOrigen
	 * @param fechaIda
	 * @param fechaVuelta
	 * @param asientos
	 * @return Devuelve una clase vuelo que cumpla con las caracteristicas descritas
	 */
	public Vuelo buscarVuelo(String aeropuertoDestino, String aeropuertoOrigen, String fecha, int asientos);
	/**
	 * @param aeropuertoOrigen Aeropuerto de Origen
	 * @param fecha Fecha de partida del vuelo
	 * @param asientos Asientos requeridos
	 * @return Devuelve la lista de vuelos que partan desde el aeropuerto origen en la fecha especificada
	 */
	public ArrayList<Vuelo> buscarVuelosDesdeOrigen(String aeropuertoOrigen, String fecha, int asientos);
	
	/**
	 * @param vuelo Vuelo que se quiere reservar
	 * @param nombre Nombre del usuario que quiere reservar el vuelo
	 * @return True si se ha reservado con exito, false si no
	 */
	public boolean reservarVuelo(Vuelo vuelo, String nombre, int plazas);

}