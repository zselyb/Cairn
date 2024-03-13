

/**
 * The Class MapTile.
 */
public class MapTile 
{
	
	/** The x. */
	int x;
	
	/** The y. */
	int y;
	
	/** The controller. */
	GameController controller;
	
	/** The button. */
	MapButton button;
	
	/** The shaman. */
	Shaman shaman = null;
	
	/** The megalith. */
	Megalith megalith = null;
	
	/** The selectable. */
	boolean selectable = false;
	
	/** The moveable. */
	boolean moveable = true;

	
	
	/**
	 * Instantiates a new map tile.
	 *
	 * @param posx the posx
	 * @param posy the posy
	 * @param gc the gc
	 */
	MapTile(int posx, int posy, GameController gc)
	{
		x = posx;
		y = posy;
		controller = gc;
	}
	
	/**
	 * Adds the megalith.
	 *
	 * @param m the m
	 */
	void addMegalith(Megalith m)
	{
		megalith = m;
		megalith.setTile(this);
		button.addMegalith(m);
	}
	
	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	int getx()
	{
		return x;
	}
	
	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	int gety()
	{
		return y;
	}
	
	/**
	 * Checks if is moveable.
	 *
	 * @param activePlayer the active player
	 * @return true, if is moveable
	 */
	boolean isMoveable(Player activePlayer)
	{
		return moveable;
	}
	
	/**
	 * Sets the selectable.
	 *
	 * @param s the new selectable
	 */
	void setSelectable(boolean s)
	{
		selectable = s;
		if(selectable)
		{
			button.highlight();
		}
		else
		{
			button.removeHighligth();
		}
	}
	
	/**
	 * Adds the shaman.
	 *
	 * @param s the s
	 */
	void addShaman(Shaman s)
	{
		shaman = s;
		moveable = false;
		button.addShaman(s);
		if(megalith != null)
			megalith.activated();;
	}
	
	/**
	 * Removes the shaman.
	 */
	void removeShaman()
	{
		shaman = null;
		moveable = true;
		button.removeShaman();
	}
	
	/**
	 * Gets the shaman.
	 *
	 * @return the shaman
	 */
	Shaman getShaman()
	{
		return shaman;
	}
	
	/**
	 * Banish shaman.
	 */
	void banishShaman()
	{
		if (shaman != null)
		{
			shaman.putback();
			shaman = null;
			button.removeShaman();
			moveable = true;
		}
	}
	
	/**
	 * Gets the button.
	 *
	 * @return the button
	 */
	MapButton getButton()
	{
		return button;
	}
	
	/**
	 * Clicked.
	 */
	void clicked()
	{
		controller.clicked(this);
	}
	
	
	/**
	 * Move shaman.
	 *
	 * @param target the target
	 */
	void MoveShaman(MapTile target)
	{
		Shaman temp = shaman;
		removeShaman();
		target.addShaman(temp);
	}

	/**
	 * Gets the megalith.
	 *
	 * @return the megalith
	 */
	public Megalith getMegalith() 
	{
		return megalith;
	}
}


