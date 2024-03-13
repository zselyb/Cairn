import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * The Class MegalithButton.
 */
public class MegalithButton extends JButton implements ActionListener
{
	
	/** The megalith. */
	Megalith megalith;
	
	/** The controller. */
	GameController controller;
	
	/**
	 * Instantiates a new megalith button.
	 *
	 * @param gc the gc
	 * @param m the m
	 */
	MegalithButton(GameController gc, Megalith m)
	{
		controller = gc;
		setBorderPainted(false);
		setBorder(null);
		setMargin(new Insets(0,0,0,0));
		megalith = m;
		setIcon(new ImageIcon(megalith.getImage()));
		addActionListener(this);
	}

	/**
	 * Gets the megalith.
	 *
	 * @return the megalith
	 */
	Megalith getMegalith()
	{
		Megalith temp = megalith;
		megalith = controller.getMegalith();
		setIcon(new ImageIcon(megalith.getImage()));
		return temp;
	}


	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	public void actionPerformed(ActionEvent e)
	{
		controller.clicked(this);
	}		

}
