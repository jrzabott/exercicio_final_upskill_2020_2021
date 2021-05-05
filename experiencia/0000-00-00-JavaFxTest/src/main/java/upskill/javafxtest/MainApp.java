package upskill.javafxtest;

import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import upskill.javafxtest.model.SceneName;
import javafx.scene.Scene;
import javafx.stage.Stage;
import upskill.javafxtest.view.MainView;
import upskill.javafxtest.view.ViewOne;
import upskill.javafxtest.view.ViewThree;
import upskill.javafxtest.view.ViewTwo;

public class MainApp extends Application {

    private static Map<SceneName, Scene> scenes = new HashMap<>();

    @Override
    public void start(Stage stage) throws Exception {

        scenes.put(SceneName.MAIN, new MainView(stage).getScene());
        scenes.put(SceneName.SCENE1, new ViewOne(stage).getScene());
        scenes.put(SceneName.SCENE2, new ViewTwo(stage).getScene());
        scenes.put(SceneName.SCENE3, new ViewThree(stage).getScene());

        stage.setScene(scenes.get(SceneName.MAIN));
        stage.setTitle("Multi-Scene Demo");
        stage.show();

//        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
//
//        Scene scene = new Scene(root);
//        scene.getStylesheets().add("/styles/Styles.css");
//
//        stage.setTitle("JavaFX and Maven");
//        stage.setScene(scene);
//        stage.show();
    }

    public static Map<SceneName, Scene> getScenes() {
        return scenes;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
