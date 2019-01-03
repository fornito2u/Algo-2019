import java.util.ArrayList;
import java.util.Collections;

public class Kruskal implements Algo
{
    public Kruskal()
    {}

    @Override
    public ArrayList<Edge> getArbreCouvrant(Graph graph)
    {
        if(graph==null)
        {
            throw new IllegalArgumentException();
        }

        // On créer l'arbre d
        ArrayList<Edge> arbre = new ArrayList<>();

        // On mélange la liste des arretes du graph
        Collections.shuffle(graph.edges());
        ArrayList<Edge> listAretes = graph.edges();

        UnionFind unionFind = new UnionFind(graph.vertices());

        for(Edge arete:listAretes)
        {
            int sommet1=arete.from;
            int sommet2=arete.to;

            if(unionFind.find(sommet1) != unionFind.find(sommet2))
            {
                unionFind.union(sommet1,sommet2);
                arbre.add(arete);
                arete.used=true;
            }
        }
        return arbre;
    }

    /* Méthode utilisé dans la classe Main qui permet de tester l'affichage d'une utilisation de l'algorithme de Kruskal */
    public void affichageKruskal(ArrayList<Edge> arbreResultat)
    {
        String resultat = "";
        for(Edge e : arbreResultat )resultat+=" "+e.from+"--"+e.to+" ";
        System.out.println(resultat);
    }
}