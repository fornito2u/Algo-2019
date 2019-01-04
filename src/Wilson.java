import java.util.Random;
import java.util.ArrayList;

public class Wilson implements Algo
{
    String nom;
    private boolean[] tabVisit;

    public Wilson()
    {
        this.nom = "Wilson";
    }

    @Override
    public ArrayList<Edge> getArbreCouvrant(Graph graph)
    {
        if(graph == null)
        {
            throw new IllegalArgumentException();
        }

        tabVisit = new boolean[graph.vertices()];
        tabVisit[new Random().nextInt(tabVisit.length)] = true;
        ArrayList<Edge> arbre = new ArrayList<>();

        while (!avoirToutVisiter())
        {
            int suivant = choixPasVisiter();
            ArrayList<Edge> routeAretes = pasAleatoire(suivant, graph);
            routeAretes = detruireCycle(routeAretes, suivant);
            visiterRoute(routeAretes, graph);

            // Ajout de route
            for (Edge arc :routeAretes)
            {
                arbre.add(arc);
            }
        }

        return arbre;
    }

    private ArrayList<Edge> detruireCycle(ArrayList<Edge> routeAretes, int numStart)
    {
        ArrayList<Edge> routePasCycle = new ArrayList<Edge>();
        int derniereOccurence, nbOccurence;
        int sommet = numStart;
        int i = 0;

        while (i < routeAretes.size())
        {

            nbOccurence = 1;
            derniereOccurence = i;

            for(int j = i + 1; j < routeAretes.size(); j++)
            {
                if(sommet==routeAretes.get(j).from||sommet==routeAretes.get(j).to)
                {
                    derniereOccurence = j;
                    nbOccurence++;
                }
            }

            if(i == derniereOccurence)
            {
                routePasCycle.add(routeAretes.get(i));
            }
            else
            {
                if(nbOccurence % 4 == 0)
                {
                    routePasCycle.add(routeAretes.get(i));
                }
                routePasCycle.add(routeAretes.get(derniereOccurence));
                i = derniereOccurence;
            }

            sommet = getSuivant(sommet, routeAretes.get(i));
            ++i;
        }

        return routePasCycle;
    }


    private int choixPasVisiter()
    {
        Random random = new Random();
        int sommet = random.nextInt(tabVisit.length);
        while(tabVisit[sommet])
        {
            sommet = random.nextInt(tabVisit.length);
        }
        return sommet;
    }

    private int getSuivant(int numSommet, Edge edge)
    {
        if(numSommet == edge.from)
        {
            return edge.to;
        }
        else
        {
            return edge.from;
        }
    }


    private boolean avoirToutVisiter()
    {
        for(int j = 0; j < tabVisit.length; j++)
        {
            if(!tabVisit[j])
            {
                return false;
            }
        }
        return true;
    }

    private ArrayList<Edge> pasAleatoire(int numStart, Graph graph)
    {
        int numSommet = numStart;
        Random random = new Random();
        ArrayList<Edge> routeAretes = new ArrayList<>();

        while (!tabVisit[numSommet])
        {
            ArrayList<Edge> adjoint = graph.getAdj()[numSommet];
            Edge suivant = adjoint.get(random.nextInt(adjoint.size()));
            routeAretes.add(suivant);
            numSommet = getSuivant(numSommet, suivant);
        }

        return routeAretes;
    }

    private void visiterRoute(ArrayList<Edge> routeAretes, Graph graph)
    {
        for (Edge edge : routeAretes)
        {
            edge.used = true;
            tabVisit[edge.to] = true;
            tabVisit[edge.from] = true;
        }
    }


    public String getNom()
    {
        return this.nom;
    }
}