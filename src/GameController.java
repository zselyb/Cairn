import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * The Class GameController.
 */
public class GameController 
{
	
	/** The player 1. */
	Player player1;
	
	/** The player 2. */
	Player player2;
	
	/** The active player. */
	Player activePlayer;
	
	/** The map. */
	Map map;
	
	/** The move action. */
	Action moveAction;
	
	/** The summon action. */
	Action summonAction;
	
	/** The jump action. */
	Action jumpAction;
	
	/** The selected action. */
	Action selectedAction;
	
	/** The transformation effect. */
	TransformationEffect transformationEffect;
	
	/** The selected tile. */
	MapTile selectedTile;
	
	/** The megalith target. */
	MapTile megalithTarget;
	
	/** The active megalith. */
	Megalith activeMegalith;
	
	/** The megalith deck. */
	List<Megalith> megalithDeck;
	
	/** The mb 1. */
	MegalithButton mb1;
	
	/** The mb 2. */
	MegalithButton mb2;
	
	/** The frame. */
	GameFrame frame;
	
	/** The flipped action. */
	boolean flippedAction;
	
	/**
	 * Instantiates a new game controller.
	 *
	 * @param p1 the p 1
	 * @param p2 the p 2
	 */
	GameController(Player p1, Player p2)
	{
		player1 = p1;
		player2 = p2;
		Random r = new Random();
		int temp = r.nextInt(0, 2);
		if(temp == 0)
		{
			activePlayer = player1;
		}
		else
		{
			activePlayer = player2;
		}
		moveAction = new MoveAction(this);
		summonAction = new SummonAction(this);
		jumpAction = new JumpAction(this);
		transformationEffect = new TransformationEffect(this);
		selectedAction = null;
		selectedTile = null;
		megalithDeck = new ArrayList<Megalith>();
		megalithDeck.add(new AlleyofDusk(this));
		megalithDeck.add(new CairnofDawn(this));
		megalithDeck.add(new ChaosoftheGiants(this));
		megalithDeck.add(new CromlechoftheStars(this));
		megalithDeck.add(new MenhiroftheDancers(this));
		megalithDeck.add(new PillarsofSpring(this));
		Collections.shuffle(megalithDeck);
		mb1 = new MegalithButton(this,megalithDeck.remove(0));
		mb2 = new MegalithButton(this,megalithDeck.remove(0));
		map = new Map(player1, player2, this);
		megalithDeck.add(new AlleyofDusk(this));
		megalithDeck.add(new CairnofDawn(this));
		megalithDeck.add(new ChaosoftheGiants(this));
		megalithDeck.add(new CromlechoftheStars(this));
		megalithDeck.add(new MenhiroftheDancers(this));
		megalithDeck.add(new PillarsofSpring(this));
		megalithTarget = null;
		activeMegalith = null;
		frame = new GameFrame(this);
		flippedAction = false;
		frame.text(activePlayer.getName()+"'s turn: choose action");
		frame.blueScore(player1.getScore());
		frame.brownScore(player2.getScore());
	}
	
	/**
	 * Gets the map.
	 *
	 * @return the map
	 */
	Map getMap()
	{
		return map;
	}
	
	/**
	 * Gets the active player.
	 *
	 * @return the active player
	 */
	Player getActivePlayer()
	{
		return activePlayer;
	}
	
	/**
	 * Gets the move action.
	 *
	 * @return the move action
	 */
	Action getMoveAction()
	{
		return moveAction;
	}
	
	/**
	 * Gets the summon action.
	 *
	 * @return the summon action
	 */
	Action getSummonAction()
	{
		return summonAction;
	}
	
	/**
	 * Gets the jump action.
	 *
	 * @return the jump action
	 */
	Action getJumpAction()
	{
		return jumpAction;
	}
	
	/**
	 * Gets the button 1.
	 *
	 * @return the button 1
	 */
	MegalithButton getButton1()
	{
		return mb1;
	}
	
	/**
	 * Gets the button 2.
	 *
	 * @return the button 2
	 */
	MegalithButton getButton2()
	{
		return mb2;
	}
	
	/**
	 * Sets the selected action.
	 *
	 * @param a the new selected action
	 */
	void setSelectedAction(Action a)
	{
		selectedAction = a;
		map.removeHighlight();
		frame.text(activePlayer.getName()+"'s turn: choose shaman");
		selectedTile = null;
	}
	
	/**
	 * Gets the transformation effect.
	 *
	 * @return the transformation effect
	 */
	TransformationEffect getTransformationEffect()
	{
		return transformationEffect;
	}
	
	/**
	 * Sets the active megalith.
	 *
	 * @param m the new active megalith
	 */
	void setActiveMegalith(Megalith m)
	{
		activeMegalith = m;
		if(activeMegalith != null)
			activeMegalith.selection(map);
	}
	
