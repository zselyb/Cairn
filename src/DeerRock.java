import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * The Class DeerRock.
 */
public class DeerRock extends Megalith
{

	/**
	 * Instantiates a new deer rock.
	 *
	 * @param gc the gc
	 */
	DeerRock(GameController gc) 
	{
		super(gc);
		try 
		{
			Graphics2D gmegalith = image.createGraphics();
			gmegalith.drawImage(ImageIO.read(new File("DeerRock.png")), 0, 0, null);
			gmegalith.dispose();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}	
	}
	
	

}
