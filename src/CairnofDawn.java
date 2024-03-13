import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * The Class CairnofDawn.
 */
public class CairnofDawn extends Megalith
{

	/**
	 * Instantiates a new Cairn of Dawn.
	 *
	 * @param gc the gc
	 */
	CairnofDawn(GameController gc) 
	{
		super(gc);
		try 
		{
			Graphics2D gmegalith = image.createGraphics();
			gmegalith.drawImage(ImageIO.read(new File("CairnofDawn.png")), 0, 0, null);
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
				if(isSummonable(map.index(i,j)))
				{
					controller.setActiveMegalith(this);
					return;
				}
			}
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
				if(isSummonable(map.index(i,j)))
					map.index(i, j).setSelectable(true);
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
		(isSummonable(clickedTile))
		{
			try 
			{
				clickedTile.addShaman(controller.getActivePlayer().getShaman());
				if(clickedTile.getMegalith() != null)
				{
					clickedTile.getMegalith().activated();
				}
				else
				{
					controller.setActiveMegalith(null);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Checks if is summonable.
	 *
	 * @param clickedTile the clicked tile
	 * @return true, if is summonable
	 */
	boolean isSummonable(MapTile clickedTile) 
	{
		if(
			clickedTile.isMoveable(controller.getActivePlayer()) && controller.getActivePlayer().getShamanNumber() > 0
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
