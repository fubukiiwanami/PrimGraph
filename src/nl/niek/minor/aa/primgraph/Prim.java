package nl.niek.minor.aa.primgraph;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that creates a minimum spanning tree from the given (Prim) Graph.
 * 
 * @author Niek
 * 
 */
public class Prim
{
	private PrimGraph	graph;

	public Prim()
	{
		graph = PrimGraphFactory.getDefaultGraph();
	}

	public Prim(PrimGraph graph)
	{
		this.graph = graph;
	}

	/**
	 * Find the minimum spanning tree for the given connected weighted graph.
	 */
	public void makeMinimumSpanningTree()
	{
		/* Pick a starting vertex. */
		Vertex startVertex = graph.getStart();
		startVertex.setVisited();
		println("Starting at " + startVertex.getName() + ".");

		/* List of edges representing the minimum spanning tree. */
		List<Edge> tree = new ArrayList<Edge>();

		/* While not all Vertices are visited */
		while (graph.hasUnvisitedVertices())
		{
			Edge smallestEdge = graph.getSmallestEdgeFromVisitedVertices();

			/*
			 * This edge is now added, therefore both ends must be visited.
			 * (Regardless of previous status)
			 */
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
