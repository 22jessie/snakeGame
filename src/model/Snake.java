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
	
	
	public Snake(Point startingPosition,SlitheryArea area,Slitherable slitherable){
		body=new ArrayList<Point>();
		prevTail=tail=head=new Point(startingPosition);
		body.add(head);
		alive=true;
		this.area=area;
		this.slitherable=slitherable;
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
				sleep(1000);
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


	public void splitInHalf() {
		int size;
		int half;
		size=body.size();
		
		if(size>=2) {
			half=size/2;
			for(int i=0; i<half;i++) {
				body.remove(--size);
			}
			slitherable.splitSnakeInHalf();
		}else {
			die();
		}
	}


	public void kill() {
		die();
		slitherable.killSnake();
	}

}
