import java.util.Random;

/**
 * The Class MoveAction.
 */
public class MoveAction extends Action
{
	
	/** The type. */
	MoveType type;
	
	/**
	 * Instantiates a new move action.
	 * Initialises the button
	 * Sets the move type and responding image randomly
	 * @param gc the GameController
	 */
	MoveAction(GameController gc) 
	{
		super(gc);
		Random r = new Random();
		int temp = r.nextInt(0, 2);
		button = new MoveActionButton(this);
		if(temp == 0)
		{
			type = MoveType.ORTOGONAL;
			button.setSide1();
		}
		else
		{
			type = MoveType.DIAGONAL;
			button.setSide2();
		}
		
	}

	/**
	 * Change side.
	 */
	public void changeSide()
	{
		if (type == MoveType.ORTOGONAL)
		{
			type = MoveType.DIAGONAL;
			button.setSide2();
		}
		else
		{
			type = MoveType.ORTOGONAL;
			button.setSide1();
		}
	}
	
	/**
	 * Do action.
	 *
	 * @param t1 the t 1
	 * @param t2 the t 2
	 * @param activePlayer the active player
	 * @param map the map
	 */
	void doAction(MapTile t1, MapTile t2, Player activePlayer, Map map)
	{
		if(isMoveable(t1,t2, activePlayer, map))
		{
			changeSide();
			controller.setFlippedAction(true);
			t1.MoveShaman(t2);
			
		}
	}
	
	/**
	 * Checks if is moveable.
	 *
	 * @param t1 the t 1
	 * @param t2 the t 2
	 * @param activePlayer the active player
	 * @param map the map
	 * @return true, if is moveable
	 */
	boolean isMoveable(MapTile t1, MapTile t2, Player activePlayer, Map map)
	{
		if(t2.isMoveable(activePlayer))
		{
			if(type == MoveType.ORTOGONAL && Math.abs(t1.getx()-t2.getx())+Math.abs(t1.gety()-t2.gety()) == 1)
			{
				return true;
			}
			if(type == MoveType.DIAGONAL && Math.abs(t1.getx()-t2.getx()) == 1 && Math.abs(t1.gety()-t2.gety()) == 1)
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Selection.
	 * Selects all the possible tiles the clicked shaman can move to
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
				if(isMoveable(clickedTile,map.index(i, j),activePlayer,map))
				{
					map.index(i, j).setSelectable(true);
				}
			}
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

}
