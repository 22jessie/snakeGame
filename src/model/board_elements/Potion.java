package model.board_elements;

import model.SlitheryArea;
import model.Snake;

public class Potion extends BoardElement {
	private SlitheryArea slitheryArea;
	

	public Potion(Snake snake, SlitheryArea slitheryArea) {
		super(snake);
		this.slitheryArea=slitheryArea;
	}

	@Override
	public void slitheOn() {
		slitheryArea.removeFire();
	}

	@Override
	public String getImagePath() {
		return "resources/potion.png";
	}

}
