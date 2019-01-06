package partie1;

public class UnionFind
{
    private int[] pere;

    public UnionFind(int size)
    {

        if(size<0)throw new IllegalArgumentException();

        pere = new int[size];

        // Initialisation
        for (int i=0;i<pere.length;i++)
        {
            pere[i] = i;
        }
    }

    public void union(int element1,int element2)
    {
        if(element1 <0 || element2 <0 || element1 > pere.length || element2 > pere.length)
        {
            throw new IllegalArgumentException();
        }

        int racine_element1 = find(element1);
        int racine_element2 = find(element2);

        if( racine_element1 != racine_element2)
        {
            pere[racine_element1] = racine_element2;
        }
    }

    public int find(int element)
    {
        if(element < 0 || element >= pere.length)
        {
            throw new IllegalArgumentException();
        }

        if(element == pere[element])
        {
            return element;
        }
        else
        {
            return find(pere[element]);
        }
    }

    public void affichage()
    {
        System.out.println("////////////////////////////////////////");

        for(int i=0;i<pere.length;i++)
        {
            System.out.print("   "+i);
        }

        System.out.println("\n");

        for(int i=0;i<pere.length;i++)
        {
            System.out.print("   "+pere[i]);
        }

        System.out.println("\n////////////////////////////////////////");
    }
}