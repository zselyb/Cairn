import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * The Class WhiteSummonTile.
 * It mainly differs from the MapTile in backgound and sets itself as a players WhiteSummonTile
 * When performing the Summon action it requests the corresponding tile from the player
 */
public class WhiteSummonTile extends MapTile
{
	
	/** The background. */
	static BufferedImage background = new BufferedImage(100,100, BufferedImage.TYPE_INT_ARGB_PRE);
	static
	{
		try 
		{
			Graphics2D g = background.createGraphics();
			g.drawImage(ImageIO.read(new File("WhiteSummonTile.png")), 0, 0, null);
			g.dispose();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}	
	}

	/**
	 * Instantiates a new white summon tile.
	 *
	 * @param posx the posx
	 * @param posy the posy
	 * @param gc the gc
	 * @param p the the player whom's summon tile it becomes
	 */
	WhiteSummonTile(int posx, int posy, GameController gc, Player p) 
	{
		super(posx, posy, gc);
		p.setWhiteSummon(this);
		button = new MapButton(this,background);
		
	}

}
