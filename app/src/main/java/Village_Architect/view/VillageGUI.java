package Village_Architect.view;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.border.MatteBorder;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;
import java.io.File;
import javax.imageio.ImageIO;

import Village_Architect.model.*;
import Village_Architect.model.buildings.*;
import Village_Architect.controller.*;


public class VillageGUI implements GameUserInterface
{
   private JFrame f;
   private JPanel buildingBar, village, stats, productionReadout;
   private JLabel woodLabel, stoneLabel, woodProduction, stoneProduction;
   private int size;
   private JButton[][] tiles;
   private JButton mine, lumberYard, castle, townHall, save, demolish;
   
   
   public VillageGUI(int s){
      
      this.size = s;
      
      
      
      int height = 1000;
      int length = 1400;
      
      int sidebarLength = length - height;
      
      //Jframe initialization
      f = new JFrame("village Simulator");
      
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setSize(new Dimension(length + 15,height + 35));
      //f.setResizable(false);
      
      
      //Village panel initialization
      village = new JPanel();
      village.setLayout(new GridLayout(size,size, 0, 0));
      village.setBackground(new Color(0,153, 51));
      village.setSize(new Dimension(height,height));
      village.setLocation(sidebarLength,0);
      
      //Creating the array that holds all the buttons in the village.
      tiles = new JButton[size][size];
      for (int n = 1; n <= size; n++){
         for(int i = 1; i <= size; i++){
            String title = Integer.toString(n) + ',' + Integer.toString(i);
            JButton temp = new JButton();
            temp.setActionCommand(title);
            temp.setBackground(new Color(25,186,0));
            tiles[i-1][n-1] = temp;
         }
      }
      
      
      drawVillage();
      f.add(village);
         
      //Resource bar initialization;
      stats = new JPanel(new GridLayout(2,1));
      stats.setSize(new Dimension(sidebarLength, height/10));
      stats.setLocation(0,0);
      
      woodLabel = new JLabel("Wood: 0");
      woodLabel.setOpaque(true);
      woodLabel.setHorizontalAlignment(JLabel.CENTER);
      woodLabel.setBackground(new Color(175,121,51));
      
      
      stoneLabel = new JLabel("Stone: 20");
      stoneLabel.setOpaque(true);
      stoneLabel.setHorizontalAlignment(JLabel.CENTER);
      stoneLabel.setBackground(Color.lightGray);
      
      stats.add(woodLabel);
      stats.add(stoneLabel);
      
      f.add(stats);
      
      
      //Defining the area with the Building Buttons
      buildingBar = new JPanel();
      buildingBar.setLayout(new GridLayout(8, 1));
      buildingBar.setBackground(new Color(102,204,255));
      buildingBar.setSize(new Dimension(sidebarLength, height - (stats.getHeight()*2)));
      buildingBar.setLocation(0,stats.getHeight());
      buildingBar.setOpaque(true);
     
      
      lumberYard = new JButton("Lumber Yard: 100 Wood");
      URL tempResource = this.getClass().getClassLoader().getResource("lumberyard.png");
      lumberYard.setIcon(new ImageIcon(tempResource));
      lumberYard.setBackground(Color.gray);
      lumberYard.setHorizontalAlignment(SwingConstants.LEFT);
      lumberYard.setBorder(new MatteBorder(2,2,2,2, Color.black));
      buildingBar.add(lumberYard);
      
      
      mine = new JButton("Mine: 100 Stone    ");
      //mine.setSize(new Dimension(180, 90));
      //mine.setLocation(10,200);
      
      tempResource = this.getClass().getClassLoader().getResource("mine.png");
      mine.setIcon(new ImageIcon(tempResource));
      mine.setHorizontalAlignment(SwingConstants.LEFT);
      mine.setBackground(Color.gray);
      mine.setBorder(new MatteBorder(2,2,2,2, Color.black));

      
      demolish = new JButton("Demolish");
      //demolish.setSize(new Dimension(180, 90));
      //demolish.setLocation(10,300);
      tempResource = this.getClass().getClassLoader().getResource("demolish.png");
      demolish.setIcon(new ImageIcon(tempResource));
      demolish.setHorizontalAlignment(SwingConstants.LEFT);
      demolish.setBackground(Color.gray);
      demolish.setBorder(new MatteBorder(2,2,2,2, Color.black));

      
      save = new JButton("Save");
      //save.setSize(new Dimension(180, 90));
      //save.setLocation(10,300);
      tempResource = this.getClass().getClassLoader().getResource("save.png");
      save.setHorizontalAlignment(SwingConstants.LEFT);
      save.setIcon(new ImageIcon(tempResource));
      save.setBackground(Color.gray);
      save.setBorder(new MatteBorder(2,2,2,2, Color.black));

      
      castle = new JButton("Castle: 250000 Wood, 250000 Stone");
      tempResource = this.getClass().getClassLoader().getResource("castle.png");
      castle.setIcon(new ImageIcon(tempResource));
      castle.setHorizontalAlignment(SwingConstants.LEFT);
      castle.setBackground(Color.gray);
      castle.setBorder(new MatteBorder(2,2,2,2, Color.black));
      
      
      townHall = new JButton("Town Hall: 100000 Wood, 100000 Stone");
      tempResource = this.getClass().getClassLoader().getResource("townhall.png");
      townHall.setIcon(new ImageIcon(tempResource));
      townHall.setHorizontalAlignment(SwingConstants.LEFT);
      townHall.setBackground(Color.gray);
      townHall.setBorder(new MatteBorder(2,2,2,2, Color.black));
      
      buildingBar.add(mine);
      buildingBar.add(lumberYard);
      buildingBar.add(townHall);
      buildingBar.add(castle);
      buildingBar.add(demolish);
      buildingBar.add(save);
      
      
      f.add(buildingBar);
      
      
      //Production Readouts
      woodProduction = new JLabel();
      woodProduction.setBackground(Color.black);
      woodProduction.setForeground(Color.white);
      woodProduction.setOpaque(true);
      woodProduction.setFont(new Font("Courier", Font.PLAIN, sidebarLength/25));
      
      stoneProduction = new JLabel();
      stoneProduction.setBackground(Color.black);
      stoneProduction.setForeground(Color.white);
      stoneProduction.setOpaque(true);
      stoneProduction.setFont(new Font("Courier", Font.PLAIN, sidebarLength/25));
      
      productionReadout = new JPanel();
      productionReadout.setLayout(new GridLayout(2,1));
      
      productionReadout.add(woodProduction);
      productionReadout.add(stoneProduction);
      
      
      productionReadout.setSize(new Dimension(sidebarLength, height/10));
      productionReadout.setLocation(0, height - height/10);
      
      f.add(productionReadout);
      
      f.add(new JPanel());
      
      f.setVisible(true);
     
   }
   
