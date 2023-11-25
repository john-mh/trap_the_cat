package model.graph;

import java.util.List;

public class Graph {

    private List<Vertex> vertices;
    private Vertex catPosition;

    private Graph() {
        setCatPosition(getVertex(61));
    }

    public Graph(List<Vertex> vertices) {
        this();
        this.vertices = vertices;
    }

    public Graph(int[][] matrix) {
        this();
    }

    private void fromAdjacencyMatrix(int[][] matrix) {

    }

    private void fromVerticesList(List<Vertex> vertices) {

    }

    public Vertex getCatPosition() {
        return catPosition;
    }
    public void setCatPosition(Vertex catPosition) {
        this.catPosition = catPosition;
    }

    public Vertex getVertex(int id) {
        return vertices.stream()
                .filter(v -> v.id() == id)
                .findFirst()
                .orElse(null);
    }

}
