package vertex;

import java.util.Arrays;
import java.util.List;

public class Edge {
    private Vertex vertexStart;
    private Vertex vertexEnd;
    private boolean isDirectional;
    private double weight;

    Edge(Vertex vertexStart, Vertex vertexEnd, boolean isDirectional) {
        this.vertexStart = vertexStart;
        this.vertexEnd = vertexEnd;
        this.isDirectional = isDirectional;
        this.weight = Vertex.weight(vertexStart, vertexEnd);
    }

    /**
     * Getter method for weight
     * @return weight of edge.
     */
    public double weight() {
        return weight;
    }

    /**
     * Returns Start/first vertex
     * @return start/first vertex
     */
    public Vertex getStartVertex() {
        return vertexStart;
    }

    /**
     * Returns End/second vertex
     * @return end/second Vertex
     */
    public Vertex getEndVertex() {
        return vertexEnd;
    }

    /**
     * Returns whether the edge is directional (true) or bidirectional (false)
     * @return true (directional), false (bidirectional)
     */
    public boolean isDirectional() {
        return isDirectional;
    }

    /**
     * Returns a list containing the Start and End vertices of the edge.
     * @return List of start and end vertices.
     */
    public List<Vertex> getVertices() {
        List<Vertex> vertices = Arrays.asList(vertexStart, vertexEnd);
        return vertices;
    }


}
