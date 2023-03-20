package Village_Architect.controller;

import Village_Architect.model.buildings.*;
import Village_Architect.model.*;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class GameController
{
    protected GameUserInterface userInterface;
    protected Player player;
    protected GameLoaderCSV loader;
    protected GameSaverCSV saver;
    
    private GridSpace selectedBuilding;
    private String action;
    
    public GameController()
    {
        this.userInterface = null;
        this.player = null;
        this.loader = new GameLoaderCSV();
        this.saver = new GameSaverCSV();
    }
    
    private void buildStructure(GridSpace gridSpace, int column, int row)
    {
        // setSpace?
        // player build
        boolean isBuilt = player.build(gridSpace, column, row);
        if (isBuilt){
            player.getPlayerVillage().setSpace(gridSpace, column, row);;
        }
    }
    
    public void onBuildingSelection(String buildingName)
    {
        action = "build";
        if (buildingName == "mine") // use strings to indicate which building type to add
        {
            selectedBuilding = new Mine();
        }
        else if (buildingName == "lumberyard")
        {
            selectedBuilding = new LumberYard();
        }
        
        else if (buildingName == "castle")
        {
            selectedBuilding = new Castle();
        }
        
        else if (buildingName == "townhall")
        {
            selectedBuilding = new TownHall();
        }
        // more else-if statements if additional buildings are included...
    }
    
    public void onGridSelection(int column, int row)
    {
        if (action == "build")
        {
            buildStructure(selectedBuilding, column, row);
        }
        else if (action == "demolish")
        {
            if (player.getPlayerVillage().getSpace(column, row).isDemolishable())
            {
                player.demolish(column, row);
                player.getPlayerVillage().setSpace(new Field(), column, row);
                System.out.println("Demolished");
            }
        }
        // check build logic and build or demolish structure
        // isDemolishable
        // setSpace?
        userInterface.updateDisplay(player);
    }
    
    public void onDemolish()
    {
        action = "demolish";    // set action to demolish for indication in onGridSelection.
    }
    
    public void onSave()
    {
        saver.saveVillage("GAMESAVE", player);
    }
    
    public void onLoad(File file)
    {
        this.player = loader.loadPlayer(file);
        //this.userInterface = new VillageGUI(
        userInterface.updateDisplay(player);
        startResourceGeneration(player);

    }
    
    public void onNewGame(int size)
    {
        
        player = new Player(size);
        player.addStone(100);
        player.addWood(100);
        startResourceGeneration(player);
        
        userInterface.updateDisplay(player);
    }
    
    public void addUI(GameUserInterface ui){
       this.userInterface = ui;
    }
    
    public void startResourceGeneration(Player player)
    {
        Timer timer = new Timer();
        int begin = 0;
        int timeInterval = 5000;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                player.addWood(player.getTotalWoodRate());
                player.addStone(player.getTotalStoneRate());
                userInterface.updateDisplay(player);
            }
        }, begin, timeInterval);
    }

}

