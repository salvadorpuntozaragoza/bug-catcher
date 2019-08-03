package controllers;

public class Pumba extends Character {
	
//	private boolean movingRight;
//	private boolean movingLeft;
	
	public Pumba(int x, int y, int xspeed, int yspeed, int height, int width) {
		super(x, y, xspeed, yspeed, width, height);
		loadSpritesheet("/Resourses/pumba2.png");
		while(spritesheet == null)
			;
		System.out.println("Spritesheet loaded: Pumba");
		animation = new Animation(this, "Pumba", 10);
		movingRight = false;
		movingLeft = false;
	}
	
	public void update() {
		if(movingRight)
			x += xspeed;
		
		if(movingLeft)
			x -= xspeed;
	}
	
//	public boolean isMovingRight() {
//		return movingRight;
//	}
//
//	public void setMovingRight(boolean movingRight) {
//		this.movingRight = movingRight;
//	}
//
//	public boolean isMovingLeft() {
//		return movingLeft;
//	}
//
//	public void setMovingLeft(boolean movingLeft) {
//		this.movingLeft = movingLeft;
//	}
}
