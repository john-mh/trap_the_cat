package control;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class GameController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ImageView logoImageView;

    @FXML
    private TextField usernameTextField;

    @FXML
    private Button goButton;

    @FXML
    private void initialize() {
       
    }

    @FXML
    private void go() throws IOException {
        // Aquí puedes agregar lógica para manejar el evento del botón "GO"
        // Por ejemplo, cargar una nueva escena o realizar alguna acción.
    }
}
