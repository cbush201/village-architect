package Village_Architect.model;

public abstract class GridSpace
{
    protected int stoneCost;
    protected int woodCost;
    protected int stoneRate;
    protected int woodRate;
    protected String buildingType;
    protected boolean demolishable;

    public GridSpace(int sc, int wc, int sr, int wr, String bt, boolean d)
    {
        stoneCost = sc;
        woodCost = wc;
        stoneRate = sr;
        woodRate = wr;
        buildingType = bt;
        demolishable = d;
    }
    
    public int getStoneCost()
    {
        return stoneCost;
    }

    
    public int getStoneRate()
    {
        return stoneRate;
    }

    
    public int getWoodCost()
    {
        return woodCost;
    }

    
    public int getWoodRate()
    {
        return woodRate;
    }

    
    public String getBuildingType()
    {
        return buildingType;
    }

    
    public boolean isDemolishable()
    {
        return demolishable;
    }
}
