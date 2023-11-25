package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.GameManager;

import java.io.IOException;

public class StartController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ImageView logoImageView;

    @FXML
    private TextField usernameTextField;

    @FXML
    private Button goButton;

    GameManager manager;

    public StartController(GameManager manager) {
        this.manager = manager;
    }

    @FXML
    private void initialize() {

    }

    public void initializeLeaderBoard() {

        if (manager.getRoot() != null) {

            setLeaderBoardTV();
        }
        if (manager.getCurrent() == null) {

            msgLb.setText("");
        }
    }

    @FXML
    public void go(ActionEvent event) throws IOException {

        String res = usernameTextField.getText();

        if (!res.isEmpty()) {

            manager.setCurrent(new User(res));
            mainStage  = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPane.fxml"));
            loader.setController(this);
            Parent p = loader.load();
            mainStage.setScene(new Scene(p));
            mainStage.show();
            initializeMainPane(res);
            st.close();
            manager.startNewGame(res);
            timer = new Timer(10,this);
            timer.setDaemon(true);
            barT = new BarThread(this);
            barT.setDaemon(true);
            timer.start();
            barT.start();
        }else {

            Alert a = new Alert(AlertType.ERROR, "Username textfield must be not empty!", ButtonType.OK);
            a.setTitle("What?!");
            a.showAndWait();
        }
    }
}