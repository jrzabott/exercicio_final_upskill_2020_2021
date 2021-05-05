package upskill.javafxtest.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import upskill.javafxtest.MainApp;
import upskill.javafxtest.controller.MainController;

public class MainView implements ViewMaker {

    private Stage stage;

    public MainView(Stage stage) {
        this.stage = stage;
    }

    @Override
	public Scene getScene() {
		
		MainController controller = new MainController(stage);
		
		Button button1 = new Button("Scene 1");
		button1.setOnMousePressed(e -> controller.handleOnPressButton1(e));
		Button button2 = new Button("Scene 2");
		button2.setOnMousePressed(e -> controller.handleOnPressButton2(e));
		Button button3 = new Button("Scene 3");
		button3.setOnMousePressed(e -> controller.handleOnPressButton3(e));
		
		VBox vbox = new VBox();
		vbox.setSpacing(10);
		vbox.setPadding(new Insets(10));
		vbox.getChildren().addAll(button1, button2, button3);
		
		BorderPane root = new BorderPane();
		root.setLeft(vbox);
		Label label = new Label("Main Scene");
		label.setFont(new Font(32));
		root.setCenter(label);
		
		Button closeButton = new Button("Close");
		closeButton.setOnMousePressed(e -> stage.close());
		ButtonBar bbar = new ButtonBar();
		bbar.setPadding(new Insets(10));
		bbar.getButtons().add(closeButton);
		root.setBottom(bbar);
		Scene scene = new Scene(root, 300, 160);
		
		return scene;
	}
}
