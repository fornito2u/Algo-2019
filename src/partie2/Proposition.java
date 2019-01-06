package partie2;

import java.util.ArrayList;

public class Proposition
{
    private ArrayList<String> proposition;
    private ArrayList<String> solution;
    private Reponse reponse;
    private int nbCombinaisonsPossibles;

    public Proposition(ArrayList<String> proposition, ArrayList<String> solution)
    {
        this.proposition = proposition;
        this.solution = solution;
        this.reponse = new Reponse();
        evaluerReponse();
        this.nbCombinaisonsPossibles = evaluerNombreCombinaisonsPossibles();
    }

    public void evaluerReponse()
    {
        for(int i = 0; i < this.proposition.size(); i++)
        {
            if(this.proposition.get(i) == this.solution.get(i))
            {
                this.reponse.setB(this.getReponse().getB() + 1);
            }
            else
            {
                for (String s : this.solution)
                {
                    if(this.proposition.get(i) == s)
                    {
                        this.reponse.setM(this.getReponse().getM() + 1);
                    }
                }
            }
        }
    }

    public int evaluerNombreCombinaisonsPossibles()
    {
        int compteurPossibiltie = 0;


        return compteurPossibiltie;
    }

    public ArrayList<String> getProposition()
    {
        return proposition;
    }

    public ArrayList<String> getSolution()
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