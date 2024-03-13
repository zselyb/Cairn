import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * The Class BasicTile.
 * Only differs from MapTile in background
 */
public class BasicTile extends MapTile
{
	
	/** The background. */
	static BufferedImage background = new BufferedImage(100,100, BufferedImage.TYPE_INT_ARGB_PRE);
	static 
	{
		
		try 
		{
			Graphics2D g = background.createGraphics();
			g.drawImage(ImageIO.read(new File("BasicTile.png")), 0, 0, null);
			g.dispose();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Instantiates a new basic tile.
	 *
	 * @param posx the posx
	 * @param posy the posy
	 * @param gc the gc
	 */
	BasicTile(int posx, int posy, GameController gc) 
	{
		super(posx, posy, gc);
		button = new MapButton(this,background);
	}

}