	/**
	 * Clicked.
	 *
	 * @param clickedTile the clicked tile
	 */
	void clicked(MapTile clickedTile)
	{
		if(megalithTarget == null)
		{
			if(activeMegalith == null)
			{
				if(selectedAction != null && selectedTile == null && clickedTile.getShaman() != null && clickedTile.getShaman().getPlayer() == activePlayer)
				{
					selectedTile = clickedTile;
					frame.text(activePlayer.getName()+"'s turn: perform action");
					selectedAction.selection(selectedTile, activePlayer, map);
				}
				else if(selectedAction != null  && selectedTile != null)
				{
					map.removeHighlight();
					selectedAction.doAction(selectedTile, clickedTile, activePlayer, map);
					selectedAction = null;
					frame.text(activePlayer.getName()+"'s turn: choose action");
				}
			}
			else
			{
				map.removeHighlight();
				activeMegalith.doAction(clickedTile);
				selectedAction = null;
				if(activeMegalith != null)
					activeMegalith.selection(map);
			}
			if(checkEndTurn())
			{
				if(transformationEffect.checkTransformation())
				{
					transformationEffect.doAction(clickedTile);
				}
				else
				{
					endTurn();
				}
			}
			if(activeMegalith != null)
				frame.text(activeMegalith.getPlayer().getName()+"'s turn: perform megalith's action");
			if(megalithTarget != null)
				frame.text(activePlayer.getName()+"'s turn: choose megalith to place");
		}
		else
		{
			frame.text(activePlayer.getName()+"'s turn: choose megalith to place");
		}
	}
	
	/**
	 * Clicked.
	 *
	 * @param megalithButton the megalith button
	 */
	public void clicked(MegalithButton megalithButton) 
	{
		if(megalithTarget != null)
		{
			megalithTarget.addMegalith(megalithButton.getMegalith());
			megalithTarget=null;
			endTurn();
		}
	}
	
	/**
	 * Place megalith.
	 *
	 * @param clickedTile the clicked tile
	 */
	void placeMegalith(MapTile clickedTile) 
	{
		megalithTarget = clickedTile;
		activePlayer.increaseScore();
		frame.blueScore(player1.getScore());
		frame.brownScore(player2.getScore());
		frame.text(activePlayer.getName()+"'s turn: choose megalith");
		map.removeHighlight();
	}
	
	
	/**
	 * Check end turn.
	 *
	 * @return true, if successful
	 */
	boolean checkEndTurn() 
	{
		if (activeMegalith == null && megalithTarget == null)
			return flippedAction;
		return false;
	}

	/**
	 * Change player.
	 */
	void changePlayer()
	{
		if(activePlayer == player1)
		{
			activePlayer = player2;
		}
		else
		{
			activePlayer = player1;
		}
	}

	

	/**
	 * Check win.
	 */
	void checkWin() 
	{
		if(activePlayer.getScore() == 3) 
		{
			scoreadd(activePlayer);
			GameEndFrame winFrame = new GameEndFrame(activePlayer);
			frame.dispose();
		}
	}

	/**
	 * Scoreadd.
	 * Adds score to scoreboard
	 * @param player the winning player
	 */
	void scoreadd(Player player) 
	{
		PlayerList list;
		list = new PlayerList();
		try
		{
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("score.txt"));
			list.list = (ArrayList<NameScore>)is.readObject();
			is.close();
			for(NameScore i: list.list)
			{
				if(i.getName().equals(player.name))
				{
					i.setScore(i.getScore()+1);
					Collections.sort(list.list, (l1, l2) -> l2.getScore().compareTo(l1.getScore()));
			        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("score.txt"));
			        oos.writeObject(list.list);
			        oos.close();
			        return;
				}
			}
			list.addPlayer(player.name, 1);
			//Collections.sort(list.list, (l1, l2) -> l2.getScore().compareTo(l1.getScore()));
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("score.txt"));
			oos.writeObject(list.list);
			oos.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Gets the active megalith.
	 *
	 * @return the active megalith
	 */
	Megalith getActiveMegalith() 
	{
		return activeMegalith;
	}

	/**
	 * Sets the flipped action.
	 *
	 * @param b the new flipped action
	 */
	void setFlippedAction(boolean b)
	{
		flippedAction = b;
	}

	/**
	 * End turn.
	 */
	void endTurn() 
	{
		map.removeHighlight();
		checkWin();
		changePlayer();
		selectedAction = null;
		selectedTile = null;
		activeMegalith = null;
		flippedAction = false;
		frame.text(activePlayer.getName()+"'s turn: choose action");
	}

	/**
	 * Gets the megalith.
	 *
	 * @return the megalith
	 */
	public Megalith getMegalith() 
	{
		return megalithDeck.remove(0);
	}



	
}
