package t4j.app.ui;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import t4j.app.controller.UIAutenticacaoController;
import t4j.app.controller.UIHabilitacaoAcademicaController;
import t4j.app.controller.UIMainSceneController;
import t4j.app.controller.UIReconhecimentoCTController;
import t4j.app.dao.CandidaturaDAO;
import t4j.app.dto.CompetenciaTecnicaDTO;
import t4j.app.dto.UserInfoDTO;
import t4j.app.model.Anuncio;
import t4j.app.model.Plataforma;
import t4j.app.repo.EnumFXMLs;
import t4j.app.repo.Roles;
import t4j.app.service.CompetenciasTecnicasService;
import t4j.app.service.PlataformaService;
import t4j.app.utils.CoresTema;
import t4j.app.utils.TamanhoFonte;

@Controller
public class MainSceneController implements Initializable {

    public final String MENU_ITEM_LOGIN_TEXT = "Login ...";

///////////////////////////////////////////////
//  COMPONENTES FXML  /////////////////////////
///////////////////////////////////////////////
    @FXML
    private Button btnDummy;
    @FXML
    private Button btnDummy2;
    @FXML
    private Button btnDummy3;
    @FXML
    private Label lblAppContext;
    @FXML
    private Label lblSessionInfo;
    @FXML
    private Menu menuAdministracao;
    @FXML
    private Menu menuAjuda;
    @FXML
    private MenuBar menuBarMainScene;
    @FXML
    private Menu menuColaborador;
    @FXML
    private Menu menuFreelancer;
    @FXML
    private Menu menuGestor;
    @FXML
    private MenuItem menuItemLogin;
    @FXML
    private MenuItem menuItemLogout;
    @FXML
    private MenuItem menuItemRegistarOrganizacao;
    @FXML
    private MenuItem menuItemSair;
    @FXML
    private Menu menuPrincipal;
    @FXML
    private Menu menuUtilizadorNA;
    @FXML
    private TextArea txtArea;
    @FXML
    private BorderPane view;
///////////////////////////////////////////////
//  FIM FXML  /////////////////////////
///////////////////////////////////////////////
    private Plataforma plataforma;
    private UserInfoDTO uidto;
    @Autowired
    private CreateAreaAtividade areaAtividade;
    @Autowired
    private CreateCategoriaTarefa categoriaTarefa;
    @Autowired
    private CreateCompetenciaTecnica competenciaTecnica;
    @Autowired
    private Autenticacao autenticacaoController;
    @Autowired
    private CreateColaborador especificarColaboradorController;
    @Autowired
    private CreateTarefa especificarTarefaController;
    @Autowired
    private CreateAnuncioController publicarTarefaController;
    @Autowired
    private UpdateAnuncioController atualizarAnuncioController;
    @Autowired
    private SeriarCandidaturasController seriarCandidaturasController;
    @Autowired
    private CreateCandidaturaController efetuarCandidaturaController;
    @Autowired
    private ConfiguracaoController configuracaoController;
    @Autowired
    private CreateOrganizacao registarOrganizacaoController;
    @Autowired
    private UIAutenticacaoController uiAutenticacaoController;
    @Autowired
    private UIMainSceneController uIApplicationController;
    @Autowired
    private UIHabilitacaoAcademicaController uIHabilitacaoAcademicaController;
    @Autowired
    private UIReconhecimentoCTController uIReconhecimentoCTController;
    @Autowired
    private CreateHabilitacoesAcademicas academicasController;
    @Autowired
    private CreateReconhecimentoCT reconhecimentoCTController;
    @Autowired
    private CreateFreelancer createFreelancer;




    private CreateTipoRegimentoController createTipoRegimentoController;

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    private CoresTema coresTema = CoresTema.DEFAULT;
    private TamanhoFonte tamanhoFonte = TamanhoFonte.MEDIO;
    private ArrayList<Stage> activeStages;

    /**
     *
     */
    private static final String MENU_AJUDA_ID = "menuAjuda";

    /**
     *
     */
    private static final String MENU_UTILIZADOR_NA_ID = "menuUtilizadorNA";

    /**
     *
     */
    private static final String MENU_PRINCIPAL_ID = "menuPrincipal";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        activeStages = new ArrayList<Stage>();
        menuItemLogout.setDisable(true);
        menuItemLogin.setText(MENU_ITEM_LOGIN_TEXT);

        setUidto(new UserInfoDTO());
        setPlataforma(PlataformaService.getInstance());

