package control;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import model.logic.GameManager;

import java.util.List;
import java.util.Objects;
import java.util.Timer;

public class GameController {
    public GameController() {
    }

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
        } else if (polygon.getFill().equals(BLOCKED)) {
            new Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            polygon.setFill(BILAIASE);
                        }
                    },
                    1000);
        }
    }

    @FXML
    void initialize() {

        catLeft.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/GatoIzquierda.png"))));
        floorPane.getChildren().stream()
                .map(node -> (Polygon) node)
                .forEach(poly -> {
                    polygons.add(poly);
                    poly.setFill(OPEN);
                });
    }

}
