import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * The Class NotPlayableTile.
 */
public class NotPlayableTile extends MapTile 
{
	
	/** The background. */
	static BufferedImage background = new BufferedImage(100,100, BufferedImage.TYPE_INT_ARGB_PRE);
	static 
	{
		try 
		{
			Graphics2D g = background.createGraphics();
			g.drawImage(ImageIO.read(new File("NotMapTile.png")), 0, 0, null);
			g.dispose();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}	
	}

	/**
	 * Instantiates a new not playable tile.
	 *
	 * @param posx the posx
	 * @param posy the posy
	 * @param gc the gc
	 */
	NotPlayableTile(int posx, int posy, GameController gc) 
	{
		super(posx, posy, gc);
		moveable = false;
		button = new MapButton(this,background);
	}
}
