import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * The Class CromlechoftheStars.
 */
public class CromlechoftheStars extends Megalith
{

	/**
	 * Instantiates a new cromlechofthe stars.
	 *
	 * @param gc the gc
	 */
	CromlechoftheStars(GameController gc) 
	{
		super(gc);
		try 
		{
			Graphics2D gmegalith = image.createGraphics();
			gmegalith.drawImage(ImageIO.read(new File("CromlechoftheStars.png")), 0, 0, null);
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
				if(isMoveable(map.index(i,j)))
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
				if(isMoveable(map.index(i,j)))
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
		(isMoveable(clickedTile))
		{
			try 
			{
				location.MoveShaman(clickedTile);
				clickedTile.getMegalith().activated();
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
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
		if(clickedTile.getShaman() == null && clickedTile.getMegalith() != null)
		{
			return true;
		}
		return false;
	}
}
