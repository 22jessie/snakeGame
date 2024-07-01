package view;

import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.Point;
import model.board_elements.BoardElement;

public class SlitheryPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private int rows;
	private int columns;	
	private JButton buttons[];
	private ImageIcon cellIcon;
	private ImageIcon snakeBodyIcon;
	

	public SlitheryPanel(int width, int height) {
		
		this.rows=width;
		this.columns=height;
		cellIcon=new ImageIcon("resources/cell.png");
		snakeBodyIcon=new ImageIcon("resources/snakeBody.png");
		setLayout(new GridLayout(width,height));
		createSlitheryBoard();
	}

	private void createSlitheryBoard() {
		JButton b;
		
		buttons=new JButton[rows*columns];
		for(int i=0; i < rows; i++) {
			for(int j=0; j < columns; j++) {
				b=new JButton();
				b.setIcon(cellIcon);
				buttons[i*columns+j]=b;
				add(b);
			}
		}
	}



	public void showSnakeHead(Point p) {
		showSnakeBody(p);
	}


	public void showSnakeBody(Point p) {
		buttons[p.getX()*columns+p.getY()].setIcon(snakeBodyIcon);
	}


	public void showSnakeTail(Point p) {
		showSnakeBody(p);
	}


	public void changeSnakeColor() {
		//
	}


	public void killSnake() {
		
		
	}

	public void clearPoint(Point p) {
		buttons[p.getX()*columns+p.getY()].setIcon(cellIcon);
		
	}

	public void putBoardElement(Point pos,BoardElement element) {
		buttons[pos.getX()*columns+pos.getY()].setIcon(getIcon(element.getImagePath()));
	}
	
	private Icon getIcon(String imagePath) {
		return new ImageIcon(imagePath);
	}

}
