package ht;

import java.io.*;
import java.net.*;

public class SaveClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket s = new Socket("localhost", 1996);
		String szoveg = "Lorem Ipsum.";
		System.out.println("A t�roland� sz�veg: "+szoveg);
		
		PrintWriter pw = new PrintWriter(s.getOutputStream());
		pw.print(szoveg);
		pw.flush();
		pw.close();
		s.close();

	}

}
