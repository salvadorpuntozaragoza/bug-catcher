package controllers;

public class Timon extends Character{
	
	private static int sec;

	public Timon(int x, int y, int xspeed, int yspeed, int height, int width) {
		super(x, y, xspeed, yspeed, width, height);
		loadSpritesheet("C:\\Users\\xX-Ch\\OneDrive\\Escritorio\\timon.png");
		while(spritesheet == null)
			;
		System.out.println("Spritesheet loaded: Timon");
		animation = new Animation(this, "Timon", 12);
		sec = 0;
		movingRight = true;
		movingLeft = false;
	}
	
	public void update() {
		
		sec++;
		
		if(getFlag()) {
			if( (int) (Math.random() * 10) > 4 )
				xspeed *= -1;
		}
		
		if(x > 550)
			xspeed *= -1;
		if(x < 6)
			xspeed *= -1;
		
		if(xspeed > 0  && movingRight == false) {
			movingRight = true;
			movingLeft = false;
		}
		
		if(xspeed < 0 && movingLeft == false) {
			movingLeft = true;
			movingRight = false;
		}
		
		x += xspeed;
	}
	
	protected static boolean getFlag() {
		if(sec == 60) {
			sec = 0;
			return true;
		}
			return false;
	}
	
}
