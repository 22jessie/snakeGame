package model;

public class SnakeFragment{
	private Point position;
	private Point previousPosition;
	
	
	public SnakeFragment(Point position) {
		this.position=new Point(position);
	}
	
	public Point getPreviousPosition() {
		return previousPosition;
	}

	public void addUpCoordinates(int iDir, int jDir) {
		previousPosition=new Point(position);
		position.setPosition(position.getX()+iDir, position.getY()+jDir);
	}

	public Point getPosition() {
		return position;
	}

	public void moveTo(Point p) {
		if(previousPosition!=null) {
			previousPosition.setPosition(position.getX(), position.getY());
		}else {
			previousPosition=new Point(position);
		}
		position.setPosition(p.getX(),p.getY());
		
	}

}
