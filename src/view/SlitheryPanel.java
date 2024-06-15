package view;

import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.Point;
import model.Slitherable;
import model.board_elements.BoardElement;

public class SlitheryPanel extends JPanel implements Slitherable{

	private static final long serialVersionUID = 1L;
	
	private int width;
	private int height;	
	private JButton buttons[];
	private ImageIcon cellIcon;
	private ImageIcon snakeBodyIcon;
	

	public SlitheryPanel(int width, int height) {
		
		this.width=width;
		this.height=height;
		cellIcon=new ImageIcon("resources/cell.png");
		snakeBodyIcon=new ImageIcon("resources/snakeBody.png");
		setLayout(new GridLayout(width,height));
		createSlitheryBoard();
	}

	private void createSlitheryBoard() {
		JButton b;
		
		buttons=new JButton[width*height];
		for(int i=0; i < width; i++) {
			for(int j=0; j < height; j++) {
				b=new JButton();
				b.setIcon(cellIcon);
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
		buttons[p.getX()*width+p.getY()].setIcon(snakeBodyIcon);
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
	public void killSnake() {
		
		
	}

	@Override
	public void clearPoint(Point p) {
		buttons[p.getX()*width+p.getY()].setIcon(cellIcon);
		
	}

	@Override
	public void putBoardElement(Point pos,BoardElement element) {
		buttons[pos.getX()*width+pos.getY()].setIcon(getIcon(element.getImagePath()));
	}
	
	private Icon getIcon(String imagePath) {
		return new ImageIcon(imagePath);
	}

}
