package panels;

import javax.swing.JPanel;

import frames.MainWindow;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MenuPanel extends JPanel {
	
	public static String PANE_ID = "MenuPanel"; 

	/**
	 * Create the panel.
	 */
	public MenuPanel() {
		setLayout(null);
		setSize(600, 600);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainWindow.startGame();
			}
		});
		btnNewButton.setBounds(260, 359, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(260, 427, 89, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(260, 393, 89, 23);
		add(btnNewButton_2);

	}

}
