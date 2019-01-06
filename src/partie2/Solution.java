package partie2;

import java.util.ArrayList;

public class Solution
{
    private ArrayList<Integer> solution;
    private int k;
    private int n;

    public Solution(ArrayList<Integer> solution, int k)
    {
        this.solution = solution;
        this.k = k;
        this.n = solution.size();
    }

    public ArrayList<Integer> getSolution()
    {
        return solution;
    }

    public int getK()
    {
        return k;
    }

    public int getN()
    {
        return n;
    }
}
