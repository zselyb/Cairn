import java.util.Random;

/**
 * The Class JumpAction.
 */
public class JumpAction extends Action
{

	/** The type. */
	JumpType type;
	
	/**
	 * Instantiates a new jump action.
	 * Initialises the button
	 * Sets the jump type and responding image randomly
	 * @param gc the GameController
	 */
	JumpAction(GameController gc) 
	{
		super(gc);
		Random r = new Random();
		int temp = r.nextInt(0, 2);
		button = new JumpActionButton(this);
		if(temp == 0)
		{
			type = JumpType.FRIENDLY;
			button.setSide1();
		}
		else
		{
			type = JumpType.ENEMY;
			button.setSide2();
		}
		
	}

	/**
	 * Change side.
	 */
	public void changeSide()
	{
		if (type == JumpType.FRIENDLY)
		{
			type = JumpType.ENEMY;
			button.setSide2();
		}
		else
		{
			type = JumpType.FRIENDLY;
			button.setSide1();
		}
	}
	
	/**
	 * Clicked.
	 */
	void clicked()
	{
		if(controller.getActiveMegalith() == null)
		{
			controller.setSelectedAction(this);
		}
		else
		{
			controller.getActiveMegalith().clicked(this);
		}
	}
	
	/**
	 * Do action.
	 * Does the Jump moves the shaman and changes sides
	 * @param selectedTile the selected tile
	 * @param clickedTile the clicked tile
	 * @param activePlayer the active player
	 * @param map the map
	 */
	void doAction(MapTile selectedTile, MapTile clickedTile,Player activePlayer, Map map)
	{
		if(isJumpable(selectedTile,clickedTile,activePlayer, map))
		{
			changeSide();
			controller.setFlippedAction(true);
			selectedTile.MoveShaman(clickedTile);
			
		}
	}
	
	/**
	 * Checks if you can jump from the selectedTile to the ClickedTile
	 * If they are at a distance of two the clickedTile is empty and you can move to it 
	 * there is a Shaman between the two tiles of the right type (depending on JumpType)
	 * @param selectedTile the selected tile
	 * @param clickedTile the clicked tile
	 * @param activePlayer the active player
	 * @param map the map
	 * @return true, if you can jump
	 */
	boolean isJumpable(MapTile selectedTile, MapTile clickedTile, Player activePlayer, Map map)
	{
		if(clickedTile.isMoveable(activePlayer))
		{
			if(
					Math.abs(clickedTile.getx()-selectedTile.getx()) == 2  
					&& (Math.abs(clickedTile.gety()-selectedTile.gety()) == 2 
					|| Math.abs(clickedTile.gety()-selectedTile.gety()) == 0) 
					|| Math.abs(clickedTile.gety()-selectedTile.gety()) == 2  
					&& (Math.abs(clickedTile.getx()-selectedTile.getx()) == 2 
					|| Math.abs(clickedTile.getx()-selectedTile.getx()) == 0) ) 
			{
				if(
						type == JumpType.FRIENDLY 
						&& map.index((clickedTile.getx()+selectedTile.getx())/2,(clickedTile.gety()+selectedTile.gety())/2).getShaman() != null 
						&& map.index((clickedTile.getx()+selectedTile.getx())/2,(clickedTile.gety()+selectedTile.gety())/2).getShaman().getPlayer() == activePlayer)
				{
					return true;
				}
				if(
						type == JumpType.ENEMY 
						&& map.index((clickedTile.getx()+selectedTile.getx())/2,(clickedTile.gety()+selectedTile.gety())/2).getShaman() != null 
						&& map.index((clickedTile.getx()+selectedTile.getx())/2,(clickedTile.gety()+selectedTile.gety())/2).getShaman().getPlayer() != activePlayer)
				{
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Selection.
	 * Selects all the possible tiles the clicked Shaman can jump to
	 * @param clickedTile the clicked tile
	 * @param activePlayer the active player
	 * @param map the map
	 */
	void selection(MapTile clickedTile, Player activePlayer, Map map)
	{
		for(int i = 0; i < 7; i++)
		{
			for(int j = 0; j < 7; j++)
			{
				if(isJumpable(clickedTile,map.index(i, j),activePlayer,map))
				{
					map.index(i, j).setSelectable(true);
				}
			}
		}
	}
}
