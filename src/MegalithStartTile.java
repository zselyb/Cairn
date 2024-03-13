import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * The Class MegalithStartTile.
 */
public class MegalithStartTile extends MapTile 
{
	
	/** The background. */
	static BufferedImage background = new BufferedImage(100,100, BufferedImage.TYPE_INT_ARGB_PRE);
	static 
	{
		try 
		{
			Graphics2D g = background.createGraphics();
			g.drawImage(ImageIO.read(new File("MegalithStartTile.png")), 0, 0, null);
			g.dispose();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}

	
	/**
	 * Instantiates a new megalith start tile.
	 *
	 * @param posx the posx
	 * @param posy the posy
	 * @param gc the gc
	 */
	MegalithStartTile(int posx, int posy, GameController gc) 
	{
		super(posx, posy, gc);
		button = new MapButton(this,background);
		addMegalith(controller.getMegalith());
	}

}
