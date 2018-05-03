package graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private double x;
    private double y;
    private List<Vertex> neighbours = new ArrayList<>();

    /**
     * Constructor for Vertex that takes the x and y coordinates of the vertex.
     * @param x : Coordinate between 0 and 1
     * @param y : Coordinate between 0 and 1
     */
    Vertex(double x, double y) {
        if (x >= 0 && x <= 1) {
            this.x = x;
        }

        if (y >= 0 && y <= 1) {
            this.y = y;
        }
    }

    /**
     * Getter method for X coordinate
     * @return : X coordinate
     */
    public double getX() {
        return this.x;
    }

    /**
     * Getter method for Y coordinate
     * @return : Y coordinate
     */
    public double getY() {
        return this.y;
    }

    /**
     * Calculates weight between two given Vertex using pythagoras theorem
     * @param vertex1
     * @param vertex2
     * @return : Value of weight
     */
    public static double weight(Vertex vertex1, Vertex vertex2) {
        return Math.sqrt(Math.pow((vertex1.getX() - vertex2.getX()), 2) + Math.pow((vertex1.getY() - vertex2.getY()), 2));
    }

    /**
     * Adds a vertex as a neighbour to this instance of Vertex
     * @param neighbour : Neighbour Vertex
     */
    public void addNeighbour(Vertex neighbour) {
        neighbours.add(neighbour);
    }

    /**
     * Returns a list of all neighbours of the Vertex (note, if the edges are directed this includes vertices connected going the 'wrong way' down the edge)
     * @return : List of Vertices that are the neighbour of this instance of Vertex
     */
    public List<Vertex> neighbours() {
        return this.neighbours;
    }

}
