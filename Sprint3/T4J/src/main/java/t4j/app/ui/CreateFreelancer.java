/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.ui;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import t4j.app.controller.UIFreeLancerController;
import t4j.app.controller.UIMainSceneController;
import t4j.app.dto.EnderecoPostalDTO;
import t4j.app.dto.FreeLancerDTO;
import t4j.app.dto.HabilitacaoAcademicaDTO;
import t4j.app.dto.ReconhecimentoCTDTO;
import t4j.app.repo.EnumFXMLs;
import t4j.app.utils.AlgoritmoGeradorPasswords;

/**
 * FXML Controller class
 *
 * @author Home
 */
@Controller
public class CreateFreelancer implements Initializable {

    @Autowired
    private UIMainSceneController appController;
    @Autowired
    private MainSceneController mainSceneController;
    @Autowired
    private UIFreeLancerController uiflc;
    @FXML
    private TableView<HabilitacaoAcademicaDTO> table_ha;
    @FXML
    private TableView<ReconhecimentoCTDTO> table_ct;
    @FXML
    private TableColumn<HabilitacaoAcademicaDTO, String> tableColumnHAGrau;
    @FXML
    private TableColumn<HabilitacaoAcademicaDTO, String> tableColumnHANomeCurso;
    @FXML
    private TableColumn<HabilitacaoAcademicaDTO, String> tableColumnHANomeInstituicao;
    @FXML
    private TableColumn<HabilitacaoAcademicaDTO, String> tableColumnHAMediaCurso;
    @FXML
    private TableColumn<ReconhecimentoCTDTO, LocalDate> tableColumnCTData;
    @FXML
    private TableColumn<ReconhecimentoCTDTO, String> tableColumnCTCompetenciaTecnica;
    @FXML
    private TableColumn<ReconhecimentoCTDTO, String> tableColumnCTGrauProficiencia;

    ObservableList<HabilitacaoAcademicaDTO> habilitacoes = FXCollections.observableArrayList();

    ObservableList<ReconhecimentoCTDTO> reconhecimentos = FXCollections.observableArrayList();

    @FXML
    private Button btnPop;
    @FXML
    private TextField txtFieldNomeFreelancer;
    @FXML
    private TextField txtFieldNifFreelancer;
    @FXML
    private TextField txtFieldTelefoneFreelancer;
    @FXML
    private TextField txtFieldEmailFreelancer;
    @FXML
    private TextField txtFieldEndMoradaFreeLancer;
    @FXML
    private TextField txtFieldEndCodigoPostalFreeLancer;
    @FXML
    private TextField txtFieldEndLocalidadeFreeLancer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        table_ct.setItems(reconhecimentos);
        tableColumnCTData.setCellValueFactory(new PropertyValueFactory<>("datareconhecimento"));
        tableColumnCTCompetenciaTecnica.setCellValueFactory(new PropertyValueFactory<>("codigocompetenciatecnica"));
        tableColumnCTGrauProficiencia.setCellValueFactory(new PropertyValueFactory<>("descricaoGrauProficiencia"));


