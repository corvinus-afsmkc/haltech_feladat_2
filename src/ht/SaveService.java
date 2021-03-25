package ht;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.text.SimpleDateFormat;

public class SaveService implements Runnable{
	private Socket s;
	
	public SaveService(Socket s) {
		this.s = s;
	}
	
	@Override
	public void run() {
		BufferedReader bf;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		Date d = new Date();
		try {
			bf = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String be = bf.readLine();
			
			PrintWriter output = new PrintWriter(new FileWriter("log.txt", true));
			output.println(formatter.format(d)+": "+be);
			output.flush();
			output.close();
			bf.close();
			
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	
		try {
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
