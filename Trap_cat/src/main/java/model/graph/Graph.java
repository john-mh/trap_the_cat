
package model.graph;

import java.util.List;

public sealed interface Graph permits ListGraph, MatrixGraph {
    void addVertex(Vertex vertex);
    void addEdge(Edge edge);
    void removeVertex(Vertex vertex);
    void removeEdge(Edge edge);
    boolean isAdjacent(Vertex vertex1, Vertex vertex2);
    List<Vertex> getNeighbors(Vertex vertex);
}
