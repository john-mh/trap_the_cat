package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import javafx.stage.Stage;
import model.entity.User;
import model.logic.GameManager;

import java.io.IOException;


public class StartController {

    GameManager manager;
    GameController games;
    private Stage st;
    private Stage godParent;
    private Stage mainStage;

    public StartController() {
    }


    public StartController(GameManager manager) {

        this.manager = manager;
    }

    @FXML
    private TextField usernameTextField;


    @FXML
    private void initialize() {

    }

    @FXML
    public void go(ActionEvent event) throws IOException {

        String res = usernameTextField.getText();

        if (!res.isEmpty()) {

            manager.setCurrent(new User(res));
            Stage mainStage  = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
            loader.setController(this);
            Parent p = loader.load();
            mainStage.setScene(new Scene(p));
            mainStage.show();

        }else {

            Alert a = new Alert(Alert.AlertType.ERROR, "Username textfield must be not empty!", ButtonType.OK);
            a.setTitle("What?!");
            a.showAndWait();
        }
    }
}
