package _1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

	static final String HOST = "localhost";
	static final int PORT = 5000;

	public Client() {
		try {
			Socket clientSocket = new Socket(HOST, PORT);

			DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
			DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());

			// Read response from server "Hello, client" and print it
			System.out.println(dataInputStream.readUTF());

			// Send request with data = 2
			dataOutputStream.write(2);

			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Client();
	}
}
