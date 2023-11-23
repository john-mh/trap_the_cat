// En model.graph
package model.graph;

import java.util.ArrayList;
import java.util.List;

public final class MatrixGraph implements Graph {
    private final List<Vertex> vertices;
    private final int[][] adjacencyMatrix;

    public MatrixGraph() {
        this.vertices = new ArrayList<>();
        this.adjacencyMatrix = new int[0][0];  // Inicializa adjacencyMatrix según la cantidad de vértices
    }


    @Override
    public void addVertex(Vertex vertex) {
        // Implementa la lógica para agregar un vértice en la matriz de adyacencia
    }

    @Override
    public void addEdge(Edge edge) {
        // Implementa la lógica para agregar una arista en la matriz de adyacencia
    }

    @Override
    public void removeVertex(Vertex vertex) {
        // Implementa la lógica para eliminar un vértice de la matriz de adyacencia
    }

    @Override
    public void removeEdge(Edge edge) {
        // Implementa la lógica para eliminar una arista de la matriz de adyacencia
    }

    @Override
    public boolean isAdjacent(Vertex vertex1, Vertex vertex2) {
        // Implementa la lógica para verificar si dos vértices son adyacentes en la matriz de adyacencia
        return false;
    }

    @Override
    public List<Vertex> getNeighbors(Vertex vertex) {
        // Implementa la lógica para obtener los vértices vecinos de un vértice en la matriz de adyacencia
        return null;
    }
}
