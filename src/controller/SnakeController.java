package controller;

import model.Point;
import model.SlitheryArea;
import model.Snake;
import view.SnakeWindow;
import model.Constants;

public class SnakeController implements Constants{
	
	private SlitheryArea slitheryArea;
	private Snake snake;
	private SnakeWindow snakeWindow;

	
	
	public SnakeController() {
		
		snakeWindow=new SnakeWindow(this);
		snake=new Snake(new Point(BOARD_ROWS/2,BOARD_COL/2), snakeWindow);
		slitheryArea=new SlitheryArea(BOARD_ROWS, BOARD_COL,snake);
		snake.setSlitheryArea(slitheryArea);
		slitheryArea.setSnake(snake);
		slitheryArea.setSlitherable(snakeWindow);
		snake.start();
	}

	public void moveSnakeUp() {
		snake.moveUp();
		
	}

	public void moveSnakeDown() {
		snake.moveDown();
		
	}

	public void moveSnakeRight() {
		snake.moveRight();
		
	}

	public void moveSnakeLeft() {
		snake.moveLeft();
		
	}

}
