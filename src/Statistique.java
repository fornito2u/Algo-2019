import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Statistique
{
    private int nbLancementAlgo;
    private Algo algoLance;
    private Map<ArrayList<Edge>,Float> arbreProba;
    private Map<ArrayList<Edge>,Integer> arbreOcc;

    /** Constructeur **/
    private Statistique()
    {
        arbreProba=new HashMap<>();
        arbreOcc=new HashMap<>();
    }

    /** Méthode qui lance l'algorithme "algo" sur le graph "graph" un nombre de fois "nbFois" **/
    /** Renvoit les statistiques après le lancement de l'algorithme **/
    public static Statistique Lancement(Algo algo, Graph graph, int nbFois){
        if(algo == null || graph == null || nbFois <= 0) throw new IllegalArgumentException();

        Statistique statistique = new Statistique();
        statistique.algoLance = algo;
        statistique.nbLancementAlgo = nbFois;

        for (int i=0;i<statistique.nbLancementAlgo;i++)
        {
            Graph cloneDuGraph = graph.clone();
            ArrayList<Edge> ech = algo.getArbreCouvrant(cloneDuGraph);
            statistique.ajoutUnEchantillon(ech);
        }

        statistique.calculeProbobilite();
        return statistique;
    }

    private void ajoutUnEchantillon(ArrayList<Edge> arbre)
    {
        for(Map.Entry<ArrayList<Edge>, Integer> prototype : arbreOcc.entrySet())
        {
            ArrayList<Edge> arbreProto = prototype.getKey();
            if(comparaisonDeDeuxArbres(arbreProto, arbre))
            {
                int nbOccurence=arbreOcc.get(arbreProto);
                arbreOcc.put(arbreProto, nbOccurence + 1);
                return;
            }
        }
        arbreOcc.put(arbre,1);
    }

    /** Méthode qui calcule la probabilité d'apparation d'un arbre couvrant **/
    private void calculeProbobilite()
    {
        for(Map.Entry<ArrayList<Edge>,Integer> prototype : arbreOcc.entrySet())
        {
            ArrayList<Edge> arbreProto = prototype.getKey();
            int nbOccurence = prototype.getValue();
            arbreProba.put(arbreProto, nbOccurence / (float)nbLancementAlgo);
        }
    }

    private boolean comparaisonDeDeuxArbres(ArrayList<Edge> arbre1,ArrayList<Edge> arbre2)
    {
        // Si la taille des deux arbres est différent, il ne peuvent pas être identique
        if(arbre1.size() != arbre2.size())
        {
            return false;
        }

        // Pour chaque aretes de l'abre 1, on va vérifier si elle exite également parmis les aretes de l'arbre 2
        for(Edge areteArbre1 : arbre1)
        {
            Boolean existe = false;

            for(Edge areteArbre2 : arbre2)
            {
                if(areteArbre1.egale(areteArbre2))
                {
                    existe = true;
                    break;
                }
            }

            if(!existe)
            {
                return false;
            }
        }
        return true;
    }

    public void affiche()
    {
        System.out.println( "Lancement de l'algorihtme "+ algoLance + " " +nbLancementAlgo + " fois sur le graph donné");
        // ....
    }

    public String getAffichageAretesArbre(ArrayList<Edge> arbre)
    {
        String resultat = "";
        for(Edge e : arbre )resultat+=" "+e.from+"--"+e.to+" ";
        return resultat;
    }
}