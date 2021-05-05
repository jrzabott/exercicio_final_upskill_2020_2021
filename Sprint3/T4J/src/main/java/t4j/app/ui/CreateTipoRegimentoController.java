package t4j.app.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import t4j.app.controller.UITipoRegimentoController;
import t4j.app.dto.TipoRegimentoDTO;

@Controller
public class CreateTipoRegimentoController implements Initializable {

    @Autowired
    private MainSceneController mainSceneController;
    @Autowired
    private UITipoRegimentoController uitrc;
    
    @FXML
    private TextArea txtDescricaoRegrasTipoRegimento;
    @FXML
    private TextField txtFieldDesignacaoTipoRegimento;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void btnCancelarRegistarTipoRegimento(ActionEvent event) {
        limparCampos();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void btnLimparRegistarTipoRegimento(ActionEvent event) {
        limparCampos();
    }

    @FXML
    private void btnPopAction(ActionEvent event) {
        
    }

    @FXML
    private void btnRegistarTipoRegimento(ActionEvent event) {
        
        TipoRegimentoDTO trdto = new TipoRegimentoDTO();
        trdto.setDesignacao(txtFieldDesignacaoTipoRegimento.getText());
        trdto.setDescricaoRegras(txtDescricaoRegrasTipoRegimento.getText());
        try {
            boolean result = uitrc.criarTipoRegimento(trdto);
            if (result) {
                Alert a = AlertaUI.criarAlerta(
                        Alert.AlertType.INFORMATION,
                        "Criar Tipo de Regimento",
                        "Criar Tipo de Regimento",
                        "Tipo de Regimento criado com Sucesso"
                );
                a.show();

                ((Node) event.getSource()).getScene().getWindow().hide();
                limparCampos();
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            Alert a = AlertaUI.criarAlerta(
                    Alert.AlertType.ERROR,
                    "Tipo Regimento",
                    "Erro ao criar Tipo de Regimento",
                    e.getMessage());
            a.show();
        }
    }
    
    private void limparCampos() {
        txtFieldDesignacaoTipoRegimento.clear();
        txtDescricaoRegrasTipoRegimento.clear();
    }
    
    void associarParentUI(MainSceneController mnc) {
        this.mainSceneController = mnc;
    }
}
