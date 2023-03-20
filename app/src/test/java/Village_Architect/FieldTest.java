package Village_Architect.model;

import Village_Architect.controller.*;
import Village_Architect.model.*;
import Village_Architect.model.buildings.*;
import org.junit.*;
import static org.junit.Assert.*;


public class FieldTest{
	
   @Test
	public void isGridSpaceTest () {
		Field test = new Field();
      boolean isGridSpace = (test instanceof GridSpace);
      assertTrue("Expecting Field should be a Gridspace object", isGridSpace);
	}
   
   @Test
   public void testStoneCost(){
      Field test = new Field();
      int stoneCost = test.getStoneCost();
      assertEquals("Expected 0", stoneCost, 0);
   }
   
   @Test
   public void testStoneRate(){
      Field test = new Field();
      int stoneRate = test.getStoneRate();
      assertEquals("Expected 0", stoneRate, 0);
   }
   
   @Test
   public void testWoodCost(){
      Field test = new Field();
      int woodCost = test.getWoodCost();
      assertEquals("Expected 0", woodCost, 0);
   }

   @Test
   public void testWoodRate(){
      Field test = new Field();
      int woodRate = test.getWoodRate();
      assertEquals("Expected 0", woodRate, 0);
   }
   
   @Test
   public void testBuildingType(){
      Field test = new Field();
      String buildingType = test.getBuildingType();
      assertTrue("Expected 'field'", buildingType.equals("field"));
   }
   
   @Test
   public void testIsDemolishable(){
      Field test = new Field();
      boolean demolishable = test.isDemolishable();
      assertTrue("Expected False", !demolishable);
   }

}
