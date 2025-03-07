package view;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JFrame;

import controller.SnakeController;
import model.Point;
import model.Slitherable;
import model.board_elements.BoardElement;
import model.Constants;


public class SnakeWindow extends JFrame implements Constants,Slitherable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static int WINDOW_WIDTH_PX=BOARD_COLS*30;
	public static int WINDOW_HEIGHT_PX=BOARD_ROWS*30;

	
	
	
	private SlitheryPanel panel;
	private SnakeController control;
	
	
	public SnakeWindow(SnakeController control) {
		
		this.control=control;
		panel=new SlitheryPanel(BOARD_ROWS,BOARD_COLS);
		add(panel);
		setSize(WINDOW_WIDTH_PX,WINDOW_HEIGHT_PX);
		setTitle(GAME_NAME);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		configureKeyListener();
		setFocusable(true);
		setVisible(true);
	}


	private void configureKeyListener() {
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {
				KeyboardManagerThread t;
				t=new KeyboardManagerThread(control);
				t.setDirection(e.getKeyCode());
				t.start();
			}
		});
		
	}



	@Override
	public void showSnakeHead(Point head) {
		panel.showSnakeHead(head);
	}


	@Override
	public void showSnakeBody(Point p) {
		panel.showSnakeBody(p);
	}


	@Override
	public void showSnakeTail(Point tail) {
		panel.showSnakeTail(tail);
	}

	@Override
	public void clearCell(Point prevTail) {
		panel.clearPoint(prevTail);
	}


	@Override
	public void putElementInCell(Point x, BoardElement element) {
		panel.putBoardElement(x, element);
	}


	@Override
	public void changeCellColor(Point p, String colorHex) {
		panel.changeSnakeColor(p,Color.decode(colorHex));
		
	}


	@Override
	public void clearElementInCell(Point p) {
		panel.clearElement(p);
		
	}


	@Override
	public void setSnakeColor(String colorHex) {
		panel.setSnakeColor(colorHex);
		
	}
	
}
