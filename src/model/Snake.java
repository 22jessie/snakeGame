package model;

import java.util.ArrayList;

import model.SlitheryArea.DeadSnakeException;

public class Snake extends Thread {
	
	private boolean alive;
	private int iDir;
	private int jDir;
	private SlitheryArea slitheryArea;
	private Slitherable slitherable;
	private ArrayList<SnakeFragment> body;
	private SnakeFragment head;
	private SnakeFragment tail;
	private int velocityMilliSeconds;
	
	public Snake(Point startingPosition,Slitherable slitherable){
		body=new ArrayList<SnakeFragment>();
		tail=head=new SnakeFragment(startingPosition);
		body.add(head);
		alive=true;
		velocityMilliSeconds=1400;
		this.slitherable=slitherable;
	}
	
	
	private void moveSnake() {
		int i,j;
		
		head.addUpCoordinates(iDir,jDir);
		for(i=1,j=body.size(); i <j; i++ ) {
			body.get(i).moveTo(body.get(i-1).getPreviousPosition());
		}
	}
	
	private void showSnake() {
		Point previousTailPosition;
		
		slitherable.showSnakeHead(head.getPosition());
		for(SnakeFragment f : body) {
			slitherable.showSnakeBody(f.getPosition());
		}
		slitherable.showSnakeTail(tail.getPosition());
		previousTailPosition=tail.getPreviousPosition();
		if(previousTailPosition!=null) {
			slitherable.clearPoint(previousTailPosition);
		}
	}
	
	public synchronized void grow() {
		SnakeFragment f=new SnakeFragment(tail.getPreviousPosition());
		body.add(f);
		tail=f;
	}

	public void run() {
		try {
			sleep(1300);
			moveRight();
			while(alive) {
				synchronized (this) {
					Point p = new Point(head.getPosition());
					slitheryArea.slitherOn(new Point(p.getX()+iDir,p.getY()+jDir));
					moveSnake();
					showSnake();
				}
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

	public void changeColor() {
		slitherable.changeSnakeColor();
	}

	public void kill() {
		die();
		slitherable.killSnake();
	}

	public void doubleSpeed() {
		velocityMilliSeconds/=2;
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


	public void setSlitheryArea(SlitheryArea a) {
		slitheryArea=a;
		
	}
	

}
