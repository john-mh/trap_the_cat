package model.factory;

import javafx.scene.Group;
import javafx.scene.Scene;
import model.graph.Graph;
import model.graph.Vertex;

import java.util.List;
import java.util.stream.IntStream;

public class GraphFactory {

    public enum GraphType {
        LIST, MATRIX
    }

    private static final int SIZE = 50;

    public static Graph createGraph(GraphType type) {
        return switch (type) {
            case LIST -> new Graph(listGraphTemplate());
            case MATRIX -> new Graph(matrixGraphTemplate());
        };
    }

    private static List<Vertex> listGraphTemplate() {
        return IntStream.range(0, SIZE)
                .mapToObj(i -> new Vertex(i + 1))
                .toList();
    }

    //TODO finish adjacency matrix
    private static int[][] matrixGraphTemplate() {
        int[][] matrix = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrix[i][j] = 0;
            }
        }

        matrix[0][1] = 1;
        matrix[0][2] = 1;


        return matrix;
    }

}