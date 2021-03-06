package t4j.app.ui;

import t4j.app.controller.UICompetenciaTecnicaController;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import t4j.app.controller.UIAreaAtividadesController;
import t4j.app.dto.AreaAtividadeDTO;
import t4j.app.dto.CompetenciaTecnicaDTO;
import t4j.app.dto.GrauProficienciaDTO;
import t4j.app.dto.RegistoAreasAtividadesDTO;
import t4j.app.exception.ElementoInvalidoException;
import t4j.app.service.AreaAtividadeService;
import t4j.app.utils.AlgoritmoGeradorPasswords;

@Controller
public class CreateCompetenciaTecnica implements Initializable {

    @Autowired
    private MainSceneController mainSceneController;
    @Autowired
    private UICompetenciaTecnicaController uidctc;
    @Autowired
    private UIAreaAtividadesController uiaac;

    @FXML
    private TextField txtFieldCodCompetenciaTecnica;
    @FXML
    private TextField txtFieldNomeCompetenciaTecnica;
    @FXML
    private TextArea txtAreaDescCompetenciaTecnica;
    @FXML
    private ComboBox<AreaAtividadeDTO> cmbAreaAtividadeCT;
    @FXML
    private TextField txtFieldGrauCompetencia;
    @FXML
    private Button btnAddGrauCompetencia;
    @FXML
    private ListView<String> listViewGrauCompetencia;
    @FXML
    private Button btnRemoverGrauCompetencia;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // popular combobox
        preencherAreasDeAtividade();
    }

    @FXML
    private void btnRegistarCompetenciaTecnica(ActionEvent event) {
        if (cmbAreaAtividadeCT.getValue() == null) {
            Alert a = AlertaUI.criarAlerta(
                    Alert.AlertType.WARNING,
                    "Compet??ncia T??cnica",
                    "Compet??ncia T??cnica",
                    "Deve selecionar uma ??rea de Atividade.");
            a.show();
            return;
        }
        if (listViewGrauCompetencia.getItems().size() < 1) {
            Alert a = AlertaUI.criarAlerta(
                    Alert.AlertType.WARNING,
                    "Compet??ncia T??cnica",
                    "Compet??ncia T??cnica",
                    "Uma compet??ncia t??cnica deve ter ao menos um grau de profici??ncia registado.");
            a.show();
            return;
        }
        try {
            CompetenciaTecnicaDTO ctdto = new CompetenciaTecnicaDTO();
            ctdto.setCodigoCompetenciaTecnica(txtFieldCodCompetenciaTecnica
                    .getText().trim());
            ctdto.setDescricaoBreve(txtFieldNomeCompetenciaTecnica.getText()
                    .trim());
            ctdto.setDescricaoDetalhada(txtAreaDescCompetenciaTecnica.getText()
                    .trim());
            ctdto.setAreaAtividade(new AreaAtividadeDTO());

            ///////////////////////////////////////////////////////////////////
            // Preparar Graus de Compet??ncia e GrauProficienciaDTO
            ArrayList<GrauProficienciaDTO> gpdtos = new ArrayList<>();

            for (String item : listViewGrauCompetencia.getItems()) {
                GrauProficienciaDTO gpdto = new GrauProficienciaDTO();
                gpdto.setDesignacao(item.substring(4));
                gpdto.setValor(item.substring(0, 2));
                gpdtos.add(gpdto);
            }
            ctdto.setGrausProficiencia(gpdtos);

            ///////////////////////////////////////////////////////////////////
            // Preparar Area de Atividade e AreaAtividadeDTO
            ctdto.setAreaAtividade(cmbAreaAtividadeCT.getValue());

            boolean result = this.uidctc.adicionarCompetenciaTecnica(ctdto);
            if (result) {
                Alert a = AlertaUI.criarAlerta(
                        Alert.AlertType.INFORMATION,
                        "Compet??ncia T??cnica",
                        "Compet??ncia T??cnica",
                        "Compet??ncia T??cnica criada com sucesso.");
                a.show();
                return;
            }
        } catch (Exception e) {
            Alert a = AlertaUI.criarAlerta(
                    Alert.AlertType.ERROR,
                    "Compet??ncia T??cnica",
                    "Compet??ncia T??cnica",
                    e.getMessage());
            a.show();
        }
    }

    @FXML
    private void btnLimparRegistarCompetenciaTecnica(ActionEvent event) {
        System.out.println(cmbAreaAtividadeCT.getItems().toString());
// limparCampos();
    }

    @FXML
    private void btnCancelarRegistarCompetenciaTecnica(ActionEvent event) {
        limparCampos();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    private void limparCampos() {
        this.txtFieldCodCompetenciaTecnica.clear();
        this.txtFieldNomeCompetenciaTecnica.clear();
        this.txtAreaDescCompetenciaTecnica.clear();
        this.cmbAreaAtividadeCT.setValue(null);
        this.listViewGrauCompetencia.getItems().clear();
        this.txtFieldGrauCompetencia.clear();
    }

    @FXML
    private void btnPopAction(ActionEvent event) {
        String codCompetenciaTecnica = AlgoritmoGeradorPasswords.geraString(
                AlgoritmoGeradorPasswords.LETRAS_NUMEROS, 20);
        String nomeCompetenciaTecnica = AlgoritmoGeradorPasswords.geraString(
                AlgoritmoGeradorPasswords.LETRAS_NUMEROS, 60);
        String descCompetenciaTecnica = AlgoritmoGeradorPasswords.geraString(
                AlgoritmoGeradorPasswords.MIX, 1024);

        this.txtFieldCodCompetenciaTecnica.setText(codCompetenciaTecnica);
        this.txtFieldNomeCompetenciaTecnica.setText(nomeCompetenciaTecnica);
        this.txtAreaDescCompetenciaTecnica.setText(descCompetenciaTecnica);

        Random rnd = new Random();
        int numOfGraus = rnd.nextInt(6) + 3;
        listViewGrauCompetencia.getItems().clear();
        for (int i = 0; i < numOfGraus; i++) {
            addGrau2List(AlgoritmoGeradorPasswords.geraString(
                    AlgoritmoGeradorPasswords.MIX, rnd.nextInt(15) + 5));
        }

        preencherAreasDeAtividade();
    }

    private void preencherAreasDeAtividade() {

        ArrayList<AreaAtividadeDTO> aadtos = uiaac.obterAreasAtividades().getAtividades();

        cmbAreaAtividadeCT.setItems(FXCollections
                .observableArrayList(aadtos));

        Callback<ListView<AreaAtividadeDTO>, ListCell<AreaAtividadeDTO>> cellFactory
                = new Callback<ListView<AreaAtividadeDTO>, ListCell<AreaAtividadeDTO>>() {

            @Override
            public ListCell<AreaAtividadeDTO> call(
                    ListView<AreaAtividadeDTO> l) {
                return new ListCell<AreaAtividadeDTO>() {

                    @Override
                    protected void updateItem(AreaAtividadeDTO item,
                            boolean empty) {
                        super.updateItem(item, empty);
                        if (item == null || empty) {
                            setGraphic(null);
                        } else {
                            String s;
                            if (item.getDescBreve().length() < 40) {
                                s = String.format("%s - %s", item.getCodigo(), item.getDescBreve()
                                        .substring(0, item
                                                .getDescBreve().length()));
                            } else {
                                s = String.format("%s - %s...", item.getCodigo(), item
                                        .getDescBreve().substring(0, 40));
                            }
                            setText(s);
                        }
                    }
                };
            }
        };

        cmbAreaAtividadeCT.setButtonCell(cellFactory.call(null));
        cmbAreaAtividadeCT.setCellFactory(cellFactory);

// preencherAreasDeAtividade() {}
//        RegistoAreasAtividadesDTO raadto = new RegistoAreasAtividadesDTO();
//        raadto = AreaAtividadeService.getRegistoAreasAtividade();
//        cmbAreaAtividadeCT.getItems().clear();
//        if (raadto != null && raadto.getAtividades().size() > 0) {
//            for (AreaAtividadeDTO atividade : raadto.getAtividades()) {
//                cmbAreaAtividadeCT.getItems().add(atividade.getCodigo() + " - " + atividade.getDescBreve());
    }

    @FXML
    private void btnAddGrauCompetenciaAction(ActionEvent event) {
        addGrau2List(txtFieldGrauCompetencia.getText());
        txtFieldGrauCompetencia.requestFocus();
    }

    @FXML
    private void btnRemoverGrauCompetenciaAction(ActionEvent event) {
        int index = 0;
        index = this.listViewGrauCompetencia.getSelectionModel()
                .getSelectedIndex();
        if (index > -1 && this.listViewGrauCompetencia.getItems().size() > 0) {
            listViewGrauCompetencia.getItems().remove(index);
            for (int i = index; i < this.listViewGrauCompetencia.getItems()
                    .size(); i++) {
                StringBuilder sb = new StringBuilder();
                String s = this.listViewGrauCompetencia.getItems().get(i);
                if (i < 10) {
                    sb.append("0");
                }
                sb.append(i + 1).append(". ");
                sb.append(s.substring(4));
                this.listViewGrauCompetencia.getItems().set(i, sb.toString());
            }
        }
    }

    private void addGrau2List(String s) throws ElementoInvalidoException {
        if (!s.trim().isEmpty()) {
            int numOfItens = (listViewGrauCompetencia.getItems().size());
            String grau = s.trim();
            StringBuilder sb = new StringBuilder();
            if (numOfItens < 9) {
                sb.append("0");
            }
            if (numOfItens >= 99) {
                throw new ElementoInvalidoException(
                        "N??o ?? poss??vel haver mais de 100 Graus de compet??ncia.");
            }
            sb.append(numOfItens + 1).append(". ").append(grau);
            boolean itemExists = false;
            for (String item : listViewGrauCompetencia.getItems()) {
                if (item.substring(4).equalsIgnoreCase(sb.toString()
                        .substring(4))) {
                    itemExists = true;
                }
            }
            if (!itemExists) {
                this.listViewGrauCompetencia.getItems().add(sb.toString());
            }
        }
    }

    void associarParentUI(MainSceneController mnc) {
        this.mainSceneController = mnc;
    }
}
