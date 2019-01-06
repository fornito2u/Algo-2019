package main;

import partie1.*;
import partie2.Proposition;
import partie2.Solution;
import java.lang.reflect.Array;
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
        System.out.println("* Pour quel algorithme voulez-vous lancer l'étude de statistique ? \n " +
                "    - Krusal : Entrer le numéro 1 \n " +
                "    - Aldous-Brother : Entrer le numéro 2 \n " +
                "    - Wilson : Entrer le numéro 3 \n" + "\n" +
                "* Pour lancer la création d'un labyrinthe : Entrer le numéro 4 \n" + "\n" +
                "* Pour lancer la comparaison des distances et des culs de sac : Entrer le numéro 5 \n" + "\n" +
                "* Pour lancer la déduction des combinaisons secrètes : Entrer le numéro 6 \n" + "\n" +
                "* Pour quitter : Entrer le numéro 7");

        boolean b = false;
        boolean quit = false;
        int entier = -1;

        while (quit == false)
        {
            entier = sc.nextInt();
            if(entier >= 1 && entier <= 7)
            {
                b = true;
                if(entier == 5)
                {
                    quit = true;
                }
            }
            while(b == false)
            {
                System.out.println("Mauvaise entrée, veuillez utiliser les chiffres entre 1 et 7 pour selectionner l'action");
                entier = sc.nextInt();
                if(entier >= 1 && entier<=7)
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
                    System.out.println("Lancement en cours... \n");
                    statistique.Lancement(kruskal, graph, 1000000).affiche();
                    break;
                case 2:
                    // Lancement pour 1000000 d'AldousBroder
                    System.out.println("Lancement en cours... \n");
                    statistique.Lancement(aldousBroder, graph, 1000000).affiche();
                    break;
                case 3:
                    // Lancement pour 1000000 de Wilson
                    System.out.println("Lancement en cours... \n");
                    statistique.Lancement(wilson, graph, 1000000).affiche();
                    break;
                case 4:
                    // Création du labyrinthe
                    Labyrinthe l = new Labyrinthe(20, aldousBroder);
                    System.out.println("Lancement en cours... \n");
                    System.out.println("Labyrinthe crée dans fichier test.svg");
                    break;
                case 5:
                    comparaisonAlgo();
                    break;
                case 6:
                    System.out.println("Entrer les nombre de position du jeu");
                    int n = sc.nextInt();
                    System.out.println("Entrer les nombre de couleur du jeu");
                    int g = sc.nextInt();
                    secondTest(n, g);
                    break;
                case 7:
                    quit = true;
                    break;
            }
            if(entier != 7)
            {
                System.out.println("Quel sera votre prochaine activité ? (Veuillez entrer un chiffre entier entre 1 et 7)");
            }
        }

    }

    public static void comparaisonAlgo() {
        AldousBroder aldousBroder = new AldousBroder();
        Kruskal kruskal = new Kruskal();

        Labyrinthe.statsPourAlgo(aldousBroder,20,1000);
        Labyrinthe.statsPourAlgo(kruskal,20,1000);
    }

    public static void secondTest(int n, int g)
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> listEntier1 = new ArrayList<>();
        ArrayList<Integer> listEntier2 = new ArrayList<>();
        int nbPosition = n;
        int nbCouleur = g;
        for(int i = 1; i <= nbPosition; i++)
        {
            System.out.println("Création de la solution : Entrer le numéro de la couleur "+ i + "\n");
            listEntier1.add(sc.nextInt());
        }
        for(int i = 1; i <= nbPosition; i++)
        {
            System.out.println("Création de la proposition : Entrer le numéro de la couleur "+ i + "\n");
            listEntier2.add(sc.nextInt());
        }
        Solution s = new Solution(listEntier1, nbCouleur);
        Proposition p = new Proposition(listEntier2, s);
        System.out.println("Nombre de combinaisons possibles : " + p.getNbCombinaisonsPossibles());
    }
}
