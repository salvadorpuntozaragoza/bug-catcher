package controllers;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Character {
	
	//BASIC PROPERTIES
	protected int x;
	protected int y;
	protected int xspeed;
	protected int yspeed;
	protected int height;
	protected int width;
	
	//STATE PROPERTIES
	protected boolean still;
	protected boolean movingRight;
	protected boolean movingLeft;
	
	//ANIMATION AND GRAPHICS PROPERTIES
	protected BufferedImage spritesheet;	//COMPLETE SPRITESHEET WITH 4X4 FRAMES
	protected BufferedImage image;			//ONE OF THE FRAMES FROM THE SPRITESHEET
	protected Animation animation;			//CLASS THAT CONTROLS WHICH FRAME TO DISPLAY AT EACH MOMENT
	
	public Character(int x, int y, int xspeed, int yspeed, int height, int width) {
		this.x = x;
		this.y = y;
		this.xspeed = xspeed;
		this.yspeed = yspeed;
		this.height= height;
		this.width = width;
		init();
	}
	
	public void init() {
		movingLeft = false;
		movingRight = false;
		still = true;
		image = null;
	}
	
	protected void loadSpritesheet(String path) {
		try {
//			"D:\\work\\files\\logo.jpg"
			spritesheet = ImageIO.read(Character.class.getResource(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//GETTERS, SETTERS AND GET BOUNDS METHOD FOR COLLISIONS

	public int getXspeed() {
		return xspeed;
	}

	public void setXspeed(int xspeed) {
		this.xspeed = xspeed;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
	
	public boolean isStill() {
		return still;
	}

	public void setStill(boolean still) {
		this.still = still;
	}

	public boolean isMovingRight() {
		return movingRight;
	}

	public void setMovingRight(boolean movingRight) {
		this.movingRight = movingRight;
	}

	public boolean isMovingLeft() {
		return movingLeft;
	}

	public void setMovingLeft(boolean movingLeft) {
		this.movingLeft = movingLeft;
	}

	public BufferedImage getSpriteSheet() {
		return spritesheet;
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,width,height);
	}
}
