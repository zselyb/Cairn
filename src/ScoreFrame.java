import java.awt.BorderLayout;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 * The Class ScoreFrame.
 */
public class ScoreFrame extends JFrame
{
	
	/** The list. */
	PlayerList list = new PlayerList();
	
	/**
	 * Instantiates a new score frame.
	 */
	ScoreFrame()
	{

		try
		{
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("score.txt"));
			list.list = ((ArrayList<NameScore>)is.readObject());
			is.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		setSize(500,500);
		JPanel panel = new JPanel();
		JTable table = new JTable(list);
		table.setFillsViewportHeight(true);
		panel.add(table);
		add(panel, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
