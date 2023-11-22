module game.trap_the_cat {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens game.trap_the_cat to javafx.fxml;
    exports game.trap_the_cat;
    exports control;
    opens control to javafx.fxml;
}