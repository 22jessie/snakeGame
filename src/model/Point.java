package model;

public class Point {
	private int x;
	private int y;

	public Point(Point p) {
		x=p.getX();
		y=p.getY();
	}

	public Point(int i, int j) {
		setPosition(i,j);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setPosition(int i, int j) {
		x=i;
		y=j;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Point) {
			Point p2=(Point)o;
			return p2.getX()==x && p2.getY()==y;
		}
		return false;
		
		
	}
	
	@Override
	public int hashCode() {
	    return toString().hashCode();
	}
	
	public String toString() {
		return "["+x+","+y+"]";
	}

}
