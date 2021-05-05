package upskill.javafxtest.view;

import javafx.stage.Stage;
import upskill.javafxtest.controller.ViewOneController;

public class ViewOne extends ViewBase {

    public ViewOne(Stage stage) {
        super(stage, "This is scene 1", e -> new ViewOneController(stage).handleMousePress(e));
    }
}
