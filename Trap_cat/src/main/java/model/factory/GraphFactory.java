package model.factory;

import exceptions.NoSuchGraphTypeException;
import model.graph.Graph;
import model.graph.ListGraph;
import model.graph.MatrixGraph;

public class GraphFactory {

    public static Graph createGraph(GraphType type) throws NoSuchGraphTypeException {
        return switch (type) {
            case LIST -> new ListGraph();
            case MATRIX -> new MatrixGraph();
            default -> throw new NoSuchGraphTypeException();
        };
    }

}