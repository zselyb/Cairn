import java.io.Serializable;

/**
 * The Class Map.
 */
public class Map 
{
	
	/** The map. */
	MapTile map[][] = new MapTile[7][7];
	
	/** The controller. */
	GameController controller;
	
	
	/**
	 * Instantiates a new map.
	 *
	 * @param p1 the p 1
	 * @param p2 the p 2
	 * @param gc the gc
	 */
	Map(Player p1,Player p2, GameController gc)
	{
		controller = gc;
		map[2][1] = new BlackSummonTile(2,1,controller,p1);
		map[4][5] = new BlackSummonTile(4,5,controller,p2);
		map[4][1] = new WhiteSummonTile(4,1,controller,p1);
		map[2][5] = new WhiteSummonTile(2,5,controller,p2);
		map[2][3] = new MegalithStartTile(2,3,controller);
		map[4][3] = new MegalithStartTile(4,3,controller);
		map[0][1] = new NotPlayableTile(0,1,controller);
		map[0][2] = new NotPlayableTile(0,2,controller);
		map[0][3] = new NotPlayableTile(0,3,controller);
		map[0][4] = new NotPlayableTile(0,4,controller);
		map[0][5] = new NotPlayableTile(0,5,controller);
		map[6][1] = new NotPlayableTile(6,1,controller);
		map[6][2] = new NotPlayableTile(6,2,controller);
		map[6][3] = new NotPlayableTile(6,3,controller);
		map[6][4] = new NotPlayableTile(6,4,controller);
		map[6][5] = new NotPlayableTile(6,5,controller);
		map[0][6] = new VillageTile(0,6,controller,p2);
		map[1][6] = new VillageTile(1,6,controller,p2);
		map[2][6] = new VillageTile(2,6,controller,p2);
		map[3][6] = new VillageTile(3,6,controller,p2);
		map[4][6] = new VillageTile(4,6,controller,p2);
		map[5][6] = new VillageTile(5,6,controller,p2);
		map[6][6] = new VillageTile(6,6,controller,p2);
		map[0][0] = new VillageTile(0,0,controller,p1);
		map[1][0] = new VillageTile(1,0,controller,p1);
		map[2][0] = new VillageTile(2,0,controller,p1);
		map[3][0] = new VillageTile(3,0,controller,p1);
		map[4][0] = new VillageTile(4,0,controller,p1);
		map[5][0] = new VillageTile(5,0,controller,p1);
		map[6][0] = new VillageTile(6,0,controller,p1);
		
		for(int i= 0; i < 7; i++)
		{
			for(int j= 0; j < 7; j++)
			{
				if(map[i][j] == null)
					map[i][j] = new BasicTile(i,j, controller);
			}
		}
		try {
			map[1][1].addShaman(p1.getShaman());
			map[3][1].addShaman(p1.getShaman());
			map[5][1].addShaman(p1.getShaman());
			map[1][5].addShaman(p2.getShaman());
			map[3][5].addShaman(p2.getShaman());
			map[5][5].addShaman(p2.getShaman());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Index.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the map tile
	 */
	MapTile index(int x, int y)
	{
		return map[x][y];
	}
	
	/**
	 * Removes the highlight.
	 */
	void removeHighlight()
	{
		for(int i= 0; i < 7; i++)
		{
			for(int j= 0; j < 7; j++)
			{
				map[i][j].setSelectable(false);
			}
		}
	}
	
	/**
	 * Gets the row.
	 *
	 * @param index the index
	 * @return the row
	 */
	MapTile[] getRow(int index)
	{
		return map[index];
	}
	
}
