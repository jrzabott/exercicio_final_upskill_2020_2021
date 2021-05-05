package t4j.app.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import t4j.app.controller.UICandidaturaController;
import t4j.app.dao.AnuncioDAO;
import t4j.app.dao.CandidaturaDAO;
import t4j.app.dto.RegistoTarefasDTO;
import t4j.app.dto.TarefaDTO;

@Controller
public class CreateCandidaturaController implements Initializable {

    @Autowired
    private MainSceneController mainSceneController;

    @FXML
    private TableView<TarefaDTO> tableViewAnuncios;
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
    private TableColumn<TarefaDTO, String> tbColNifOrg;
    @FXML
    private TextArea txtAreaApresentacao;
    @FXML
    private TextArea txtAreaMotivacao;
    @FXML
    private TextField txtFieldDuracao;
    @FXML
    private TextField txtFieldValorPretendido;

    private ObservableList<TarefaDTO> listaTarefas;

    @Autowired
    private UICandidaturaController uicc;
    @Autowired
    private CandidaturaDAO cddao;
    @Autowired
    private AnuncioDAO adao;

    @FXML
    private void btnPopAction(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(() -> {
            preencherAnuncios();
        });
    }

    @FXML
    private void btnCancelarCandidatura(ActionEvent event) {
        limparCampos();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void btnLimparCandidatura(ActionEvent event) {
        limparCampos();
    }

    @FXML
    private void btnRegistarCandidatura(ActionEvent event) {
        boolean result;
        try {
            String nrDias, txtApresentacao, txtMotivacao, refAnuncio, emailFreelancer, valorPretendido;

            valorPretendido = txtFieldValorPretendido.getText();
            nrDias = txtFieldDuracao.getText();
            txtApresentacao = txtAreaApresentacao.getText();
            txtMotivacao = txtAreaMotivacao.getText();
            refAnuncio = tableViewAnuncios.getSelectionModel().getSelectedItem().getReferencia();
            emailFreelancer = "HwyXID@AOnmae.pt";
//            emailFreelancer = mainSceneController.getUidto().getEmail();

            result = uicc.registarCandidatura(valorPretendido, nrDias, txtApresentacao, txtMotivacao, refAnuncio, emailFreelancer);
            if (result) {
                Alert a = AlertaUI.criarAlerta(
                        Alert.AlertType.INFORMATION,
                        "Efetuar Candidatura",
                        "Efetuar Nova Candidatura",
                        "Candidatura efetuada com Sucesso"
                );
                a.show();

                ((Node) event.getSource()).getScene().getWindow().hide();
                limparCampos();
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            Alert a = AlertaUI.criarAlerta(Alert.AlertType.ERROR,
                    "Efetuar Candidatura",
                    "Erro ao efetuar candidatura", e.getMessage());
            a.show();
        }

    }

    private void preencherAnuncios() {
        RegistoTarefasDTO radto = uicc.obterAnunciosElegiveisFreelancer("HwyXID@AOnmae.pt");
//        RegistoTarefasDTO radto = uicc.obterAnunciosElegiveisFreelancer(mainSceneController.getUidto().getEmail());
        listaTarefas = FXCollections.observableArrayList();
        for (TarefaDTO tarefaDTO : radto.getTarefas()) {
            TarefaDTO tdto = new TarefaDTO();
            listaTarefas.add(tarefaDTO);
        }
        tableViewAnuncios.setItems(listaTarefas);

        tbColReferencia.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<TarefaDTO, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<TarefaDTO, String> param) {
                return new SimpleStringProperty(param.getValue().getReferencia());
            }});
        tbColReferencia.setCellFactory(TextFieldTableCell.forTableColumn());

        tbColCategoria.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<TarefaDTO, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<TarefaDTO, String> param) {
                return new SimpleStringProperty(param.getValue().getCategoria().getDescricao());
            }});
        tbColCategoria.setCellFactory(TextFieldTableCell.forTableColumn());

        tbColDesignacao.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<TarefaDTO, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<TarefaDTO, String> param) {
                return new SimpleStringProperty(param.getValue().getDesignacao());
            }});
        tbColDesignacao.setCellFactory(TextFieldTableCell.forTableColumn());

        tbColDuracao.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<TarefaDTO, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<TarefaDTO, String> param) {
                return new SimpleStringProperty(param.getValue().getDuracaoEstimada());
            }});
        tbColDuracao.setCellFactory(TextFieldTableCell.forTableColumn());

        tbColCusto.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<TarefaDTO, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<TarefaDTO, String> param) {
                return new SimpleStringProperty(param.getValue().getCustoEstimado());
            }});
        tbColCusto.setCellFactory(TextFieldTableCell.forTableColumn());

        tbColNifOrg.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<TarefaDTO, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<TarefaDTO, String> param) {
                return new SimpleStringProperty(param.getValue().getNifOrganizacao());
            }});
        tbColNifOrg.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    private void limparCampos() {
        tableViewAnuncios.getItems().clear();
        txtFieldValorPretendido.clear();
        txtFieldDuracao.clear();
        txtAreaApresentacao.clear();
        txtAreaMotivacao.clear();
    }

    void associarParentUI(MainSceneController mnc) {
        this.mainSceneController = mnc;
    }

}
