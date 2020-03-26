package model;

public class Strip {
	
	//attributes
	
	private char letter;
	
	//relations
	
	private Strip next;
	
	//methods
	
	public Strip(char l) {
		letter = l;
	}
	
	public char getLetter() {
		return letter;
	}
	
	public void setNext(Strip n) {
		next = n;
	}
	
	public Strip getNext() {
		return next;
	}
}
