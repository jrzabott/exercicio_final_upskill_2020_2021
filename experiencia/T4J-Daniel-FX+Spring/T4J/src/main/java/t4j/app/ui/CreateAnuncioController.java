package t4j.app.ui;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import t4j.app.controller.UIAnuncioController;
import t4j.app.controller.UITarefaController;
import t4j.app.controller.UITipoRegimentoController;
import t4j.app.dao.AnuncioDAO;
import t4j.app.dto.AnuncioDTO;
import t4j.app.dto.LocalDateDTO;
import t4j.app.dto.TipoRegimentoDTO;
import t4j.app.exception.ElementoInvalidoException;

@Controller
public class CreateAnuncioController implements Initializable {

    @Autowired
    private MainSceneController mainSceneController;
    @Autowired
    private UIAnuncioController uiac;
    @Autowired
    private UITipoRegimentoController uitrc;
    @Autowired
    private UITarefaController uitc;

    @FXML
    private ComboBox<String> cmbTarefa;
    @FXML
    private ComboBox<TipoRegimentoDTO> cmbTipoRegimento;
    @FXML
    private DatePicker dataFimCandidatura;
    @FXML
    private DatePicker dataFimPublicitacao;
    @FXML
    private DatePicker dataFimSeriacao;
    @FXML
    private DatePicker dataInicioCandidatura;
    @FXML
    private DatePicker dataInicioPublicitacao;
    @FXML
    private DatePicker dataInicioSeriacao;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(() -> {
            preencherTarefas();
        });
        Platform.runLater(() -> {
            preencherTiposRegimento();
        });
    }

    @FXML
    private void btnCancelarPublicarTarefa(ActionEvent event) {
        limparCampos();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void btnLimparPublicarTarefa() {
        limparCampos();
    }

    @FXML
    private void btnPublicarTarefa(ActionEvent event) {
        try {
            if (dataInicioPublicitacao.getValue() == null
                    || dataFimPublicitacao.getValue() == null
                    || dataInicioCandidatura.getValue() == null
                    || dataFimCandidatura.getValue() == null
                    || dataInicioSeriacao.getValue() == null
                    || dataFimSeriacao.getValue() == null) {
                throw new ElementoInvalidoException("Todos os campos data têm de estar preenchidos!");
            }
            if (cmbTarefa.getValue() == null) {
                throw new ElementoInvalidoException("Tem de selecionar uma Tarefa!");
            }
            if (cmbTipoRegimento.getValue() == null) {
                throw new ElementoInvalidoException("Tem de selecionar um Tipo de Regimento!");
            }

            AnuncioDTO adto = new AnuncioDTO();
            LocalDateDTO dradto = new LocalDateDTO();
            dradto.setLocalDate(LocalDate.now());
            LocalDateDTO dipdto = new LocalDateDTO();
            dipdto.setLocalDate(dataInicioPublicitacao.getValue());
            LocalDateDTO dfpdto = new LocalDateDTO();
            dfpdto.setLocalDate(dataFimPublicitacao.getValue());
            LocalDateDTO dicdto = new LocalDateDTO();
            dicdto.setLocalDate(dataInicioCandidatura.getValue());
            LocalDateDTO dfcdto = new LocalDateDTO();
            dfcdto.setLocalDate(dataFimCandidatura.getValue());
            LocalDateDTO disdto = new LocalDateDTO();
            disdto.setLocalDate(dataInicioSeriacao.getValue());
            LocalDateDTO dfsdto = new LocalDateDTO();
            dfsdto.setLocalDate(dataFimSeriacao.getValue());

            adto.setDataRegistoAnuncio(dradto);
            adto.setDataInicioPublicitacao(dipdto);
            adto.setDataFimPublicitacao(dfpdto);
            adto.setDataInicioCandidatura(dicdto);
            adto.setDataFimCandidatura(dfcdto);
            adto.setDataInicioSeriacao(disdto);
            adto.setDataFimSeriacao(dfsdto);
            adto.setReferenciaTarefa(cmbTarefa.getValue());
            adto.setIdTipoRegimento(cmbTipoRegimento.getValue().getId());

            boolean result = uiac.publicarTarefa(adto);
            if (result) {
                Alert a = AlertaUI.criarAlerta(
                        Alert.AlertType.INFORMATION,
                        "Publicar Tarefa",
                        "Criar Anúncio",
                        "Anúncio criado com Sucesso"
                );
                a.show();

                ((Node) event.getSource()).getScene().getWindow().hide();
                limparCampos();
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            Alert a = AlertaUI.criarAlerta(
                    Alert.AlertType.ERROR,
                    "Publicar Tarefa",
                    "Erro ao publicar Tarefa",
                    e.getMessage());
            a.show();
        }
    }

    @FXML
    private void btnPopAction(ActionEvent event) {
        dataInicioPublicitacao.setValue(LocalDate.now().plusDays(1));
        dataInicioCandidatura.setValue(LocalDate.now().plusDays(4));
        dataFimCandidatura.setValue(LocalDate.now().plusDays(10));
        dataInicioSeriacao.setValue(LocalDate.now().plusDays(11));
        dataFimSeriacao.setValue(LocalDate.now().plusDays(15));
        dataFimPublicitacao.setValue(LocalDate.now().plusDays(15));
    }

    private void limparCampos() {
        cmbTarefa.getSelectionModel().clearSelection();
        cmbTipoRegimento.getSelectionModel().clearSelection();
        dataInicioPublicitacao.setValue(null);
        dataFimPublicitacao.setValue(null);
        dataInicioCandidatura.setValue(null);
        dataFimCandidatura.setValue(null);
        dataInicioSeriacao.setValue(null);
        dataFimSeriacao.setValue(null);
    }
    @Autowired
    AnuncioDAO adao;

    private void preencherTarefas() {
//        List<String> lista = uitc.tarefasNaoPublicadas("nbgept@qdbgoqekwr.com");
        List<String> lista = adao.tarefasNaoPublicadas(mainSceneController.getUidto().getEmail());
        cmbTarefa.getItems().addAll(lista);
    }

    private void preencherTiposRegimento() {
        Callback<ListView<TipoRegimentoDTO>, ListCell<TipoRegimentoDTO>> cellFactory
                = new Callback<ListView<TipoRegimentoDTO>, ListCell<TipoRegimentoDTO>>() {
            @Override
            public ListCell<TipoRegimentoDTO> call(ListView<TipoRegimentoDTO> listView) {
                return new ListCell<TipoRegimentoDTO>() {
                    @Override
                    protected void updateItem(TipoRegimentoDTO item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item == null || empty) {
                            setGraphic(null);
                        } else {
                            setText(String.format(
                                    "%s - %s",
                                    item.getId(),
                                    item.getDesignacao()));
                        }
                    }
                };
            }
        };
        cmbTipoRegimento.setButtonCell(cellFactory.call(null));
        cmbTipoRegimento.setCellFactory(cellFactory);
        ArrayList<TipoRegimentoDTO> rtrdto = uitrc.getRegistoTiposRegimentoDTO();
        cmbTipoRegimento.getItems().addAll(rtrdto);
    }

    void associarParentUI(MainSceneController mnc) {
        this.mainSceneController = mnc;
    }
}
