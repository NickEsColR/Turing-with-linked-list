package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Turing {
	public static String PATH_OUT = "data"+ System.getProperty(File.separator) +"output.txt";
	private int size;
	private Strip c0;
	private Strip c1;
	private Strip c2;
	
	public Turing() {
		size = 0;
	}
	
	public void cleanAll() {
		c0 = null;
		c1 = null;
		c2 = null;
		size = 0;
	}
	
	public char readStrip(int c) {
		char r = ' ';
		if(c0 != null) {
			switch(c) {
			case 0:
				r = c0.getLetter();
			break;
			case 1:
				r = c1.getLetter();
			break;
			case 2:
				r = c2.getLetter();
			break;
			}
		}
		return r;
	}
	
	public void addStrip(Strip n, int c) {
		if(size == 0) {
			c0 = n;
			c1 = n;
			c2 = n;
			size++;
		}else {
			Strip temp = null;
			size++;
			switch(c) {
			case 0:
				temp = c0;
				c0 = n;
				c0.setNext(temp);
				if(size == 2) {
					c1 = c0.getNext();
					c2 = c0.getNext();
				}else if(size % 2 == 0 || size == 3) {
					c1 = beforeMid();
				}
			break;
			case 1:
				temp = c1;
				beforeMid().setNext(n);
				c1 = n;
				c1.setNext(temp);
				if(size == 2) {
					c0 = n;
					c1 = c1.getNext();
				}else if(size % 2 != 0 && size != 3) {
					c1 = c1.getNext();
				}
			break;
			case 2:
				c2.setNext(n);
				c2 = c2.getNext();
				if(size == 2) {
					c1 = c1.getNext();
				}else if(size % 2 != 0 && size != 3) {
					c1 = c1.getNext();
				}
			break;
			}
		}
		
		
	}
	
	public void removeStrip(int c) {
		Strip temp = null;
		size--;
		if(size != 0) {
			switch(c) {
			case 0:
				c0 = c0.getNext();
				if((size % 2 != 0 && size != 1) || size == 2) {
					c1 = c1.getNext();
				}
			break;
			case 1:
				
				temp = beforeMid();
				if(temp != null) {
					temp.setNext(c1.getNext());
					c1 = temp;
					if((size % 2 != 0 && size != 1) || size == 2) {
						c1 = c1.getNext();
					}
				}
			break;
			case 2:
				temp = c0;
				while(temp.getNext() != c2) {
					temp = temp.getNext();
				}
				c2 = temp;
				if((size % 2 == 0 && size != 2 )|| size == 1) {
					c1 = beforeMid();
				}
			break;
			}
		}else {
			c0 = null;
			c1 = null;
			c2 = null;
		}
	}
	
	private Strip beforeMid() {
		Strip before = c0;
		if(before != null) {
			while(before.getNext() != c1 ) {
				before = before.getNext();
			}
		}
		return before;
	}
	
	public void readText(String input) throws IOException  { 
		BufferedReader br = new BufferedReader(new FileReader(input));
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
					bw.write(readStrip(head));
				break;
				case 1:
					char l = line.charAt(i);
					i++;
					addStrip(new Strip(l), head);
				break;
				case 2:
					removeStrip(head);
				break;
				}
			}
			line = br.readLine();
			cleanAll();
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
