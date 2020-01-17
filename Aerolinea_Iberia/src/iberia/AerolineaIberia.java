package iberia;

import java.util.ArrayList;

public class AerolineaIberia implements IGatewayAerolinea {

	private ArrayList<VueloDTO> vuelos = new ArrayList<VueloDTO>();
	VueloDTO v1 = new VueloDTO();
	VueloDTO v2 = new VueloDTO();
	VueloDTO v3 = new VueloDTO();

	public AerolineaIberia() {

	}



	@Override
	public ArrayList<VueloDTO> getAllVuelos() {
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
				
		for (VueloDTO vuelo : vuelos) {
			System.out.println("Aerolinea: " + vuelo.getNomAerolinea() + "\n Origen: " + vuelo.getAeropuertoOrigen()
					+ "\n Destino: " + vuelo.getAeropuertoDestino());
		}
		// TODO Auto-generated method stub
		return vuelos;
	}

	@Override
	public VueloDTO buscarVuelo(String aeropuertoDestino, String aeropuertoOrigen, String fechaIda, String fechaVuelta,
			int asientos) {
		// TODO Auto-generated method stub
		int i = 0;
		VueloDTO vueloEncontrado = null;
		for(i=0;i<vuelos.size();i++) {
			if(vuelos.get(i).getAeropuertoOrigen()==aeropuertoOrigen && vuelos.get(i).getAeropuertoDestino() == aeropuertoDestino && vuelos.get(i).getFecha() == fechaIda && vuelos.get(i).getNumAsientos() == asientos) {
				vueloEncontrado = vuelos.get(i);
			}
			
		}
		return vueloEncontrado;
		
	}

	@Override
	public ArrayList<VueloDTO> buscarVuelosDesdeOrigen(String aeropuertoOrigen, String fecha, int asientos) {
		// TODO Auto-generated method stub
		ArrayList<VueloDTO> vuelosEncontrados = new ArrayList<VueloDTO>();
		int i;
		for(i=0;i<vuelos.size();i++) {
			if(vuelos.get(i).getAeropuertoOrigen()==aeropuertoOrigen && vuelos.get(i).getFecha() == fecha  ) {
				vuelosEncontrados.add(vuelos.get(i));
			}
		}
		
		return vuelosEncontrados;
	}



	@Override
	public boolean reservarVuelo(VueloDTO vuelo, String nombre, int plazas) {
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
		
		// TODO Auto-generated method stub
		return reserva;
	
	}


	
	
	

		 

}
