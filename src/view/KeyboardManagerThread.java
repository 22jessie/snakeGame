package view;

import java.awt.event.KeyEvent;

import model.Snake;
import model.SnakeMotionManagerThread;

public class KeyboardManagerThread extends SnakeMotionManagerThread{
	private int keyCode;
	private Snake snake;
	
	
	public KeyboardManagerThread(Snake snake) {
		this.snake=snake;
	}

	@Override
	public void run() {
		switch( keyCode ) { 
		case KeyEvent.VK_UP:	snake.moveUp();		break;
		case KeyEvent.VK_DOWN:	snake.moveDown();	break;	
		case KeyEvent.VK_LEFT:	snake.moveLeft();	break;
		case KeyEvent.VK_RIGHT:	snake.moveRight();	break;
		default: ;
		}

	}

	public void setDirection(int keyCode) {
		this.keyCode=keyCode;
	}

}
