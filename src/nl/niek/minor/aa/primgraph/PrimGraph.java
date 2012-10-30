package nl.niek.minor.aa.primgraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Representation of a connected, weighted graph. Keeps a list of vertices and
 * edges. Is responsible for modifying these and getting info from them.
 * 
 * @author Niek
 * 
 */
public class PrimGraph
{
	private List<Vertex>	vertices;
	private List<Edge>		edges;

	/**
	 * Construct a new PrimGraph. Edges and Vertices need to be added manually.
	 */
	public PrimGraph()
	{
		vertices = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
	}

	/**
	 * Get all connecting edges for this vertex that are not in the tree.
	 * 
	 * @param vertex
	 * @return
	 */
	public List<Edge> getEdgesNotInTree(Vertex vertex)
	{
		List<Edge> edgeList = new ArrayList<Edge>();

		for (Edge edge : edges)
		{
			if (edge.hasVertex(vertex))
			{
				if (!edge.isInTree())
				{
					edgeList.add(edge);
				}
			}
		}

		return edgeList;
	}

	/**
	 * Add a vertex. Make sure it is added to an Edge which is also added to
	 * this Graph.
	 * 
	 * @param newVertex
	 */
	public void addVertex(final Vertex newVertex)
	{
		vertices.add(newVertex);
	}

	/**
	 * Add an Edge. Make sure the Edge has two Vertices which are also in this
	 * Graph.
	 * 
	 * @param newEdge
	 */
	public void addEdge(final Edge newEdge)
	{
		edges.add(newEdge);
	}

	/**
	 * Get a pseudo random starting Vertex.
	 * 
	 * @return
	 */
	public Vertex getStart()
	{
		Vertex retVal = null;

		if (vertices.size() > 0)
		{
			Random r = new Random();
			retVal = vertices.get(r.nextInt(vertices.size()));
		}

		return retVal;
	}

	/**
	 * Get the smallest edge from the already visited vertices, which is not
	 * already in the tree. Also ignores edges which are between two vertices
	 * that are already visited.
	 * 
	 * @return
	 */
	public final Edge getSmallestEdgeFromVisitedVertices()
	{
		List<Vertex> visitedVertices = getVisitedVertices();
		List<Edge> edgeList = new ArrayList<Edge>();

		for (Vertex v : visitedVertices)
		{
			for (Edge e : getEdgesNotInTree(v))
			{
				if (!e.bothVerticesVisited())
				{
					edgeList.add(e);
				}
			}
		}

		Edge smallestEdge = getSmallestEdge(edgeList);
		smallestEdge.setInTree();
		return smallestEdge;
	}

	private Edge getSmallestEdge(List<Edge> edgeList)
	{
		if (edgeList != null && edgeList.size() < 1)
		{
			illegalArgument("Edgelist must have at least one element.");
		}

		Edge smallestEdge = edgeList.get(0);

		for (Edge e : edgeList)
		{
			if (e.getWeight() < smallestEdge.getWeight())
			{
				smallestEdge = e;
			}
		}

		return smallestEdge;
	}

	private List<Vertex> getVisitedVertices()
	{
		List<Vertex> visitedVertices = new ArrayList<Vertex>();

		for (Vertex v : vertices)
		{
			if (v.visited())
			{
				visitedVertices.add(v);
			}
		}

		return visitedVertices;
	}

	/**
	 * Check if there are any univisted Vertices left in the list.
	 * 
	 * @return
	 */
	public boolean hasUnvisitedVertices()
	{
		for (Vertex v : vertices)
		{
			if (!v.visited())
			{
				return true;
			}
		}

		return false;
	}

	private void illegalArgument(String string)
	{
		throw new IllegalArgumentException(string);
	}
}
