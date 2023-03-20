package Village_Architect.model;

import Village_Architect.model.buildings.*;
public class Player
{
    private int playerVillageSize;
    private int totalStone;
    private int totalWood;
    private int totalStoneRate;
    private int totalWoodRate;
    private Village playerVillage;

    public Player(int playerVillageSize)
    {
        this.playerVillageSize = playerVillageSize;
        playerVillage = new Village(playerVillageSize);
        totalStone = 0;
        totalWood = 0;
        totalStoneRate = 0;
        totalStoneRate = 0;
    }

    public Player(int playerVillageSize, int totalStone, int totalWood, int totalStoneRate, int totalWoodRate, Village playerVillage)
    {
        this.playerVillageSize = playerVillageSize;
        this.totalStone = totalStone;
        this.totalWood = totalWood;
        this.totalStoneRate = totalStoneRate;
        this.totalWoodRate = totalWoodRate;
        this.playerVillage = playerVillage;
    }

    public boolean build(GridSpace g, int c, int r)
    {
        if (playerVillage.getSpace(c,r).getBuildingType().equals("field") && totalStone >= g.getStoneCost() && totalWood >= g.getWoodCost())
        {
            playerVillage.setSpace(g,c,r);
            totalWood -= g.getWoodCost();
            totalStone -= g.getStoneCost();
            totalStoneRate += g.getStoneRate();
            totalWoodRate += g.getWoodRate();
            return true;
        }
        return false;
    }

    public boolean demolish(int c, int r)
    {
        if (playerVillage.getSpace(c,r).isDemolishable()) {
            if (playerVillage.getSpace(c, r).getBuildingType().contains("obstacle"))
            {
                totalStone += playerVillage.getSpace(c, r).getStoneCost();
                totalWood += playerVillage.getSpace(c, r).getWoodCost();
                return true;
            }
            else if (playerVillage.getSpace(c, r).getBuildingType().contains("generator"))
            {
                totalStone += playerVillage.getSpace(c, r).getStoneCost() / 2;
                totalWood += playerVillage.getSpace(c, r).getWoodCost() / 2;
                return true;
            }
        }
        return false;
    }

    public int getTotalStoneRate()
    {
        int totalRate = 0;
        for (int i = 0; i < playerVillageSize; i++)
            for (int j = 0; j < playerVillageSize; j++)
            {
                totalRate += playerVillage.getSpace(i,j).getStoneRate();
            }
        totalStoneRate = totalRate;
        return totalRate;
    }

    public int getTotalWoodRate()
    {
        int totalRate = 0;
        for (int i = 0; i < playerVillageSize; i++)
            for (int j = 0; j < playerVillageSize; j++)
            {
                totalRate += playerVillage.getSpace(i,j).getWoodRate();
            }
        totalWoodRate = totalRate;
        return totalRate;
    }

    public Village getPlayerVillage()
    {
        return this.playerVillage;
    }

    public int getTotalStone()
    {
        return totalStone;
    }

    public int getTotalWood()
    {
        return totalWood;
    }

    public void addStone(int stone)
    {
        totalStone += stone;
    }

    public void addWood(int wood)
    {
        totalWood += wood;
    }
}
