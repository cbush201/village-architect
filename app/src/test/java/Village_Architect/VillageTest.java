package Village_Architect;

import Village_Architect.controller.*;
import Village_Architect.model.*;
import Village_Architect.model.buildings.*;
import org.junit.*;
import static org.junit.Assert.*;

public class VillageTest{

   @Test
   public void testConstructor(){
      Village v = new Village(5);
      assertTrue(v instanceof Village);
      
   }
   
   public void testSpaceManipulation(){
      Village v = new Village(5);
      v.setSpace(new Mine(), 1, 1);
      
      assertTrue(v.getSpace(1,1) instanceof Mine);
      
   }
   

}
