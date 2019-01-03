import java.util.ArrayList;
import java.util.Collections;

public class Kruskal
{
    public Kruskal()
    {}

    @Override
    public ArrayList<Edge> getArbreCouvrante(Graph graph)
    {

        if(graph==null)
        {
            throw new IllegalArgumentException();
        }

        ArrayList<Edge> arbre =new ArrayList<>();
        ArrayList<Edge> aretes=Collections.shuffle(graph.edges());
        UnionFind ver =new UnionFind(graph.vertices());

        for(Edge arete:aretes)
        {
            int sommet1=arete.from;
            int sommet2=arete.to;

            if(ver.find(sommet1)!=ver.find(sommet2))
            {
                ver.union(sommet1,sommet2);
                arbre.add(arete);
                arete.used=true;
            }
        }
        return arbre;
    }
}