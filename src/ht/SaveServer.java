package ht;

import java.io.IOException;
import java.net.ServerSocket;

public class SaveServer {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(1996);
		
		while(true) {
			new Thread(new SaveService(ss.accept())).start();
			
			
		}
	}

}
