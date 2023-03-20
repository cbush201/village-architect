package Village_Architect.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GameSaverCSV
{
    public void saveVillage(String fileName, Player p)
    {
        String userFile = fileName + ".csv";
        Village village = p.getPlayerVillage();
        File userSave = new File(userFile);
        String arrayString = "";

        //Creating the Lines of Strings to define the village in the CSV
        for (int i = 0; i < village.getSize(); i++)
        {
            for (int j = 0; j < village.getSize(); j++)
            {
                arrayString += village.getSpace(j,i).buildingType + ",";
            }
            arrayString += "\n";
        }

        try
        {
            FileWriter fileWriter = new FileWriter(userFile, false);
            fileWriter.write("Village\n");
            fileWriter.write(village.getSize() + "\n");
            fileWriter.write(arrayString);
            fileWriter.write("Player\n");
            fileWriter.write(p.getTotalWood() + "\n");
            fileWriter.write(p.getTotalStone() + "\n");
            fileWriter.write(p.getTotalWoodRate() + "\n");
            fileWriter.write(p.getTotalStoneRate() + "\n");
            fileWriter.write(String.valueOf((System.currentTimeMillis() / 1000)));
            fileWriter.close();
        }
        catch(IOException e)
        {
            System.out.println("An Error Occurred.");
            e.printStackTrace();
        }
    }
}
