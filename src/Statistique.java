import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Statistique
{
    private Map<ArrayList<Edge>,Float> arbre_proba;
    private Map<ArrayList<Edge>,Integer> arbre_occ;

    private Statistique()
    {
        arbre_occ=new HashMap<>();
        arbre_proba=new HashMap<>();
    }

    public static Statistique Lancement(Algo algo, Graph graph, int nbFois){
        if(algo == null || graph == null || nbFois == null) throw new IllegalArgumentException();

        Statistique statistique = new Statistique();

        return statistique;
    }

    public void affichageResultat()
    {

    }
}