package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JFrame;


public class SnakeWindow extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static int WIDTH=1000;
	public static int HEIGHT=670;
	
	
	public SnakeWindow() {
		setSize(WIDTH,HEIGHT);
		setLocation(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		configureKeyListener();
		add(new SlitheryPanel());
	}


	private void configureKeyListener() {
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {
				KeyboardManagerThread t;
				
				t=new KeyboardManagerThread();
				t.setDirection(e.getKeyCode());
				t.start();
			}
		});
		
	}
	
}
