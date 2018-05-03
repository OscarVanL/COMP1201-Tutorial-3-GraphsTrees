package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Graph {

    Random rand = new Random();
    private List<Vertex> vertices = new ArrayList<>();
    private List<Edge> edges = new ArrayList<>();
    private boolean isDirected;

    public static void main(String args[]) {
        //Generates a random graph where n=number of vertices, p=probability of having edge to another vertex
        Graph graph = new Graph(false);
        graph.randomGraph(20, 0.35);
        graph.displayGraph();
    }

    /**
     * When creating our graph, if we pass true as argument, all edges in the graph will be directed.
     * @param edgesDirected : Should all edges added to the graph be directional (true) or bidirectional (false).
     */
    Graph(boolean edgesDirected) {
        this.isDirected = edgesDirected;
    }

    /**
     * Generates a random bidirectional graph, with vertices in random places. These have bidirectional edges
     * @param n : Number of vertices to add to the graph.
     * @param p : Probability of an edge from that vertex.
     */
    public void randomGraph(int n, double p) {
        randomVertices(n);
        randomEdges(p);
    }

    /**
     * Adds vertices in random places on our graph.
     * @param n : Number of vertices to add.
     */
    public void randomVertices(int n) {
        for (int i=0; i<n; i++) {
            vertices.add(new Vertex(Math.random(), Math.random()));
        }
    }

    /**
     * Adds random edges to the vertices in our graph.
     * @param p : Probability that an edge will be created.
     */
    public void randomEdges(double p) {
        //Iterates through every vertex and with probability p picks another vertex to become neighbours with.
        //Then we create a new edge, which we choose to be directed.
        for (Vertex vertexStart : vertices) {
            for (Vertex vertexEnd : vertices) {
                if (Math.random() <= p && vertexStart != vertexEnd) {
                    vertexStart.addNeighbour(vertexEnd);
                    vertexEnd.addNeighbour(vertexStart);
                    edges.add(new Edge(vertexStart, vertexEnd, isDirected));
                }
            }
        }
    }

    /**
     * Uses our GraphDisplay class to show the graph we generated.
     */
    public void displayGraph() {
        GraphDisplay display = new GraphDisplay();
        display.showInWindow(500,500,"A Random Graph");

        for (Vertex vertex : vertices) {
            display.addNode(vertex, vertex.getX(), vertex.getY());
        }

        for (Edge edge : edges) {
            display.addEdge(edge.getStartVertex(), edge.getEndVertex());
        }

    }

    /**
     * Determines whether an edge exists between the two vertices (this does conform to the edge's direction)
     * @param startVertex : Vertex to check for edges
     * @param endVertex : Vertex to check for edges
     * @return true (If an edge between exist), false (If no edge between exists)
     */
    public boolean edgeExists(Vertex startVertex, Vertex endVertex) {
        for (Edge edge : edges) {
            if (edge.isDirectional()) {
                if (edge.getStartVertex() == startVertex && edge.getEndVertex() == endVertex) {
                    return true;
                }
            } else {
                if ((edge.getStartVertex() == startVertex && edge.getEndVertex() == endVertex) | (edge.getEndVertex() == startVertex && edge.getStartVertex() == endVertex)) {
                    return true;
                }
            }
        }
        return false;
    }
}
