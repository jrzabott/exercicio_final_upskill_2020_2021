package upskill.javafxtest.controller;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import upskill.javafxtest.MainApp;
import upskill.javafxtest.model.SceneName;

public class MainController {
    private Stage stage;
	
	public MainController(Stage stage) {
		this.stage = stage;
	}

	public void handleOnPressButton1(MouseEvent event) {
		stage.setScene(MainApp.getScenes().get(SceneName.SCENE1));
	}
	
	public void handleOnPressButton2(MouseEvent event) {
		stage.setScene(MainApp.getScenes().get(SceneName.SCENE2));
	}
	
	public void handleOnPressButton3(MouseEvent event) {
		stage.setScene(MainApp.getScenes().get(SceneName.SCENE3));
	}
}
