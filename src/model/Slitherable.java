package model;

import model.board_elements.BoardElement;

public interface Slitherable {
	void showSnakeHead(Point head);

	void showSnakeBody(Point p);

	void showSnakeTail(Point tail);

	void changeSnakeColor(Point p, String colorAsHex);

	void clearPoint(Point prevTail);

	void putBoardElement(Point x, BoardElement element);

	void clearElement(Point p);
	
	void setSnakeColor(String colorHex);
}
