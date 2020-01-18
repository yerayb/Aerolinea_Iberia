package iberia;

import java.util.ArrayList;

public class AerolineaIberia implements IAerolineaIberia {

	private ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
	Vuelo v1 = new Vuelo();
	Vuelo v2 = new Vuelo();
	Vuelo v3 = new Vuelo();
	Vuelo v4 = new Vuelo();

	public AerolineaIberia() {

	}



	@Override
	public ArrayList<Vuelo> getAllVuelos() {
		// Vuelo 1
				v1.setAeropuertoOrigen("BIO");
				v1.setAeropuertoDestino("BCN");
				v1.setFecha("20/01/19");
				v1.setNomAerolinea("IB");
				v1.setNumAsientos(550);
				v1.setAsientosDisponibles(550);
				v1.setNumVuelo("IB425");
				vuelos.add(v1);

				// Vuelo 2
				v2.setAeropuertoOrigen("BCN");
				v2.setAeropuertoDestino("MAD");
				v2.setFecha("22/01/19");
				v2.setNomAerolinea("IB");
				v2.setNumVuelo("IB625");
				v2.setAsientosDisponibles(650);
				v2.setNumAsientos(650);
				vuelos.add(v2);

				// Vuelo 3
				v3.setAeropuertoOrigen("VLC");
				v3.setAeropuertoDestino("MAD");
				v3.setFecha("24/01/19");
				v3.setNomAerolinea("IB");
				v3.setNumVuelo("IB25");
				v3.setAsientosDisponibles(530);
				v3.setNumAsientos(530);
				vuelos.add(v3);
				
				// Vuelo 4
				v4.setAeropuertoOrigen("BIO");
				v4.setAeropuertoDestino("MAD");
				v4.setFecha("20/01/19");
				v4.setNomAerolinea("IB");
				v4.setNumVuelo("IB256");
				v4.setAsientosDisponibles(530);
				v4.setNumAsientos(530);
				vuelos.add(v4);
				
		for (Vuelo vuelo : vuelos) {
			System.out.println("Aerolinea: " + vuelo.getNomAerolinea() + "\n Origen: " + vuelo.getAeropuertoOrigen()
					+ "\n Destino: " + vuelo.getAeropuertoDestino());
		}
		// TODO Auto-generated method stub
		return vuelos;
	}

	@Override
	public Vuelo buscarVuelo(String aeropuertoDestino, String aeropuertoOrigen, String fecha, int asientos) {
		// TODO Auto-generated method stub
		int i = 0;
		Vuelo vueloEncontrado = null;
		for(i=0;i<vuelos.size();i++) {
			if(vuelos.get(i).getAeropuertoOrigen()==aeropuertoOrigen && vuelos.get(i).getAeropuertoDestino() == aeropuertoDestino && vuelos.get(i).getFecha() == fecha && vuelos.get(i).getAsientosDisponibles() >= asientos) {
				vueloEncontrado = vuelos.get(i);
			}
			
		}
		System.out.println("Origen: " +vueloEncontrado.getAeropuertoOrigen() +" Destino: " +vueloEncontrado.getAeropuertoDestino() +" Numero de vuelo: " +vueloEncontrado.getNumVuelo() );
		return vueloEncontrado;
		
	}

	@Override
	public ArrayList<Vuelo> buscarVuelosDesdeOrigen(String aeropuertoOrigen, String fecha, int asientos) {
		// TODO Auto-generated method stub
		ArrayList<Vuelo> vuelosEncontrados = new ArrayList<Vuelo>();
		int i;
		for(i=0;i<vuelos.size();i++) {
			if(vuelos.get(i).getAeropuertoOrigen()==aeropuertoOrigen && vuelos.get(i).getFecha() == fecha &&vuelos.get(i).getAsientosDisponibles() >= asientos ) {
				vuelosEncontrados.add(vuelos.get(i));
				
			}
			
		}
		
		for (int j = 0; j < vuelosEncontrados.size(); j++) {
			System.out.println("Numero de vuelo: " +vuelosEncontrados.get(j).getNumVuelo());
		}
			
		
		
		return vuelosEncontrados;
	}



	@Override
	public boolean reservarVuelo(Vuelo vuelo, String nombre, int plazas) {
		// TODO Auto-generated method stub

		boolean reserva;
		int plazasdisponibles = vuelo.getAsientosDisponibles();
		int comprobarReserva = plazasdisponibles-plazas;
		if(comprobarReserva>=0) {
			vuelo.setAsientosDisponibles(vuelo.getAsientosDisponibles()-plazas);
			reserva = true;
		}
		else {
			reserva = false;
		}
		
		System.out.println(reserva);
		// TODO Auto-generated method stub
		return reserva;
	
	}

	public static void main(String[] args) {
		AerolineaIberia ob=new AerolineaIberia();
		System.out.println("Metodo getallvuelos");
		System.out.println("---------------------");
		ob.getAllVuelos();
		System.out.println("---------------------");
		
		System.out.println("Metodo buscarvuelo");
		ob.buscarVuelo("BCN", "BIO", "20/01/19" , 4);
		System.out.println("---------------------");
		
		System.out.println("Metodo buscarvuelodesdeorigen");
		ob.buscarVuelosDesdeOrigen("BIO", "20/01/19", 30);
		
		System.out.println("---------------------");
		System.out.println("Metodo Reserva");
		System.out.println("Asientas antes de reserva: " +ob.v1.getAsientosDisponibles());
		ob.reservarVuelo(ob.v1, "Yeray", 5);
		System.out.println("Asientas despues de reserva: " +ob.v1.getAsientosDisponibles());
		

		
	}

	
	
	

		 

}
