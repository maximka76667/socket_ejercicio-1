package _1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	static final int PORT = 5000;
	protected ServerSocket serverSocket;
	protected DataOutputStream dataOutputStream;
	protected DataInputStream dataInputStream;

	public Server() {
		try {
			// Server socket
			ServerSocket serverSocket = new ServerSocket(PORT);
			System.out.println("Listening port = " + PORT);

			// Client socket
			Socket clientSocket = serverSocket.accept();
			System.out.println("Client connected");

			// Data input and output streams
			DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
			DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());

			// Send response to client when its connected
			dataOutputStream.writeUTF("Hello, client");

			// Receive request from client with data = 2
			// 2 + 2 = 4
			System.out.println(dataInputStream.read() + 2);

			clientSocket.close();

			serverSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Server();
	}

	public void establishServer() {

	}
}
