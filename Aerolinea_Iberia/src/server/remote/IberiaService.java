package server.remote;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import server.data.VueloIberia;
import server.data.dto.VueloDTO;

public class IberiaService extends Thread {

	private DataInputStream in;
	private DataOutputStream out;
	private Socket tcpSocket;
	private AerolineaIberia fDb;

	public IberiaService(Socket socket) {
		
		try {
			this.tcpSocket = socket;
			this.fDb = new AerolineaIberia();
		    this.in = new DataInputStream(socket.getInputStream());
			this.out = new DataOutputStream(socket.getOutputStream());
			this.start();
		} catch (IOException e) {
			System.err.println("# IberiaService - TCPConnection IO error:" + e.getMessage());
		}
	}

	public void run() {
		// Iberia server
		try {
			
			//Metodo buscarVuelo
			String data[] = this.in.readUTF().split(";");
			String origen = data[0];
			String destino = data[1];
			String fecha = data[2];
			int asientos = Integer.parseInt(data[3]);
			
			// Read request from the client
		
			
			System.out.println("   - IberiaService - Received data from '" + tcpSocket.getInetAddress().getHostAddress()
					+ ":" + tcpSocket.getPort() + "' -> '" + data + "'");
			
			VueloDTO vuelo = fDb.buscarVuelo(destino, origen, fecha, asientos);
			String r = "";
			r = r + vuelo.toString() + "#";
			// Send response to the client
			this.out.writeUTF(r +"");
			
			//metodo getVuelo
			String datagetVuelo[] =this.in.readUTF().split(";");
			String codVuelo = datagetVuelo[0];
			VueloDTO vueloGet = fDb.getVuelo(codVuelo);
			System.out.println("   - IberiaService - Received data from '" + tcpSocket.getInetAddress().getHostAddress()
					+ ":" + tcpSocket.getPort() + "' -> '" + datagetVuelo + "'");
			
			String f = "";
			f = f + vueloGet.toString() + "#";
			// Send response to the client
			this.out.writeUTF(f +"");
			

			//Metodo buscarVuelosDesdeOrigen
			String databuscarOrigen[] = this.in.readUTF().split(";");
			String aeropuertoOrigen = databuscarOrigen[0];
			String fechaOrigen = databuscarOrigen[1];
			int asientosOrigen = Integer.parseInt(databuscarOrigen[2]);
			System.out.println("   - IberiaService - Received data from '" + tcpSocket.getInetAddress().getHostAddress()
					+ ":" + tcpSocket.getPort() + "' -> '" + databuscarOrigen + "'");
			
		
			ArrayList<VueloDTO> hArr = fDb.buscarVuelosDesdeOrigen(aeropuertoOrigen, fechaOrigen, asientosOrigen);
			String h = "";
			for(int i = 0; i < hArr.size(); i++) {
				h = h +hArr.get(i).toString() + "#";
			}

			this.out.writeUTF(h+"");
			
			
			//Metodo getallvuelos
		
			ArrayList<VueloDTO> getAllVuelos = fDb.getAllVuelos();
			String j = "";
			for(int i = 0; i < getAllVuelos.size(); i++) {
				j = j +getAllVuelos.get(i).toString() + "#";
			}

			this.out.writeUTF(j+"");
			
			// metodo reservarVuelo
			String reservar[] = this.in.readUTF().split(";");
			String codVueloR = reservar[0];
			String nombre = reservar[1];
			int plazas = Integer.parseInt(reservar[2]);
			System.out.println("   - IberiaService - Received data from '" + tcpSocket.getInetAddress().getHostAddress()
					+ ":" + tcpSocket.getPort() + "' -> '" + reservar + "'");
			
			boolean reserva = fDb.reservarVuelo(codVueloR, nombre, plazas);
			
			String t = "";
			t = t + reserva + "#";
			// Send response to the client
			this.out.writeUTF(t +"");
			
			System.out.println("   - IberiaService - Sent data to '" + tcpSocket.getInetAddress().getHostAddress() + ":"
					+ tcpSocket.getPort() + "' -> '" + r + "'");
		} catch (EOFException e) {
			System.err.println("   # IberiaService - TCPConnection EOF error" + e.getMessage());
		} catch (IOException e) {
			System.err.println("   # IberiaService - TCPConnection IO error:" + e.getMessage());
		} finally {
			try {
				tcpSocket.close();
			} catch (IOException e) {
				System.err.println("   # IberiaService - TCPConnection IO error:" + e.getMessage());
			}
		}
	}
}