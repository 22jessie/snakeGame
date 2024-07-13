package model;

import model.board_elements.BoardElement;

public interface Slitherable {
	void showSnakeHead(Point head);

	void showSnakeBody(Point p);

	void showSnakeTail(Point tail);

	void changeCellColor(Point p, String colorAsHex);

	void clearCell(Point prevTail);

	void putElementInCell(Point x, BoardElement element);

	void clearElementInCell(Point p);
	
	void setSnakeColor(String colorHex);
}
