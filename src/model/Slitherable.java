package model;

import model.board_elements.BoardElement;

public interface Slitherable {
	abstract void showSnakeHead(Point head);

	abstract void showSnakeBody(Point p);

	abstract void showSnakeTail(Point tail);

	abstract void changeSnakeColor();

	abstract void killSnake();

	abstract void clearPoint(Point prevTail);

	abstract void putBoardElement(Point x, BoardElement element);
}
