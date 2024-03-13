import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * The Class VillageTile.
 */
public class VillageTile extends MapTile
{
	
	/** The owner. */
	Player owner;
	
	/** The background. */
	BufferedImage background = new BufferedImage(100,100, BufferedImage.TYPE_INT_ARGB_PRE);

	/**
	 * Instantiates a new village tile.
	 *
	 * @param posx the posx
	 * @param posy the posy
	 * @param gc the gc
	 * @param p the p
	 */
	VillageTile(int posx, int posy, GameController gc, Player p) 
	{
		
		super(posx, posy, gc);
		owner = p;
		BufferedImage background = new BufferedImage(100,100, BufferedImage.TYPE_INT_ARGB_PRE);
		try 
		{
			Graphics2D g = background.createGraphics();
			if(owner.getPlayerColor() == PlayerColor.BROWN) 
			{
				g.drawImage(ImageIO.read(new File("BrownVillageTile.png")), 0, 0, null);
			}
			else
			{
				g.drawImage(ImageIO.read(new File("BlueVillageTile.png")), 0, 0, null);
			}
			g.dispose();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		button = new MapButton(this, background);
	}
	
	/**
	 * Checks if is moveable.
	 *
	 * @param activePlayer the active player
	 * @return true, if is moveable
	 */
	boolean isMoveable(Player activePlayer)
	{
		if(owner == activePlayer)
			return false;
		return true;
	}
	
	/**
	 * Adds the shaman.
	 *
	 * @param s the s
	 */
	void addShaman(Shaman s)
	{
		shaman = s;
		banishShaman();
		controller.placeMegalith(controller.selectedTile);
	}


}
