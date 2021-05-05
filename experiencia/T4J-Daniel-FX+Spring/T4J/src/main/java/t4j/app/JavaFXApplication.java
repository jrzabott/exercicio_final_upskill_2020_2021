/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javax.annotation.PostConstruct;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;
import t4j.app.ui.MainSceneController;

/**
 *
 * @author user
 */
public class JavaFXApplication extends Application {

    private ConfigurableApplicationContext applicationContext;

    public static void main(String[] args) {
        launch(args);
    }

    // Method start, já inclui componentes da UI.
    @Override
    public void start(Stage primaryStage) throws Exception {
        applicationContext.publishEvent(new StageReadyEvent(primaryStage));

    }

    @Override
    public void stop() throws Exception {
        super.stop();
        applicationContext.close();
        Platform.exit();
    }

    // Method Init, antes de qualquer operação gráfica
    @Override
    public void init() throws Exception {

        applicationContext = new SpringApplicationBuilder(AppApplication.class)
                .run();
        applicationContext.getAutowireCapableBeanFactory().autowireBean(this);

    }

    static class StageReadyEvent extends ApplicationEvent {

        public StageReadyEvent(Stage stage) {
            super(stage);
        }

        public Stage getStage() {
            return (Stage) this.getSource();
        }
    }

}
