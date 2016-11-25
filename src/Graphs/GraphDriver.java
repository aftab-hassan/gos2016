package Graphs;

public class GraphDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Graph graph = new Graph();
		
//		graph.addvertices("A");
//		graph.addvertices("B");
//		graph.addvertices("S");
//		graph.addvertices("C");
//		graph.addvertices("D");
//		graph.addvertices("E");
//		graph.addvertices("F");
//		graph.addvertices("G");
//		graph.addvertices("H");
//		graph.addvertices("I");
//		graph.addvertices("J");
//		
//		graph.addedges("A", "B");
//		graph.addedges("A", "S");
//		graph.addedges("S", "C");
//		graph.addedges("S", "G");
//		graph.addedges("C", "D");
//		graph.addedges("C", "E");
//		graph.addedges("C", "F");
//		graph.addedges("G", "F");
//		graph.addedges("G", "H");
//		graph.addedges("E", "H");
//		graph.addedges("H", "I");
//		graph.addedges("I", "J");
		
		graph.addvertices("5");
		graph.addvertices("4");
		graph.addvertices("3");
		graph.addvertices("2");
		graph.addvertices("1");
		graph.addvertices("0");
		
		graph.addedges("5", "2");
		graph.addedges("5", "0");
		graph.addedges("4", "0");
		graph.addedges("4", "1");
		graph.addedges("2", "3");
		graph.addedges("3", "1");
		
		graph.displayedges();
//		graph.breadthfirstsearch();
//		graph.depthfirstsearchiterative();
//		graph.depthfirstsearchrecursive();
//		graph.dfsusingstack();
		graph.topologicalsortrecursive();
	}

}
