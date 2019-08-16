package System;

import System.Client;

public class ClientLauncher {
	public static void main(String[] args) {
		System.out.println("Start Client");
		//Scanner sc = new Scanner(System.in);
		System.out.println("Write your port!");
		//int port = sc.nextInt();
		System.out.println("Write yout username");
		//String username = sc.next();
		System.out.println("Write host ip");
		//String host = sc.next();
		//Client client = new Client(port, username, host);
		Client client = new Client(1077, "mak", "192.168.0.106");
	}
}
