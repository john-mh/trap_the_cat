package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.entity.User;
import model.logic.GameManager;

import java.io.IOException;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.control.cell.PropertyValueFactory;


public class LeaderboardController implements Initializable {

    public LeaderboardController() {
    }

    GameManager manager;

    public LeaderboardController(GameManager manager) {
        this.manager = new GameManager();
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
    private TableView<User> tv;



    @FXML
    public void startNewGame(ActionEvent event) throws IOException {

        manager.exportData();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("start.fxml"));
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
