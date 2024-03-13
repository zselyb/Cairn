import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The Class GameFrame.
 */
public class GameFrame extends JFrame
{
	
	/** The controller. */
	GameController controller;
	
	/** The text. */
	JTextField text;
	
	/** The blue score. */
	JTextField blueScore;
	
	/** The brown score. */
	JTextField brownScore;
	
	/** The game panel. */
	JPanel gamePanel;
	
	/** The map panel. */
	JPanel mapPanel;
	
	/** The action panel. */
	JPanel actionPanel;
	
	/**
	 * Instantiates a new game frame.
	 *
	 * @param gc the gc
	 */
	GameFrame(GameController gc)
	{
		controller = gc;
		text = new JTextField();
		blueScore = new JTextField();
		brownScore = new JTextField();
		text.setEditable(false);
		blueScore.setEditable(false);
		brownScore.setEditable(false);
		gamePanel = new JPanel(new BorderLayout());
		mapPanel = new JPanel(new GridBagLayout());
		actionPanel = new JPanel();
		actionPanel.setLayout(new BoxLayout(actionPanel,BoxLayout.Y_AXIS));
		
		gamePanel.add(text,BorderLayout.NORTH);
		gamePanel.add(mapPanel,BorderLayout.CENTER);
		gamePanel.add(actionPanel,BorderLayout.WEST);
		add(gamePanel);
		
		actionPanel.add(controller.getMoveAction().getButton());
		actionPanel.add(controller.getJumpAction().getButton());
		actionPanel.add(controller.getSummonAction().getButton());
		actionPanel.add(controller.getTransformationEffect().getButton());
		actionPanel.add(controller.getButton1());
		actionPanel.add(controller.getButton2());
		actionPanel.add(blueScore);
		actionPanel.add(brownScore);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagConstraints gbc = new GridBagConstraints();
		
		for(int y = 0; y < 7; y++) 
		{
			for (int x = 0; x < 7; x++) 
			{
				gbc.gridx = x;  
				gbc.gridy = y;
				mapPanel.add(controller.getMap().index(x,y).getButton(),gbc);
			}
		}
		pack();
		setVisible(true);
	}
	
	/**
	 * Text.
	 *
	 * @param s the s
	 */
	void text(String s)
	{
		text.setText(s);
	}

	/**
	 * Blue score.
	 *
	 * @param n the n
	 */
	void blueScore(int n)
	{
		blueScore.setText("Blue score:"+n);
		pack();
	}
	
	/**
	 * Brown score.
	 *
	 * @param n the n
	 */
	void brownScore(int n)
	{
		brownScore.setText("Brown score:"+n);
		pack();
	}
}
