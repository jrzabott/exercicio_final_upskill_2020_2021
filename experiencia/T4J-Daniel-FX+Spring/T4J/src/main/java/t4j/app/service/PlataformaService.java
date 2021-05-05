package t4j.app.service;

import t4j.app.model.Plataforma;
import t4j.app.ui.MainSceneController;

public class PlataformaService {

    /**
     *
     */
    private static MainSceneController mainSceneController;

    /**
     *
     */
    private static Plataforma plataforma;

    /**
     *
     * @return
     */
    public static MainSceneController getMainSceneController() {
        return mainSceneController;
    }

    /**
     *
     * @return
     */
    public static Plataforma getPlataforma() {
        return plataforma;
    }

    /**
     *
     * @param mainSceneController
     */
    public static void setMainSceneController(MainSceneController mainSceneController) {
        PlataformaService.mainSceneController = mainSceneController;
    }

    /**
     *
     * @param plataforma
     */
    public static void setPlataforma(Plataforma plataforma) {
        PlataformaService.plataforma = plataforma;
    }

    /**
     *
     * @return
     */
    public static Plataforma getInstance() {
        return Plataforma.getInstance();
    }
}
