import java.io.Serializable;
import java.util.ArrayList;
/**
 * The Class Player.
 */
public class Player
{
	/** The color. */
	PlayerColor color;
	
	/** The name. */
	String name;
	
	/** The black summon. */
	MapTile blackSummon;
	
	/** The white summon. */
	MapTile whiteSummon;
	
	/** The shamans. */
	ArrayList<Shaman> shamans = new ArrayList<Shaman>();
	
	/** The score. */
	int score = 0;
	
	/**
	 * Instantiates a new player.
	 *
	 * @param c the c
	 * @param n the n
	 */
	Player(PlayerColor c, String n)
	{
		color = c;
		name = n;
		for(int i = 0; i < 5; i++)
		{
			shamans.add(new Shaman(this));
		}
	}
	
	/**
	 * Gets the player color.
	 *
	 * @return the player color
	 */
	PlayerColor getPlayerColor()
	{
		return color;
	}
	
	/**
	 * Gets the summon tile.
	 *
	 * @param st the st
	 * @return the summon tile
	 */
	MapTile getSummonTile(SummonType st)
	{
		if(st == SummonType.BLACK)
			return blackSummon;
		return whiteSummon;
	}
	
	/**
	 * Sets the black summon.
	 *
	 * @param bs the new black summon
	 */
	void setBlackSummon(MapTile bs)
	{
		blackSummon = bs;	
	}
	
	/**
	 * Sets the white summon.
	 *
	 * @param ws the new white summon
	 */
	void setWhiteSummon(MapTile ws)
	{
		whiteSummon = ws;	
	}
	
	/**
	 * Gets the shaman.
	 *
	 * @return the shaman
	 * @throws Exception the exception
	 */
	Shaman getShaman() throws Exception
	{
		return shamans.remove(0);
	}
	
	/**
	 * Put shaman.
	 *
	 * @param s the s
	 */
	void putShaman(Shaman s)
	{
		shamans.add(s);
	}
	
	/**
	 * Gets the score.
	 *
	 * @return the score
	 */
	int getScore()
	{
		return score;
	}

	/**
	 * Increase score.
	 */
	void increaseScore() 
	{
			score++;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() 
	{
		return name+color.toString();
	}

	/**
	 * Gets the shaman number.
	 *
	 * @return the shaman number
	 */
	int getShamanNumber() 
	{
		return shamans.size();
	}
}
