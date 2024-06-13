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
	
	
	public SlitheryArea(Snake snake, int rows, int columns) {
		this.rows=rows;
		this.columns=columns;
		this.snake=snake;
		cellsWithElements=new HashMap<Point, String>();

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
	
	
	void slitherOn(Point p) {
		String val;
		if(cellsWithElements.containsKey(p)) {
			val=cellsWithElements.get(p);
			switch(val) {
			case "APPLE": 		snake.grow();			break;
			case "STRAWBERRY":	snake.changeColor();	break;
			case "BOMB":		snake.kill();			break;
			case "FIRE":		snake.splitInHalf();	break;
			}
		}
	}	
}
