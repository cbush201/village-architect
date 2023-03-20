package Village_Architect.model.buildings;

import Village_Architect.model.GridSpace;

public class Mine extends GridSpace
{
    //Stone Cost | Wood Cost | Stone Rate | Wood Rate | Building Type | Demolishable
    public Mine()
    {
        super(100,0,10,0,"generatorStone",true);
    }

}