        table_ha.setItems(habilitacoes);
        tableColumnHAGrau.setCellValueFactory(new PropertyValueFactory<>("grau"));
        tableColumnHAMediaCurso.setCellValueFactory(new PropertyValueFactory<>("mediacurso"));
        tableColumnHANomeCurso.setCellValueFactory(new PropertyValueFactory<>("designacaocurso"));
        tableColumnHANomeInstituicao.setCellValueFactory(new PropertyValueFactory<>("nomeinstituicao"));
    }

    public ObservableList<ReconhecimentoCTDTO> getReconhecimentos() {
        return reconhecimentos;
    }

    public TextField getTxtFieldEmailFreelancer() {
        return txtFieldEmailFreelancer;
    }

    @FXML
    private void btnRegistarFreelancer(ActionEvent event) {

        String nomeFreeLancer, nifFreeLancer, telefoneFreeLancer, emailFreeLancer, cp, morada, localidade;

        nomeFreeLancer = txtFieldNomeFreelancer.getText();
        nifFreeLancer = txtFieldNifFreelancer.getText();
        telefoneFreeLancer = txtFieldTelefoneFreelancer.getText();
        emailFreeLancer = txtFieldEmailFreelancer.getText();
        cp = txtFieldEndCodigoPostalFreeLancer.getText();
        localidade = txtFieldEndLocalidadeFreeLancer.getText();
        morada = txtFieldEndMoradaFreeLancer.getText();


        EnderecoPostalDTO epto = new EnderecoPostalDTO();
        epto.setCodigoPostal(cp);
        epto.setLocalidade(localidade);
        epto.setMorada(morada);


        FreeLancerDTO flto;
        flto = new FreeLancerDTO();
        flto.setNome(nomeFreeLancer);
        flto.setNif(nifFreeLancer);
        flto.setTelefone(telefoneFreeLancer);
        flto.setEmail(emailFreeLancer);
        flto.setEndereco(epto);
        flto.setHabilitacoes(habilitacoes);
        flto.setReconhecimentos(reconhecimentos);

        boolean result = false;
        try {
            result = uiflc.especificarFreeLancer(flto);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            Alert a = AlertaUI.criarAlerta(
                        Alert.AlertType.INFORMATION,
                        "FreeLancer",
                        "Erro ao criar novo FreeLancer",
                        e.getMessage());
                a.show();
        }

        if (result) {
            Alert a = AlertaUI.criarAlerta(
                    Alert.AlertType.INFORMATION,
                    "FreeLancer",
                    "Especificar novo FreeLancer",
                    "Colaborador adicionado com sucesso.");
            a.show();
            limparCampos();
        }
    }

    @FXML
    private void btnLimparRegistarFreelancer(ActionEvent event) {
        limparCampos();
    }

    private void limparCampos() {
        this.txtFieldEmailFreelancer.clear();
        this.txtFieldEndLocalidadeFreeLancer.clear();
        this.txtFieldEndCodigoPostalFreeLancer.clear();
        this.txtFieldEndMoradaFreeLancer.clear();
        this.txtFieldNifFreelancer.clear();
        this.txtFieldNomeFreelancer.clear();
        this.txtFieldTelefoneFreelancer.clear();
        this.habilitacoes.clear();
        this.reconhecimentos.clear();
        table_ct.refresh();
        table_ha.refresh();
    }

    @FXML
    private void btnCancelarRegistarFreelancer(ActionEvent event) {
        limparCampos();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    void associarParentUI(MainSceneController mainSceneController) {
        this.mainSceneController = mainSceneController;
        this.appController = mainSceneController.getAppController();
    }

    @FXML
    private void btnPopAction(ActionEvent event) {
        String nomeFreeLancer, nifFreeLancer, telefoneFreeLancer, emailFreeLancer, cp, morada, localidade;

        nomeFreeLancer = AlgoritmoGeradorPasswords.geraString(AlgoritmoGeradorPasswords.LETRAS, 10);
        nifFreeLancer = AlgoritmoGeradorPasswords.geraString(AlgoritmoGeradorPasswords.NUMEROS, 9);
        telefoneFreeLancer = AlgoritmoGeradorPasswords.geraString(AlgoritmoGeradorPasswords.NUMEROS, 9);
        emailFreeLancer = String.format("%s@%s.pt",
                AlgoritmoGeradorPasswords.geraString(AlgoritmoGeradorPasswords.LETRAS, 6),
                AlgoritmoGeradorPasswords.geraString(AlgoritmoGeradorPasswords.LETRAS, 6)
        );
        cp = String.format("%s-%s",
                AlgoritmoGeradorPasswords.geraString(AlgoritmoGeradorPasswords.NUMEROS, 4),
                AlgoritmoGeradorPasswords.geraString(AlgoritmoGeradorPasswords.NUMEROS, 3)
        );
        morada = AlgoritmoGeradorPasswords.geraString(AlgoritmoGeradorPasswords.LETRAS, 10);
        localidade = AlgoritmoGeradorPasswords.geraString(AlgoritmoGeradorPasswords.LETRAS, 10);

        txtFieldNomeFreelancer.setText(nomeFreeLancer);
        txtFieldNifFreelancer.setText(nifFreeLancer);
        txtFieldTelefoneFreelancer.setText(telefoneFreeLancer);
        txtFieldEmailFreelancer.setText(emailFreeLancer);
        txtFieldEndCodigoPostalFreeLancer.setText(cp);
        txtFieldEndLocalidadeFreeLancer.setText(localidade);
        txtFieldEndMoradaFreeLancer.setText(morada);

    }

    @FXML
    private void btnIntroduzirNovaHabilitacaoAcademica(ActionEvent event) {
        mainSceneController.loadGUI(EnumFXMLs.REGISTAR_HABILITACAO_ACADEMICA);
    }

    @FXML
    private void btnIntroduzirNovaCompetenciaTecnica(ActionEvent event) {
        mainSceneController.loadGUI(EnumFXMLs.CRIAR_RECONHECIMENTO_CT);
    }

    public ObservableList<HabilitacaoAcademicaDTO> getHabilitacoes() {
        return habilitacoes;
    }

}
