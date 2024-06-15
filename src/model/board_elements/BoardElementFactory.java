package model.board_elements;

import java.util.Random;

import model.Snake;

public class BoardElementFactory {
	private Snake snake;
	
	public BoardElementFactory(Snake s) {
		snake=s;
	}
	

	public BoardElement createRandomElement() {
		int rand;
		
		rand=(new Random()).nextInt(4);
		switch(rand) {
		case 0: return new Apple(snake);	
		case 1: return new Bomb(snake);
		case 2: return new Fire(snake);
		case 3: return new Strawberry(snake);
		default: return new Apple(snake);
		}
		
	}

}
