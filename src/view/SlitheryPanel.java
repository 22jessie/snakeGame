package view;

import java.awt.GridLayout;

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
	
	private Icon snakeBody;
	private Icon normalCell;
	
	
	public SlitheryPanel(int width, int height) {
		this.width=width;
		this.height=height;
		setLayout(new GridLayout(width,height));
		loadSnakeImages();
		createSlitheryBoard();
	}
	
	private void loadSnakeImages() {
		snakeBody=new ImageIcon("resources/snakeBody.png");
		normalCell=new ImageIcon("resources/cell.png");
		
	}

	private void createSlitheryBoard() {
		JButton b;
		
		buttons=new JButton[width*height];
		for(int i=0; i < width; i++) {
			for(int j=0; j < height; j++) {
				b=new JButton();
				b.setIcon(normalCell);
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
		buttons[p.getX()*width+p.getY()].setIcon(snakeBody);
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
	public void splitSnakeInHalf() {
		
	}


	@Override
	public void killSnake() {
		
		
	}

	@Override
	public void clearPoint(Point p) {
		buttons[p.getX()*width+p.getY()].setIcon(normalCell);
		
	}

}
