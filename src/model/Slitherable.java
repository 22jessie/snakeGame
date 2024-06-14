package model;

public interface Slitherable {
	abstract void showSnakeHead(Point head);

	abstract void showSnakeBody(Point p);

	abstract void showSnakeTail(Point tail);

	abstract void changeSnakeColor();

	abstract void splitSnakeInHalf();

	abstract void killSnake();

	abstract void clearPoint(Point prevTail);

	abstract void putApple(int r, int c);

	abstract void putStrawberry(int r, int c);

	abstract void putBomb(int r, int c);

	abstract void putFire(int r, int c);
}
