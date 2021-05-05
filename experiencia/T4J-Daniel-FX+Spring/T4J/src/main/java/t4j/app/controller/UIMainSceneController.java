package t4j.app.controller;

import javafx.scene.control.Alert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import t4j.app.ui.AlertaUI;
import t4j.app.ui.MainSceneController;

@Controller
public class UIMainSceneController {

    @Autowired
    private MainSceneController mainSceneController;
    @Autowired
    private UIAutenticacaoController uIAutenticacaoController;

    public UIMainSceneController() {
    }

    /**
     *
     * @return
     */
    public MainSceneController getMainSceneController() {
        return mainSceneController;
    }

    public boolean logoutAction(boolean silentLogout) {
        boolean result = false;
        if (!mainSceneController.getUidto().getApp_context().isEmpty()) {
            result = uIAutenticacaoController.logout();
        }
        if (!result) {
            if (!silentLogout) {
                Alert a = AlertaUI.criarAlerta(
                        Alert.AlertType.WARNING,
                        "Logout",
                        "Logout",
                        "Não há um utilizador logado.");
                a.show();
            }
            return true;
        }
        if (!silentLogout) {
            Alert a = AlertaUI.criarAlerta(
                    Alert.AlertType.INFORMATION,
                    "Logout",
                    "Logout",
                    "Logout bem sucedido.");
            a.show();
            mainSceneController.getMenuItemLogout().setDisable(true);
            mainSceneController.getMenuItemLogin().setText(mainSceneController.MENU_ITEM_LOGIN_TEXT);
            mainSceneController.hideMenuPrincipalItens();
            mainSceneController.getMenuUtilizadorNA().setVisible(true);
        }
        return false;
    }

    public boolean logoutAction() {
        return logoutAction(false);
    }
}
