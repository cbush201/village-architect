package Village_Architect.model.buildings;

import Village_Architect.model.GridSpace;

public class Rock extends GridSpace
{
    public Rock()
    {
        //Stone Cost | Wood Cost | Stone Rate | Wood Rate | Building Type | Demolishable
        super(50,0,0,0,"obstacleStone",true);
    }


}
