package nl.niek.minor.aa.primgraph;

public class Vertex
{
	private String	name;
	private boolean	visited;

	public Vertex(String name)
	{
		this.name = name;
	}

	public final String getName()
	{
		return name;
	}

	/**
	 * Has the algorithm visited this node?
	 * 
	 * @return
	 */
	public boolean visited()
	{
		return visited;
	}

	/**
	 * Set visited to TRUE.
	 */
	public void setVisited()
	{
		visited = true;
	}
	
	@Override
	public String toString()
	{
		return name;
	}

	@Override
	public boolean equals(Object arg0)
	{
		Vertex vertex = null;
		if (arg0 instanceof Vertex)
		{
			vertex = (Vertex) arg0;

			return vertex.getName().equalsIgnoreCase(name);
		}

		return false;
	}
}
