package Village_Architect.model;

import Village_Architect.controller.*;
import Village_Architect.model.*;
import Village_Architect.model.buildings.*;
import org.junit.*;
import static org.junit.Assert.*;

public class RockTest{
	
   @Test
	public void isGridSpaceTest () {
		Rock test = new Rock();
      boolean isGridSpace = (test instanceof GridSpace);
      assertTrue("Expecting Rock should be a Gridspace object", isGridSpace);
	}
   
   @Test
   public void testStoneCost(){
      Rock test = new Rock();
      int stoneCost = test.getStoneCost();
      assertEquals(-50, stoneCost);
   }
   
   @Test
   public void testStoneRate(){
      Rock test = new Rock();
      int stoneRate = test.getStoneRate();
      assertEquals(0, stoneRate);
   }
   
   @Test
   public void testWoodCost(){
      Rock test = new Rock();
      int woodCost = test.getWoodCost();
      assertEquals(0, woodCost);
   }

   @Test
   public void testWoodRate(){
      Rock test = new Rock();
      int woodRate = test.getWoodRate();
      assertEquals(0, woodRate);
   }
   
   @Test
   public void testBuildingType(){
      Rock test = new Rock();
      String buildingType = test.getBuildingType();
      assertTrue("Expected 'obstacle'", buildingType.equals("obstacle"));
   }
   
   @Test
   public void testIsDemolishable(){
      Rock test = new Rock();
      boolean demolishable = test.isDemolishable();
      assertTrue("Expected True", demolishable);
   }

}
