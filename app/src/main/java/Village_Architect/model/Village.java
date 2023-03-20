package Village_Architect.model;

import Village_Architect.model.buildings.*;
import java.util.Random;

public class Village
{
    GridSpace[][] spaces;
    private int size;

    public Village(int size)
    {
        this.size = size;
	    spaces = new GridSpace[size][size];
	    Random gen = new Random();

	    for (int i = 0; i < (size/2); i++)
        {
            int c = gen.nextInt(size);
            int r = gen.nextInt(size);
            int type = gen.nextInt(2);

            if (spaces[c][r] == null)
            {
                if (type == 1)
                    spaces[c][r] = new Rock();
                else if (type == 0)
                    spaces[c][r] = new Tree();
            }
            else
                i--;
        }

        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                if (spaces[i][j] == null)
                    spaces[i][j] = new Field();
            }
        }
    }

    public GridSpace getSpace(int c, int r)
    {
        return spaces[c][r];
    }

    public void setSpace(GridSpace g, int c, int r)
    {
        spaces[c][r] = g;
    }

    public int getSize()
    {
        return size;
    }
}
