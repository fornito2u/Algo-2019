import java.util.ArrayList;

public class Main {

    public static void main (String [] args ){

        Graph graph = Graph.example();
        Kruskal kruskal = new Kruskal();

        // Test pour 1 lancement de Kruskal
        ArrayList<Edge> resultat = kruskal.getArbreCouvrant(graph);
        kruskal.affichageKruskal(resultat);

        // Test pour 1000000 lancement de Kruskal
        /*Statistique statistique = new Statistique();
        statistique.Lancement(kruskal, graph, 1000000).affiche();*/
    }
}
