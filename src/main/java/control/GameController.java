package control;

import game.trap_the_cat.GameApplication;
import model.logic.GameManager;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;

import javafx.stage.Stage;

import java.net.URL;

import javafx.util.Duration;
import java.util.List;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    static final Paint BLOCKED = Color.rgb(84, 99, 17);
    static final Paint OPEN = Color.rgb(218, 247, 12);
    static final Paint BILAIASE = Color.RED;

    @FXML
    private AnchorPane floorPane;

    @FXML
    private ImageView catLeft;
    private boolean canClick = true;

    @FXML
    private void onMouseClicked(MouseEvent event) {
        Polygon polygon = (Polygon) event.getSource();

        if (!canClick) return;

        if (polygon.getFill().equals(OPEN)) {
            canClick = false;
            polygon.setFill(BLOCKED);
            int id = Integer.parseInt(polygon.getId().substring(4));
            //TODO tal vez mover esto a un metodo de GameManager
            GameManager.getInstance().getGraph().getVertex(id).setClosed(true);
            GameManager.getInstance().getGraph().deleteFromNeighbours(id);
            GameManager.getInstance().moveCat();

            if(GameManager.getInstance().isGameFinished()) {
                canClick = false;
                catLeft.setVisible(false);

                Timeline timeline = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(floorPane.opacityProperty(), 1)),
                        new KeyFrame(Duration.seconds(1), new KeyValue(floorPane.opacityProperty(), 0.6)),
                        new KeyFrame(Duration.seconds(1), new KeyValue(floorPane.opacityProperty(), 0.4)),
                        new KeyFrame(Duration.seconds(1), new KeyValue(floorPane.opacityProperty(), 0.25)),
                        new KeyFrame(Duration.seconds(1), new KeyValue(floorPane.opacityProperty(), 0.15)),
                        new KeyFrame(Duration.seconds(1), new KeyValue(floorPane.opacityProperty(), 0.05))
                );

                timeline.play();

                PauseTransition wait = new PauseTransition(Duration.seconds(2));
                wait.setOnFinished(e -> {
                    GameApplication.hideWindow((Stage) floorPane.getScene().getWindow());
                    GameApplication.showWindow("leaderboard", null, 610, 610);
                });
                wait.play();
            }

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

    private void moveCatImage(Polygon polygon) {
        catLeft.setLayoutX(polygon.getLayoutX() - 36.5);
        catLeft.setLayoutY(polygon.getLayoutY() - 26);
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
        this.catLeft.toFront();
        GameManager.getInstance().setGameFinished(true); //test
    }
}
