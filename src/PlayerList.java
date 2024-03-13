import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 * The Class PlayerList.
 */
public class PlayerList extends AbstractTableModel
{
	
	/** The list. */
	ArrayList<NameScore> list = new ArrayList<>();
	
	
	/**
	 * Gets the column name.
	 *
	 * @param column the column
	 * @return the column name
	 */
	public String getColumnName(int column)
	{
		if(column == 0)
			return "name";
		return "score";
	}
	
	/**
	 * Gets the row count.
	 *
	 * @return the row count
	 */
	@Override
	public int getRowCount() {
		return list.size();
	}

	/**
	 * Gets the column count.
	 *
	 * @return the column count
	 */
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	/**
	 * Gets the value at.
	 *
	 * @param rowIndex the row index
	 * @param columnIndex the column index
	 * @return the value at
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) 
	{
		NameScore ns = list.get(rowIndex);
		if(columnIndex == 0)
			return ns.getName();
		return ns.getScore();
	}
	
	/**
	 * Adds the player.
	 *
	 * @param name the name
	 * @param score the score
	 */
	public void addPlayer(String name, int score)
	{
		list.add(new NameScore(name,score));
	}

	/**
	 * Sets the list.
	 *
	 * @param readObject the new list
	 */
	public void setList(ArrayList<NameScore> readObject) 
	{
		list = readObject;
	}

	/**
	 * Gets the list.
	 *
	 * @return the list
	 */
	public ArrayList<NameScore> getList() 
	{
		return list;
	}

}
