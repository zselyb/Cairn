import java.util.Random;

/**
 * The Class SummonAction.
 */
public class SummonAction extends Action
{
	
	/** The type. */
	SummonType type;
	
	/**
	 * Instantiates a new summon action.
	 * Initialises the button
	 * Sets the move type and responding image randomly
	 * @param gc the GameController
	 */
	SummonAction(GameController gc) 
	{
		super(gc);
		Random r = new Random();
		int temp = r.nextInt(0, 2);
		button = new SummonActionButton(this);
		if(temp == 0)
		{
			type = SummonType.BLACK;
			button.setSide1();
		}
		else
		{
			type = SummonType.WHITE;
			button.setSide2();
		}
	}

	/**
	 * Change side.
	 */
	public void changeSide()
	{
		if (type == SummonType.BLACK)
		{
			type = SummonType.WHITE;
			button.setSide2();
		}
		else
		{
			type = SummonType.BLACK;
			button.setSide1();
		}
	}
	
	/**
	 * Do action.
	 *
	 * @param activePlayer the active player
	 */
	void doAction(Player activePlayer)
	{
		MapTile target = activePlayer.getSummonTile(type);
		if((target.getShaman() == null || target.getShaman().getPlayer() != activePlayer) && controller.getActiveMegalith() == null)
		{
			try 
			{
				Shaman temp = activePlayer.getShaman();
				target.banishShaman();
				target.addShaman(temp);
				changeSide();
				controller.setFlippedAction(true);
			} 
			catch (Exception e) 
			{
				
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
			SummonType temp = type;
			doAction(controller.getActivePlayer());
			controller.clicked(controller.getActivePlayer().getSummonTile(temp));
		}
		else
		{
			controller.getActiveMegalith().clicked(this);
		}
	}

	
}
