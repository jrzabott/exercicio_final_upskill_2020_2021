package t4j.app.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import t4j.app.controller.UIColaboradorController;
import t4j.app.controller.UIMainSceneController;
import t4j.app.dto.ColaboradorDTO;
import t4j.app.dto.OrganizacaoDTO;
import t4j.app.dto.RegistoOrganizacoesDTO;
import t4j.app.utils.AlgoritmoGeradorPasswords;

@Controller
public class CreateColaborador implements Initializable {

    @Autowired
    private UIMainSceneController appController;
    @Autowired
    private MainSceneController mainSceneController;
    @Autowired
    private UIColaboradorController uiecc;

    @FXML
    private Button btnPop;
    @FXML
    private ComboBox<String> cmbBoxOrganizacao;

    @FXML
    private TextField txtFieldNomeColaborador;
    @FXML
    private TextField txtFieldFuncaoColaborador;
    @FXML
    private TextField txtFieldTelefoneColaborador;
    @FXML
    private TextField txtFieldEmailColaborador;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cmbBoxOrganizacao.setVisible(false);
    }

    @FXML
    private void btnPopAction(ActionEvent event) {
        String nomeColaborador, funcaoColaborador, telefoneColaborador, emailColaborador;

        nomeColaborador = AlgoritmoGeradorPasswords.geraString(AlgoritmoGeradorPasswords.LETRAS, 10);
        funcaoColaborador = AlgoritmoGeradorPasswords.geraString(AlgoritmoGeradorPasswords.LETRAS, 10);
        telefoneColaborador = AlgoritmoGeradorPasswords.geraString(AlgoritmoGeradorPasswords.NUMEROS, 9);
        emailColaborador = String.format("%s@%s.pt",
                AlgoritmoGeradorPasswords.geraString(AlgoritmoGeradorPasswords.LETRAS, 6),
                AlgoritmoGeradorPasswords.geraString(AlgoritmoGeradorPasswords.LETRAS, 6)
        );

        txtFieldNomeColaborador.setText(nomeColaborador);
        txtFieldFuncaoColaborador.setText(funcaoColaborador);
        txtFieldTelefoneColaborador.setText(telefoneColaborador);
        txtFieldEmailColaborador.setText(emailColaborador);

        // Temporariamente obtermos as organizações e populamos um combobox
        // para que determinado colaborador possa ser adicionado
        // àquela organização.
        RegistoOrganizacoesDTO rodto = uiecc.getRegistoOrganizacoes();
        cmbBoxOrganizacao.getItems().clear();
        for (OrganizacaoDTO org : rodto.getOrganizacoes()) {
            cmbBoxOrganizacao.getItems().add(org.getNifOrganizacao() + " - " + org.getNomeOrganizacao());
        }
    }

    @FXML
    private void btnRegistarColaborador(ActionEvent event) {
//        String organizacaoNif = cmbBoxOrganizacao.getValue().substring(0, 9);
//        System.out.println(organizacaoNif);

        String nomeColaborador, funcaoColaborador, telefoneColaborador, emailColaborador;

        nomeColaborador = txtFieldNomeColaborador.getText();
        funcaoColaborador = txtFieldFuncaoColaborador.getText();
        telefoneColaborador = txtFieldTelefoneColaborador.getText();
        emailColaborador = txtFieldEmailColaborador.getText();

        ColaboradorDTO cdto = new ColaboradorDTO();
        cdto.setNome(nomeColaborador);
        cdto.setFuncao(funcaoColaborador);
        cdto.setTelefone(telefoneColaborador);
        cdto.setEmail(emailColaborador);
        cdto.setNifOrganizacao(mainSceneController.getUidto().getNifOrganizacao());
        cdto.setGestor("0");

//        boolean result = uiecc.especificarColaborador(cdto.getNifOrganizacao(), cdto);
        boolean result = false;
        try {
            result = uiecc.especificarColaborador(cdto);
        } catch (Exception e) {
            if (result) {
                Alert a = AlertaUI.criarAlerta(
                        Alert.AlertType.INFORMATION,
                        "Colaborador",
                        "Erro ao criar novo colaborador",
                        e.getMessage());
                a.show();
            }
        }

        if (result) {
            Alert a = AlertaUI.criarAlerta(
                    Alert.AlertType.INFORMATION,
                    "Colaborador",
                    "Especificar novo colaborador",
                    "Colaborador adicionado com sucesso.");
            a.show();
        }
    }

    @FXML
    private void btnLimparRegistarColaborador(ActionEvent event) {
        this.txtFieldNomeColaborador.clear();
        this.txtFieldFuncaoColaborador.clear();
        this.txtFieldTelefoneColaborador.clear();
        this.txtFieldEmailColaborador.clear();
    }

    @FXML
    private void btnCancelarRegistarColaborador(ActionEvent event) {
        this.txtFieldNomeColaborador.clear();
        this.txtFieldFuncaoColaborador.clear();
        this.txtFieldTelefoneColaborador.clear();
        this.txtFieldEmailColaborador.clear();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    void associarParentUI(MainSceneController mainSceneController) {
        this.mainSceneController = mainSceneController;
        this.appController = mainSceneController.getAppController();
    }
}
