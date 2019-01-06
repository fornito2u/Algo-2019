package partie1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Labyrinthe {

    //La taille d'un coté du labyrinthe (carré)
    private int taille;

    //L'algorithme utilisé pour générer l'arbre couvrant
    private Algo algo;

    private Graph graph;

    //Un tableau de cases représentant le labyrinthe
    private CaseLabyrinthe[][] labyrinthe;

    //L'arbre couvrant du graphe
    private ArrayList<Edge> arbreCouvrant;

    public Labyrinthe(int taille, Algo algo) {
        this.taille=taille;
        this.algo=algo;
        this.graph=new Graph(taille*taille);
        //On va créé un graphe de sorte à ce que le sommet 0 soit en haut à gauche et le sommet taille * taille -1 en bas à droite
        Edge e;
        //Par exemple pour taille = 3
        // 0 1 2
        // 3 4 5
        // 6 7 8
        //
        //i 0 3 6
        //j 0 1 2
        for (int i=0;i<taille*(taille-1);i+=taille) {
            for (int j=0;j<taille;j++) {
                if (j < taille-1) {
                    e=new Edge(i+j,i+j+1);
                    this.graph.addEdge(e);
                }
                e=new Edge(i+j,i+j+taille);
                this.graph.addEdge(e);
            }
        }

        for (int i=0;i<taille-1;i++) {
            if (i < taille-1) {
                e=new Edge(i+taille*(taille-1),i+taille*(taille-1)+1);
                this.graph.addEdge(e);
            }
        }
        this.arbreCouvrant=algo.getArbreCouvrant(this.graph);

        initialiserLabyrinthe();
        for (Edge edge : this.arbreCouvrant) {
            enleverArreteDansLabyrinthe(edge);
        }
        writeFile("test.svg",30);
    }

    private void initialiserLabyrinthe() {
        this.labyrinthe=new CaseLabyrinthe[taille][taille];
        for (int i=0;i<taille;i++) {
            for (int j=0;j<taille;j++) {
                labyrinthe[i][j]=new CaseLabyrinthe();
            }
        }

        //On met arbitrairement l'entrée et la sortie comme dans l'exemple
        //Entrée
        labyrinthe[taille-1][0].setDroite(false);
        //Sortie
        labyrinthe[0][taille-1].setGauche(false);
    }

    public void enleverArreteDansLabyrinthe(Edge e) {
        //e.from est à gauche de e.to
        if (e.from-e.to == -1) {
            int iGauche=e.from%taille;
            int jGauche=(e.from-(e.from%taille))/taille;
            labyrinthe[iGauche][jGauche].setDroite(false);
            labyrinthe[iGauche+1][jGauche].setGauche(false);
        //e.from est à droite de e.to
        } else if (e.from-e.to == 1) {
            int iGauche=e.to%taille;
            int jGauche=(e.to-(e.to%taille))/taille;
            labyrinthe[iGauche][jGauche].setDroite(false);
            labyrinthe[iGauche+1][jGauche].setGauche(false);
        //e.from est en haut de e.to
        } else if (e.from-e.to == -taille) {
            int iHaut=e.from%taille;
            int jHaut=(e.from-(e.from%taille))/taille;
            labyrinthe[iHaut][jHaut].setBas(false);
            labyrinthe[iHaut][jHaut+1].setHaut(false);
        //e.from est en bas de e.to
        } else if (e.from-e.to == taille) {
            int iHaut=e.to%taille;
            int jHaut=(e.to-(e.to%taille))/taille;
            labyrinthe[iHaut][jHaut].setBas(false);
            labyrinthe[iHaut][jHaut+1].setHaut(false);
        }
    }

    public int nbCulDeSac() {
        int[] nbArretePourSommet=new int[this.graph.vertices()];

        //On initilasise à 0
        for (int i=0;i<nbArretePourSommet.length;i++) {
            nbArretePourSommet[i]=0;
        }

        //On ajoute une arrete pour l'entree et la sortie
        nbArretePourSommet[taille-1]=1;
        nbArretePourSommet[(taille-1)*taille]=1;

        //On compte le nombre d'arrete pour chaque sommet
        for (Edge e : this.arbreCouvrant) {
            nbArretePourSommet[e.to]++;
            nbArretePourSommet[e.from]++;
        }

        int nbCulDeSac=0;
        for (int i=0;i<nbArretePourSommet.length;i++) {
            if (nbArretePourSommet[i]==1) {
                nbCulDeSac++;
                //System.out.println("Cul de sac, sommet "+i);
            }
        }
        return nbCulDeSac;
    }

    public static double nbMoyenCulSac(Algo algo, int repetion) {
        double nbCulDeSacTotal=0;
        for (int i=0;i<repetion;i++) {
            Labyrinthe l=new Labyrinthe(5, algo);
            nbCulDeSacTotal+=l.nbCulDeSac();
            //l.writeFile("test"+i+".svg",30);
        }
        return (nbCulDeSacTotal/repetion);
    }

    public void writeFile(String s, int tailleCase) {
        try {
            PrintWriter writer = new PrintWriter(s, "UTF-8");
            writer.println("<svg width=\""+((tailleCase*(taille+1))+20)+"\" height=\""+((tailleCase*(taille+1))+20)+"\" version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">");
            writer.println("\t<g stroke=\"black\" stroke-width=\"1\" stroke-linecap=\"round\">");
            for (int i=0;i<taille;i++) {
                for (int j=0;j<taille;j++) {
                    if (labyrinthe[i][j].isHaut()) {
                        writer.println("\t\t<line x1=\""+(10+tailleCase+tailleCase*(i+1))+"\" y1=\""+(10+tailleCase*(j+1))+"\" x2=\""+(10+tailleCase*(i+1))+"\" y2=\""+(10+tailleCase*(j+1))+"\"/> <!-- Arête haut  -->");
                    }
                    if (labyrinthe[i][j].isGauche()) {
                        writer.println("\t\t<line x1=\""+(10+tailleCase*(i+1))+"\" y1=\""+(10+tailleCase*(j+1))+"\" x2=\""+(10+tailleCase*(i+1))+"\" y2=\""+(10+tailleCase+tailleCase*(j+1))+"\"/> <!-- Arête gauche  -->");
                    }
                    if (labyrinthe[i][j].isBas()) {
                        writer.println("\t\t<line x1=\""+(10+tailleCase*(i+1))+"\" y1=\""+(10+tailleCase+tailleCase*(j+1))+"\" x2=\""+(10+tailleCase+tailleCase*(i+1))+"\" y2=\""+(10+tailleCase+tailleCase*(j+1))+"\"/> <!-- Arête bas  -->");
                    }
                    if (labyrinthe[i][j].isDroite()) {
                        writer.println("\t\t<line x1=\""+(10+tailleCase+tailleCase*(i+1))+"\" y1=\""+(10+tailleCase*(j+1))+"\" x2=\""+(10+tailleCase+tailleCase*(i+1))+"\" y2=\""+(10+tailleCase+tailleCase*(j+1))+"\"/> <!-- Arête droite  -->");
                    }
                }
            }
            writer.println("\t</g>");
            writer.println("</svg>");
            writer.close();
        } catch (IOException e) {

        }
    }
}
