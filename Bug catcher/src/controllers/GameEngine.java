package controllers;

import panels.GamePanel;

public class GameEngine implements Runnable {
	
	private static GamePanel gamePan;
	private Thread t;
	private int sec;
	private int FPS;
	
	public GameEngine(GamePanel gp) {
		GameEngine.gamePan = gp;
		sec = 0;
		FPS = 0;
		t = new Thread(this);
		t.start();
	}
	
	public void run() {
		while(true) {
			if(sec % 9 == 0) {
				update();
				render();
				FPS++;
			}
			
			if(sec % 200 == 0)
				gamePan.insertNewBug();
				
				
			if(sec == 1000) {
				sec = 0;
				System.out.println("Frames per second: " + FPS);
				FPS = 0;
			}
			
			try {
				Thread.sleep(1);
				sec++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private static void update() {
		gamePan.getPumba().update();
		gamePan.getTimon().update();
		gamePan.updateBugs();
	}
	
	private static void render() {
		gamePan.repaint();
		gamePan.getScoreLabel().repaint();
	}

}
