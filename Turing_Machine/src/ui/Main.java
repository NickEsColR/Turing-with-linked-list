package ui;

import java.io.IOException;


import model.*;

public class Main {
	
	public static String PATH_READ = "data"+ System.getProperty("file.separator") +"input.txt"; 
	
	
	public static void main(String[] args){
		Turing machine = new Turing();
		
		try {
			machine.readText(PATH_READ);
		}catch(IOException e) {
			System.out.println("an error ocurred\n "+ e.getMessage());
		}
		
	}
}
