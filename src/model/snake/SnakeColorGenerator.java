package model.snake;

import java.util.Random;

public class SnakeColorGenerator{
	
	public enum SnakeColor {
		ORANGE,YELLOW,GREEN,BLUE,PURPLE;
	}
	
	private static final SnakeColor[] colors=SnakeColor.values();
	
	private static final int NUM_COLORS=colors.length;

	public static String generateRandomColorAsHex() {
		Random rand=new Random();
		SnakeColor color;
	
		color=colors[rand.nextInt(NUM_COLORS)];
		
		switch(color) {
		case BLUE:	return "#1982c4";
		case GREEN:	return "#8ac926";
		case ORANGE:return "#ff595e";
		case PURPLE:return "#6a4c93";
		case YELLOW:return "#ffca3a";
		default:	return "#f15bb5";
		}
	}

	public static String getInitialColor() {
		return "#8ac926";
	}
	
}
