package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import model.*;

public class Main {
	
	public static String PATH_READ = "data/input.text"; 
	public static String PATH_OUT = "data/output.text";
	
	public static void main(String[] args) throws IOException {
		Turing machine = new Turing();
		BufferedReader br = new BufferedReader(new FileReader(PATH_READ));
		BufferedWriter bw = new BufferedWriter(new FileWriter(PATH_OUT));
		String line = br.readLine();
		while(line != null) {
			int i = 0;
			while( i < line.length()) {
				int head = Character.getNumericValue(line.charAt(i));
				i++;
				int operation =  Character.getNumericValue(line.charAt(i));
				i++;
				switch(operation) {
				case 0:
					bw.write(machine.readStrip(head));
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
			line = br.readLine();
			machine.cleanAll();
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
