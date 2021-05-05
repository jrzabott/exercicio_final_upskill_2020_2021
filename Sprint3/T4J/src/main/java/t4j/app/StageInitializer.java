/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import t4j.app.JavaFXApplication.StageReadyEvent;
import t4j.app.dto.UserInfoDTO;
import t4j.app.model.Plataforma;
import t4j.app.repo.EnumFXMLs;
import t4j.app.service.PlataformaService;
import t4j.app.ui.AlertaUI;
import t4j.app.ui.MainSceneController;

/**
 *
 * @author user
 */
@Component
public class StageInitializer implements
        ApplicationListener<StageReadyEvent> {

    private ConfigurableApplicationContext applicationContext;

    public StageInitializer(ConfigurableApplicationContext context) {
        this.applicationContext = context;

    }

    public ConfigurableApplicationContext getContext() {
        return applicationContext;
    }

    @Override
    public void onApplicationEvent(StageReadyEvent e) {

        try {
            Stage stage = e.getStage();

            FXMLLoader loader = new FXMLLoader(MainSceneController.class
                    .getResource("/fxml/MainScene.fxml"));
            loader.setControllerFactory(aClass -> applicationContext.getBean(aClass));
            Parent parent = loader.load();

            Scene scene = new Scene(parent);

            final String stageTitle = Plataforma.getTITULO_APLICACAO();

            stage.setScene(scene);
            stage.sizeToScene();
            stage.setResizable(false);
            stage.setOnCloseRequest((WindowEvent event) -> {
                Alert alerta = AlertaUI
                        .criarAlerta(Alert.AlertType.CONFIRMATION,
                                stageTitle, "Confirmação da ação.",
                                "Deseja mesmo encerrar a aplicação?");

                if (alerta.showAndWait().get() == ButtonType.CANCEL) {
                    event.consume();
                }

                MainSceneController msc = loader.getController();
                msc.getAppController().logoutAction(true);
            });

//            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle(EnumFXMLs.MAIN_SCENE.getTitle());
            stage.setResizable(false);
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(StageInitializer.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

}
