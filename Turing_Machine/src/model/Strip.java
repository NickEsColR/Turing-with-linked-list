package model;

public class Strip {
	private char letter;
	private Strip next;
	
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
