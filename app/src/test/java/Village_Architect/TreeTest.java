package Village_Architect.model;

import Village_Architect.controller.*;
import Village_Architect.model.*;
import Village_Architect.model.buildings.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TreeTest{
	
   @Test
	public void isGridSpaceTest () {
		Tree test = new Tree();
      boolean isGridSpace = (test instanceof GridSpace);
      assertTrue("Expecting Tree should be a Gridspace object", isGridSpace);
	}
   
   @Test
   public void testStoneCost(){
      Tree test = new Tree();
      int stoneCost = test.getStoneCost();
      assertEquals(0, stoneCost);
   }
   
   @Test
   public void testStoneRate(){
      Tree test = new Tree();
      int stoneRate = test.getStoneRate();
      assertEquals(0, stoneRate);
   }
   
   @Test
   public void testWoodCost(){
      Tree test = new Tree();
      int woodCost = test.getWoodCost();
      assertEquals(-50, woodCost);
   }

   @Test
   public void testWoodRate(){
      Tree test = new Tree();
      int woodRate = test.getWoodRate();
      assertEquals(0, woodRate);
   }
   
   @Test
   public void testBuildingType(){
      Tree test = new Tree();
      String buildingType = test.getBuildingType();
      assertTrue("Expected 'obstacle'", buildingType.equals("obstacle"));
   }
   
   @Test
   public void testIsDemolishable(){
      Tree test = new Tree();
      boolean demolishable = test.isDemolishable();
      assertTrue("Expected True", demolishable);
   }

}
