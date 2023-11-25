package control;

import game.trap_the_cat.GameApplication;
import model.entity.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

import java.net.URL;

import java.util.ResourceBundle;

public class LeaderboardController implements Initializable {

    @FXML
    private TableColumn<User, Integer> posTc;
    @FXML
    private TableColumn<User, String> nameTc;
    @FXML
    private TableColumn<User, Integer> scoreTc;
    @FXML
    private Label msgLb;
    @FXML
    private TableView<User> tv;
    @FXML
    private Button exitButton;
    @FXML
    private Button newGameButton;
    @FXML
    private Button deleteScoreButton;

    @FXML
    public void startNewGame(ActionEvent event) throws IOException {
        //GameManager.getInstance().exportData();
        GameApplication.hideWindow((Stage) exitButton.getScene().getWindow());
        GameApplication.showWindow("start", null, 600, 500);
    }

    @FXML
    public void deleteCurrentScore(ActionEvent event) {
        // Lógica para eliminar el puntaje actual
        // Puedes dejar el cuerpo vacío si no necesitas ninguna lógica aquí
    }

    @FXML
    public void exitGame(ActionEvent event) throws IOException {
        //GameManager.getInstance().exportData();
        GameApplication.hideWindow((Stage) exitButton.getScene().getWindow());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    /**
    public void initializeLeaderBoard() {

        if (manager.getRoot() != null) {

            setLeaderBoardTV();
        }
        if (manager.getCurrent() == null) {

            msgLb.setText("");
        }
    }
     */

    /**
    private void setLeaderBoardTV() {

        ArrayList<User> a = (ArrayList<User>) manager.getUsersList();
        ArrayList<User> b = new ArrayList<>();

        if (a.size() < 5) {

            b = a;
        }else {

            for (int i = 0; i < 5; i++) {

                a.add(a.get(i));
            }
        }


        ObservableList<User> observableList;
        observableList = FXCollections.observableArrayList(b);

        tv.setItems(observableList);
        nameTc.setCellValueFactory(new PropertyValueFactory<User,String>("name"));
        scoreTc.setCellValueFactory(new PropertyValueFactory<User,Integer>("score"));
        posTc.setCellValueFactory(new PropertyValueFactory<User,Integer>("position"));
    }
    */
}
