package model.board_elements;

import model.Snake;

public abstract class BoardElement {
	protected Snake snake;
	protected String imagePath;
	
	public BoardElement(Snake s) {
		snake=s;
	}
	
	public abstract void slitheOn();
	
	public abstract String getImagePath();

}
