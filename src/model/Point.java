package model;

public class Point {
	int x;
	int y;

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
	
	public boolean equals(Point p2) {
		return p2.getX()==x && p2.getY()==y;
	}
	
	public String toString() {
		return "["+x+","+y+"]";
	}

}
