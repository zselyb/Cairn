import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * The Class ChaosoftheGiants.
 */
public class ChaosoftheGiants extends Megalith
{

	/**
	 * Instantiates a new chaosofthe giants.
	 *
	 * @param gc the gc
	 */
	ChaosoftheGiants(GameController gc) 
	{
		super(gc);
		try 
		{
			Graphics2D gmegalith = image.createGraphics();
			gmegalith.drawImage(ImageIO.read(new File("ChaosoftheGiants.png")), 0, 0, null);
			gmegalith.dispose();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}	
	}
	
	/**
	 * Activated.
	 */
	void activated()
	{
		Map map = controller.getMap();
		for(int i = 0; i < 7; i++)
		{
			for(int j = 0; j < 7; j++)
			{
				if(isBanishable(map.index(i,j)))
				{
					controller.setActiveMegalith(this);
					return;
				}
			}
		}
	}
	
	/**
	 * Do action.
	 *
	 * @param clickedTile the clicked tile
	 */
	void doAction(MapTile clickedTile) 
	{
		if
		(isBanishable(clickedTile))
		{
			clickedTile.banishShaman();
			controller.setActiveMegalith(null);
		}
	}
	
	/**
	 * Selection.
	 *
	 * @param map the map
	 */
	void selection(Map map)
	{
		for(int i = 0; i < 7; i++)
		{
			for(int j = 0; j < 7; j++)
			{
				if(isBanishable(map.index(i,j)))
					map.index(i, j).setSelectable(true);
			}
		}
	}

	/**
	 * Checks if is banishable.
	 *
	 * @param clickedTile the clicked tile
	 * @return true, if is banishable
	 */
	boolean isBanishable(MapTile clickedTile) 
	{
		if(
			clickedTile.getShaman() != null &&
			clickedTile.getShaman().getPlayer() != controller.getActivePlayer()
			)
		{
			if(controller.getActivePlayer().getPlayerColor() == PlayerColor.BLUE && clickedTile.gety() == 1)
				return true;
			if(controller.getActivePlayer().getPlayerColor() == PlayerColor.BROWN && clickedTile.gety() == 5)
				return true;
		}
		return false;
	}
	
	

}
