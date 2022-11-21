package _1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	static final int PORT = 5000;
	protected ServerSocket serverSocket;

	public Server() {
		try {
			// Establish server socket
			establishServer();

			// Client socket
			Socket clientSocket = serverSocket.accept();
			System.out.println("Client connected");

			// Data input and output streams for this client
			DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
			DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());

			// Send response to client when its connected
			dataOutputStream.writeUTF("Hello, client");

			double a = dataInputStream.readDouble();
			double b = dataInputStream.readDouble();

			double sum = a + b;
			double rest = a - b;

			dataOutputStream.writeDouble(sum);
			dataOutputStream.writeDouble(rest);

			clientSocket.close();
			serverSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Server();
	}

	public void establishServer() throws IOException {
		// Server socket
		serverSocket = new ServerSocket(PORT);
		System.out.println("Listening port = " + PORT);

	}
}
