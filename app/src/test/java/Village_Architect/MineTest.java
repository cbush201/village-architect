package Village_Architect.model;

import Village_Architect.controller.*;
import Village_Architect.model.*;
import Village_Architect.model.buildings.*;
import org.junit.*;
import static org.junit.Assert.*;

public class MineTest{
	
   @Test
	public void isGridSpaceTest () {
		Mine test = new Mine();
      boolean isGridSpace = (test instanceof GridSpace);
      assertTrue("Expecting Mine should be a Gridspace object", isGridSpace);
	}
   
   @Test
   public void testStoneCost(){
      Mine test = new Mine();
      int stoneCost = test.getStoneCost();
      assertEquals(100, stoneCost);
   }
   
   @Test
   public void testStoneRate(){
      Mine test = new Mine();
      int stoneRate = test.getStoneRate();
      assertEquals(0, stoneRate);
   }
   
   @Test
   public void testWoodCost(){
      Mine test = new Mine();
      int woodCost = test.getWoodCost();
      assertEquals(0, woodCost);
   }

   @Test
   public void testWoodRate(){
      Mine test = new Mine();
      int woodRate = test.getWoodRate();
      assertEquals(10, woodRate);
   }
   
   @Test
   public void testBuildingType(){
      Mine test = new Mine();
      String buildingType = test.getBuildingType();
      assertTrue("Expected 'generator'", buildingType.equals("generator"));
   }
   
   @Test
   public void testIsDemolishable(){
      Mine test = new Mine();
      boolean demolishable = test.isDemolishable();
      assertTrue("Expected True", demolishable);
   }

}
