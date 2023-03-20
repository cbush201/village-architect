package Village_Architect.model;

import Village_Architect.controller.*;
import Village_Architect.model.*;
import Village_Architect.model.buildings.*;
import org.junit.*;
import static org.junit.Assert.*;

public class LumberYardTest{
	
   @Test
	public void isGridSpaceTest () {
		LumberYard test = new LumberYard();
      boolean isGridSpace = (test instanceof GridSpace);
      assertTrue("Expecting LumberYard should be a Gridspace object", isGridSpace);
	}
   
   @Test
   public void testStoneCost(){
      LumberYard test = new LumberYard();
      int stoneCost = test.getStoneCost();
      assertEquals("Expected 0", 0, stoneCost);
   }
   
   @Test
   public void testStoneRate(){
      LumberYard test = new LumberYard();
      int stoneRate = test.getStoneRate();
      assertEquals(0, stoneRate);
   }
   
   @Test
   public void testWoodCost(){
      LumberYard test = new LumberYard();
      int woodCost = test.getWoodCost();
      assertEquals("Expected 100", 100, woodCost);
   }

   @Test
   public void testWoodRate(){
      LumberYard test = new LumberYard();
      int woodRate = test.getWoodRate();
      assertEquals("Expected 10", 10, woodRate);
   }
   
   @Test
   public void testBuildingType(){
      LumberYard test = new LumberYard();
      String buildingType = test.getBuildingType();
      assertTrue("Expected 'generator'", buildingType.equals("generator"));
   }
   
   @Test
   public void testIsDemolishable(){
      LumberYard test = new LumberYard();
      boolean demolishable = test.isDemolishable();
      assertTrue("Expected True", demolishable);
   }

}
