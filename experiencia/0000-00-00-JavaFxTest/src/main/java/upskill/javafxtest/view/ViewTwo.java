package upskill.javafxtest.view;

import javafx.stage.Stage;
import upskill.javafxtest.controller.ViewTwoController;

public class ViewTwo extends ViewBase {

    public ViewTwo(Stage stage) {
        super(stage, "This is scene 2", e -> new ViewTwoController(stage).handleMousePress(e));
    }
}
