import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * The Class StartFrame.
 */
public class StartFrame extends JFrame
{
	
	/** The blue. */
	JTextField blue = new JTextField("BluePlayerName:");
	
	/** The brown. */
	JTextField brown = new JTextField("BrownPlayerName:");
	
	/** The c. */
	JTextField c = new JTextField("");
	
	/** The d. */
	JTextField d = new JTextField(""); 
	
	/** The e. */
	JButton e = new JButton("Start");
	
	/** The f. */
	JButton f = new JButton("Score");
	
	/**
	 * Instantiates a new start frame.
	 */
	StartFrame()
	{
		setLayout(new GridLayout(3,2));
		blue.setEditable(false);
		brown.setEditable(false);
		e.addActionListener(new StartActionListener());
		f.addActionListener(new ScoreActionListener());
		add(blue);
		add(brown);
		add(c);
		add(d);
		add(e);
		add(f);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	class StartActionListener implements ActionListener
	{
		
		/**
		 * Action performed.
		 *
		 * @param e the e
		 */
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			GameController controller = new GameController (new Player(PlayerColor.BLUE,c.getText()),new Player(PlayerColor.BROWN,d.getText()));
			dispose();
		}
	}

	class ScoreActionListener implements ActionListener
	{
		
		/**
		 * Action performed.
		 *
		 * @param e the e
		 */
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			ScoreFrame s = new ScoreFrame();
			dispose();
		}
	}
	
}
