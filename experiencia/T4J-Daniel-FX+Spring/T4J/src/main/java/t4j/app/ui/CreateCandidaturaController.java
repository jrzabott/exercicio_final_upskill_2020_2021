package t4j.app.ui;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import t4j.app.controller.UICandidaturaController;
import t4j.app.dto.AnuncioDTO;
import t4j.app.dto.CandidaturaDTO;
import t4j.app.dto.LocalDateDTO;
import t4j.app.dto.OrganizacaoDTO;
import t4j.app.dto.TarefaDTO;
import t4j.app.exception.ElementoInvalidoException;

@Controller
public class CreateCandidaturaController implements Initializable {

    @FXML
    private Button btnAtualizar;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnLimpar;
    @FXML
    private Button btnRegistar;

    @Autowired
    private MainSceneController mainSceneController;

    @FXML
    private TableView<TarefaDTO> tableViewAnuncios;
    @FXML
    private TableColumn<TarefaDTO, String> tbColCand;
    @FXML
    private TableColumn<TarefaDTO, String> tbColFimCand;
    @FXML
    private TableColumn<TarefaDTO, String> tbColFimSeriacao;
    @FXML
    private TableColumn<TarefaDTO, String> tbColInicioCand;
    @FXML
    private TableColumn<TarefaDTO, String> tbColReferencia;
    @FXML
    private TableColumn<TarefaDTO, String> tbColCategoria;
    @FXML
    private TableColumn<TarefaDTO, String> tbColCusto;
    @FXML
    private TableColumn<TarefaDTO, String> tbColDesignacao;
    @FXML
    private TableColumn<TarefaDTO, String> tbColDuracao;
    @FXML
    private TableColumn<TarefaDTO, String> tbColOrg;
    @FXML
    private TextArea txtAreaApresentacao;
    @FXML
    private TextArea txtAreaMotivacao;
    @FXML
    private TextField txtFieldDuracao;
    @FXML
    private TextField txtFieldValorPretendido;

    @Autowired
    private UICandidaturaController uicc;

