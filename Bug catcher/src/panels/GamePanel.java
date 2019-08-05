package panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import SwingElements.ScoreLabel;
import controllers.Animation;
import controllers.Bug;
import controllers.Pumba;
import controllers.Timon;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements KeyListener{
	
	private Pumba pumba;
	private Timon timon;
	private ScoreLabel score;
	private BufferedImage spritesheet;
	private BufferedImage bg_image;
	private Animation animation;
	private ArrayList<Bug> bugs;
	public static String PANE_ID = "GamePanel"; 

	/**
	 * Create the panel.
	 */
	
	private static final int HEIGHT = 600;
	private static final int WIDTH = 600;
	
	public GamePanel() {
		score = new ScoreLabel();
		add(score);
		pumba = new Pumba(HEIGHT / 2, WIDTH  - 150, 5, 0, 100, 100);
		timon = new Timon(300, WIDTH  - 550, 4, 0, 50, 50);
		bugs = new ArrayList<Bug>();
		try {
			spritesheet = ImageIO.read(GamePanel.class.getResource("/Resourses/sunset_BG.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		animation = new Animation(this, "bg", 2);
		//setFocusable(true);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bg_image, 0, 0, null);
		g.drawImage(pumba.getImage(), pumba.getX(), pumba.getY(), null);
		g.drawImage(timon.getImage(), timon.getX(), timon.getY(), null);
		g.setColor(Color.YELLOW);
		for(int i = 0 ; i < bugs.size() ; i++) {
			g.fillRect(bugs.get(i).getX(), bugs.get(i).getY(), bugs.get(i).getWidth(), bugs.get(i).getHeight());
		}
	}
	
	public Pumba getPumba() {
		return this.pumba;
	}
	
	public Timon getTimon() {
		return this.timon;
	}
	
	public void insertNewBug() {
		if(Math.random() * 10 > 8) {
			int rand = (int) (Math.random() * 5);
			if(rand == 0)
				rand = 1;
			
			bugs.add(new Bug(timon.getX(), timon.getY(), 0, rand, 25, 25));
		}
			
	}
	
	public void updateBugs() {
		for(int i = 0 ; i < bugs.size() ; i++) {
			bugs.get(i).update();
			
			if(bugs.get(i).getBounds().intersects(pumba.getBounds())) {
				bugs.remove(i);
				score.updateScore(5);
				System.out.println("Bug catched, Score: " + score.getScore());
			}
		}
		
		for(int i = 0 ; i < bugs.size() ; i++) {
			if(bugs.get(i).getY() > 600) {
				bugs.remove(i);
				System.out.println("Bug missed");
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Key Pressed");
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public BufferedImage getSpriteSheet() {
		return spritesheet;
	}
	
	public void setImage(BufferedImage bg) {
		this.bg_image = bg;
	}
	
	public ScoreLabel getScoreLabel() {
		return score;
	}
}
