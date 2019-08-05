package SwingElements;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ScoreLabel extends JLabel{
	
	private int x = 400;
	private int y = 20;
	private int HEIGHT = 30;
	private int WIDTH = 200;
	private int score;
	
	public ScoreLabel() {
		score = 0;
		setBounds(x, y, WIDTH, HEIGHT);
		setForeground(Color.ORANGE);
		setBackground(null);
		setText("Marcador: " + Integer.toString(score));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public void updateScore(int points) {
		this.score += points;
		setText("Marcador: " + Integer.toString(score));
	}

}
