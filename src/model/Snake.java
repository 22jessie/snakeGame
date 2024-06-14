package model;

import java.util.ArrayList;

import model.SlitheryArea.DeadSnakeException;

public class Snake extends Thread {
	
	private boolean alive;
	private int iDir;
	private int jDir;
	private SlitheryArea area;
	private Slitherable slitherable;
	private ArrayList<Point> body;
	private Point head;
	private Point tail;
	private Point prevTail;
	private int velocityMilliSeconds;
	
	public Snake(Point startingPosition,SlitheryArea area,Slitherable slitherable){
		body=new ArrayList<Point>();
		prevTail=tail=head=new Point(startingPosition);
		body.add(head);
		alive=true;
		this.area=area;
		this.slitherable=slitherable;
		velocityMilliSeconds=1400;
	}

	public void run() {
		try {
			sleep(1300);
			moveRight();
			while(alive) {
				prevTail=new Point(tail);
				synchronized (this) {
					area.slitherOn(new Point(head.getX()+iDir,head.getY()+jDir));
					for(Point p : body) {
						p.setPosition(p.getX()+iDir,p.getY()+jDir);
					}
				}
				showSnake();
				sleep(velocityMilliSeconds);
			}
		}catch(DeadSnakeException e) {
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			System.out.println("Game Over!");
		}
	}
	
	private void showSnake() {
		slitherable.showSnakeHead(head);
		for(Point p : body) {
			slitherable.showSnakeBody(p);
		}
		slitherable.showSnakeTail(tail);
		slitherable.clearPoint(prevTail);
	}
	
	public synchronized void moveUp() {
		iDir=-1;
		jDir=0;
	}

	public synchronized void moveLeft() {
		jDir=-1;
		iDir=0;
	}

	public synchronized void moveRight() {
		jDir=1;
		iDir=0;
		
	}

	public synchronized void moveDown() {
		iDir=1;
		jDir=0;
	}
	
	protected void die() {
		alive=false;
	}
	
	public void grow() {
		tail=new Point(prevTail);
		body.add(tail);
	}

	public void changeColor() {
		slitherable.changeSnakeColor();
	}

	public void kill() {
		die();
		slitherable.killSnake();
	}

	public void doubleSpeed() {
		velocityMilliSeconds/=2;
		slitherable.doubleSpeed();
		(new TimerThreadForVelocity()).start();
	}
	
	private class TimerThreadForVelocity extends Thread{
		
		public void run() {
			try {
				sleep(30000);
				velocityMilliSeconds*=2;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	

}
