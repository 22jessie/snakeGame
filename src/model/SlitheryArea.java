package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SlitheryArea {
	
	private final static int MAX_ELEMENTS_IN_BOARD=5;
	
	private int rows;
	private int columns;
	private Map<Point,String> cellsWithElements;
	private Snake snake;
	private Slitherable slitherable;
	
	private static final String GAME_ELEMENTS[]= {"APPLE","STRAWBERRY","BOMB","FIRE"};
	
	
	public SlitheryArea(int rows, int columns) {
		this.rows=rows;
		this.columns=columns;
		cellsWithElements=new HashMap<Point, String>();
		(new ElementGenerator()).start();

	}
	
	public void setSlitherable(Slitherable s) {
		slitherable=s;
	}
	
	public void setSnake(Snake s) {
		snake=s;
	}
	
	
	
	
	void slitherOn(Point p) throws DeadSnakeException{
		String val;
		
		if(p.getX()>=0 && p.getX()<rows && p.getY()>=0 && p.getY()<columns) {
			if(cellsWithElements.containsKey(p)) {
				val=cellsWithElements.get(p);
				cellsWithElements.remove(p);
				switch(val) {
				case "APPLE": 		snake.grow();			break;
				case "STRAWBERRY":	snake.changeColor();	break;
				case "BOMB":		snake.kill();			break;
				case "FIRE":		snake.splitInHalf();	break;
				}
			}
			
		}else {
			snake.kill();
			throw new DeadSnakeException("The Snake has crossed the board's limit");
		}
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
			int newElement;
			int r;
			int c;
			
			rand=new Random();
			newElement=rand.nextInt(GAME_ELEMENTS.length);
			r=rand.nextInt(rows);
			c=rand.nextInt(columns);
			cellsWithElements.put(new Point(r,c), GAME_ELEMENTS[newElement]);
			switch(GAME_ELEMENTS[newElement]) {
			case "APPLE": 		slitherable.putApple(r,c);			break;
			case "STRAWBERRY":	slitherable.putStrawberry(r,c);		break;
			case "BOMB":		slitherable.putBomb(r,c);			break;
			case "FIRE":		slitherable.putFire(r,c);			break;
			}
		}
	}

	
	public class DeadSnakeException extends RuntimeException{
		public DeadSnakeException(String m) {
			super(m);
		}

		private static final long serialVersionUID = 1L;
	}
}
