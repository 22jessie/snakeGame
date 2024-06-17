package model.board_elements;

import model.Snake;

public class Fire extends BoardElement {

	public Fire(Snake s) {
		super(s);
	}

	@Override
	public void slitheOn() {
		snake.doubleSpeed();
		
	}

	@Override
	public String getImagePath() {
		return "resources/fire.png";
	}

}
