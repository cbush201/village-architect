package Village_Architect;

import Village_Architect.view.*;
import Village_Architect.model.*;
import Village_Architect.model.buildings.*;
import Village_Architect.controller.*;
import java.awt.event.*;
import javax.swing.JButton;
import java.io.File;
import java.lang.NumberFormatException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Driver{
   private static GameController controller;
   public static void main(String []args){
        
        
        controller = new GameController();
        
        StartScreenGUI startScreen = new StartScreenGUI();
        
        startScreen.addNewGameListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            try{
               int size = startScreen.getSize();
            
               if(size < 5) size = 5;
               else if (size > 10) size = 10;
            
               VillageGUI gameGUI = new VillageGUI(size);
               addGameListeners(gameGUI);
            
            
               controller.addUI(gameGUI);
               controller.onNewGame(size);
               startScreen.close();
               
         }
         catch (NumberFormatException ex){
               System.out.println("Invalid Size");
         }
            }
         });


         startScreen.addLoadGameListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){

               File gameFile = new File("GAMESAVE.csv");
               try {
                   if (gameFile.exists()) {
                       int gameSize = Integer.parseInt(Files.readAllLines(Paths.get("GAMESAVE.csv")).get(1));
                       VillageGUI gameGUI = new VillageGUI(gameSize);
                       addGameListeners(gameGUI);
                       controller.addUI(gameGUI);
                       controller.onLoad(new File("GAMESAVE.csv"));
                       startScreen.close();
                   }
               }
               catch (IOException ex)
               {
                   ex.printStackTrace();
               }
           }

       });
   }
   
   
   public static void addGameListeners(VillageGUI gui){
      
      gui.addVillageListeners(new ActionListener(){
           
         public void actionPerformed(ActionEvent e){
            //System.out.println(e.getActionCommand());
            String[] space = e.getActionCommand().split(",");
            controller.onGridSelection(Integer.parseInt(space[0]) - 1, Integer.parseInt(space[1]) - 1);
            
         }
      });
      
      //Connect Mine button with use case.
      gui.addMineListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
             controller.onBuildingSelection("mine");
             //System.out.println(e.getActionCommand());
         }
      });
      //Connect Save button with use case.
      gui.addSaveListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
             controller.onSave();
             //System.out.println(e.getActionCommand());
         }
      });
      //Connect Demolish button with use case.
      gui.addDemolishListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
             controller.onDemolish();
             //System.out.println(e.getActionCommand());
         }
      });
      //Connect Lumberyard button with use case.
      gui.addLumberYardListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
             controller.onBuildingSelection("lumberyard");
             //System.out.println(e.getActionCommand());
         }
      });
      
      gui.addCastleListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
             controller.onBuildingSelection("castle");
             //System.out.println(e.getActionCommand());
         }
      });
      
      gui.addTownHallListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
             controller.onBuildingSelection("townhall");
             //System.out.println(e.getActionCommand());
         }
      });
      
   }
}
