import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * The Class AlleyofDusk.
 * A Megalith that Banishes an enemy Shaman adjacent to this Megalith.
 */
public class AlleyofDusk extends Megalith
{
	
	/**
	 * Instantiates a new Alley of Dusk Megalith.
	 * It loads the image
	 * @param gc the GameController
	 */
	AlleyofDusk(GameController gc)
	{
		super(gc);
		try 
		{
			Graphics2D gmegalith = image.createGraphics();
			gmegalith.drawImage(ImageIO.read(new File("AlleyofDusk.png")), 0, 0, null);
			gmegalith.dispose();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}	
	}
	
	/**
	 * Do action.
	 * Banishes an enemy Shaman adjacent to this Megalith, if the clicked tile was valid.
	 * Then sets active Megalith to null as no movement was made no new Megalith had been activated
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
	 * Selects banishable tiles and marks them as highlighted
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
		return
				Math.abs(clickedTile.getx()-location.getx()) + Math.abs(clickedTile.gety()-location.gety()) >=1 
				&& Math.abs(clickedTile.getx()-location.getx()) <=1 
				&& Math.abs(clickedTile.gety()-location.gety()) <=1
				&& clickedTile.getShaman() != null 
				&& clickedTile.getShaman().getPlayer() != controller.getActivePlayer();
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
}