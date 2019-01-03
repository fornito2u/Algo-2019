public class Main {

    public static void main (String [] args ){

        Graph graph = Graph.example();
        Kruskal kruskal = new Kruskal(graph);
        Statistique statistique = new Statistique();

        statistique.Lancement(kruskal, graph, 1000000);
        statistique.affichageResultat();

    }
}