   private void drawVillage(){
      for(int j = 0; j < size; j++){
         for(int i = 0; i < size; i++){
         village.add(tiles[j][i]);
         }
      }
   }
   
   public void addVillageListeners(ActionListener l){
      for (JButton[] b: tiles){
         for(JButton button: b){
            button.addActionListener(l);
         }
      }
   }
   
   public void addMineListener(ActionListener l){
      mine.addActionListener(l);
   }
   
   public void addLumberYardListener(ActionListener l){
      lumberYard.addActionListener(l);
   }
   
   public void addSaveListener(ActionListener l){
      save.addActionListener(l);
   }
   
   public void addDemolishListener(ActionListener l){
      demolish.addActionListener(l);
   }
   
   public void addCastleListener(ActionListener l){
      castle.addActionListener(l);
   }
   
   public void addTownHallListener(ActionListener l){
      townHall.addActionListener(l);
   }
   
   
   private void showVillage(Village v){
      //temp GridSpace for iterating 
      GridSpace space;
      int width = tiles[0][0].getWidth();
      int height = tiles[0][0].getHeight();
      
      //Using nested loops, iterate through the Village and set the button to display the correct object.
      for(int j = 0; j < size; j++){
         for(int i = 0; i < size; i++){
            space = v.getSpace(i,j);
            //If-else chain to see what object the gridspace is
            if(space instanceof Field){
               tiles[j][i].setBackground(new Color(25,186,0));
               tiles[j][i].setIcon(null);
            }else if(space instanceof Mine){
               URL resource = this.getClass().getClassLoader().getResource("mine.png");
               tiles[j][i].setIcon(new ImageIcon(resource));
            }else if(space instanceof LumberYard){
               URL resource = this.getClass().getClassLoader().getResource("lumberyard.png");
               tiles[j][i].setIcon(new ImageIcon(resource));
            }else if(space instanceof Tree){
               URL resource = this.getClass().getClassLoader().getResource("tree.png");
               tiles[j][i].setIcon(new ImageIcon(resource));
            }else if(space instanceof Rock){
               URL resource = this.getClass().getClassLoader().getResource("rock.png");
               tiles[j][i].setIcon(new ImageIcon(resource));
            }else if(space instanceof Castle){
               URL resource = this.getClass().getClassLoader().getResource("castle.png");
               tiles[j][i].setIcon(new ImageIcon(resource));
            }else if(space instanceof TownHall){
               URL resource = this.getClass().getClassLoader().getResource("townhall.png");
               tiles[j][i].setIcon(new ImageIcon(resource));
            }
            
         }
      }
   }
   
   public void updateDisplay(Player p){
      
      
      
      woodLabel.setText("Wood: " + Integer.toString(p.getTotalWood()));
      
      stoneLabel.setText("Stone: " + Integer.toString(p.getTotalStone()));
      
      
      stoneProduction.setText("Stone Production: " + Integer.toString(p.getTotalStoneRate()) + " per 5 seconds");
      
      woodProduction.setText("Wood Production: " + Integer.toString(p.getTotalWoodRate()) + " per 5 seconds");
      
      showVillage(p.getPlayerVillage());
      
      
   }
   

}
