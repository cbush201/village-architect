package Village_Architect.view;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.border.MatteBorder;
import java.awt.event.*;
import java.net.URL;

public class StartScreenGUI {
	
	JFrame screen;
   JLabel title;
   JPanel buttonHolder;
   JButton newGameButton, loadGameButton;
   JTextField sizeInput;
    
   
   public StartScreenGUI(){
      
      screen = new JFrame("Village Architect");
      screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      screen.setPreferredSize(new Dimension(600,400));
      screen.setLayout(new BorderLayout());

      screen.getContentPane().setBackground(new Color(3, 163, 19));
      screen.setVisible(true);
      
      //Adding Title to the Frame
      title = new JLabel("Village Architect", JLabel.CENTER);
      title.setLocation(200,50);
      title.setFont(new Font("Courier", Font.BOLD, 20));
      screen.add(title, BorderLayout.NORTH);
      
      //creating button holder
      buttonHolder = new JPanel();
      buttonHolder.setLayout(new GridLayout(2,1));
      buttonHolder.setPreferredSize(new Dimension(300,300));
      
      //creating buttons and adding them to button Holder
      newGameButton = new JButton("New Game");
      newGameButton.setPreferredSize(new Dimension(150,150));
      
      
      loadGameButton = new JButton("Load Game");
      loadGameButton.setPreferredSize(new Dimension(150,150));
      
      buttonHolder.add(newGameButton);
      buttonHolder.add(loadGameButton);
      
      screen.add(buttonHolder, BorderLayout.CENTER);
      
      sizeInput = new JTextField("Input Size of you village (Only if creating a new village) (Min of 5 and max of 10)");
      
      screen.add(sizeInput, BorderLayout.SOUTH);
      screen.pack();
      
      
      
      
   }
   
   public void addNewGameListener(ActionListener l){
      newGameButton.addActionListener(l);
   }
   
   public void addLoadGameListener(ActionListener l){
      loadGameButton.addActionListener(l);
   }
   
   public void close(){
      screen.dispose();
   }
   
   public int getSize(){
      return Integer.parseInt(sizeInput.getText());
   }
}