        hideMenuPrincipalItens();

    }

    public MenuItem getMenuItemLogin() {
        return menuItemLogin;
    }

    public MenuItem getMenuItemLogout() {
        return menuItemLogout;
    }

    public Menu getMenuUtilizadorNA() {
        return menuUtilizadorNA;
    }

    public CoresTema getCoresTema() {
        return coresTema;
    }

    public void setCoresTema(CoresTema coresTema) {
        this.coresTema = coresTema;
    }

    public TamanhoFonte getTamanhoFonte() {
        return tamanhoFonte;
    }

    public void setTamanhoFonte(TamanhoFonte tamanhoFonte) {
        this.tamanhoFonte = tamanhoFonte;
    }

    @Autowired
    CandidaturaDAO cdao;

    @FXML
    private void btnDummy3Action(ActionEvent event) {

        List<Object> anunciosEmPeriodoSeriacao = cdao.anunciosEmPeriodoSeriacao("nbgept@qdbgoqekwr.com");
        List<Anuncio> listAnuncio = new ArrayList();

        for (Object object : anunciosEmPeriodoSeriacao) {
            Object[] get = (Object[]) object;

            LocalDate dataReg = ((Timestamp) get[0]).toLocalDateTime().toLocalDate();
            LocalDate dataIniPub = ((Timestamp) get[1]).toLocalDateTime().toLocalDate();
            LocalDate dataFimPub = ((Timestamp) get[2]).toLocalDateTime().toLocalDate();
            LocalDate dataIniCand = ((Timestamp) get[3]).toLocalDateTime().toLocalDate();
            LocalDate dataFimCand = ((Timestamp) get[4]).toLocalDateTime().toLocalDate();
            LocalDate dataIniSer = ((Timestamp) get[5]).toLocalDateTime().toLocalDate();
            LocalDate dataFimSer = ((Timestamp) get[6]).toLocalDateTime().toLocalDate();
            String ref = ((String) get[7]);
            Long regimento = ((BigDecimal) get[8]).longValue();

            Anuncio a = new Anuncio();
            a.setDataFimCandidatura(dataFimCand);
            a.setDataFimPublicitacao(dataFimPub);
            a.setDataFimSeriacao(dataFimSer);
            a.setDataInicioCandidatura(dataIniCand);
            a.setDataInicioPublicitacao(dataIniPub);
            a.setDataInicioSeriacao(dataIniSer);
            a.setDataRegistoAnuncio(dataFimCand);
            a.setIdTipoRegimento(regimento);
            a.setReferencia(ref);

            listAnuncio.add(a);
        }

        boolean result = true;

    }

    @Autowired
    CompetenciasTecnicasService competenciasTecnicasService;

    @FXML
    private void btnDummyAction(ActionEvent event) {
        List<CompetenciaTecnicaDTO> findAll = (List) competenciasTecnicasService
                .getRegistoCompetenciasTecnicas().getCompetenciasTecnicas();
        if (!findAll.isEmpty()) {
            findAll.forEach(System.out::println);

        }
    }

    @FXML
    private void btnDummyAction2(ActionEvent event) {
        loadGUI(EnumFXMLs.REGISTAR_HABILITACAO_ACADEMICA);
    }

    @FXML
    private void btnHSAllMenus(ActionEvent event) {
        for (Menu menu : menuBarMainScene.getMenus()) {
            if ("Ajuda".equalsIgnoreCase(menu.getText())) {
                continue;
            }
            menu.setVisible(!menu.isVisible());
        }
    }

    @FXML
    private void menuItemAtualizarAnuncioAction(ActionEvent event) {
        loadGUI(EnumFXMLs.CRIAR_ANUNCIO);
    }

    @FXML
    private void menuItemConfiguracao(ActionEvent event) {
        loadGUI(EnumFXMLs.CONFIGURACAO);
    }

    @FXML
    private void menuItemDefinirAreaAtividade(ActionEvent event) {
        loadGUI(EnumFXMLs.CRIAR_AREA_ATIVIDADE);
    }

    @FXML
    private void menuItemDefinirCategoriaTarefa(ActionEvent event) {
        loadGUI(EnumFXMLs.CRIAR_CATEGORIA_TAREFA);
    }

    @FXML
    private void menuItemDefinirCompetenciaTecnica(ActionEvent event) {
        loadGUI(EnumFXMLs.CRIAR_COMPETENCIA_TECNICA);
    }

    @FXML
    private void menuItemDefinirTipoRegimentoAction(Event event) {
        loadGUI(EnumFXMLs.CRIAR_TIPO_REGIMENTO);
    }

    @FXML
    private void menuItemEfetuarCandidaturaAction(ActionEvent event) {
        loadGUI(EnumFXMLs.CRIAR_CANDIDATURA);
    }

    @FXML
    private void menuItemEspecificarColaboradorAction(ActionEvent event) {
        loadGUI(EnumFXMLs.CRIAR_COLABORADOR);
    }

    @FXML
    private void menuItemLoginAction(ActionEvent event) {
        if (menuItemLogin.getText().equalsIgnoreCase(MENU_ITEM_LOGIN_TEXT)) {
            loadGUI(EnumFXMLs.AUTENTICACAO);
        }
    }

    @FXML
    private void menuItemPublicarTarefaAction(ActionEvent event) {
        loadGUI(EnumFXMLs.PUBLICAR_TAREFA);
    }

    @FXML
    private void menuItemRegistarFreelancerAction(ActionEvent event) {
        loadGUI(EnumFXMLs.CRIAR_FREELANCER);
    }

    @FXML
    private void menuItemRegistarOrganizacaoAction(ActionEvent event) {
        loadGUI(EnumFXMLs.CRIAR_ORGANIZACAO);
    }

    @FXML
    private void menuItemSair(ActionEvent event) {
        Window window = menuBarMainScene.getScene().getWindow();
        window.fireEvent(new WindowEvent(window,
                WindowEvent.WINDOW_CLOSE_REQUEST));
    }

    @FXML
    private void menuItemSairAction(ActionEvent event) {
        Window myWindow = menuBarMainScene.getScene().getWindow();
        myWindow.fireEvent(new WindowEvent(myWindow,
                WindowEvent.WINDOW_CLOSE_REQUEST));
    }

    @FXML
    private void menuItemSariarCandidaturaAction(ActionEvent event) {
        loadGUI(EnumFXMLs.SERIAR_CANDIDATURA);
    }

    @FXML
    private void menuItemSobre(ActionEvent event) {
        AlertaUI.criarAlerta(
                Alert.AlertType.INFORMATION,
                plataforma.getTITULO_APLICACAO(),
                "Acerca.",
                "@Copyright\nSprint 2 - Grupo 3\nBruno Barbosa, Daniel Junior, Fernando Crista, Jorge Pires\nUPskill 2020/2021")
                .show();
    }

    @FXML
    private void menuItemLogoutAction(ActionEvent event) {
        if (uIApplicationController.logoutAction()) {
            return;
        }
    }

    @FXML
    private void menuItemEspecificarTarefaAction(ActionEvent event) {
        loadGUI(EnumFXMLs.CRIAR_TAREFA);
    }

     void loadGUI(EnumFXMLs efxml) {
        Optional<Stage> stage = Optional.empty();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(efxml
                    .getPath()));

            loader.setControllerFactory(aClass -> applicationContext.getBean(aClass));

            Parent parent = loader.load();
            Scene scene = new Scene(parent);

