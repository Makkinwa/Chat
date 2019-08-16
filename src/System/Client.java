package System;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	ChatWindow window;
	Socket client;
	static InputHandler in;
	static OutputHandler out;
	int port;
	String username;
	public Client(int port, String username, String host) {
		try {
			client = new Socket(host, port);
			System.out.println("Connection is successful");
			out = new OutputHandler(client);
			window = new ChatWindow(username, out);
			in = new InputHandler(client, window);
			System.out.println(username);
			in.startInput();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Port or host fatal error!");
			System.exit(0);
		}
	}

	
}