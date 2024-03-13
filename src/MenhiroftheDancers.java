import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * The Class MenhiroftheDancers.
 */
public class MenhiroftheDancers extends Megalith
{
	
	/**
	 * Instantiates a new menhirofthe dancers.
	 *
	 * @param gc the gc
	 */
	MenhiroftheDancers(GameController gc)
	{
		super(gc);
		try 
		{
			Graphics2D gmegalith = image.createGraphics();
			gmegalith.drawImage(ImageIO.read(new File("MenhiroftheDancers.png")), 0, 0, null);
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
		if
		(isMoveable(clickedTile))
		{
			location.MoveShaman(clickedTile);
			if(clickedTile.getMegalith() != null)
			{
				clickedTile.getMegalith().activated();
			}
			else
			{
				controller.setActiveMegalith(null);
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
				if(isMoveable(map.index(i,j)))
					map.index(i, j).setSelectable(true);
			}
		}
	}
	
	/**
	 * Checks if is moveable.
	 *
	 * @param clickedTile the clicked tile
	 * @return true, if is moveable
	 */
	boolean isMoveable(MapTile clickedTile)
	{
		return
				Math.abs(clickedTile.getx()-location.getx()) + Math.abs(clickedTile.gety()-location.gety()) >=1 
				&& Math.abs(clickedTile.getx()-location.getx()) <=1 
				&& Math.abs(clickedTile.gety()-location.gety()) <=1
				&& clickedTile.isMoveable(controller.getActivePlayer());
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
				if(isMoveable(map.index(i,j)))
					{
					controller.setActiveMegalith(this);
					}
			}
		}
		
	}
}
