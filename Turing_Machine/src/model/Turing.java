package model;

public class Turing {
	private int size;
	private Strip c0;
	private Strip c1;
	private Strip c2;
	
	public Turing() {
		size = 0;
	}
	
	public void setC0(Strip n) {
		c0 = n;
	}
	
	public void setC1(Strip n) {
		c1 = n;
	}
	
	public void setC2(Strip n) {
		c2 = n;
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
		}else {
			Strip temp = null;
			switch(c) {
			case 0:
				temp = c0;
				c0 = n;
				c0.setNext(temp);
			break;
			case 1:
				temp = c1;
				c1 = n;
				c1.setNext(temp);
			break;
			case 2:
				c2.setNext(n);
				c2 = c2.getNext();
			break;
			}
		}
		size++;
		
	}
	
	public void removeStrip(int c) {
		Strip temp = null;
		switch(c) {
		case 0:
			c0.setNext(c0.getNext());
		break;
		case 1:
			temp = c0;
			while(temp.getNext() != c1) {
				temp = temp.getNext();
			}
			c1 = temp;
			c1.setNext(temp.getNext().getNext());
		break;
		case 2:
			temp = c1;
			while(temp.getNext() != c2) {
				temp = temp.getNext();
			}
			c2 = temp;
		break;
		}
		size-=1;
	}
	
	public void findMid() {
		if(size != 0) {
			
		}
	}
}
