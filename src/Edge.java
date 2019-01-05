class Edge
{
   int from;
   int to;
   boolean used;
    Edge(int x, int y)
    {
	this.from = x;
	this.to = y;
	this.used = false;
    }

    //Rajout d'un constructeur de copies
    Edge(Edge e) {
        this.from=e.from;
        this.to=e.to;
        this.used=e.used;
    }
    
    final int other(int v)
    {
	if (this.from == v) return this.to; else return this.from;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////* Nouvelles Méthodes *///////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Edge) {
            Edge edge=(Edge)obj;
            return ((edge.from == this.from && edge.to == this.to) || (edge.from == this.to && edge.to == this.from));
        } else {
            return false;
        }
    }

    public void setUsed(boolean used)
    {
        this.used = used;
    }
}
