package upskill.javafxtest.controller;

import javafx.event.Event;
import javafx.stage.Stage;
import upskill.javafxtest.MainApp;
import upskill.javafxtest.model.SceneName;

public class ViewThreeController {

    private Stage stage;

    public ViewThreeController(Stage stage) {
        if (stage == null) {
            throw new IllegalArgumentException("Stage cannot be null");
        }

        this.stage = stage;
    }

    public void handleMousePress(Event event) {
        stage.setScene(MainApp.getScenes().get(SceneName.MAIN));
    }
}
