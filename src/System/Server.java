package System;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class Server{
	ChatWindow window;
	ServerSocket serversocket;
	Socket client;
	static InputHandler in;
	static OutputHandler out;
	int port;
	String username;
	public Server(int port, String username){
		try {
			serversocket = new ServerSocket(port);
			System.out.println("Server is created");
			client = serversocket.accept();
			System.out.println("Client is connected");
			out = new OutputHandler(client);
			window = new ChatWindow(username, out);
			in = new InputHandler(client, window);
			System.out.println(username);
			in.startInput();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Port fatal error!");
			System.exit(0);
		}
	}

	
}
