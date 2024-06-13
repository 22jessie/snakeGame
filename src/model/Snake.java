package model;

import java.util.ArrayList;

public class Snake extends Thread {
	
	private boolean alive;
	private int dirX;
	private int dirY;
	private SlitheryArea area;
	private Slitherable slitherable;
	private ArrayList<Point> body;
	private Point head;
	private Point tail;
	
	
	Snake(Point startingPosition){
		body=new ArrayList<Point>();
		head=new Point(startingPosition);
		body.add(head);
	}
	

	public void run() {
		
		while(alive) {
			area.slitherOn(head);
			for(Point p : body) {
				p.setPosition(p.getX()+dirX,p.getY()+dirY);
				
			}
			slitherable.showSnakeHead(head);
			for(Point p : body) {
				slitherable.showSnakeBody(p);
			}
			slitherable.showSnakeTail(tail);
		}
	}
	

	public void moveUp() {
		dirY=-1;
	}

	public void moveLeft() {
		dirX=-1;
	}

	public void moveRight() {
		dirX=1;
	}

	public void moveDown() {
		dirY=1;
	}
	
	protected void eat() {
		
	}
	
	protected void die() {
		alive=false;
	}
	
	public void grow() {
		if(tail!=null) {
			
		}
		body.add(new Point(0,0));
	}


	public void changeColor() {
		slitherable.changeSnakeColor();
		
	}


	public void splitInHalf() {
		slitherable.splitSnakeInHalf();
		
	}


	public void kill() {
		die();
		slitherable.killSnake();
	}

}
