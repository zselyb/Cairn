import java.io.Serializable;

/**
 * The Class NameScore.
 */
public class NameScore implements Serializable
{
	
	/** The name. */
	String name;
	
	/** The score. */
	int score;
	
	/**
	 * Instantiates a new name score.
	 *
	 * @param n the n
	 * @param s the s
	 */
	public NameScore(String n, int s) 
	{
		name = n;
		score = s;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	String getName()
	{
		return name;
	}
	
	/**
	 * Gets the score.
	 *
	 * @return the score
	 */
	Integer getScore()
	{
		return score;
	}

	/**
	 * Sets the score.
	 *
	 * @param i the new score
	 */
	public void setScore(int i) 
	{
		score = i;
		
	}
	
	/**
	 * Sets the name.
	 *
	 * @param n the new name
	 */
	public void setName(String n) 
	{
		name = n;
		
	}

}
