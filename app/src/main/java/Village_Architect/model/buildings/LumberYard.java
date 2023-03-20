package Village_Architect.model.buildings;

import Village_Architect.model.GridSpace;

public class LumberYard extends GridSpace
{
    //Stone Cost | Wood Cost | Stone Rate | Wood Rate | Building Type | Demolishable
    public LumberYard()
    {
        super(0,100,0,10,"generatorWood",true);
    }
}
