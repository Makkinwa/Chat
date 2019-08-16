package System;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;
public class InputHandler {
	static InputStream in;
	ChatWindow window;
	public InputHandler(Socket s, ChatWindow window) throws IOException {
		this.window = window;
		in = s.getInputStream();
	}
	
	public void startInput() throws IOException {
		int i;
		while(true) {
			String tmp = "";
			while((i = in.read()) != 2) {
				if (i == -1) {
					System.out.println("Connection is closed");
					System.exit(0);
				}
				tmp += (char) i;
			}
			System.out.println(tmp);
			window.takeMessage(tmp);
		}
	}
}