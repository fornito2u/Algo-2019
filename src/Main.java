import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main (String [] args )
    {
        Graph graph = Graph.example();
        Statistique statistique = new Statistique();
        Kruskal kruskal = new Kruskal();
        AldousBroder aldousBroder = new AldousBroder();
        Wilson wilson = new Wilson();

        Scanner sc = new Scanner(System.in);
        System.out.println("Pour quel algorithme voulez-vous lancer l'étude de statistique ? \n " +
                           "- Krusal : Entrer le numéro 1 \n " +
                           "- Aldous-Brother : Entrer le numéro 2 \n " +
                           "- Wilson : Entrer le numéro 3 \n");
        boolean b = false;
        int entier = -1;
        entier = sc.nextInt();
        if(entier == 1 || entier == 2 || entier == 3)
        {
            b = true;
        }
        while(b == false)
        {
            System.out.println("Mauvaise entrée, veuillez utiliser les chiffres 1, 2 ou 3 pour selectionner l'algorithme");
            entier = sc.nextInt();
            if(entier == 1 || entier == 2 || entier == 3)
            {
                b = true;
            }
        }

        if(entier == 1)
        {
            // Lancement pour 1000000 Kruskal
            System.out.println("Lancement en cour... \n");
            statistique.Lancement(kruskal, graph, 1000000).affiche();
        }
        if(entier == 2)
        {
            // Lancement pour 1000000 d'AldousBroder
            System.out.println("Lancement en cour... \n");
            statistique.Lancement(aldousBroder, graph, 1000000).affiche();
        }
        if(entier == 3)
        {
            // Lancement pour 1000000 de Wilson
            System.out.println("Lancement en cour... \n");
            statistique.Lancement(wilson, graph, 1000000).affiche();
        }

        Labyrinthe l = new Labyrinthe(20, aldousBroder);
        System.out.println(Labyrinthe.nbMoyenCulSac(kruskal,2));
    }
}