//            if (stage == null) {
//                stage = new Stage();
//            }
            stage = Optional.of(new Stage());
            stage.get().setScene(scene);
            stage.get().setTitle(efxml.getTitle());
            switch (efxml) {
                case CRIAR_AREA_ATIVIDADE:
                    areaAtividade = loader.getController();
                    areaAtividade.associarParentUI(this);
                    break;
                case CRIAR_CATEGORIA_TAREFA:
                    categoriaTarefa = loader.getController();
                    categoriaTarefa.associarParentUI(this);
                    break;
                case CRIAR_COMPETENCIA_TECNICA:
                    competenciaTecnica = loader.getController();
                    competenciaTecnica.associarParentUI(this);
                    break;
                case AUTENTICACAO:
                    autenticacaoController = loader.getController();
                    autenticacaoController.associarParentUI(this);
                    break;
                case CRIAR_COLABORADOR:
                    especificarColaboradorController = loader.getController();
                    especificarColaboradorController.associarParentUI(this);
                    break;
                case CRIAR_TAREFA:
                    especificarTarefaController = loader.getController();
                    especificarTarefaController.associarParentUI(this);
                    break;
                case CRIAR_ORGANIZACAO:
                    registarOrganizacaoController = loader.getController();
                    registarOrganizacaoController.associarParentUI(this);
                    break;
                case REGISTAR_HABILITACAO_ACADEMICA:
                    academicasController = loader.getController();
//                    uIHabilitacaoAcademicaController.associarParentUI(this);
                    break;
                case CRIAR_RECONHECIMENTO_CT:
                    reconhecimentoCTController = loader.getController();
//                    uIReconhecimentoCTController.associarParentUI(this);
                    break;
                case PUBLICAR_TAREFA:
                    publicarTarefaController = loader.getController();
                    publicarTarefaController.associarParentUI(this);
                    break;
                case CRIAR_ANUNCIO:
                    atualizarAnuncioController = loader.getController();
                    atualizarAnuncioController.associarParentUI(this);
                    break;
                case CRIAR_FREELANCER:
                    //                    registarFreelancerController = loader.getController();
                    //                    registarFreelancerController.associarParentUI(this);
                    break;
                case CRIAR_CANDIDATURA:
                    efetuarCandidaturaController = loader.getController();
                    efetuarCandidaturaController.associarParentUI(this);
                    break;
                case SERIAR_CANDIDATURA:
                    seriarCandidaturasController = loader.getController();
                    seriarCandidaturasController.associarParentUI(this);
                    break;
                case CONFIGURACAO:
                    configuracaoController = loader.getController();
                    configuracaoController.associarParentUI(this);
                    break;
                case CRIAR_TIPO_REGIMENTO:
                    createTipoRegimentoController = loader.getController();
                    createTipoRegimentoController.associarParentUI(this);
                    break;
                case MAIN_SCENE:
                default:
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();

            AlertaUI.criarAlerta(
                    Alert.AlertType.ERROR,
                    Plataforma.getTITULO_APLICACAO(),
                    "Erro.", ex.getMessage() + "\n" + Arrays.toString(ex
                    .getStackTrace())).show();
        }
