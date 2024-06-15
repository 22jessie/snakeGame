package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JFrame;

import model.Snake;
import model.Point;
import model.SlitheryArea;


public class SnakeWindow extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static int WINDOW_WIDTH_PX=300;
	public static int WINDOW_HEIGHT_PX=300;
	
	public static int BOARD_ROWS=10;
	public static int BOARD_COL=10;
	
	
	private Snake snake;
	private SlitheryPanel panel;
	
	
	public SnakeWindow() {
		panel=new SlitheryPanel(BOARD_ROWS,BOARD_COL);
		add(panel);
		
		setSize(WINDOW_WIDTH_PX,WINDOW_HEIGHT_PX);
		setTitle("Snake Game :)");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		configureKeyListener();
		createGameElements();
		setFocusable(true);
		setVisible(true);
		
		
		
	}
	
	private void createGameElements() {
		SlitheryArea area;
		snake=new Snake(new Point(BOARD_ROWS/2,BOARD_COL/2), panel);
		area=new SlitheryArea(BOARD_ROWS, BOARD_COL,snake);
		snake.setSlitheryArea(area);
		area.setSnake(snake);
		area.setSlitherable(panel);
		snake.start();
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
				t=new KeyboardManagerThread(snake);
				t.setDirection(e.getKeyCode());
				t.start();
			}
		});
		
	}
	
}
