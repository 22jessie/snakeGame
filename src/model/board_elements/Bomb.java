package model.board_elements;

import model.snake.Snake;

public class Bomb extends BoardElement {

	public Bomb(Snake s) {
		super(s);
	}

	@Override
	public void slitheOn() {
		snake.kill();
		
	}

	@Override
	public String getImagePath() {
		return "resources/bomb.png";
	}

}
