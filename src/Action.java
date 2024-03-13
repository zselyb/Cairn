
/**
 * The Class Action.
 */




public class Action 
{
	
	/** The button. */
	ActionButton button;
	
	/** The controller. */
	GameController controller;
	
	/**
	 * Instantiates a new action.
	 *
	 * @param gc sets controller
	 */
	Action(GameController gc)
	{
		controller = gc;
	}
	
	/**
	 * Gets the button.
	 *
	 * @return the button
	 */
	ActionButton getButton()
	{
		return button;
	}
	
	/**
	 * Clicked.
	 */
	void clicked()
	{

	}

	/**
	 * Change side.
	 */
	public void changeSide() 
	{

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
		
	}
	
	/**
	 * Selection.
	 * Makes highlights on the map based on clicked Tile and the action itself
	 * @param clickedTile the clicked tile
	 * @param activePlayer the active player
	 * @param map the map
	 */
	void selection(MapTile clickedTile, Player activePlayer, Map map)
	{
		
	}
}
