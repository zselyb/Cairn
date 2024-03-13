import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * The Class Megalith.
 */
public class Megalith 
{
	
	/** The controller. */
	GameController controller;
	
	/** The location. */
	MapTile location = null;
	
	/** The image. */
	BufferedImage image = new BufferedImage(100,100, BufferedImage.TYPE_INT_ARGB_PRE);
	
	/**
	 * Instantiates a new megalith.
	 *
	 * @param gc the gc
	 */
	Megalith(GameController gc)
	{
		controller = gc;
	}

	/**
	 * Sets the tile.
	 *
	 * @param mapTile the new tile
	 */
	public void setTile(MapTile mapTile) 
	{
		location = mapTile;
	}
	
	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	BufferedImage getImage() 
	{
		return image;
	}
	
	/**
	 * Do action.
	 *
	 * @param clickedTile the clicked tile
	 */
	void doAction(MapTile clickedTile) 
	{

	}
	
	/**
	 * Selection.
	 *
	 * @param map the map
	 */
	void selection(Map map)
	{
		
	}

	/**
	 * Clicked.
	 *
	 * @param clickedAction the clicked action
	 */
	void clicked(Action clickedAction) 
	{
		
	}

	/**
	 * Activated.
	 */
	void activated() 
	{
		
	}

	/**
	 * Gets the player.
	 *
	 * @return the player
	 */
	Player getPlayer() 
	{
		return location.getShaman().getPlayer();
	}

}
