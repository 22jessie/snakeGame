package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import model.board_elements.BoardElement;
import model.board_elements.BoardElementFactory;

public class SlitheryArea {
	
	private final static int MAX_ELEMENTS_IN_BOARD=2;
	
	private int rows;
	private int columns;
	private Map<Point,BoardElement> cellsWithElements;
	private Snake snake;
	private Slitherable slitherable;
	private BoardElementFactory boardElementsFact;
	
	public SlitheryArea(int rows, int columns,Snake snake) {
		this.rows=rows;
		this.columns=columns;
		cellsWithElements=new HashMap<Point, BoardElement>();
		(new ElementGenerator()).start();
		boardElementsFact=new BoardElementFactory(snake);

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
					if(cellsWithElements.size()<MAX_ELEMENTS_IN_BOARD) {
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
}