    private Stage stage;
    private ObservableList<TarefaDTO> listaTarefas;
    private List<TarefaDTO> ltdto = new ArrayList<>();
//    private List<OrganizacaoDTO> lodto = new ArrayList<>();
    private List<AnuncioDTO> lanudto = new ArrayList<>();
    private List<CandidaturaDTO> candidaturas = new ArrayList<>();
    private String idCandidatura;
    private String selectedRef;
    private AnuncioDTO selectedAnuncio = new AnuncioDTO();
    private CandidaturaDTO selectedCandidatura = new CandidaturaDTO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(() -> {
            stage = (Stage) btnCancelar.getScene().getWindow();
            preencherAnuncios();
            getSelectedAnuncioFromTableView();
        });
    }

    @FXML
    private void btnPopAction(ActionEvent event) {
        txtFieldValorPretendido.setText("3500");
        txtFieldDuracao.setText("40");
        txtAreaApresentacao.setText("Teste 1");
        txtAreaMotivacao.setText("Teste 2");
    }

    @FXML
    private void btnCancelarCandidatura(ActionEvent event) {
        limparCamposCandidatura();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void btnLimparCandidatura(ActionEvent event) {
        limparCamposCandidatura();
    }

    @FXML
    private void btnRegistarCandidatura(ActionEvent event) {
        boolean result;
        try {
            if (!isWithinCandidaturaDate(selectedRef)) {
                throw new ElementoInvalidoException("Anúncio não se encontra em período de candidatura.");
            }
            if (idCandidatura != null) {
                throw new ElementoInvalidoException("Já se candidatou a este anúncio.");
            }
            if (registarCandidatura()) {
                Alert a = AlertaUI.criarAlerta(
                        Alert.AlertType.INFORMATION,
                        "Efetuar Candidatura",
                        "Efetuar Nova Candidatura",
                        "Candidatura efetuada com Sucesso");
                a.show();
                ((Node) event.getSource()).getScene().getWindow().hide();
                limparCamposCandidatura();
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            Alert a = AlertaUI.criarAlerta(Alert.AlertType.ERROR,
                    "Efetuar Candidatura",
                    "Erro ao efetuar candidatura", e.getMessage());
            a.show();
        }

    }

    @FXML
    private void btnAtualizarCandidatura(ActionEvent event) {
        boolean result;
        try {
            if (!isCandidaturaChanged()) {
                throw new ElementoInvalidoException("Não se registaram alterações na sua candidatura.");
            }
            if (!isWithinCandidaturaDate(selectedRef)) {
                throw new ElementoInvalidoException("Não pode atualizar uma candidatura que se encontra em período de seriação.");
            }
            if (idCandidatura == null) {
                throw new ElementoInvalidoException("Ainda não se candidatou a este anúncio.");
            }
            if (registarCandidatura()) {
                Alert a = AlertaUI.criarAlerta(
                        Alert.AlertType.INFORMATION,
                        "Atualizar Candidatura",
                        "Atualizar Candidatura",
                        "Candidatura atualizada com Sucesso");
                a.show();

                ((Node) event.getSource()).getScene().getWindow().hide();
                limparCamposCandidatura();
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            Alert a = AlertaUI.criarAlerta(Alert.AlertType.ERROR,
                    "Atualizar Candidatura",
                    "Erro ao atualizar candidatura", e.getMessage());
            a.show();
        }
    }

    private boolean registarCandidatura() {
        boolean result;
        String id, valorPretendido, nrDias, txtApresentacao, txtMotivacao, refAnuncio, emailFreelancer;
        id = idCandidatura;
        valorPretendido = txtFieldValorPretendido.getText().trim();
        nrDias = txtFieldDuracao.getText().trim();
        txtApresentacao = txtAreaApresentacao.getText().trim();
        txtMotivacao = txtAreaMotivacao.getText().trim();
        refAnuncio = tableViewAnuncios.getSelectionModel().getSelectedItem().getReferencia();
        emailFreelancer = "HwyXID@AOnmae.pt";
//        emailFreelancer = mainSceneController.getUidto().getEmail();
        if (idCandidatura == null) {
            return result = uicc.registarCandidatura(id, valorPretendido, nrDias, txtApresentacao, txtMotivacao, refAnuncio, emailFreelancer);
        }
        return result = uicc.atualizarCandidatura(id, valorPretendido, nrDias, txtApresentacao, txtMotivacao, refAnuncio, emailFreelancer);
    }

    @FXML
    private void btnEliminarCandidatura(ActionEvent event) {
        try {
            if (!isWithinCandidaturaDate(selectedRef)) {
                throw new ElementoInvalidoException("Não pode remover uma candidatura que se encontra em período de seriação.");
            }
            if (idCandidatura == null) {
                throw new ElementoInvalidoException("Ainda não se candidatou a este anúncio.");
            }
            boolean result = uicc.removerCandidatura(idCandidatura);
            if (result) {
                Alert a = AlertaUI.criarAlerta(
                        Alert.AlertType.INFORMATION,
                        "Remover Candidatura",
                        "Remover Candidatura",
                        "Candidatura removida com Sucesso"
                );
                a.show();

                ((Node) event.getSource()).getScene().getWindow().hide();
                limparCamposCandidatura();
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            Alert a = AlertaUI.criarAlerta(Alert.AlertType.ERROR,
                    "Remover Candidatura",
                    "Erro ao remover candidatura", e.getMessage());
            a.show();
        }
    }

    private void preencherAnuncios() {
        ltdto = uicc.obterAnunciosElegiveisFreelancer("HwyXID@AOnmae.pt");
//        ltdto = uicc.obterAnunciosElegiveisFreelancer(mainSceneController.getUidto().getEmail());
        isListaAnunciosEmpty(ltdto);
        lanudto = uicc.obterAnunciosPorTarefas(ltdto);
        candidaturas = uicc.obterCandidaturasFreelancer("HwyXID@AOnmae.pt");
//        candidaturas = uicc.obterCandidaturasFreelancer(mainSceneController.getUidto().getEmail());
        listaTarefas = FXCollections.observableArrayList();
        for (TarefaDTO tdto : ltdto) {
            if (isAnuncioEmSeriacao(tdto.getReferencia()) && !isAnuncioCandidatado(tdto.getReferencia())) {
                assert true;
            } else {
                listaTarefas.add(tdto);                
            }
        }
//        lodto = uicc.getOrganizacaoFromNif(listaTarefas);
        tableViewAnuncios.setItems(listaTarefas);

        tbColReferencia.setCellValueFactory(new PropertyValueFactory<>("referencia"));
        tbColCategoria.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getCategoria().getDescricao()));
        tbColDesignacao.setCellValueFactory(new PropertyValueFactory<>("designacao"));
        tbColDuracao.setCellValueFactory(new PropertyValueFactory<>("duracaoEstimada"));
        tbColCusto.setCellValueFactory(new PropertyValueFactory<>("custoEstimado"));
        tbColOrg.setCellValueFactory(new PropertyValueFactory<>("nifOrganizacao"));
        tbColCand.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getReferencia()));
        tbColCand.setCellValueFactory(param -> {
            if (getCandidatura(param.getValue().getReferencia()) != null) {
                if (isWithinCandidaturaDate(param.getValue().getReferencia())) {
                    return new SimpleStringProperty("Sim");
                }
                return new SimpleStringProperty("Sim/Em Seriação");
            }
            return new SimpleStringProperty("Não");
        });
        tbColInicioCand.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getReferencia()));
        tbColInicioCand.setCellValueFactory(param -> {
            String inicioCandidatura = String.valueOf(getAnuncio(param.getValue().getReferencia()).getDataInicioCandidatura());
            return new SimpleStringProperty(inicioCandidatura);
        });
        tbColFimCand.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getReferencia()));
        tbColFimCand.setCellValueFactory(param -> {
            String fimCandidatura = String.valueOf(getAnuncio(param.getValue().getReferencia()).getDataFimCandidatura());
            return new SimpleStringProperty(fimCandidatura);
        });
        tbColFimSeriacao.setCellValueFactory(param -> {
            String fimSeriacao = String.valueOf(getAnuncio(param.getValue().getReferencia()).getDataFimSeriacao());
            return new SimpleStringProperty(fimSeriacao);
        });
    }

    private void getSelectedAnuncioFromTableView() {
        tableViewAnuncios.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TarefaDTO>() {
            @Override
            public void changed(ObservableValue<? extends TarefaDTO> observable, TarefaDTO oldValue, TarefaDTO newValue) {
                selectedRef = tableViewAnuncios.getSelectionModel().getSelectedItem().getReferencia();
                selectedAnuncio = getAnuncio(selectedRef);
                boolean candidatado = isAnuncioCandidatado(selectedRef);
                boolean emSeriacao = isAnuncioEmSeriacao(selectedRef);
                if (candidatado) {
                    selectedCandidatura = getCandidatura(selectedRef);
                    idCandidatura = selectedCandidatura.getId();
                    txtFieldValorPretendido.setText(selectedCandidatura.getValorPretendido());
                    txtFieldDuracao.setText(selectedCandidatura.getNrDias());
                    txtAreaApresentacao.setText(selectedCandidatura.getTxtApresentacao());
                    txtAreaMotivacao.setText(selectedCandidatura.getTxtMotivacao());
                    btnRegistar.setDisable(true);
                    if (emSeriacao) {
                        btnAtualizar.setDisable(true);
                        btnEliminar.setDisable(true);
                    } else {
                        btnAtualizar.setDisable(false);
                        btnEliminar.setDisable(false);
                    }

                } else {
                    idCandidatura = null;
                    btnRegistar.setDisable(false);
                    btnAtualizar.setDisable(true);
                    btnEliminar.setDisable(true);
                    limparCamposCandidatura();
                }
                System.out.println(idCandidatura);
            }

        });
    }

    private AnuncioDTO getAnuncio(String ref) {
        AnuncioDTO selectedAnuncio = new AnuncioDTO();
        for (AnuncioDTO anuncioDTO : lanudto) {
            if (anuncioDTO.getReferenciaTarefa().equals(ref)) {
                selectedAnuncio = anuncioDTO;
            }
        }
        return selectedAnuncio;
    }

    private CandidaturaDTO getCandidatura(String ref) {
        for (CandidaturaDTO cddto : candidaturas) {
            if (cddto.getRefAnuncio().equals(ref)) {
                return cddto;
            }
        }
        return null;
    }

    private void isListaAnunciosEmpty(List<TarefaDTO> ltdto) {
        if (ltdto.isEmpty()) {
            stage.hide();
            Alert a = AlertaUI.criarAlerta(
                    Alert.AlertType.ERROR,
                    "Efetuar Candidatura",
                    "Efetuar Candidatura",
                    "De momento não existem anúncios elegíveis para o seu perfil."
            );
            a.show();
        }
    }

    private boolean isAnuncioCandidatado(String ref) {
        for (CandidaturaDTO cd : candidaturas) {
            if (cd.getRefAnuncio().equals(ref)) {
                return true;
            }
        }
        return false;
    }

    private boolean isAnuncioEmSeriacao(String ref) {
        LocalDateDTO localDate = new LocalDateDTO();
        localDate.setLocalDate(LocalDate.now());
        AnuncioDTO selectedAnuncio = getAnuncio(ref);
        if (localDate.getLocalDate().isAfter(selectedAnuncio.getDataInicioSeriacao().getLocalDate())
                && localDate.getLocalDate().isBefore(selectedAnuncio.getDataFimSeriacao().getLocalDate())) {
            return true;
        }
        if (localDate.getLocalDate().equals(selectedAnuncio.getDataInicioSeriacao().getLocalDate())
                || localDate.getLocalDate().equals(selectedAnuncio.getDataFimSeriacao().getLocalDate())) {
            return true;
        }
        return false;
    }

    private boolean isWithinCandidaturaDate(String ref) {
        LocalDateDTO localDate = new LocalDateDTO();
        localDate.setLocalDate(LocalDate.now());
        AnuncioDTO selectedAnuncio = getAnuncio(ref);
        if (localDate.getLocalDate().isAfter(selectedAnuncio.getDataInicioCandidatura().getLocalDate())
                && localDate.getLocalDate().isBefore(selectedAnuncio.getDataFimCandidatura().getLocalDate())) {
            return true;
        }
        if (localDate.getLocalDate().equals(selectedAnuncio.getDataInicioCandidatura().getLocalDate())
                || localDate.getLocalDate().equals(selectedAnuncio.getDataFimCandidatura().getLocalDate())) {
            return true;
        }
        return false;
    }

    private boolean isCandidaturaChanged() {
        if (!txtFieldValorPretendido.getText().trim().equals(selectedCandidatura.getValorPretendido())) {
            return true;
        }
        if (!txtFieldDuracao.getText().trim().equals(selectedCandidatura.getNrDias())) {
            return true;
        }
        if (!txtAreaApresentacao.getText().trim().equals(selectedCandidatura.getTxtApresentacao())) {
            return true;
        }
        if (!txtAreaMotivacao.getText().trim().equals(selectedCandidatura.getTxtMotivacao())) {
            return true;
        }
        return false;
    }

    private void limparCamposCandidatura() {
        txtFieldValorPretendido.clear();
        txtFieldDuracao.clear();
        txtAreaApresentacao.clear();
        txtAreaMotivacao.clear();
    }

    void associarParentUI(MainSceneController mnc) {
        this.mainSceneController = mnc;
    }

}
