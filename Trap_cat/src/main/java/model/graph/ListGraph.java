// En model.graph
package model.graph;

import java.util.ArrayList;
import java.util.List;

public final class ListGraph implements Graph {
    private final List<Vertex> vertices;
    private final List<Edge> edges;

    public ListGraph() {
        this.vertices = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    // Implementa las operaciones del grafo utilizando listas de adyacencia
    @Override
    public void addVertex(Vertex vertex) {
        // Implementa la lógica para agregar un vértice en la lista de adyacencia
    }

    @Override
    public void addEdge(Edge edge) {
        // Implementa la lógica para agregar una arista en la lista de adyacencia
    }

    @Override
    public void removeVertex(Vertex vertex) {
        // Implementa la lógica para eliminar un vértice de la lista de adyacencia
    }

    @Override
    public void removeEdge(Edge edge) {
        // Implementa la lógica para eliminar una arista de la lista de adyacencia
    }

    @Override
    public boolean isAdjacent(Vertex vertex1, Vertex vertex2) {
        // Implementa la lógica para verificar si dos vértices son adyacentes en la lista de adyacencia
        return false;
    }

    @Override
    public List<Vertex> getNeighbors(Vertex vertex) {
        // Implementa la lógica para obtener los vértices vecinos de un vértice en la lista de adyacencia
        return null;
    }
}
