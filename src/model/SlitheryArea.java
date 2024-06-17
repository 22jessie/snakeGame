package model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import model.board_elements.BoardElement;
import model.board_elements.Bomb;
import model.board_elements.BoardElementFactory;

public class SlitheryArea {
	
	private final static int MAX_ELEMENTS_IN_BOARD=1;
	
	private int rows;
	private int columns;
	private Map<Point,BoardElement> cellsWithElements;
	private Snake snake;
	private Slitherable slitherable;
	private BoardElementFactory boardElementsFact;
	
	public SlitheryArea(int rows, int columns,Snake snake) {
		this.rows=rows;
		this.columns=columns;
		cellsWithElements=new ConcurrentHashMap<Point, BoardElement>();
		(new ElementGenerator()).start();
		boardElementsFact=new BoardElementFactory(snake,this);

	}
	
	public void setSlitherable(Slitherable s) {
		slitherable=s;
	}
	
	public void setSnake(Snake s) {
		snake=s;
	}
	
	
	
	
	void slitherOn(Point p) throws DeadSnakeException{
		if(p.getX()>=0 && p.getX()<rows && p.getY()>=0 && p.getY()<columns) {
			if(cellsWithElements.containsKey(p)) {
				cellsWithElements.get(p).slitheOn();
				removePoint(p);
			}
		}else {
			snake.kill();
			throw new DeadSnakeException("The Snake has crossed the board's limit");
		}
	}	
	
	private void removePoint(Point p) {
		cellsWithElements.remove(p);
	}
	
	
	public class ElementGenerator extends Thread {
		
		

		public void run() {
			try {
				sleep(2000);
				while(true) {
					if(cellsWithElements.size()<MAX_ELEMENTS_IN_BOARD || bombsInBoard() >= MAX_ELEMENTS_IN_BOARD) {
						generateRandomElement();
					}
					sleep(10000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		public void generateRandomElement() {
			Random rand;
			Point x;
			BoardElement element;
			
			rand=new Random();
			x= new Point(rand.nextInt(rows),rand.nextInt(columns));
			
			element=boardElementsFact.createRandomElement();
			cellsWithElements.put(x,element);
			slitherable.putBoardElement(x,element);
			
		}
	}

	
	public class DeadSnakeException extends RuntimeException{
		public DeadSnakeException(String m) {
			super(m);
		}

		private static final long serialVersionUID = 1L;
	}

	private int bombsInBoard() {
		int n;
		n=0;
		for(BoardElement e : cellsWithElements.values()) {
			if(e instanceof Bomb) {
				n++;
			}
		}
		return n;
	}
	
	public void removeFire() {
		Entry<Point,BoardElement> entry;
		
		
		for(Iterator<Entry<Point, BoardElement>> i=cellsWithElements.entrySet().iterator();i.hasNext();) {
			entry=i.next();
			if(entry.getValue() instanceof Bomb) {
				slitherable.clearPoint(entry.getKey());
				cellsWithElements.remove(entry.getKey());
			}
		}
		
	}
}
