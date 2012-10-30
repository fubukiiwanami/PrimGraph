package nl.niek.minor.aa.primgraph;

public class PrimGraphFactory
{
	/**
	 * Default example set of Vertices and Edges as seen on <a
	 * href="http://en.wikipedia.org/wiki/Prim's_algorithm#Example_run"
	 * >Wikipedia<a>.
	 * 
	 * @return
	 */
	public static PrimGraph getDefaultGraph()
	{
		PrimGraph nodeMap = new PrimGraph();

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

}
