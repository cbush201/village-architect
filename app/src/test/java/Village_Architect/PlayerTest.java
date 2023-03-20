package Village_Architect;

import Village_Architect.controller.*;
import Village_Architect.model.*;
import Village_Architect.model.buildings.*;
import org.junit.*;
import static org.junit.Assert.*;

public class PlayerTest{

   @Test
   public void testBuildInvalid(){
      Player p = new Player();
      
      assertTrue(!p.build(new Mine(), 1,1));
      
   }

}
