import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;



/**
 * The Class ActionButton.
 */
public class ActionButton extends JButton implements ActionListener
{
	
	/** The side 1 image. */
	BufferedImage side1Image;
	
	/** The side 2 image. */
	BufferedImage side2Image;
	
	/** The action. */
	Action action;
	
	/**
	 * Instantiates a new action button.
	 *
	 * @param actionin the actionin
	 */
	ActionButton(Action actionin)
	{
		action = actionin;
		side1Image = new BufferedImage(100,100, BufferedImage.TYPE_INT_ARGB);
		side2Image = new BufferedImage(100,100, BufferedImage.TYPE_INT_ARGB);
		setBorderPainted(false);
		setBorder(null);
		setMargin(new Insets(0,0,0,0));
		addActionListener(this);
	}
	
	/**
	 * Sets the side 1.
	 */
	void setSide1()
	{
		BufferedImage temp = new BufferedImage(100,100, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = temp.createGraphics();
		g.drawImage(side1Image,0,0,null);
		setIcon(new ImageIcon(temp));
	}
	
	/**
	 * Sets the side 2.
	 */
	void setSide2()
	{
		BufferedImage temp = new BufferedImage(100,100, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = temp.createGraphics();
		g.drawImage(side2Image,0,0,null);
		setIcon(new ImageIcon(temp));
	}
		
	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
			action.clicked();
	}
}
