package t4j.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import t4j.app.dto.UserInfoDTO;
import t4j.app.service.UsersService;
import t4j.app.ui.MainSceneController;

@Controller
public class UIAutenticacaoController {

    /**
     *
     */
    @Autowired
    private MainSceneController mainSceneController;
    @Autowired
    private UsersService usersService;

    /**
     *
     */
    @Autowired
    private UIMainSceneController appController;

    public UIAutenticacaoController() {
    }

    /**
     *
     * @return true se logout efetuado e false se contrário
     */
    public boolean logout() {
        UserInfoDTO u = this.mainSceneController.getUidto();
        return usersService.logout(u);
    }

    /**
     *
     * @return os papell do utilizador
     */
    public String getRoles() {
        UserInfoDTO u = this.mainSceneController.getUidto();
        return usersService.getRoles(u);
    }

    /**
     *
     * @return o controlller principal
     */
    public MainSceneController getMainSceneController() {
        return mainSceneController;
    }

    /**
     *
     * @param mainSceneController controller principal
     */
    public void setMainSceneController(MainSceneController mainSceneController) {
        this.mainSceneController = mainSceneController;
    }

    /**
     *
     * @return controller da aplicação
     */
    public UIMainSceneController getAppController() {
        return appController;
    }

    /**
     *
     * @param appController controller da aplicação
     */
    public void setAppController(UIMainSceneController appController) {
        this.appController = appController;
    }

    /**
     *
     * @param u informação do utilizador que pretende efetuar o login
     * @return true se login efetuado e false se contrário
     */
    public boolean login(UserInfoDTO u) {
        boolean result = false;
        result = usersService.login(u);
        return result;
    }
}
