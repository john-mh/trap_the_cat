package control;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;
import model.logic.GameManager;

import java.util.List;
import java.util.Objects;
import java.util.Timer;

public class GameController {

    static final Paint BLOCKED = Color.rgb(84, 99, 17);
    static final Paint OPEN = Color.rgb(218, 247, 12);
    static final Paint BILAIASE = Color.RED;

    @FXML
    private AnchorPane floorPane;

    private List<Polygon> polygons;

    @FXML
    private ImageView catLeft;

    //TODO transition from bilaiase to closed
    @FXML
    private void onMouseClicked(MouseEvent event) {
        Polygon polygon = (Polygon) event.getSource();
        if (polygon.getFill().equals(OPEN)) {
            polygon.setFill(BLOCKED);
            int id = Integer.parseInt(polygon.getId().substring(4));
            //TODO tal vez mover esto a un metodo de GameManager
            GameManager.getInstance().getGraph().getVertex(id).setClosed(true);
            GameManager.getInstance().getGraph().deleteFromNeighbours(id);
            GameManager.getInstance().moveCat();
        } else {
            polygon.setFill(BILAIASE);

            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(polygon.fillProperty(), BILAIASE)),
                    new KeyFrame(Duration.seconds(3), new KeyValue(polygon.fillProperty(), BLOCKED))
            );

            timeline.play();
        }
    }

    @FXML
    private void initialize() {
        catLeft.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/game/trap_the_cat/cat_left.png"))));

        for(int i = 0; i < floorPane.getChildren().size(); i++) {
            Polygon polygon = (Polygon) floorPane.getChildren().get(i);
            polygon.setFill(OPEN);
            int id = Integer.parseInt(polygon.getId().substring(4));
            GameManager.getInstance().getGraph().setPolygon(id + 1, polygon);
        }
    }

}
