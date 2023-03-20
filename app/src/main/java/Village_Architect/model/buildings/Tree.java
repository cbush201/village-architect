package Village_Architect.model.buildings;

import Village_Architect.model.GridSpace;

public class Tree extends GridSpace
{

    public Tree()
    {
        //Stone Cost | Wood Cost | Stone Rate | Wood Rate | Building Type | Demolishable
        super(0,50,0,0,"obstacleWood",true);
    }

}
