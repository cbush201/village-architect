package Village_Architect.model;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import Village_Architect.model.buildings.*;

public class GameLoaderCSV
{

    public Player loadPlayer(File fileName)
    {
        try
        {
            Village playerVillage = loadVillage(fileName);

            Scanner scanner = new Scanner(fileName);

            //Moving the Scanner to the appropriate Section of the CSV
            while (scanner.hasNextLine())
            {
                String playerCheck = scanner.nextLine();
                if(playerCheck.equalsIgnoreCase("Player"))
                    break;
            }

            int playerWood = Integer.parseInt(scanner.nextLine());
            int playerStone = Integer.parseInt(scanner.nextLine());
            int playerWoodRate = Integer.parseInt(scanner.nextLine());
            int playerStoneRate = Integer.parseInt(scanner.nextLine());
            int lastSaveTime = Integer.parseInt(scanner.nextLine());

            int timePassedMultiplier = (int)(((System.currentTimeMillis() / 1000) - lastSaveTime) / 10);
            playerWood += playerWoodRate * timePassedMultiplier;
            playerStone += playerStoneRate * timePassedMultiplier;

            return new Player(playerVillage.getSize(), playerStone, playerWood, playerStoneRate, playerWoodRate, playerVillage);

        }
        catch(IOException e)
        {
            System.out.println("A loader Error Occurred loading Player. File Not Found or Formatted Incorrectly");
        }

        return null;
    }

    public Village loadVillage(File fileName)
    {
        try
        {
            Scanner scanner = new Scanner(fileName);
            //Check File Format for Village Section
            String villageCheck = scanner.nextLine();
            if (!villageCheck.equalsIgnoreCase("Village"))
                throw new IOException();

            //Iterates through Building types on file and sets up a village Accordingly
            
            Village loadedVillage = new Village(Integer.parseInt(scanner.nextLine()));

            for (int i = 0; i < loadedVillage.getSize(); i++)
            {
                String[] buildings = scanner.nextLine().split(",");
                for (int j = 0; j < loadedVillage.getSize(); j++)
                {
                    loadedVillage.setSpace(loadGridSpaceType(buildings[j]), j, i);
                }
            }

            return loadedVillage;
        }
        catch (IOException e)
        {
            System.out.println("A loader Error Occurred loading Village. File Not Found or Formatted Incorrectly");
        }



        System.out.println("GameLoaderCSV::Load Village");
        return null;
    }

    public GridSpace loadGridSpaceType(String str)
    {
        if (str.equalsIgnoreCase("field"))
            return new Field();
        else if (str.contains("generator"))
        {
            if (str.equals("generatorWood")) return new LumberYard();
            else if (str.equals("generatorStone")) return new Mine();
            else if (str.equals("generatorCombo")) return new TownHall();
            else if (str.equals("generatorFinal")) return new Castle();
         
        }
        else if (str.contains("obstacle"))
        {
            if (str.equals("obstacleWood"))
                return new Tree();
            else if (str.equals("obstacleStone"))
                return new Rock();
        }

        return null;
    }
}
