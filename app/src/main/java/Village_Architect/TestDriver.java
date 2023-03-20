package Village_Architect;

import Village_Architect.view.*;
import Village_Architect.model.*;
import Village_Architect.model.buildings.*;
import Village_Architect.controller.*;
import java.awt.event.*;
import javax.swing.JButton;

public class TestDriver{

   public static void main(String []args){
         // GUI Object
      
      //Game objects
      Player p = new Player(5);
      //Village v = new Village(5);
      GameLoaderCSV loader = new GameLoaderCSV();
      GameSaverCSV saver = new GameSaverCSV();
      VillageGUI gui = new VillageGUI(5);
      
      //Game controller
      GameController controller = new GameController();
      
      StartScreenGUI test = new StartScreenGUI();
      /*
      test.addNewGameSmallListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            
            controller.onNewGame(5);
         }
      });
      
      test.addNewGameBigListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            
            controller.onNewGame(10);
         }
      }
      
      test.addLoadGameListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            controller.onLoad();
         }
      
      });
      */
      
      //VillageGUI gui = new VillageGUI(5); 
      //Game controller
      //GameController controller = new GameController(p, v, gui, loader, saver);
      
      /*
      //Connect ...?
      gui.addVillageListeners(new ActionListener(){
           
         public void actionPerformed(ActionEvent e){
            System.out.println(e.getActionCommand());
            String[] space = e.getActionCommand().split(",");
            controller.onGridSelection(Integer.parseInt(space[0]), Integer.parseInt(space[1]));
            
         }
      });
      
      
      //Connect Mine button with use case.
      gui.addMineListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
             controller.onBuildingSelection("mine");
             System.out.println(e.getActionCommand());
         }
      });
      //Connect Save button with use case.
      gui.addSaveListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
             controller.onSave();
             System.out.println(e.getActionCommand());
         }
      });
      //Connect Demolish button with use case.
      gui.addDemolishListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
             controller.onDemolish();
             System.out.println(e.getActionCommand());
         }
      });
      //Connect Lumberyard button with use case.
      gui.addLumberYardListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
             controller.onBuildingSelection("lumberyard");
             System.out.println(e.getActionCommand());
         }
      });
      
      //v.setSpace(new Mine(), 1, 1);
      gui.updateDisplay(p);
      */
   }
}
