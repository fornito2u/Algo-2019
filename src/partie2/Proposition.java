package partie2;


import java.util.ArrayList;
import java.util.Random;

public class Proposition
{
    private ArrayList<Integer> proposition;
    private Solution solution;
    private Reponse reponse;
    private int nbCombinaisonsPossibles;

    public Proposition(ArrayList<Integer> proposition, Solution solution)
    {
        this.proposition = proposition;
        this.solution = solution;
        this.reponse = new Reponse();
        evaluerReponse(this.proposition);
        this.nbCombinaisonsPossibles = evaluerNombreCombinaisonsPossibles();
    }

    public void evaluerReponse(ArrayList<Integer> p) throws IndexOutOfBoundsException
    {
        for(int i = 0; i < p.size(); i++)
        {
            if(i>=0 && i < this.solution.getSolution().size())
            {
                if(p.get(i) == this.solution.getSolution().get(i))
                {
                    this.reponse.setB(this.getReponse().getB() + 1);
                }
                else
                {
                    for (int s : this.solution.getSolution())
                    {
                        if(p.get(i) == s)
                        {
                            this.reponse.setM(this.getReponse().getM() + 1);
                        }
                    }
                }
            }

        }

    }

    public int evaluerNombreCombinaisonsPossibles()
    {
        int compteurPossibilite = 0;
        int nbPosition = this.solution.getN();
        int nbCouleurs = this.solution.getK();

        ArrayList<ArrayList<Integer>> listTablAlea = new ArrayList<>();
        ArrayList<Integer> tabAlea = new ArrayList<>();
        Random rand = new Random();
        int alea;
        boolean b = true;
        int c = 0;

        while(c <= 100000)
        {
            while(b == true)
            {
                alea = rand.nextInt(nbCouleurs + 1);
                if(tabAlea.contains(alea) == false)
                {
                    tabAlea.add(alea);
                }
                if(tabAlea.size()+1 == nbPosition)
                {
                    b = false;
                }
            }
            if(listTablAlea.contains(tabAlea) == false)
            {
                listTablAlea.add(tabAlea);
            }
            tabAlea = new ArrayList<>();
            b = true;
            c++;
        }
        compteurPossibilite = listTablAlea.size();
        return compteurPossibilite;
    }

    public ArrayList<Integer> getProposition()
    {
        return proposition;
    }

    public Solution getSolution()
    {
        return solution;
    }

    public int getNbCombinaisonsPossibles()
    {
        return nbCombinaisonsPossibles;
    }

    public Reponse getReponse()
    {
        return reponse;
    }
}