package partie1;

import java.util.Random;
import java.util.ArrayList;

public class AldousBroder implements Algo
{

    String nom;
    private ArrayList<Edge> arbreCouvrant;
    private int sommetActuel;
    private boolean[] sommetsDejaVisites;
    private int nombreSommetsNonVisites;
    private Random random;


    public AldousBroder()
    {
        this.nom = "Aldous-Broder";
        arbreCouvrant = new ArrayList<>();
        nombreSommetsNonVisites = 0;
        random = new Random();
    }

    @Override
    public ArrayList<Edge> getArbreCouvrant(Graph graph)
    {
        int entier = graph.vertices();
        this.nombreSommetsNonVisites = entier;
        this.sommetsDejaVisites = new boolean[entier];
        this.arbreCouvrant = new ArrayList<>();

        for(int i=0; i<entier;i++)
        {
            sommetsDejaVisites[i] = false;
        }

        sommetActuel = random.nextInt(entier);
        sommetsDejaVisites[sommetActuel] = true;
        nombreSommetsNonVisites--;


        while(nombreSommetsNonVisites > 0)
        {
            prochainSommet(graph);
        }
        return arbreCouvrant;
    }

    private void prochainSommet(Graph graph)
    {
        random = new Random();
        ArrayList<Edge> voisins = graph.getAdj()[sommetActuel];
        Edge arreteSelec = voisins.get(random.nextInt(voisins.size()));

        sommetActuel = arreteSelec.other(sommetActuel);

        if(!sommetsDejaVisites[sommetActuel])
        {
            arbreCouvrant.add(arreteSelec);
            sommetsDejaVisites[sommetActuel] = true;
            nombreSommetsNonVisites--;
            arreteSelec.setUsed(true);
        }
    }

    public String getNom()
    {
        return this.nom;
    }
}