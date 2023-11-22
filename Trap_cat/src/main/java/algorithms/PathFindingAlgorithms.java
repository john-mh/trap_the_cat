package algorithms;

import exceptions.AlgorithmTypeMismatchException;
import exceptions.NotSuchAlgorithmException;
import model.graph.Graph;
import model.graph.Vertex;

import java.util.List;

public class PathFindingAlgorithms {

    public static List<Vertex> findPath(Algorithm algorithm, Graph graph, Vertex source, Vertex target) throws AlgorithmTypeMismatchException, NotSuchAlgorithmException {
        List<Vertex> result;

        switch (algorithm) {
            case BFS -> result = bfs(graph, source, target);
            case DFS -> result = dfs(graph, source, target);

            case DIJKSTRA -> result = dijkstra(graph, source, target);
            case FLOYD_WARSHALL -> result = floydWarshall(graph, source, target);
            case PRIM, KRUSKAL -> throw new AlgorithmTypeMismatchException();
            default -> throw new NotSuchAlgorithmException();
        }

        return result;
    }

    private static List<Vertex> bfs(Graph graph, Vertex source, Vertex target) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static List<Vertex> dfs(Graph graph, Vertex source, Vertex target) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static List<Vertex> dijkstra(Graph graph, Vertex source, Vertex target) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static List<Vertex> floydWarshall(Graph graph, Vertex source, Vertex target) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
