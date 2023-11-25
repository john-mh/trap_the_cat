package control;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

public class GameController {
    @FXML
    private Button startButton;

    @FXML
    private Label scoreLabel;

    @FXML
    private Canvas gameCanvas;

    @FXML
    private void startGame() {
        drawCat();
    }

    private void drawCat() {
        GraphicsContext gc = gameCanvas.getGraphicsContext2D();

        // Cargar la imagen del gato
        Image catImage = new Image("/assets/Logo.png");

        // Dibujar la imagen del gato en el centro del Canvas
        double x = (gameCanvas.getWidth() - catImage.getWidth()) / 2;
        double y = (gameCanvas.getHeight() - catImage.getHeight()) / 2;

        gc.clearRect(0, 0, gameCanvas.getWidth(), gameCanvas.getHeight()); // Limpiar el Canvas antes de dibujar
        gc.drawImage(catImage, x, y);
    }
}
