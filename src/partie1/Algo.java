package partie1;

import java.util.ArrayList;

public interface Algo
{
    public ArrayList<Edge> getArbreCouvrant(Graph graph);

    public String getNom();
}