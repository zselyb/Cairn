import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * The Class TransformationButton.
 */
public class TransformationButton extends ActionButton
{

	/**
	 * Instantiates a new transformation button.
	 *
	 * @param a the a
	 */
	TransformationButton(TransformationEffect a) 
	{
		super(a);
		Graphics2D gs1 = side1Image.createGraphics();
		try {
			gs1.drawImage(ImageIO.read(new File("FormationEffectA.png")), 0, 0, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gs1.dispose();
		Graphics2D gs2 = side2Image.createGraphics();
		try {
			gs2.drawImage(ImageIO.read(new File("FormationEffectB.png")), 0, 0, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gs2.dispose();
		setSide1();
	}

}
