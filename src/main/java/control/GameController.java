package control;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;
import model.graph.Vertex;
import model.logic.GameManager;

import java.net.URL;
import java.util.*;

public class GameController implements Initializable {

    static final Paint BLOCKED = Color.rgb(84, 99, 17);
    static final Paint OPEN = Color.rgb(218, 247, 12);
    static final Paint BILAIASE = Color.RED;

    @FXML
    private AnchorPane floorPane;

    private List<Polygon> polygons;

    @FXML
    private ImageView catLeft;
    private boolean canClick = true;

    //TODO ckeck transition
    @FXML
    private void onMouseClicked(MouseEvent event) {
        Polygon polygon = (Polygon) event.getSource();

        if (!canClick) return;

        if (polygon.getFill().equals(OPEN)) {
            canClick = false;
            polygon.setFill(BLOCKED);
            int id = Integer.parseInt(polygon.getId().substring(4));
            GameManager.getInstance().getGraph().getVertex(id).setClosed(true);
            GameManager.getInstance().getGraph().deleteFromNeighbours(id);

            // Obtener vértices adyacentes al gato
            Vertex catPosition = GameManager.getInstance().getGraph().getCatPosition();
            List<Vertex> adjacentVertices = GameManager.getInstance().getGraph().getAdjacentVertices(catPosition);

            // Seleccionar un vértice adyacente al azar
            Vertex randomVertex = getRandomAdjacentVertex(adjacentVertices);

            // Actualizar la posición del gato
            GameManager.getInstance().getGraph().setCatPosition(randomVertex);
            moveCatImage(randomVertex.getPolygon());

            PauseTransition wait = new PauseTransition(Duration.seconds(0.35));
            wait.setOnFinished(e -> canClick = true);
            wait.play();
        } else {
            polygon.setFill(BILAIASE);

            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(polygon.fillProperty(), BILAIASE)),
                    new KeyFrame(Duration.seconds(3), new KeyValue(polygon.fillProperty(), BLOCKED))
            );

            timeline.play();
        }
    }

    private Vertex getRandomAdjacentVertex(List<Vertex> vertices) {
        // Seleccionar un vértice al azar de la lista de vértices adyacentes
        int randomIndex = new Random().nextInt(vertices.size());
        return vertices.get(randomIndex);
    }


    private void moveCatImage(Polygon polygon) {
        double x = polygon.getLayoutX() - 36.5;
        double y = polygon.getLayoutY() - 26;
        catLeft.setLayoutX(x);
        catLeft.setLayoutY(y);
        catLeft.toFront();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (int i = 0; i < floorPane.getChildren().size(); i++) {
            if(floorPane.getChildren().get(i) instanceof ImageView) continue;
            Polygon polygon = (Polygon) floorPane.getChildren().get(i);
            polygon.setFill(OPEN);
            polygon.toBack();
            int id = Integer.parseInt(polygon.getId().substring(4));
            GameManager.getInstance().getGraph().setPolygon(id, polygon);
        }

        this.catLeft.setImage(new Image("file:src/assets/GatoAbajo.png"));
        moveCatImage(GameManager.getInstance().getGraph().getVertex(61).getPolygon());
        System.out.println(this.catLeft.getLayoutX() + " " + this.catLeft.getLayoutY());
        this.catLeft.toFront();
    }
}
