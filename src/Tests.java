import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Tests
{
	GameController controller;
	Map map;

	
		@Before
		public void setup()
		{
			controller = new GameController(new Player(PlayerColor.BLUE,"testblue"),new Player(PlayerColor.BROWN,"testbrown"));
			map = controller.getMap();
		}
	
		@Test
		public void test1() 
		{
			assertEquals(controller.getActiveMegalith(),null);
			assertTrue(!controller.checkEndTurn());
		}
		
		@Test
		public void test2()
		{
			map.index(1, 1).banishShaman();
			assertEquals(map.index(1, 1).getShaman(),null);
		}
		
		@Test
		public void test3()
		{
			map.index(1, 1).addMegalith(new CairnofDawn(controller));
			assertEquals(map.index(1, 1).getMegalith().location,map.index(1, 1));
		}
		
		@Test
		public void test4()
		{
			controller.getActivePlayer().increaseScore();
			assertEquals(controller.getActivePlayer().getScore(),1);
		}

		@Test
		public void test5()
		{
			controller.getMoveAction().clicked();
			assertEquals(controller.getMoveAction(),controller.selectedAction);
		}
		
		@Test
		public void test6()
		{
			MoveAction move = new MoveAction(controller);
			move.type = MoveType.ORTOGONAL;
			controller.activePlayer = controller.player1;
			move.clicked();
			map.index(1, 1).clicked();
			map.index(1, 2).clicked();
			assertEquals(map.index(1, 2).getShaman().getPlayer(),controller.player1);
			assertEquals(map.index(1, 1).getShaman(),null);
		}
		@Test
		public void test7()
		{
			controller.activePlayer = controller.player1;
			SummonAction summon = new SummonAction(controller);
			summon.type = SummonType.BLACK;
			summon.clicked();
			assertEquals(controller.getActivePlayer(),controller.player2);
			assertEquals(map.index(2, 1).getShaman().getPlayer(),controller.player1);
		}
		
		@Test
		public void test8()
		{
			controller.placeMegalith(map.index(1, 1));
			controller.clicked(controller.getButton1());
			Assert.assertNotNull(map.index(1, 1).getMegalith());
		}
		@Test
		public void test9() throws Exception
		{
			JumpAction jump = new JumpAction(controller);
			controller.activePlayer = controller.player1;
			map.index(1, 2).addShaman(controller.activePlayer.getShaman());
			jump.type = JumpType.FRIENDLY;
			jump.clicked();
			map.index(1, 1).clicked();
			map.index(1, 3).clicked();
			assertEquals(map.index(1, 3).getShaman().getPlayer(),controller.player1);
			assertEquals(map.index(1, 2).getShaman().getPlayer(),controller.player1);
			assertNull(map.index(1, 1).getShaman());
		}
		
		@Test
		public void test10() throws FileNotFoundException, IOException, ClassNotFoundException
		{
			map.index(1, 2).addMegalith(new AlleyofDusk(controller));
			controller.activePlayer =controller.player2;
			map.index(1, 2).getMegalith().activated();
			map.index(1, 2).getMegalith().doAction(map.index(1, 1));
			assertNull(map.index(1, 1).getShaman());
		}
		
		
		
		
		
}
