package Village_Architect.model.buildings;

import Village_Architect.model.GridSpace;


public class Castle extends GridSpace
{
    public Castle()
    {
        //Stone Cost | Wood Cost | Stone Rate | Wood Rate | Building Type | Demolishable
        super(250000,250000,750,750,"generatorFinal",true);
    }
}
