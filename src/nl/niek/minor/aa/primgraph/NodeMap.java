package nl.niek.minor.aa.primgraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Wrapping class for the list of vertices and edges.
 * 
 * @author Niek
 * 
 */
public class NodeMap
{
	private List<Vertex>	vertices;
	private List<Edge>		edges;

	public NodeMap()
	{
		vertices = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
	}

	/**
	 * Default example set of Vertices and Edges as seen on <a
	 * href="http://en.wikipedia.org/wiki/Prim's_algorithm#Example_run"
	 * >Wikipedia<a>.
	 * 
	 * @return
	 */
	public static NodeMap getDefaultNodeMap()
	{
		NodeMap nodeMap = new NodeMap();

		Vertex a = new Vertex("A");
		Vertex b = new Vertex("B");
		Vertex c = new Vertex("C");
		Vertex d = new Vertex("D");
		Vertex e = new Vertex("E");
		Vertex f = new Vertex("F");
		Vertex g = new Vertex("G");

		nodeMap.addVertex(a);
		nodeMap.addVertex(b);
		nodeMap.addVertex(c);
		nodeMap.addVertex(d);
		nodeMap.addVertex(e);
		nodeMap.addVertex(f);
		nodeMap.addVertex(g);

		Edge ab = new Edge(a, b, 7);
		Edge ad = new Edge(a, d, 5);

		Edge bc = new Edge(b, c, 8);
		Edge be = new Edge(b, e, 7);
		Edge bd = new Edge(b, d, 9);

		Edge ce = new Edge(c, e, 5);
		Edge eg = new Edge(e, g, 9);
		Edge ef = new Edge(e, f, 8);

		Edge df = new Edge(d, f, 6);
		Edge de = new Edge(d, e, 15);

		Edge fg = new Edge(f, g, 11);

		nodeMap.addEdge(ab);
		nodeMap.addEdge(ad);
		nodeMap.addEdge(bc);
		nodeMap.addEdge(be);
		nodeMap.addEdge(bd);
		nodeMap.addEdge(ce);
		nodeMap.addEdge(eg);
		nodeMap.addEdge(ef);
		nodeMap.addEdge(df);
		nodeMap.addEdge(de);
		nodeMap.addEdge(fg);

		return nodeMap;
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

	public void addVertex(final Vertex newVertex)
	{
		vertices.add(newVertex);
	}

	public void addEdge(final Edge newEdge)
	{
		edges.add(newEdge);
	}

	/**
	 * Starting at D
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
