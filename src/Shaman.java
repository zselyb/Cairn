

/**
 * The Class Shaman.
 */
public class Shaman 
{
	
	/** The owner. */
	Player owner;
	
	/**
	 * Instantiates a new shaman.
	 *
	 * @param p the p
	 */
	Shaman(Player p)
	{
		owner = p;
	}
	
	/**
	 * Gets the player.
	 *
	 * @return the player
	 */
	Player getPlayer()
	{
		return owner;
	}
	
	/**
	 * Putback.
	 */
	void putback()
	{
		owner.putShaman(this);
	}
}
