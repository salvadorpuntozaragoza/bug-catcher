package frames;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.GameEngine;
import panels.GamePanel;
import panels.MenuPanel;

public class MainWindow extends JFrame {
	
	private static JPanel mainPan;
	private static MenuPanel menuPan;
	private static GamePanel gamePan;
	private static CardLayout card;
//	private static final int FPS = 60;
//	private static final int limit = 1000;
//	private static int update;
//	private static int sec = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					//GameEngine ge = new GameEngine(gamePan);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		card = new CardLayout(0,0);
		
		mainPan = new JPanel();
		mainPan.setLayout(card);
		mainPan.setSize(600, 600);
		
		menuPan = new MenuPanel();
		
		
		
		gamePan = new GamePanel();
		gamePan.setBorder(new EmptyBorder(5, 5, 5, 5));
		gamePan.setLayout(new BorderLayout(0, 0));
		gamePan.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
					gamePan.getPumba().setMovingRight(true);
					gamePan.getPumba().setStill(false);
				}
					
				
				if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
					gamePan.getPumba().setMovingLeft(true);
					gamePan.getPumba().setStill(false);
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
					gamePan.getPumba().setMovingRight(false);
					gamePan.getPumba().setStill(true);
				}
				
				if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
					gamePan.getPumba().setMovingLeft(false);
					gamePan.getPumba().setStill(true);
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		mainPan.add(menuPan, MenuPanel.PANE_ID);
		mainPan.add(gamePan, GamePanel.PANE_ID);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		setTitle("Bug catcher");
		setContentPane(mainPan);
		setVisible(true);
		//setContentPane(gamePan);
	}
	
	public static void startGame() {
		card.show(mainPan, GamePanel.PANE_ID);
		GameEngine ge = new GameEngine(gamePan);
		//gamePan.setFocusable(true);
		gamePan.grabFocus();
	}

}
