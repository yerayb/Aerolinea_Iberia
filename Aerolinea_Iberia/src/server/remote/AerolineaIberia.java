package server.remote;

import java.util.ArrayList;

import server.data.VueloIberia;
import server.data.dto.Assembler;
import server.data.dto.VueloDTO;

public class AerolineaIberia implements IAerolineaIberia {

	private ArrayList<VueloDTO> vuelos;
	private Assembler assem;
	
	
	public AerolineaIberia() {
		super();
		vuelos = new ArrayList<VueloDTO>();
		assem = new Assembler();
	}



	@Override
	public ArrayList<VueloDTO> getAllVuelos() {
		System.out.println("Request: +getAllVuelos()");
		
		VueloIberia v1 = new VueloIberia();
		VueloIberia v2 = new VueloIberia();
		VueloIberia v3 = new VueloIberia();
		VueloIberia v4 = new VueloIberia();

		// Vuelo 1
				v1.setAeropuertoOrigen("BIO");
				v1.setAeropuertoDestino("BCN");
				v1.setFecha("20/01/19");
				v1.setNomAerolinea("IB");
				v1.setNumAsientos(550);
				v1.setAsientosDisponibles(550);
				v1.setNumVuelo("IB425");
				vuelos.add(assem.assemble(v1));

				// Vuelo 2
				v2.setAeropuertoOrigen("BCN");
				v2.setAeropuertoDestino("MAD");
				v2.setFecha("22/01/19");
				v2.setNomAerolinea("IB");
				v2.setNumVuelo("IB625");
				v2.setAsientosDisponibles(650);
				v2.setNumAsientos(650);
				vuelos.add(assem.assemble(v2));

				// Vuelo 3
				v3.setAeropuertoOrigen("VLC");
				v3.setAeropuertoDestino("MAD");
				v3.setFecha("24/01/19");
				v3.setNomAerolinea("IB");
				v3.setNumVuelo("IB25");
				v3.setAsientosDisponibles(530);
				v3.setNumAsientos(530);
				vuelos.add(assem.assemble(v3));
				
				// Vuelo 4
				v4.setAeropuertoOrigen("BIO");
				v4.setAeropuertoDestino("MAD");
				v4.setFecha("20/01/19");
				v4.setNomAerolinea("IB");
				v4.setNumVuelo("IB256");
				v4.setAsientosDisponibles(530);
				v4.setNumAsientos(530);
				vuelos.add(assem.assemble(v4));
				
		for (VueloDTO vuelo : vuelos) {
			System.out.println("Aerolinea: " + vuelo.getNomAerolinea() + "\n Origen: " + vuelo.getAeropuertoOrigen()
					+ "\n Destino: " + vuelo.getAeropuertoDestino());
		}
		// TODO Auto-generated method stub
		return vuelos;
	}

	@Override
	public VueloDTO buscarVuelo(String aeropuertoDestino, String aeropuertoOrigen, String fecha, int asientos) {
		// TODO Auto-generated method stub
		System.out.println("Request: +buscarVuelo()");
		int i = 0;
		VueloDTO vueloEncontrado = null;
		for(i=0;i<vuelos.size();i++) {
			if(vuelos.get(i).getAeropuertoOrigen()==aeropuertoOrigen && vuelos.get(i).getAeropuertoDestino() == aeropuertoDestino && vuelos.get(i).getFecha() == fecha && vuelos.get(i).getAsientosDisponibles() >= asientos) {
				vueloEncontrado = vuelos.get(i);
				System.out.println("Vuelo encontrado");
			}
			
		}
		System.out.println("Origen: " +vueloEncontrado.getAeropuertoOrigen() +" Destino: " +vueloEncontrado.getAeropuertoDestino() +" Numero de vuelo: " +vueloEncontrado.getNumVuelo() );
		return vueloEncontrado;
		
	}

	@Override
	public ArrayList<VueloDTO> buscarVuelosDesdeOrigen(String aeropuertoOrigen, String fecha, int asientos) {
		// TODO Auto-generated method stub
		System.out.println("Request: +buscarVuelosDesdeOrigen()");
		ArrayList<VueloDTO> vuelosEncontrados = new ArrayList<VueloDTO>();
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
	public boolean reservarVuelo(String codVuelo, String nombre, int plazas) {
		// TODO Auto-generated method stub
		System.out.println("Request: +reservarVuelo()");

		boolean reserva;
		VueloDTO v = null;
		for(int i=0;i<vuelos.size();i++) {
			if(vuelos.get(i).getNumVuelo()==codVuelo) {
				v = vuelos.get(i);
			}
			
		}
		
		System.out.println("Asientos disponibles: " +v.getAsientosDisponibles());
		
		int plazasdisponibles = v.getAsientosDisponibles();
		int comprobarReserva = plazasdisponibles-plazas;
		if(comprobarReserva>=0) {
			v.setAsientosDisponibles(v.getAsientosDisponibles()-plazas);
			System.out.println("Vuelo reservado");
			reserva = true;
		}
		else {
			System.out.println("Vuelo no reservado");
			reserva = false;
		}
		
		System.out.println("Asientos disponibles: " +v.getAsientosDisponibles());
		
		System.out.println(reserva);
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
		ob.reservarVuelo("IB625", "Yeray", 5);

		

		
	}

	
	
	

		 

}
