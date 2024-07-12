package model.board_elements;

import model.snake.Snake;

class Strawberry extends BoardElement {

	public Strawberry(Snake s) {
		super(s);
	}

	@Override
	public void slitheOn() {
		snake.changeColor();
	}

	@Override
	public String getImagePath() {
		return "resources/strawberry.png";
	}

}
