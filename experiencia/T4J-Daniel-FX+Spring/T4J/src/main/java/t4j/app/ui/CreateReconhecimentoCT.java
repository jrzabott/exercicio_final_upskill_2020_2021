/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.ui;

import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import t4j.app.controller.UIReconhecimentoCTController;
import t4j.app.dto.CompetenciaTecnicaDTO;
import t4j.app.dto.GrauProficienciaDTO;
import t4j.app.dto.ReconhecimentoCTDTO;
import t4j.app.exception.ElementoDuplicadoException;
import t4j.app.exception.ElementoInvalidoException;
import t4j.app.service.CompetenciasTecnicasService;

/**
 * FXML Controller class
 *
 * @author Home
 */
@Controller
public class CreateReconhecimentoCT implements Initializable {

    @Autowired
    private MainSceneController mainSceneController;
    @Autowired
    private UIReconhecimentoCTController uirctc;
    @Autowired
    private CreateFreelancer createFreelancer;

    private CompetenciaTecnicaDTO ctdto;

    @FXML
    private Button btnPop;
    @FXML
    private DatePicker datepickerData;
    @FXML
    private ComboBox<CompetenciaTecnicaDTO> cmbCompetenciaTecnica;
    @FXML
    private ComboBox<GrauProficienciaDTO> cmbGrauProficiencia;

    ObservableList<GrauProficienciaDTO> graus;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        prepararComboBoxCT();
        preencherComboBoxCompetenciaTecnica();

    }

    @FXML
    private void btnPopAction(ActionEvent event) {
    }
    @Autowired
    CompetenciasTecnicasService cts;

    @FXML
    private void btnRegistarReconhecimentoCT(ActionEvent event) {
        try {

            if (datepickerData.getValue() == null) {
                throw new ElementoInvalidoException("Deve selecionar uma data.");
            }
            if (cmbCompetenciaTecnica.getValue() == null) {
                throw new ElementoInvalidoException("Deve selecionar uma Competência Técnica.");
            }
            if (cmbGrauProficiencia.getValue() == null) {
                throw new ElementoInvalidoException("Deve selecionar um grau de proficiência para esta competência.");
            }

            ReconhecimentoCTDTO rctdto = new ReconhecimentoCTDTO();
            rctdto.setCodigocompetenciatecnica(cmbCompetenciaTecnica.getValue().getCodigoCompetenciaTecnica());
            rctdto.setDatareconhecimento(datepickerData.getValue());
            rctdto.setEmailfreelancer(createFreelancer.getTxtFieldEmailFreelancer().getText().trim());
            rctdto.setIdgrauproficiencia(cmbGrauProficiencia.getValue().getId());
            rctdto.setDescricaoGrauProficiencia(cmbGrauProficiencia.getValue().getDesignacao());

            for (ReconhecimentoCTDTO reconhecimento : createFreelancer.getReconhecimentos()) {
                rctdto.equals(reconhecimento);
            }
            if (createFreelancer.getReconhecimentos().contains(rctdto)) {
                throw new ElementoDuplicadoException("Já existe uma competência técnica com estas caracaterísticas.");
            }

            createFreelancer.getReconhecimentos().add(rctdto);

        } catch (Exception e) {
            Alert a = AlertaUI.criarAlerta(
                    Alert.AlertType.INFORMATION,
                    "Reconhecimento de Competências Técnicas",
                    "Erro ao criar novo Reconhecimento de Competências Técnicas",
                    e.getMessage());
            a.show();
        }

    }

    @FXML
    private void btnLimparReconhecimentoCT(ActionEvent event) {
        limparCampos();
    }

    private void limparCampos() {
        this.datepickerData.setValue(null);
        this.cmbCompetenciaTecnica.setValue(null);
        this.cmbGrauProficiencia.setValue(null);

    }
    
    @FXML
    private void btnCancelarReconhecimentoCT(ActionEvent event) {
        limparCampos();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    private void preencherCMB() {

    }

    private void preencherComboBoxCompetenciaTecnica() {
        ObservableList<CompetenciaTecnicaDTO> listaCompetencias = uirctc.findAllCompetenciasTecnicas();
        cmbCompetenciaTecnica.setItems(listaCompetencias);
    }

    private void prepararComboBoxCT() {
        Callback<ListView<CompetenciaTecnicaDTO>, ListCell<CompetenciaTecnicaDTO>> cellFactory = new Callback<ListView<CompetenciaTecnicaDTO>, ListCell<CompetenciaTecnicaDTO>>() {
            @Override
            public ListCell<CompetenciaTecnicaDTO> call(ListView<CompetenciaTecnicaDTO> l) {
                return new ListCell<CompetenciaTecnicaDTO>() {

                    @Override
                    protected void updateItem(CompetenciaTecnicaDTO item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item == null || empty) {
                            setText(null);
                            setGraphic(null);
                        } else {
                            setText(item.getCodigoCompetenciaTecnica());
                            setGraphic(null);
                        }
                    }
                };
            }
        };
        cmbCompetenciaTecnica.setCellFactory(cellFactory);
        cmbCompetenciaTecnica.setButtonCell(cellFactory.call(null));

        cmbCompetenciaTecnica.valueProperty().addListener(new ChangeListener<CompetenciaTecnicaDTO>() {
            @Override
            public void changed(ObservableValue<? extends CompetenciaTecnicaDTO> observable, CompetenciaTecnicaDTO oldValue, CompetenciaTecnicaDTO newValue) {
                ctdto = uirctc.findCompetenciaTecnicaById(newValue.getCodigoCompetenciaTecnica());
                cmbGrauProficiencia.setItems(FXCollections.observableArrayList(ctdto.getGrausProficiencia()));
            }
        });
    }
}
