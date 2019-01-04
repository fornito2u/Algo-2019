import java.util.ArrayList;

public class Main {

    public static void main (String [] args )
    {
        Graph graph = Graph.example();
        Statistique statistique = new Statistique();
        Kruskal kruskal = new Kruskal();
        AldousBroder aldousBroder = new AldousBroder();

        // Test pour 1 lancement de Kruskal
        //ArrayList<Edge> resultat = kruskal.getArbreCouvrant(graph);
        //kruskal.affichageKruskal(resultat);

        // Test pour 1000000 lancement de Kruskal
        //statistique.Lancement(kruskal, graph, 1000000).affiche();

        // Test pour 1000000 lancement de AldousBroder
        //statistique.Lancement(aldousBroder, graph, 1000000).affiche();

        Labyrinthe l=new Labyrinthe(20, aldousBroder);
    }
}
