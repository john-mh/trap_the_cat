package algorithms;

import exceptions.AlgorithmTypeMismatchException;
import exceptions.NotSuchAlgorithmException;
import model.graph.Edge;
import model.graph.Graph;

import java.util.List;

public class MSTAlgorithms {

    public static List<Edge> use(Algorithm algorithm, Graph graph) throws NotSuchAlgorithmException, AlgorithmTypeMismatchException {
        List<Edge> result;

        switch (algorithm) {
            case KRUSKAL -> result = kruskal(graph);
            case PRIM -> result = prim(graph);
            case BFS, DFS, DIJKSTRA, FLOYD_WARSHALL -> throw new AlgorithmTypeMismatchException();
            default -> throw new NotSuchAlgorithmException();
        }

        return result;
    }

    private static List<Edge> kruskal(Graph graph) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static List<Edge> prim(Graph graph) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}