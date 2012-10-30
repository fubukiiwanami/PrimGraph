package nl.niek.minor.aa.primgraph;

public class Edge
{
	private Vertex	one;
	private Vertex	two;
	private int		weight;
	private boolean	inTree	= false;

	public Edge(Vertex one, Vertex two, final int weight)
	{
		this.one = one;
		this.two = two;
		this.weight = weight;
	}

	public Vertex getOne()
	{
		return one;
	}

	public Vertex getTwo()
	{
		return two;
	}

	public final boolean hasVertex(final Vertex vertex)
	{
		return vertex.equals(one) || vertex.equals(two);
	}

	public final int getWeight()
	{
		return weight;
	}

	public final String toString()
	{
		return one.getName() + " <-" + weight + "-> " + two.getName();
	}

	public void setInTree()
	{
		inTree = true;
	}

	public boolean isInTree()
	{
		return inTree;
	}

	public boolean bothVerticesVisited()
	{
		return one.visited() && two.visited();
	}
}
