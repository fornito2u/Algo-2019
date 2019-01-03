import java.util.ArrayList;

public class Main {

    public static void main (String [] args ){

        Graph graph = Graph.example();
        Kruskal kruskal = new Kruskal();

        ArrayList<Edge> resultat = kruskal.getArbreCouvrant(graph);
        kruskal.affichageKruskal(resultat);

        //Statistique statistique = new Statistique();
        //statistique.Lancement(kruskal, graph, 1000000);
        //statistique.affichageResultat();

    }
}
