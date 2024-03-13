import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * The Class GameEndFrame.
 */
public class GameEndFrame extends JFrame
{
	
	/** The field. */
	JTextField field;

	/**
	 * Instantiates a new game end frame.
	 *
	 * @param p the p
	 */
	GameEndFrame(Player p)
	{
		field = new JTextField("Winner is: "+p.getName());
		field.setEditable(false);
		add(field);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
}
