package model;

public interface Slitherable {
	abstract void showSnakeHead(Point head);

	abstract void showSnakeBody(Point p);

	abstract void showSnakeTail(Point tail);

	abstract void changeSnakeColor();

	abstract void splitSnakeInHalf();

	abstract void killSnake();

	abstract void clearPoint(Point prevTail);
}
