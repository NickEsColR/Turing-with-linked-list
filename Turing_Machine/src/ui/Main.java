package ui;

import java.io.IOException;


import model.*;

public class Main {
	
	public static String PATH_READ = "data"+ System.getProperty("file.separator") +"input.txt"; 
	public static String PATH_BIG = "data"+ System.getProperty("file.separator") +"in_turing.txt"; 

	
	public static void main(String[] args){
		Turing machine = new Turing();
		long time = System.currentTimeMillis();
		try {
			machine.readText(PATH_BIG);
			time = System.currentTimeMillis() - time;
			System.out.println( String.valueOf(time));
		}catch(IOException e) {
			System.out.println("an error ocurred\n "+ e.getMessage());
			System.out.println(time -= System.currentTimeMillis());
		}
		
		
	}
	
}
