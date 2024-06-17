package model.board_elements;

import java.util.Random;

import model.SlitheryArea;
import model.Snake;

public class BoardElementFactory {
	private Snake snake;
	private SlitheryArea slitheryArea;
	
	public BoardElementFactory(Snake snake,SlitheryArea slitheryArea) {
		this.snake=snake;
		this.slitheryArea=slitheryArea;
	}
	

	public BoardElement createRandomElement() {
		int rand;
		
		rand=(new Random()).nextInt(5);
		switch(rand) {
		case 0: return new Potion(snake,slitheryArea);
		case 1: return new Bomb(snake);
		case 2: return new Fire(snake);
		case 3: return new Apple(snake);
		case 4: return new Strawberry(snake);
		default: return new Apple(snake);
		}
		
	}

}
