package model.board_elements;

import model.snake.Snake;

class Apple extends BoardElement{

	public Apple(Snake s) {
		super(s);
	
	}

	@Override
	public void slitheOn() {
		snake.grow();
		
	}

	@Override
	public String getImagePath() {
		return "resources/apple.png";
	}

}
