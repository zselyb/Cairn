import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * The Class BlackSummonTile.
 * It mainly differs from the MapTile in backgound and sets itself as a players BlackSummonTile
 * When performing the Summon action it requests the corresponding tile from the player
 */
public class BlackSummonTile extends MapTile 
{
	
	/** The background. */
	static BufferedImage background = new BufferedImage(100,100, BufferedImage.TYPE_INT_ARGB_PRE);
	static 
	{
		try 
		{
			Graphics2D g = background.createGraphics();
			g.drawImage(ImageIO.read(new File("BlackSummonTile.png")), 0, 0, null);
			g.dispose();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Instantiates a new black summon tile.
	 *
	 * @param posx the posx
	 * @param posy the posy
	 * @param gc the GameController
	 * @param p the player whom's summon tile it becomes
	 */
	BlackSummonTile(int posx, int posy, GameController gc, Player p) 
	{
		super(posx, posy, gc);
		p.setBlackSummon(this);
		button = new MapButton(this,background);
	}
}
