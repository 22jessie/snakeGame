package view;

import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.Point;
import model.Slitherable;

public class SlitheryPanel extends JPanel implements Slitherable{

	private static final long serialVersionUID = 1L;
	
	private int width;
	private int height;
	
	private JButton buttons[];
	
	
	private Map<String,Icon> icons;
	private static final String[] iconsFilenames= {"resources/snakeBody.png","resources/cell.png","resources/fire.png"
			,"resources/bomb.png","resources/strawberry.png","resources/apple.png"};
	private final String ELEMENTS[]={
		"SNAKE_BODY","CELL","FIRE","BOMB","STRAWBERRY","APPLE"
	};
	
	 

	
	public SlitheryPanel(int width, int height) {
		
		this.width=width;
		this.height=height;
		setLayout(new GridLayout(width,height));
		loadImages();
		createSlitheryBoard();
	}
	
	private void loadImages() {
		icons=new HashMap<String, Icon>();	
		for(int i=0; i < iconsFilenames.length; i++) {
			icons.put(ELEMENTS[i], new ImageIcon(iconsFilenames[i]));
		}
	}

	private void createSlitheryBoard() {
		JButton b;
		
		buttons=new JButton[width*height];
		for(int i=0; i < width; i++) {
			for(int j=0; j < height; j++) {
				b=new JButton();
				b.setIcon(icons.get(ELEMENTS[1]));
				buttons[i*width+j]=b;
				add(b);
			}
		}
	}


	@Override
	public void showSnakeHead(Point p) {
		showSnakeBody(p);
	}


	@Override
	public void showSnakeBody(Point p) {
		buttons[p.getX()*width+p.getY()].setIcon(icons.get(ELEMENTS[0]));
	}


	@Override
	public void showSnakeTail(Point p) {
		showSnakeBody(p);
	}


	@Override
	public void changeSnakeColor() {
		//
	}


	@Override
	public void removeFire() {
		
	}


	@Override
	public void killSnake() {
		
		
	}

	@Override
	public void clearPoint(Point p) {
		buttons[p.getX()*width+p.getY()].setIcon(icons.get(ELEMENTS[1]));
		
	}

	@Override
	public void putApple(int r, int c) {
		buttons[r*width+c].setIcon(icons.get(ELEMENTS[5]));
		
	}

	@Override
	public void putStrawberry(int r, int c) {
		buttons[r*width+c].setIcon(icons.get(ELEMENTS[4]));
		
	}

	@Override
	public void putBomb(int r, int c) {
		buttons[r*width+c].setIcon(icons.get(ELEMENTS[3]));
		
	}

	@Override
	public void putFire(int r, int c) {
		buttons[r*width+c].setIcon(icons.get(ELEMENTS[2]));
		
				
	}

	@Override
	public void doubleSpeed() {
		
	}

}
