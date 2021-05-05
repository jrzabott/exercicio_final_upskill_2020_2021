package upskill.javafxtest.view;

import javafx.stage.Stage;
import upskill.javafxtest.controller.ViewThreeController;

public class ViewThree extends ViewBase {

    public ViewThree(Stage stage) {
        super(stage, "This is scene 3", e -> new ViewThreeController(stage).handleMousePress(e));
    }
}
