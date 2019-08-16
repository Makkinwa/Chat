package System;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import System.*;
public class OutputHandler {
	ChatWindow window;
	Server server;
	String username;
	OutputStream out;
	private byte[] end = {2};
	public OutputHandler(Socket s) throws IOException {
		out = s.getOutputStream();
	}
	
	
	public void takeText(String s) {
		try {
			out.write(s.getBytes());
			out.write(end);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
