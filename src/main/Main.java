package main;

import partie1.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main (String [] args )
    {
        petitTest();
        /*Graph graph = Graph.example();
        Statistique statistique = new Statistique();
        Kruskal kruskal = new Kruskal();
        AldousBroder aldousBroder = new AldousBroder();
        Wilson wilson = new Wilson();

        Scanner sc = new Scanner(System.in);
        System.out.println("* Pour quel algorithme voulez-vous lancer l'étude de statistique ? \n " +
                "    - Krusal : Entrer le numéro 1 \n " +
                "    - Aldous-Brother : Entrer le numéro 2 \n " +
                "    - Wilson : Entrer le numéro 3 \n" + "\n" +
                "* Pour lancer la création d'un labyrinthe : Entrer le numéro 4 \n" + "\n" +
                "* Pour quitter : Entrer le numéro 5");
        boolean b = false;
        boolean quit = false;
        int entier = -1;

        while (quit == false)
        {
            entier = sc.nextInt();
            if(entier == 1 || entier == 2 || entier == 3 || entier == 4 || entier == 5)
            {
                b = true;
                if(entier == 5)
                {
                    quit = true;
                }
            }
            while(b == false)
            {
                System.out.println("Mauvaise entrée, veuillez utiliser les chiffres 1, 2, 3, 4 ou 5 pour selectionner l'action");
                entier = sc.nextInt();
                if(entier == 1 || entier == 2 || entier == 3 || entier == 4 || entier == 5)
                {
                    b = true;
                    if(entier == 5)
                    {
                        quit = true;
                    }
                }
            }

            switch(entier)
            {
                case 1:
                    // Lancement pour 1000000 Kruskal
                    System.out.println("Lancement en cour... \n");
                    statistique.Lancement(kruskal, graph, 1000000).affiche();
                    break;
                case 2:
                    // Lancement pour 1000000 d'AldousBroder
                    System.out.println("Lancement en cour... \n");
                    statistique.Lancement(aldousBroder, graph, 1000000).affiche();
                    break;
                case 3:
                    // Lancement pour 1000000 de Wilson
                    System.out.println("Lancement en cour... \n");
                    statistique.Lancement(wilson, graph, 1000000).affiche();
                    break;
                case 4:
                    // Création du labyrinthe
                    Labyrinthe l = new Labyrinthe(20, aldousBroder);
                    System.out.println("Lancement en cour... \n");
                    System.out.println(Labyrinthe.statsPourAlgo(kruskal,2));
                    System.out.println("Labyrinthe crée dans fichier test.svg");
                    break;
                case 5:
                    quit = true;
                    break;
            }
        }*/

    }

    public static void petitTest() {
        AldousBroder aldousBroder = new AldousBroder();
        Kruskal kruskal = new Kruskal();

        Labyrinthe.statsPourAlgo(aldousBroder,20,1000);
        Labyrinthe.statsPourAlgo(kruskal,20,1000);
        /*Labyrinthe l = new Labyrinthe(5, aldousBroder);
        ArrayList<Integer>[] sommetsSuivant=l.calculSommetsSucesseurs();
        for (int i=0;i<sommetsSuivant.length;i++) {
            System.out.print("S"+i+" ");
            for (int j=0;j<sommetsSuivant[i].size();j++) {
                System.out.print("S"+sommetsSuivant[i].get(j)+" ");
            }
            System.out.println();
        }
        System.out.println("Distance : "+l.calculerDistance(4,0));*/
    }
}