//        updateEstilos(scene);
        stage.ifPresent(s -> s.show());
//        activeStages.add(stage);
    }

    public UIMainSceneController getAppController() {
        return this.uIApplicationController;
    }

    public UserInfoDTO getUidto() {
        return this.uidto;
    }

    public void setMenuItemLoginText(String username) {
        menuItemLogin.setText(username);
    }

    public void setMenuItemLogoutDisabled(boolean b) {
        menuItemLogout.setDisable(b);
    }

    private void setUidto(UserInfoDTO userInfoDTO) {
        this.uidto = userInfoDTO;
    }

    private void setPlataforma(Plataforma instance) {
        this.plataforma = instance;
    }

    void setUiac(UIAutenticacaoController uiac) {
        this.uiAutenticacaoController = uiac;
    }

    public void hideMenuPrincipalItens() {
        for (Menu menu : menuBarMainScene.getMenus()) {
            if (menu.getId().equalsIgnoreCase(MENU_AJUDA_ID)) {
                menu.setVisible(true);
                continue;
            }
            if (menu.getId().equalsIgnoreCase(MENU_UTILIZADOR_NA_ID)) {
                menu.setVisible(true);
                continue;
            }
            if (menu.getId().equalsIgnoreCase(MENU_PRINCIPAL_ID)) {
                menu.setVisible(true);
                continue;
            }
            menu.setVisible(false);
        }
    }

    public void showMenusByRole(UserInfoDTO u) {

        String[] rolesStrings = u.getRolenames().split(",");
        ArrayList<Roles> roles = new ArrayList<>();
        for (String rolesString : rolesStrings) {
            for (Roles value : Roles.values()) {
                if (value.name().equalsIgnoreCase(rolesString.trim())) {
                    roles.add(value);
                }
            }
        }

        menuUtilizadorNA.setVisible(false);

        for (Roles role : roles) {
            switch (role) {
                case ADMINISTRATIVO:
                    menuAdministracao.setVisible(true);
                    break;
                case COLABORADOR:
                    menuColaborador.setVisible(true);
                    break;
                case FREELANCER:
                    menuFreelancer.setVisible(true);
                    break;
                case GESTOR:
                    menuGestor.setVisible(true);
                    break;
                default:
            }
        }
    }

    public void updateAllStyles() {
        for (Stage stage : activeStages) {
            Scene scene = stage.getScene();
            updateEstilos(scene);
        }
    }

    public void updateEstilos(Scene scene) {
        scene.getStylesheets().clear();
        scene.getStylesheets().add(getClass().getResource(CoresTema.getCssPath(coresTema)).toExternalForm());
        scene.getStylesheets().add(getClass().getResource(TamanhoFonte.getCssPath(tamanhoFonte)).toExternalForm());
    }
}
