import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JPanel;



/**
 * The Class TransformationEffect.
 */
public class TransformationEffect extends Action
{
	
	/** The type. */
	TransformationType type;
	
	/**
	 * Instantiates a new transformation effect.
	 * Initialises the button
	 * Sets the move type and responding image randomly
	 * @param gc the GameController
	 */
	TransformationEffect(GameController gc)
	{
		super(gc);
		Random r = new Random();
		int temp = r.nextInt(0, 2);
		button = new TransformationButton(this);
		if(temp == 0)
		{
			type = TransformationType.B;
			button.setSide1();
		}
		else
		{
			type = TransformationType.A;
			button.setSide2();
		}
	}
	
	/**
	 * Clicked.
	 */
	void clicked()
	{
		Map map = controller.getMap();
		if(controller.checkEndTurn())
		{
			controller.endTurn();
		}
	}

	
	/**
	 * Check transformation.
	 *
	 * @return true, if successful
	 */
	boolean checkTransformation()
	{
		Map map = controller.getMap();
		boolean found = false;
		for(int i = 1; i < 6; i++)
		{
			for(int j = 1; j < 6; j++)
			{
				if(isTargetOfFormation(map.index(i, j)))
				{
					found = true;
					map.index(i, j).setSelectable(true);
				}
			}
		}
		return found;
	}
	
	/**
	 * Change side.
	 */
	public void changeSide()
	{
		if (type == TransformationType.B)
		{
			type = TransformationType.A;
			button.setSide2();
		}
		else
		{
			type = TransformationType.B;
			button.setSide1();
		}
	}
	
	/**
	 * Checks if is target of formation.
	 *
	 * @param tile the tile
	 * @return true, if is target of formation
	 */
	boolean isTargetOfFormation(MapTile tile)
	{
		Map map = controller.getMap();
		if (tile.getShaman() == null || tile.getShaman().owner == controller.getActivePlayer())
		{
			return false;
		}
		for(int i = -1; i <= 1; i++)
		{
			for(int j = -1; j <= 1; j++)
			{
				if(map.index(tile.getx()+i, tile.gety()+j).getShaman() != null && map.index(tile.getx()+i, tile.gety()+j).getShaman().getPlayer() == controller.getActivePlayer())
				{
					if(type == TransformationType.A)
					{
						if((map.index(tile.getx()+(2*i), tile.gety() +(2*j)).getShaman() != null && map.index(tile.getx()+(2*i), tile.gety() +(2*j)).getShaman().getPlayer() == controller.getActivePlayer()))
							return true;
					}
					else
					{
						if((map.index(tile.getx()-i, tile.gety()-j).getShaman() != null && map.index(tile.getx()-i, tile.gety()-j).getShaman().getPlayer() == controller.getActivePlayer()))
							return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Do action.
	 *
	 * @param clickedTile the clicked tile
	 */
	public void doAction(MapTile clickedTile) 
	{
		if(isTargetOfFormation(clickedTile))
		{
			clickedTile.banishShaman();
			changeSide();
			if(clickedTile.getMegalith() == null)
			{
				controller.placeMegalith(clickedTile);
			}
			
		}
	}
}
