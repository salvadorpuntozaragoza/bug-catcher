package controllers;

public class Bug extends Character{
	
	
	public Bug(int x, int y, int xspeed, int yspeed, int height, int width) {
		super(x, y, xspeed, yspeed, width, height);
	}
	
	public void update() {
		y += yspeed;
	}

}
