package controllers;

public class Animation implements Runnable{
	
	private Thread t;
	private Character character;
	private String charName;
	private int i;
	private double j;
	private int fps;
	
	public Animation(Character character, String charName, int fps) {
		this.character = character;
		this.charName = charName;
		this.fps = (int)(1000 / fps);
		i = 0;
		j = 1;
		t = new Thread(this);
		t.start();
	}
	
	public void run() {
		while(true) {	
			
			if(charName.equals("Pumba"))
				animatePumba();
			
			if(charName.equals("Timon"))
				animateTimon();
			
			try {
				Thread.sleep(fps);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
	}
	
	private void animateTimon() {
		if(character.isMovingLeft()) {
			character.setImage(character.getSpriteSheet().getSubimage(50 * i, 50, character.getWidth(), character.getHeight()));
			System.out.println("Animating timon");
			i++;
		
			if(i == 4)
				i = 0;
		}
		
		if(character.isMovingRight()) {
			character.setImage(character.getSpriteSheet().getSubimage(50 * i, 0, character.getWidth(), character.getHeight()));
		
			i++;
		
			if(i == 4)
				i = 0;
		}
	}
	
	private void animatePumba() {
		if(character.isStill()) {
			character.setImage(character.getSpriteSheet().getSubimage(100 * i, (int)(200 * j), character.getWidth(), character.getHeight()));
			
			i++;
			
			if(i == 4) {
				i = 0;
				if(j == 1)
					j = 1.5;
				else
					j = 1.0;
			}
		}
		
		if(character.isMovingLeft()) {
			character.setImage(character.getSpriteSheet().getSubimage(100 * i, 100, character.getWidth(), character.getHeight()));
			
			i++;
		
			if(i == 4)
				i = 0;
		}
		
		if(character.isMovingRight()) {
			character.setImage(character.getSpriteSheet().getSubimage(100 * i, 0, character.getWidth(), character.getHeight()));
		
			i++;
		
			if(i == 4)
				i = 0;
		}
	}
}
