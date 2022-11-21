package _1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	static final String HOST = "localhost";
	static final int PORT = 5000;
	Scanner scanner;

	public Client() {
		scanner = new Scanner(System.in);
		try {
			Socket clientSocket = new Socket(HOST, PORT);

			DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
			DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());

			// Read response from server "Hello, client" and print it
			System.out.println(dataInputStream.readUTF());

			// Send 2 request with data = double
			for (int i = 0; i < 2; i++) {
				dataOutputStream.writeDouble(readDouble("Give me a new number: "));
			}

			double sum = dataInputStream.readDouble();
			double rest = dataInputStream.readDouble();

			System.out.println("Sum: " + sum);
			System.out.println("Rest: " + rest);

			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Client();
	}

	public double readDouble(String message) {
		System.out.print(message);
		double number = scanner.nextDouble();
		scanner.nextLine();
		return number;
	}

	public String readString(String message) {
		System.out.print(message);
		return scanner.nextLine();
	}
}
