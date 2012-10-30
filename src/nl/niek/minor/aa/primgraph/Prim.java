package nl.niek.minor.aa.primgraph;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that creates a minimum spanning tree from the given NodeMap.
 * 
 * @author Niek
 * 
 */
public class Prim
{
	private NodeMap	nodeMap;

	public Prim()
	{
		nodeMap = NodeMap.getDefaultNodeMap();
	}

	public Prim(NodeMap nodeMap)
	{
		this.nodeMap = nodeMap;
	}

	/**
	 * Find the minimum spanning tree for the given connected weighted graph.
	 * For now it always starts at the first Vertex of the list.
	 */
	public void go()
	{
		/* Pick a starting vertex. */
		Vertex startVertex = nodeMap.getStart();
		startVertex.setVisited();
		println("Starting at " + startVertex.getName() + ".");

		/* List of edges representing the minimum spanning tree. */
		List<Edge> tree = new ArrayList<Edge>();

		println("Looping...");
		while (nodeMap.hasUnvisitedVertices())
		{
			Edge smallestEdge = nodeMap.getSmallestEdgeFromVisitedVertices();

			smallestEdge.getOne().setVisited();
			smallestEdge.getTwo().setVisited();

			tree.add(smallestEdge);
			println("Added: " + smallestEdge.toString());
		}

		println("\nDone. List of edges in the minimum spanning tree:");
		printEdges(tree);
	}

	private void printEdges(List<Edge> edges)
	{
		for (Edge e : edges)
		{
			println(e.toString());
		}
	}

	public static void print(String string)
	{
		System.out.print(string);
	}

	public static void println(String string)
	{
		System.out.println(string);
	}
}
