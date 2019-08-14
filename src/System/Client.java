package System;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	

	public static void main(String[] args) throws InterruptedException, UnknownHostException, IOException {
		final byte[] end = {10, 2};
		String username;
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Write your username (no spaces)");
			username = sc.next();
			System.out.println("\n");
			System.out.println("Write Server's IP");
			//String name = sc.next();
			System.out.println("Write port");
			//int port = sc.nextInt();

			System.out.println("Done");
			Socket s = new Socket("192.168.0.106", 1077);
			
			OutputStream out = s.getOutputStream();
			InputStream input = s.getInputStream();
			Runnable outThread = new Runnable() {
				@Override
				public void run() {
					String mail;
						try {
							while(true) {
							//	System.out.print(username + ": ");
								if(sc.hasNext()) {
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
					/*if(input.available() > 0) {
						System.out.print("***");
						System.out.println("\n");
					}*/
					while((i = input.read()) != 2) {
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
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("\n");
	}

}