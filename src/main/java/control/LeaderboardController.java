package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import model.entity.User;
import model.logic.GameManager;

import java.io.IOException;

public class LeaderboardController {

    public LeaderboardController() {
    }

    GameManager manager;

    public LeaderboardController(GameManager manager) {
        this.manager = manager;
    }

    @FXML
    private TableColumn<User, Integer> posTc;

    @FXML
    private TableColumn<User, String> nameTc;

    @FXML
    private TableColumn<User, Integer> scoreTc;

    @FXML
    private Label msgLb;


    @FXML
    public void startNewGame(ActionEvent event) throws IOException {

        manager.exportData();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("leaderboard.fxml"));
        loader.setController(this);
        Parent parent = loader.load();
        Stage st = new Stage();
        st.setScene(new Scene(parent));
        st.showAndWait();
    }

    @FXML
    public void deleteCurrentScore(ActionEvent event) {
        // Lógica para eliminar el puntaje actual
        // Puedes dejar el cuerpo vacío si no necesitas ninguna lógica aquí
    }

    @FXML
    public void exitGame(ActionEvent event){

    }

    @FXML
    public void initialize() {
        // Inicialización, si es necesaria
    }

}
