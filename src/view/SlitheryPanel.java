package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.Point;
import model.board_elements.BoardElement;
import model.snake.SnakeColorGenerator;

public class SlitheryPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private int rows;
	private int columns;	
	private JButton buttons[];
	private final Color backgroundColor=Color.decode("#000000");
	private Color currentColor;
	

	public SlitheryPanel(int width, int height) {
		
		this.rows=width;
		this.columns=height;
		setLayout(new GridLayout(width,height));
		createSlitheryBoard();
		currentColor=Color.decode(SnakeColorGenerator.getInitialColor());
	}

	private void createSlitheryBoard() {
		JButton b;
		
		buttons=new JButton[rows*columns];
		for(int i=0; i < rows; i++) {
			for(int j=0; j < columns; j++) {
				b=new JButton();
				b.setBackground(backgroundColor);
				buttons[i*columns+j]=b;
				add(b);
			}
		}
	}



	public void showSnakeHead(Point p) {
		showSnakeBody(p);
	}


	public void showSnakeBody(Point p) {
		buttons[p.getX()*columns+p.getY()].setBackground(currentColor);
	}


	public void showSnakeTail(Point p) {
		showSnakeBody(p);
	}


	public void changeSnakeColor(Point p,Color color) {
		buttons[p.getX()*columns+p.getY()].setBackground(color);
	}
	
	public void setSnakeColor(String colorHex) {
		currentColor=Color.decode(colorHex);
	}
	public void clearPoint(Point p) {
		buttons[p.getX()*columns+p.getY()].setBackground(backgroundColor);
		
		
	}

	public void putBoardElement(Point pos,BoardElement element) {
		buttons[pos.getX()*columns+pos.getY()].setIcon(getIcon(element.getImagePath()));
	}
	
	private Icon getIcon(String imagePath) {
		return new ImageIcon(imagePath);
	}

	public void clearElement(Point p) {
		buttons[p.getX()*columns+p.getY()].setIcon(null);
		
	}

}
