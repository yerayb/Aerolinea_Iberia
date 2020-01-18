package server.data.dto;
import server.data.VueloIberia;




public class Assembler {

	public VueloDTO assemble(VueloIberia vr) {
		VueloDTO v = new VueloDTO();
		v.setAeropuertoDestino(vr.getAeropuertoDestino());
		v.setAeropuertoOrigen(vr.getAeropuertoOrigen());
		v.setAsientosDisponibles(vr.getAsientosDisponibles());
		v.setFecha(vr.getFecha());
		v.setNomAerolinea(vr.getNomAerolinea());
		v.setNumAsientos(vr.getNumAsientos());
		v.setNumVuelo(vr.getNumVuelo());
		return v;
	}
	
	public VueloIberia disassemble(VueloDTO vr) {
		VueloIberia v = new VueloIberia();
		v.setAeropuertoDestino(vr.getAeropuertoDestino());
		v.setAeropuertoOrigen(vr.getAeropuertoOrigen());
		v.setAsientosDisponibles(vr.getAsientosDisponibles());
		v.setFecha(vr.getFecha());
		v.setNomAerolinea(vr.getNomAerolinea());
		v.setNumAsientos(vr.getNumAsientos());
		v.setNumVuelo(vr.getNumVuelo());
		return v;
	}

}
