package System;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) throws IOException, InterruptedException {
		final byte[] end = {10, 2};
		String username;
		try{
			ServerSocket s = new ServerSocket(1077, 3);
			Scanner sc = new Scanner(System.in);
			System.out.println("Start");
			System.out.println("Write your username");
			System.out.println("\n");
			username = sc.next();
			Socket client;
			client = s.accept();
			System.out.println("Client is connected");
			InputStream in = client.getInputStream();
			OutputStream out = client.getOutputStream();
			Runnable outThread = new Runnable() {
				String mail;
				@Override
				public void run() {
					try {
						while(true) {
							//System.out.print(username + ": ");
							if (sc.hasNext()) {
								mail = username + ": " + sc.nextLine();
								out.write(mail.getBytes());
								out.write(end);
							}
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				};
			Thread t = new Thread(outThread);
			t.start();
				
			while(true) {
				int tmp = 0;
				int i;
				/*if(in.available() > 0) {
					System.out.print("***");
					System.out.println("\n");
				}*/
				while((i = in.read()) != 2 ) {
					if (i == -1) { 
						System.out.println("Connection is closed");
						System.exit(0);
					}
					out.flush();
					System.out.print((char) i);
					tmp++;
				}
				tmp = 0;
			}
	}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
