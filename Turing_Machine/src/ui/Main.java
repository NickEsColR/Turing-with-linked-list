package ui;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import model.*;

public class Main {
	
	public static String PATH_READ = "data"+ System.getProperty(File.separator) +"input.txt"; 
	
	
	public static void main(String[] args){
		Turing machine = new Turing();
		/**
		try {
			machine.readText(PATH_READ);
		}catch(IOException e) {
			System.out.println("an error ocurred\n "+ e.getMessage());
		}
		*/
		Scanner board = new Scanner(System.in);
		String line = board.nextLine();
		while(line != null) {
			int i = 0;
			while( i < line.length()) {
				int head = Character.getNumericValue(line.charAt(i));
				i++;
				int operation =  Character.getNumericValue(line.charAt(i));
				i++;
				switch(operation) {
				case 0:
					System.out.println(machine.readStrip(head));
				break;
				case 1:
					char l = line.charAt(i);
					i++;
					machine.addStrip(new Strip(l), head);
				break;
				case 2:
					machine.removeStrip(head);
				break;
				}
			}
			line = board.nextLine();
			machine.cleanAll();
		}
		board.close();
	}
}
