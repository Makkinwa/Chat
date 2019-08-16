package System;

import java.util.Scanner;
import System.*;
public class ServerLauncher {

	public static void main(String[] args) {
		System.out.println("Start Server");
		Scanner sc = new Scanner(System.in);
		System.out.println("Write your port");
		int port = sc.nextInt();
		System.out.println("Write your username (no spaces)");
		String username = sc.next();
		Server server = new Server(port, username);
		
	}

}