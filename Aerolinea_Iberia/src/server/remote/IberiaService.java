package server.remote;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

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
			String data[] = this.in.readUTF().split(";");
			String origen = data[0];
			String destino = data[1];
			String fecha = data[2];
			int asientos = Integer.parseInt(data[3]);
			
			// Read request from the client
			//String data = this.in.readUTF();
			
			System.out.println("   - IberiaService - Received data from '" + tcpSocket.getInetAddress().getHostAddress()
					+ ":" + tcpSocket.getPort() + "' -> '" + data + "'");
			
			VueloDTO vuelos = fDb.buscarVuelo(destino, origen, fecha, asientos);
			String r = "";
			r = r + vuelos.toString() + "#";
			
		

			// Send response to the client
			this.out.writeUTF(r +"");
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