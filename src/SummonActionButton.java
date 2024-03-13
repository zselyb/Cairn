import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * The Class SummonActionButton.
 */
public class SummonActionButton extends ActionButton 
{
	
	/**
	 * Instantiates a new summon action button.
	 *
	 * @param a the a
	 */
	SummonActionButton(Action a) 
	{
		super(a);
		Graphics2D gs1 = side1Image.createGraphics();
		try {
			gs1.drawImage(ImageIO.read(new File("SummonActionBlack.png")), 0, 0, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gs1.dispose();
		Graphics2D gs2 = side2Image.createGraphics();
		try {
			gs2.drawImage(ImageIO.read(new File("SummonActionWhite.png")), 0, 0, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gs2.dispose();
		setSide1();
		// TODO Auto-generated constructor stub
	}
}
