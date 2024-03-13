import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * The Class MapButton.
 */
public class MapButton extends JButton implements ActionListener
{
	
	/** The blue shaman image. */
	static BufferedImage blueShamanImage = new BufferedImage(100,100, BufferedImage.TYPE_INT_ARGB_PRE);
	
	/** The brown shaman image. */
	static BufferedImage brownShamanImage = new BufferedImage(100,100, BufferedImage.TYPE_INT_ARGB_PRE);
	
	/** The highlight image. */
	static BufferedImage highlightImage = new BufferedImage(100,100, BufferedImage.TYPE_INT_ARGB_PRE);;
	static
	{
		try 
		{
			Graphics2D gblue = blueShamanImage.createGraphics();
			gblue.drawImage(ImageIO.read(new File("BlueShaman.png")), 0, 0, null);
			gblue.dispose();
			Graphics2D gbrown = brownShamanImage.createGraphics();
			gbrown.drawImage(ImageIO.read(new File("BrownShaman.png")), 0, 0, null);
			gbrown.dispose();
			Graphics2D ghigh = highlightImage.createGraphics();
			ghigh.drawImage(ImageIO.read(new File("Highlight.png")), 0, 0, null);
			ghigh.dispose();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	/** The background. */
	BufferedImage background;
	
	/** The highlight. */
	BufferedImage highlight = null;
	
	/** The shaman image. */
	BufferedImage shamanImage = null;
	
	/** The megalith image. */
	BufferedImage megalithImage = null;
	
	/** The tile. */
	MapTile tile;
	
	/**
	 * Instantiates a new map button.
	 *
	 * @param t the t
	 * @param bg the bg
	 */
	MapButton(MapTile t,BufferedImage bg)
	{
		tile = t;
		setBorderPainted(false);
		setBorder(null);
		setMargin(new Insets(0,0,0,0));
		background = bg;
		addActionListener(this);
		UpdateImage();
	}
	
	/**
	 * Update image.
	 */
	void UpdateImage()
	{
		BufferedImage temp = new BufferedImage(100,100, BufferedImage.TYPE_INT_ARGB_PRE);
		Graphics2D g = temp.createGraphics();
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
		g.drawImage(background, 0, 0, null);
		g.drawImage(megalithImage, 0, 0, null);		
		g.drawImage(shamanImage, 0, 0, null);
		g.drawImage(highlight, 0, 0, null);
		g.dispose();
		setIcon(new ImageIcon(temp));
	}
	
	/**
	 * Adds the shaman.
	 *
	 * @param s the s
	 */
	void addShaman(Shaman s)
	{
		if(s.getPlayer().getPlayerColor() == PlayerColor.BROWN)
		{
			shamanImage = brownShamanImage;
		}
		else
		{
			shamanImage = blueShamanImage;
		}
		UpdateImage();
	}
	
	/**
	 * Removes the shaman.
	 */
	void removeShaman()
	{
		shamanImage = null;
		UpdateImage();
	}

	/**
	 * Adds the megalith.
	 *
	 * @param m the m
	 */
	void addMegalith(Megalith m) 
	{
		megalithImage = m.getImage();
		UpdateImage();
	}
	
	/**
	 * Removes the megalith.
	 */
	void removeMegalith() 
	{
		megalithImage = null;
	}
	
	/**
	 * Highlight.
	 */
	public void highlight() 
	{
		highlight = highlightImage;
		UpdateImage();
	}
	
	/**
	 * Removes the highligth.
	 */
	public void removeHighligth() 
	{
		highlight = null;
		UpdateImage();
	}
		
		/**
		 * Action performed.
		 *
		 * @param e the e
		 */
		@Override
	public void actionPerformed(ActionEvent e)
	{
		tile.clicked();
	}		
}
