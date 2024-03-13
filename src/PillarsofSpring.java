import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * The Class PillarsofSpring.
 */
public class PillarsofSpring extends Megalith
{
	
	/**
	 * Instantiates a new pillarsof spring.
	 *
	 * @param gc the gc
	 */
	PillarsofSpring(GameController gc) 
	{
		super(gc);
		try 
		{
			Graphics2D gmegalith = image.createGraphics();
			gmegalith.drawImage(ImageIO.read(new File("PillarsofSpring.png")), 0, 0, null);
			gmegalith.dispose();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}	
	}
	
	/**
	 * Do action.
	 *
	 * @param clickedTile the clicked tile
	 */
	void doAction(MapTile clickedTile) 
	{
		controller.setFlippedAction(false);
	}

	/**
	 * Activated.
	 */
	void activated() 
	{
		doAction(null);
		
	}
}
