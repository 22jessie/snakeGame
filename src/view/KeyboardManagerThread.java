package view;

import java.awt.event.KeyEvent;

import controller.SnakeController;
import model.SnakeMotionManagerThread;

public class KeyboardManagerThread extends SnakeMotionManagerThread{
	private int keyCode;
	private SnakeController controller;
	

	
	
	public KeyboardManagerThread(SnakeController controller) {
		this.controller=controller;
	}

	@Override
	public void run() {
		switch( keyCode ) { 
		case KeyEvent.VK_UP:	controller.moveSnakeUp();		break;
		case KeyEvent.VK_DOWN:	controller.moveSnakeDown();		break;	
		case KeyEvent.VK_LEFT:	controller.moveSnakeLeft();	 	break;
		case KeyEvent.VK_RIGHT:	controller.moveSnakeRight();	break;
		default: ;
		}

	}

	public void setDirection(int keyCode) {
		this.keyCode=keyCode;
	}

}
