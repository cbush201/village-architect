package Village_Architect.model.buildings;

import Village_Architect.model.GridSpace;


public class TownHall extends GridSpace
{
    public TownHall()
    {
        //Stone Cost | Wood Cost | Stone Rate | Wood Rate | Building Type | Demolishable
        super(10000,10000,50,50,"generatorCombo",true);
    }
}
