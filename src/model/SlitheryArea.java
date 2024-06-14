package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SlitheryArea {
	private int rows;
	private int columns;
	private Map<Point,String> cellsWithElements;
	private Snake snake;
	
	private static final String GAME_ELEMENTS[]= {"APPLE","STRAWBERRY","BOMB","FIRE"};
	
	
	public SlitheryArea(int rows, int columns) {
		this.rows=rows;
		this.columns=columns;
		cellsWithElements=new HashMap<Point, String>();

	}
	
	public void setSnake(Snake s) {
		snake=s;
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
	}
	
	
	void slitherOn(Point p) throws DeadSnakeException{
		String val;
		
		if(p.getX()>=0 && p.getX()<rows && p.getY()>=0 && p.getY()<columns) {
			if(cellsWithElements.containsKey(p)) {
				val=cellsWithElements.get(p);
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
	
	public class DeadSnakeException extends RuntimeException{
		public DeadSnakeException(String m) {
			super(m);
		}

		private static final long serialVersionUID = 1L;
		
		
		
	}
}
